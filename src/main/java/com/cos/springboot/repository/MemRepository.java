package com.cos.springboot.repository;

import java.util.List;

import com.cos.springboot.dto.RequestMemJoinDto;
import com.cos.springboot.dto.RequestMemUpdateDto;
import com.cos.springboot.model.Mem;

//MapperScan에 의해서 메모리에 로드됨(그래서 따로 어노테이션이 없음)
//MapperScam은 DataAccessConfig에 있고 여기서
//@MapperScan(basePackages = "com.cos.springboot.repository")스캔할때 메모리에 띄워짐 
public interface MemRepository {
	//전체보기
	List<Mem> findAll();
	//상세보기
	Mem findById(int id);
	//회원가입
	int save(RequestMemJoinDto requestMemJoinDto);
	//회원수정
	int update(RequestMemUpdateDto requestMemUpdateDto);
	//회원삭제
	int delete(int id);
}
