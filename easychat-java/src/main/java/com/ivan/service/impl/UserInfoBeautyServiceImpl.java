package com.ivan.service.impl;

import com.ivan.entity.po.UserInfoBeauty;
import com.ivan.entity.query.UserInfoBeautyQuery;
import com.ivan.entity.vo.PaginationResultVO;
import com.ivan.entity.query.SimplePage;
import com.ivan.mapper.UserInfoBeautyMapper;
import com.ivan.enums.PageSize;
import com.ivan.service.UserInfoBeautyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: Service
 * @author: ivan
 * @date: 2024/05/21
 */
@Service("infoBeautyService")
public class UserInfoBeautyServiceImpl implements UserInfoBeautyService {

	@Resource
	private UserInfoBeautyMapper<UserInfoBeauty, UserInfoBeautyQuery> infoBeautyMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<UserInfoBeauty> findListByParam(UserInfoBeautyQuery query) {
		return this.infoBeautyMapper.selectList(query);
	}

	/**
	 * 根据条件查询数量
	 */
	@Override
	public int findCountByParam(UserInfoBeautyQuery query) {
		return this.infoBeautyMapper.selectCount(query);
	}

	/**
	 * 分页查询
	 */
	@Override
	public PaginationResultVO<UserInfoBeauty> findListByPage(UserInfoBeautyQuery query) {
		int count = this.findCountByParam(query);
		int pageSize = query.getPageSize()==null?PageSize.SIZE15.getSize():query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(),count,pageSize);
		query.setSimplePage(page);
		List<UserInfoBeauty> list = this.findListByParam(query);
		PaginationResultVO<UserInfoBeauty> result = new PaginationResultVO<>(count,page.getPageSize(),page.getPageNo(),page.getPageTotal(),list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public int add(UserInfoBeauty bean) {
		return this.infoBeautyMapper.insert(bean);
	}

	/**
	 * 新增或更新
	 */
	@Override
	public int addOrUpdate(UserInfoBeauty bean) {
		return this.infoBeautyMapper.insertOrUpdate(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public int addBatch(List<UserInfoBeauty> listBean) {
		if(listBean == null || listBean.isEmpty()){
			return 0;
		}
		return this.infoBeautyMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或更新
	 */
	@Override
	public int addOrUpdateBatch(List<UserInfoBeauty> listBean) {
		if(listBean == null || listBean.isEmpty()){
			return 0;
		}
		return this.infoBeautyMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 根据IdAndUserId查询
	 */
	@Override
	public UserInfoBeauty getByIdAndUserId(Integer id, String userId) {
		return this.infoBeautyMapper.selectByIdAndUserId(id, userId);
	}

	/**
	 * 根据IdAndUserId删除
	 */
	@Override
	public int deleteByIdAndUserId(Integer id, String userId) {
		return this.infoBeautyMapper.deleteByIdAndUserId(id, userId);
	}

	/**
	 * 根据IdAndUserId更新
	 */
	@Override
	public int updateByIdAndUserId(UserInfoBeauty bean, Integer id, String userId) {
		return this.infoBeautyMapper.updateByIdAndUserId(bean, id, userId);
	}

	/**
	 * 根据UserId查询
	 */
	@Override
	public UserInfoBeauty getByUserId(String userId) {
		return this.infoBeautyMapper.selectByUserId(userId);
	}

	/**
	 * 根据UserId删除
	 */
	@Override
	public int deleteByUserId(String userId) {
		return this.infoBeautyMapper.deleteByUserId(userId);
	}

	/**
	 * 根据UserId更新
	 */
	@Override
	public int updateByUserId(UserInfoBeauty bean, String userId) {
		return this.infoBeautyMapper.updateByUserId(bean, userId);
	}

	/**
	 * 根据Email查询
	 */
	@Override
	public UserInfoBeauty getByEmail(String email) {
		return this.infoBeautyMapper.selectByEmail(email);
	}

	/**
	 * 根据Email删除
	 */
	@Override
	public int deleteByEmail(String email) {
		return this.infoBeautyMapper.deleteByEmail(email);
	}

	/**
	 * 根据Email更新
	 */
	@Override
	public int updateByEmail(UserInfoBeauty bean, String email) {
		return this.infoBeautyMapper.updateByEmail(bean, email);
	}

}