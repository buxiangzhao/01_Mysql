package com.bxz.jpa;

import com.bxz.entity.LoggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoggerJPA
        extends JpaRepository<LoggerEntity,Long>
{

}
