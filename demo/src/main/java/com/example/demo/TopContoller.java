package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.form.MemberForm;

@SessionAttributes(types = MemberForm.class)
@Controller
public class TopContoller {

	@RequestMapping("/")
	public String input_mem(Model model) {
		
		
		String authority=null;
		
		boolean mem_token = true;
		
		if (mem_token == false) {
			authority = "Customer";
		}
		model.addAttribute("memberForm",new MemberForm(mem_token,null,null,authority,null));
		
		return "/input_member";
	}
	
}
