package com.ivan.entity.po;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import com.ivan.enums.DateTimePatternEnum;
import com.ivan.utils.DateUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @Description: 用户信息
 * @author: ivan
 * @date: 2024/05/21
 */
public class UserInfo implements Serializable {
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * 0.直接加好友 1.需要同意
	 */
	private Integer joinType;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 性别：0男 1女
	 */
	private Integer sex;
	/**
	 * 个性签名
	 */
	private String personalSignature;
	/**
	 * 状态
	 */
	@JsonIgnore
	private Integer status;
	/**
	 * 最后登出时间
	 */
	private Long lastOffTime;
	/**
	 * 最后登录时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date lastLoginTime;
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**
	 * 地区
	 */
	private String areaName;
	/**
	 * 地区编码
	 */
	private String areaCode;
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

	@Override
	public String toString() {
		return "Info {" + "用户id : " + (userId == null ? "空" : userId) + "," + "邮箱 : " + (email == null ? "空" : email) + "," + "昵称 : " + (nickName == null ? "空" : nickName) + "," + "0.直接加好友 1.需要同意 : " + (joinType == null ? "空" : joinType) + "," + "密码 : " + (password == null ? "空" : password) + "," + "性别：0男 1女 : " + (sex == null ? "空" : sex) + "," + "个性签名 : " + (personalSignature == null ? "空" : personalSignature) + "," + "状态 : " + (status == null ? "空" : status) + "," + "最后登出时间 : " + (lastOffTime == null ? "空" : lastOffTime) + "," + "最后登录时间 : " + (lastLoginTime == null ? "空" : DateUtils.format(lastLoginTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + "创建时间 : " + (createTime == null ? "空" : DateUtils.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + "地区 : " + (areaName == null ? "空" : areaName) + "," + "地区编码 : " + (areaCode == null ? "空" : areaCode) + "}";
	}
}