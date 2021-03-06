package com.bxz.controller;

import com.bxz.entity.UserEntity;
import com.bxz.jpa.UserJpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class LoginController {
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserJpa userJPA;

    @RequestMapping(value = "/login")
    public String login(UserEntity user, HttpServletRequest request)
    {
        //登录成功
        boolean flag = true;
        String result = "登录成功";
        //根据用户名查询用户是否存在
        Optional<UserEntity> isPresent = userJPA.findOne(new Specification<UserEntity>() {
            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                criteriaQuery.where(criteriaBuilder.equal(root.get("name"), user.getName()));
                return null;
            }
        });
        //用户不存在
        if(!isPresent.isPresent()){
            flag = false;
            result = "用户不存在，登录失败";}
        //密码错误
        else if(!isPresent.get().getPwd().equalsIgnoreCase(user.getPwd())){
            flag = false;
            result = "用户密码不相符，登录失败";
        }
        //登录成功
        if(flag){
            //将用户写入session
            request.getSession().setAttribute("_session_user",isPresent.get());
        }
        return result;
    }
}
