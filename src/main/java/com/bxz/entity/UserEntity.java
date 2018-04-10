package com.bxz.entity;

import javax.persistence.*;

/**
 * Created by SQ_BXZ on 2018-04-10.
 */
@Entity
@Table(name = "t_user")
public class UserEntity {
	@Id
	@GeneratedValue
	@Column(name = "t_id")
	private Long id;

	@Column(name ="t_name")
	private String name;
	@Column(name ="t_address")
	private String address;

	@Column(name = "t_age")
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
