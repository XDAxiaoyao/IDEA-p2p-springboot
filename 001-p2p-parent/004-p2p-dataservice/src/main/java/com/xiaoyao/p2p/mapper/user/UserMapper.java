package com.xiaoyao.p2p.mapper.user;

import com.xiaoyao.p2p.model.user.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    /**
     * 查询用户总人数
     * @return
     */
    Integer selectAllUserCount();
}















