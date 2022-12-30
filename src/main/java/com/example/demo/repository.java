package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface repository extends JpaRepository<Maintask,Integer>{

	@Query(value="SELECT * FROM maintask s where s.taskId=?1",nativeQuery=true)
	List<Maintask> findById(int id);
	
	
	@Query(value="SELECT * FROM maintask s where s.taskHolderName=?1",nativeQuery=true)
	List<Maintask> findByName(String taskHolderName);
	
	
	@Modifying
	@Transactional
	@Query(value="Update maintask s set s.taskId=?1 , s.taskHolderName=?2 , s.taskDate=?3 , s.taskName=?4 , s.taskStatus=?5 where s.taskId=?6", nativeQuery=true)
	void update(int taskId,String taskHolderName, String taskDate, String taskName, String taskStatus,int id);
	
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM maintask where taskId=?1", nativeQuery=true)
	void deleteAllByIdInBatch(int id);
}
