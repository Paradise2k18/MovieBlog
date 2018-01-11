package com.example.demo.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.Base64MultipartFile;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.LoginRequest;
import com.example.demo.service.UserService;

import sun.misc.BASE64Decoder;
@Service
public class UserServiceImpl implements UserService,UserDetailsService {
	private final static String PATH = "C://Users//Yurko//Desktop//images";


	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User user) throws IOException {
		byte[]fileContent;
		if(user.getPhoto()!=null) {
			BASE64Decoder decoder = new BASE64Decoder();
			fileContent = decoder.decodeBuffer(user.getPhoto().split(",")[1]);
			String expansion = user.getPhoto().split(",")[0].split("/")[1].split(";")[0];
			user.setPhoto(null);
			user = userRepository.saveAndFlush(user);
			Base64MultipartFile multipartFile = new Base64MultipartFile(fileContent,user.getId()+"."+expansion);
			saveFile(multipartFile);
			user.setPhoto("/images/"+user.getId()+"."+expansion);
		}
		return userRepository.save(user);
	}

	private void saveFile(MultipartFile file ) throws FileNotFoundException, IOException {
		File pathToFolder = new File (PATH);
		createFolder(pathToFolder);
		File newFile = new File(pathToFolder+"/"+file.getOriginalFilename());
		writeFile(newFile,file);
	}
	
	private void createFolder(File path) {
		if (!path.exists()) {
			path.mkdirs();
		}
	}
	
	private void writeFile(File file,MultipartFile multipartFile) throws FileNotFoundException, IOException {
		try(OutputStream fos = new FileOutputStream(file);BufferedOutputStream bos = new BufferedOutputStream(fos)){
			bos.write(multipartFile.getBytes(),0,multipartFile.getBytes().length);
			bos.flush();
		}catch(IOException e) {
			
		}
	}
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findOne(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public boolean delete(Integer id) {
		userRepository.delete(id);
		return true;
	}

	@Override
	public boolean login(LoginRequest loginRequest) {
		if(loginRequest!=null){
			User user  = userRepository.findByEmail(loginRequest.getEmail());
			if(user!=null){
				if(user.getPassword().equals(loginRequest.getPassword())){
					return true;
				}else{
					throw new IllegalArgumentException("Login or password is incorrect");
				}
			}else{
				throw new IllegalArgumentException("Login or password is incorrect");
			}
		}else{
			throw new IllegalArgumentException("LoginRequest not be null");
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByEmail(username);
	}



}
