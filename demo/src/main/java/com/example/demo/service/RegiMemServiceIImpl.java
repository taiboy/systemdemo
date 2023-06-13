package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.MemberMapper;



@Service
public class RegiMemServiceIImpl implements RegiMemService{
	
	
	//Mapper
	@Autowired
	private MemberMapper mapper;

	
	
	public Boolean checkMail(String mail) {

		
		
		Boolean check=false;
		
		
		ArrayList<String> mailList = new ArrayList<>();
		
//		memberList.add(new Member(true,"tt00001","takedataiki","Employee","taikiairperson123@gmail.com"));
//		memberList.add(new Member(true,"tt00002","takedajunko","Employee","jhunko@gmail.com"));
//		memberList.add(new Member(false,"tt00003","takedachinatu","Customer","chinatu@gmail.com"));
		
		mailList.add(mapper.findcheckMail());
		
		
		for (String memli : mailList) {
			
			if(mail.equals(memli)){
				
				check = true;
				
			}
			
		}
		
		return check;
		
		 
	}
}
