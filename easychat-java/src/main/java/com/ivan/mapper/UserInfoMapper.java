package com.ivan.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @Description: 用户信息
 * @author: ivan
 * @date: 2024/05/21
 */
public interface UserInfoMapper<T,P> extends BaseMapper {
	/**
	 * 根据UserId查询
	 */
	T selectByUserId(@Param("userId") String userId);

	/**
	 * 根据UserId删除
	 */
	int deleteByUserId(@Param("userId") String userId);

	/**
	 * 根据UserId更新
	 */
	int updateByUserId(@Param("bean") T t, @Param("userId") String userId);

	/**
	 * 根据Email查询
	 */
	T selectByEmail(@Param("email") String email);

	/**
	 * 根据Email删除
	 */
	int deleteByEmail(@Param("email") String email);

	/**
	 * 根据Email更新
	 */
	int updateByEmail(@Param("bean") T t, @Param("email") String email);

}