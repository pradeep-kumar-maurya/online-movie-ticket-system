package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.bean.Authentication;

public interface AuthenticationDao extends JpaRepository<Authentication, Integer>{

	@Query("select a from Authentication a where username=?1 and password=?2 ")
	public Authentication authenticate(String uname, String pass);

}
