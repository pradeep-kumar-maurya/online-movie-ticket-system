package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.bean.Authentication;

public interface RegisterDao extends JpaRepository<Authentication, Integer>{

	@Query("select a from Authentication a where username=?1")
	public Authentication findUsername(String username);

}
