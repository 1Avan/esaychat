package com.ivan.service;
import java.util.List;
import com.ivan.entity.po.UserInfoBeauty;
import com.ivan.entity.query.UserInfoBeautyQuery;
import com.ivan.entity.vo.PaginationResultVO;
/**
 * @Description: Service
 * @author: ivan
 * @date: 2024/05/21
 */
public interface UserInfoBeautyService {

	/**
	 * 根据条件查询列表
	 */
	List<UserInfoBeauty> findListByParam(UserInfoBeautyQuery query);

	/**
	 * 根据条件查询数量
	 */
	int findCountByParam(UserInfoBeautyQuery query);

	/**
	 * 分页查询
	 */
	PaginationResultVO<UserInfoBeauty> findListByPage(UserInfoBeautyQuery query);

	/**
	 * 新增
	 */
	int add(UserInfoBeauty bean);

	/**
	 * 新增或更新
	 */
	int addOrUpdate(UserInfoBeauty bean);

	/**
	 * 批量新增
	 */
	int addBatch(List<UserInfoBeauty> listBean);

	/**
	 * 批量新增或更新
	 */
	int addOrUpdateBatch(List<UserInfoBeauty> listBean);

	/**
	 * 根据IdAndUserId查询
	 */
	UserInfoBeauty getByIdAndUserId(Integer id, String userId);

	/**
	 * 根据IdAndUserId删除
	 */
	int deleteByIdAndUserId(Integer id, String userId);

	/**
	 * 根据IdAndUserId更新
	 */
	int updateByIdAndUserId(UserInfoBeauty bean, Integer id, String userId);

	/**
	 * 根据UserId查询
	 */
	UserInfoBeauty getByUserId(String userId);

	/**
	 * 根据UserId删除
	 */
	int deleteByUserId(String userId);

	/**
	 * 根据UserId更新
	 */
	int updateByUserId(UserInfoBeauty bean, String userId);

	/**
	 * 根据Email查询
	 */
	UserInfoBeauty getByEmail(String email);

	/**
	 * 根据Email删除
	 */
	int deleteByEmail(String email);

	/**
	 * 根据Email更新
	 */
	int updateByEmail(UserInfoBeauty bean, String email);

}