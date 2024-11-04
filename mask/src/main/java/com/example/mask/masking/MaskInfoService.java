package com.example.mask.masking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaskInfoService {
	@Autowired
	private MaskInfoDao dao;
	
	public List<MaskInfoDto> list(){
	return dao.list();
	}
}
