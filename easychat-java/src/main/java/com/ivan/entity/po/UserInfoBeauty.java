package com.ivan.entity.po;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @Description: 
 * @author: ivan
 * @date: 2024/05/21
 */
public class UserInfoBeauty implements Serializable {
	/**
	 * 自增id
	 */
	private Integer id;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 状态 0未使用 1已使用
	 */
	@JsonIgnore
	private Integer status;
	/**
	 * 自增id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 自增id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * 邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 邮箱
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * 用户id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 用户id
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * 状态 0未使用 1已使用
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 状态 0未使用 1已使用
	 */
	public Integer getStatus() {
		return this.status;
	}

	@Override
	public String toString() {
		return "InfoBeauty {" + "自增id : " + (id == null ? "空" : id) + "," + "邮箱 : " + (email == null ? "空" : email) + "," + "用户id : " + (userId == null ? "空" : userId) + "," + "状态 0未使用 1已使用 : " + (status == null ? "空" : status) + "}";
	}
}