package com.ivan.entity.query;


/**
 * @Description: 查询对象
 * @author: ivan
 * @date: 2024/05/21
 */
public class UserInfoBeautyQuery extends BaseQuery {
	/**
	 * 自增id
	 */
	private Integer id;
	/**
	 * 邮箱
	 */
	private String email;
	private String emailfuzzy;
	/**
	 * 用户id
	 */
	private String userId;
	private String userIdfuzzy;
	/**
	 * 状态 0未使用 1已使用
	 */
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

	/**
	 * 
	 */
	public void setEmailfuzzy(String emailfuzzy) {
		this.emailfuzzy = emailfuzzy;
	}

	/**
	 * 
	 */
	public String getEmailfuzzy() {
		return this.emailfuzzy;
	}

	/**
	 * 
	 */
	public void setUserIdfuzzy(String userIdfuzzy) {
		this.userIdfuzzy = userIdfuzzy;
	}

	/**
	 * 
	 */
	public String getUserIdfuzzy() {
		return this.userIdfuzzy;
	}

}