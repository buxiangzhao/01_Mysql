package com.bxz.jpa;

import com.bxz.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * Created by SQ_BXZ on 2018-04-10.
 */

/**
 * JpaRepository SpringDataJPA提供的简单数据操作接口
 * JpaSpecificationExecutor SpringDataJPA提供的复杂查询接口
 * Serializable 序列化接口
 */
public interface UserJpa extends JpaRepository<UserEntity,Long>,
JpaSpecificationExecutor<UserEntity>,Serializable {

}
