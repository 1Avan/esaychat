package com.ivan.service;
import java.util.List;
import java.util.Map;

import com.ivan.entity.po.UserInfo;
import com.ivan.entity.query.UserInfoQuery;
import com.ivan.entity.vo.PaginationResultVO;
/**
 * @Description: 用户信息Service
 * @author: ivan
 * @date: 2024/05/21
 */
public interface UserInfoService {

	/**
	 * 根据条件查询列表
	 */
	List<UserInfo> findListByParam(UserInfoQuery query);

	/**
	 * 根据条件查询数量
	 */
	int findCountByParam(UserInfoQuery query);

	/**
	 * 分页查询
	 */
	PaginationResultVO<UserInfo> findListByPage(UserInfoQuery query);

	/**
	 * 新增
	 */
	int add(UserInfo bean);

	/**
	 * 新增或更新
	 */
	int addOrUpdate(UserInfo bean);

	/**
	 * 批量新增
	 */
	int addBatch(List<UserInfo> listBean);

	/**
	 * 批量新增或更新
	 */
	int addOrUpdateBatch(List<UserInfo> listBean);

	/**
	 * 根据UserId查询
	 */
	UserInfo getByUserId(String userId);

	/**
	 * 根据UserId删除
	 */
	int deleteByUserId(String userId);

	/**
	 * 根据UserId更新
	 */
	int updateByUserId(UserInfo bean, String userId);

	/**
	 * 根据Email查询
	 */
	UserInfo getByEmail(String email);

	/**
	 * 根据Email删除
	 */
	int deleteByEmail(String email);

	/**
	 * 根据Email更新
	 */
	int updateByEmail(UserInfo bean, String email);

	/**
	 * 注册
	 * @param email
	 * @param nickName
	 * @param password
	 */
	Map register(String email, String nickName, String password);


	Map register(String email, String password);


}