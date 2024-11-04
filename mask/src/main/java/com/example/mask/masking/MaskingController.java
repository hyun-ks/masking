package com.example.mask.masking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaskingController {
	@Autowired
	private MaskInfoService m;
	
	@GetMapping("/maskinfo")
	public List<MaskInfoDto> getMaskInfo(){
		List<MaskInfoDto> maskinfolist = m.list();
		System.out.println(maskinfolist);
		
		for(MaskInfoDto maskedInfo : maskinfolist) {
			String maskedPhone = maskedPhoneNumber(maskedInfo.getPhonenumber());
			maskedInfo.setPhonenumber(maskedPhone);
			
			String maskedUserid = maskedUserid(maskedInfo.getUserid());
			maskedInfo.setUserid(maskedUserid);
		}
		
		System.out.println(maskinfolist);
		return maskinfolist;
	}
	
	public String maskedPhoneNumber(String phonenumber) {
		StringBuilder maskedPhoneNumber = new StringBuilder(phonenumber);
		
		if(phonenumber.contains("-")) {//phonenumber가 -를 포함하고있으면
			String[] parts = phonenumber.split("-");//-를 기준으로 잘라서 parts배열에 넣어서 중간값만 마스킹
				maskedPhoneNumber = new StringBuilder(parts[0] + "-" + "****" + "-" + parts[2]);
		}
		return maskedPhoneNumber.toString();		
	}
	
	public String maskedUserid(String userid) {
		StringBuilder maskedUserid = new StringBuilder(userid);
		
		if(userid.length() == 3) {//userid가 세글자일때
			maskedUserid.setCharAt(1, '*');//2번째 배열값을 *로 바꿈
		}
		else if(userid.length() == 4) {
			maskedUserid.setCharAt(1, '*');
			maskedUserid.setCharAt(2, '*');
		}
		return maskedUserid.toString();
	}

}
