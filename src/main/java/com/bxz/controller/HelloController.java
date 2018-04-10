package com.bxz.controller;

import com.bxz.entity.UserEntity;
import com.bxz.jpa.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by SQ_BXZ on 2018-04-10.
 */
@RestController // 声明控制器
public class HelloController {

	@Autowired
	private UserJpa userJpa;

	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public List<UserEntity> list(){
		return userJpa.findAll();
	}
	@RequestMapping(value = "/save",method = RequestMethod.GET)
	public UserEntity save(UserEntity entity){
		return userJpa.save(entity);
	}
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	public List<UserEntity> delete(Long id){
		userJpa.deleteById(id);
		return userJpa.findAll();
	}


	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public String index(){
		return "index";
	}

}
