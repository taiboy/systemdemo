package com.example.demo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.entity.Member;
import com.example.demo.form.MemberForm;
import com.example.demo.service.RegiMemService;

@SessionAttributes(types = MemberForm.class)
@Controller
public class RegimemController {
	
	
	//Service
	@Autowired
	private RegiMemService service;
	
	@RequestMapping("/conf_mem")
	public String conf_mem(@Validated MemberForm form,
			BindingResult result
			,Model model) {
		
		
		if(result.hasErrors()) {
			return "/input_member";
		}
		
		
		boolean checkMail=service.checkMail(form.getMail());
		
		if (checkMail == true) {
			model.addAttribute("checkMailToken", checkMail);
			return "input_member";
			
		}
		
		
		//FormはHTTPのPOSTメソッドで送信された値が入っている。
		//entityはDBに登録更新する値を入れておく。
		//DBから取得した値を保持しておく。
		//確認→登録の流れでentityを使うと変数に値がうまく入らなかった。
		
//		String memberName = form.getMemberName();
//		String mail = form.getMail();
//		
//		
//		model.addAttribute("member", new Member(memberName,mail));
		
		return "/conf_mem";
	}

	
	@RequestMapping("/exec_mem")
	public String suc_mem(MemberForm form,Model model,SessionStatus status) {
		
		
		
		String memberName = form.getMemberName();
		String mail = form.getMail();
		String authority = form.getAuthority();
		String memberCode = "taiboy";
		Boolean mem_token = form.getMemberToken();
		

		model.addAttribute("member", new Member(mem_token,memberCode,memberName,authority,mail));
		
		status.setComplete();
		return "/mem_suc";
	}
}
