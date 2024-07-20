package com.ivan.service.impl;

import com.ivan.entity.po.UserInfo;
import com.ivan.entity.po.UserInfoBeauty;
import com.ivan.entity.query.UserInfoBeautyQuery;
import com.ivan.entity.query.UserInfoQuery;
import com.ivan.entity.vo.PaginationResultVO;
import com.ivan.entity.query.SimplePage;
import com.ivan.entity.vo.ResponseVO;
import com.ivan.enums.BeautyAccountStatusEnum;
import com.ivan.enums.UserContactTypeEnum;
import com.ivan.enums.UserStatusEnum;
import com.ivan.exception.BusinessException;
import com.ivan.mapper.UserInfoBeautyMapper;
import com.ivan.mapper.UserInfoMapper;
import com.ivan.enums.PageSize;
import com.ivan.service.UserInfoService;
import com.ivan.utils.StringTools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 用户信息Service
 * @author: ivan
 * @date: 2024/05/21
 */
@Service("infoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper<UserInfo, UserInfoQuery> userInfoMapper;

    @Resource
    private UserInfoBeautyMapper<UserInfoBeauty, UserInfoQuery> userInfoBeautyMapper;

    /**
     * 根据条件查询列表
     */
    @Override
    public List<UserInfo> findListByParam(UserInfoQuery query) {
        return this.userInfoMapper.selectList(query);
    }

    /**
     * 根据条件查询数量
     */
    @Override
    public int findCountByParam(UserInfoQuery query) {
        return this.userInfoMapper.selectCount(query);
    }

    /**
     * 分页查询
     */
    @Override
    public PaginationResultVO<UserInfo> findListByPage(UserInfoQuery query) {
        int count = this.findCountByParam(query);
        int pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
        SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
        query.setSimplePage(page);
        List<UserInfo> list = this.findListByParam(query);
        PaginationResultVO<UserInfo> result = new PaginationResultVO<>(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }

    /**
     * 新增
     */
    @Override
    public int add(UserInfo bean) {
        return this.userInfoMapper.insert(bean);
    }

    /**
     * 新增或更新
     */
    @Override
    public int addOrUpdate(UserInfo bean) {
        return this.userInfoMapper.insertOrUpdate(bean);
    }

    /**
     * 批量新增
     */
    @Override
    public int addBatch(List<UserInfo> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.userInfoMapper.insertBatch(listBean);
    }

    /**
     * 批量新增或更新
     */
    @Override
    public int addOrUpdateBatch(List<UserInfo> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.userInfoMapper.insertOrUpdateBatch(listBean);
    }

    /**
     * 根据UserId查询
     */
    @Override
    public UserInfo getByUserId(String userId) {
        return this.userInfoMapper.selectByUserId(userId);
    }

    /**
     * 根据UserId删除
     */
    @Override
    public int deleteByUserId(String userId) {
        return this.userInfoMapper.deleteByUserId(userId);
    }

    /**
     * 根据UserId更新
     */
    @Override
    public int updateByUserId(UserInfo bean, String userId) {
        return this.userInfoMapper.updateByUserId(bean, userId);
    }

    /**
     * 根据Email查询
     */
    @Override
    public UserInfo getByEmail(String email) {
        return this.userInfoMapper.selectByEmail(email);
    }

    /**
     * 根据Email删除
     */
    @Override
    public int deleteByEmail(String email) {
        return this.userInfoMapper.deleteByEmail(email);
    }

    /**
     * 根据Email更新
     */
    @Override
    public int updateByEmail(UserInfo bean, String email) {
        return this.userInfoMapper.updateByEmail(bean, email);
    }

    /**
     * 用户注册
     *
     * @param email
     * @param nickName
     * @param password
     */
    @Override
    public Map<String, Object> register(String email, String nickName, String password) {
        UserInfo userInfo = this.userInfoMapper.selectByEmail(email);
        Map<String, Object> result = new HashMap<>();
        if (null == userInfo) {
            String userId = StringTools.getUserId();

            UserInfoBeauty beautyAccount = this.userInfoBeautyMapper.selectByEmail(email);
            Boolean UseBeautyAcount = null != beautyAccount && BeautyAccountStatusEnum.NO_USE.getStatus().equals(beautyAccount.getStatus());
            if (UseBeautyAcount) {
                userId = UserContactTypeEnum.USER.getPrefix() + beautyAccount.getUserId();
            }
            Date curDate = new Date();
            userInfo = new UserInfo();
            userInfo.setUserId(userId);
            userInfo.setEmail(email);
            userInfo.setPassword(StringTools.encodeMd5(password));
            userInfo.setCreateTime(curDate);
            userInfo.setStatus(UserStatusEnum.ENABLE.getStatus());
            userInfo.setLastOffTime(curDate.getTime());
            this.userInfoMapper.insert(userInfo);
            if(UseBeautyAcount) {
                UserInfoBeauty updateBeauty = new UserInfoBeauty();
                updateBeauty.setStatus(BeautyAccountStatusEnum.USEED.getStatus());
                this.userInfoBeautyMapper.updateByUserId(updateBeauty, String.valueOf(beautyAccount.getId()));
            }
            //TODO 创建机器人好友
        } else {
            result.put("success", false);
            result.put("errorMsg", "邮箱已存在");

        }
        return result;

    }

    @Override
    public Map register(String email, String password) {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(StringTools.getUserId());
    }

}