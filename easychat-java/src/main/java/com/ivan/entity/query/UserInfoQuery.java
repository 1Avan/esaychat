package com.ivan.entity.query;

import java.util.Date;

/**
 * @Description: 用户信息查询对象
 * @author: ivan
 * @date: 2024/05/21
 */
public class UserInfoQuery extends BaseQuery {
	/**
	 * 用户id
	 */
	private String userId;
	private String userIdfuzzy;
	/**
	 * 邮箱
	 */
	private String email;
	private String emailfuzzy;
	/**
	 * 昵称
	 */
	private String nickName;
	private String nickNamefuzzy;
	/**
	 * 0.直接加好友 1.需要同意
	 */
	private Integer joinType;
	/**
	 * 密码
	 */
	private String password;
	private String passwordfuzzy;
	/**
	 * 性别：0男 1女
	 */
	private Integer sex;
	/**
	 * 个性签名
	 */
	private String personalSignature;
	private String personalSignaturefuzzy;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 最后登出时间
	 */
	private Long lastOffTime;
	/**
	 * 最后登录时间
	 */
	private Date lastLoginTime;
	private String lastLoginTimeStart;
	private String lastLoginTimeEnd;
	/**
	 * 创建时间
	 */
	private Date createTime;
	private String createTimeStart;
	private String createTimeEnd;
	/**
	 * 地区
	 */
	private String areaName;
	private String areaNamefuzzy;
	/**
	 * 地区编码
	 */
	private String areaCode;
	private String areaCodefuzzy;
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
	 * 昵称
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * 昵称
	 */
	public String getNickName() {
		return this.nickName;
	}

	/**
	 * 0.直接加好友 1.需要同意
	 */
	public void setJoinType(Integer joinType) {
		this.joinType = joinType;
	}

	/**
	 * 0.直接加好友 1.需要同意
	 */
	public Integer getJoinType() {
		return this.joinType;
	}

	/**
	 * 密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 密码
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * 性别：0男 1女
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/**
	 * 性别：0男 1女
	 */
	public Integer getSex() {
		return this.sex;
	}

	/**
	 * 个性签名
	 */
	public void setPersonalSignature(String personalSignature) {
		this.personalSignature = personalSignature;
	}

	/**
	 * 个性签名
	 */
	public String getPersonalSignature() {
		return this.personalSignature;
	}

	/**
	 * 状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 状态
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * 最后登出时间
	 */
	public void setLastOffTime(Long lastOffTime) {
		this.lastOffTime = lastOffTime;
	}

	/**
	 * 最后登出时间
	 */
	public Long getLastOffTime() {
		return this.lastOffTime;
	}

	/**
	 * 最后登录时间
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * 最后登录时间
	 */
	public Date getLastLoginTime() {
		return this.lastLoginTime;
	}

	/**
	 * 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 创建时间
	 */
	public Date getCreateTime() {
		return this.createTime;
	}

	/**
	 * 地区
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * 地区
	 */
	public String getAreaName() {
		return this.areaName;
	}

	/**
	 * 地区编码
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * 地区编码
	 */
	public String getAreaCode() {
		return this.areaCode;
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
	public void setNickNamefuzzy(String nickNamefuzzy) {
		this.nickNamefuzzy = nickNamefuzzy;
	}

	/**
	 * 
	 */
	public String getNickNamefuzzy() {
		return this.nickNamefuzzy;
	}

	/**
	 * 
	 */
	public void setPasswordfuzzy(String passwordfuzzy) {
		this.passwordfuzzy = passwordfuzzy;
	}

	/**
	 * 
	 */
	public String getPasswordfuzzy() {
		return this.passwordfuzzy;
	}

	/**
	 * 
	 */
	public void setPersonalSignaturefuzzy(String personalSignaturefuzzy) {
		this.personalSignaturefuzzy = personalSignaturefuzzy;
	}

	/**
	 * 
	 */
	public String getPersonalSignaturefuzzy() {
		return this.personalSignaturefuzzy;
	}

	/**
	 * 
	 */
	public void setLastLoginTimeStart(String lastLoginTimeStart) {
		this.lastLoginTimeStart = lastLoginTimeStart;
	}

	/**
	 * 
	 */
	public String getLastLoginTimeStart() {
		return this.lastLoginTimeStart;
	}

	/**
	 * 
	 */
	public void setLastLoginTimeEnd(String lastLoginTimeEnd) {
		this.lastLoginTimeEnd = lastLoginTimeEnd;
	}

	/**
	 * 
	 */
	public String getLastLoginTimeEnd() {
		return this.lastLoginTimeEnd;
	}

	/**
	 * 
	 */
	public void setCreateTimeStart(String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	/**
	 * 
	 */
	public String getCreateTimeStart() {
		return this.createTimeStart;
	}

	/**
	 * 
	 */
	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	/**
	 * 
	 */
	public String getCreateTimeEnd() {
		return this.createTimeEnd;
	}

	/**
	 * 
	 */
	public void setAreaNamefuzzy(String areaNamefuzzy) {
		this.areaNamefuzzy = areaNamefuzzy;
	}

	/**
	 * 
	 */
	public String getAreaNamefuzzy() {
		return this.areaNamefuzzy;
	}

	/**
	 * 
	 */
	public void setAreaCodefuzzy(String areaCodefuzzy) {
		this.areaCodefuzzy = areaCodefuzzy;
	}

	/**
	 * 
	 */
	public String getAreaCodefuzzy() {
		return this.areaCodefuzzy;
	}

}