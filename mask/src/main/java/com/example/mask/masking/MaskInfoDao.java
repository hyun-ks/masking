package com.example.mask.masking;
import java.util.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MaskInfoDao {
	@Select("select * from masktype")
	List<MaskInfoDto> list();
}
