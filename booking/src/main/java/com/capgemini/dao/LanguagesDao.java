package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.bean.Languages;

public interface LanguagesDao extends JpaRepository<Languages, Integer>{

}
