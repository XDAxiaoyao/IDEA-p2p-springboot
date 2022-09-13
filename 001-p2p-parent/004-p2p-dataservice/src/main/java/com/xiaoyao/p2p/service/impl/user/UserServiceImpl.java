package com.xiaoyao.p2p.service.impl.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaoyao.cons.Constants;
import com.xiaoyao.p2p.mapper.user.UserMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Program:
 * @ClassName:
 * @Date: 2022/9/3 17:36
 * @Auther: 潇遙
 * @Project_Name: IDEA-p2p-springboot
 * @Description:
 */


@Component
@Service(interfaceClass = UserService.class,version = "1.0.0",timeout = 15000)
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Override
    public Integer queryAllUserCount() {
      Integer allUserCount = (Integer) redisTemplate.opsForValue().get(Constants.ALL_USER_COUNT);
      //表明
        if (!ObjectUtils.allNotNull(allUserCount)) {
            synchronized (this){
               allUserCount = (Integer) redisTemplate.opsForValue().get(Constants.ALL_USER_COUNT);
               if (!ObjectUtils.allNotNull(allUserCount)){
                  allUserCount = userMapper.selectAllUserCount();
                  redisTemplate.opsForValue().set(Constants.ALL_USER_COUNT,allUserCount) ;
               }
            }
        }
        return allUserCount;
    }
}
