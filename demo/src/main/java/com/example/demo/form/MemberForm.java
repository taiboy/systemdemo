package com.example.demo.form;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberForm implements Serializable{
		
		private Boolean memberToken;
		private String memberCode;
		
		@NotBlank(message = "ユーザー名は必須項目です。")
		@Size(min=6,max=20,message = "ユーザー名は6~20文字で入力してください。")
		private String memberName;
		
		@Size(max=15)
		private String authority;
		
		@Email(message = "正しいメールアドレスを入力してください")
		@NotBlank(message = "メールアドレスは入力必須項目です。")
		private String mail;
}
