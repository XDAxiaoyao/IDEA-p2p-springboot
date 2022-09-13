package com.xiaoyao.p2p.service.impl.loan;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaoyao.cons.Constants;
import com.xiaoyao.p2p.mapper.loan.LoanInfoMapper;
import com.xiaoyao.p2p.service.loan.LoanInfoService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Program:
 * @ClassName:
 * @Date: 2022/8/25 19:45
 * @Auther: 潇遙
 * @Project_Name: IDEA-p2p-springboot
 * @Description:
 */

@Component
@Service(interfaceClass = LoanInfoService.class,version = "1.0.0",timeout = 15000)
public class LoanInfoServiceImpl implements LoanInfoService {

    @Autowired
    private LoanInfoMapper loanInfoMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public  Double queryHistoryAvgRate() {

        redisTemplate.setKeySerializer(new StringRedisSerializer());//修改redis中key的序列化方式
        //"historyAvgRate"在002模块中设置了工具常量类
        Double historyAvgRate = (Double) redisTemplate.opsForValue().get(Constants.HISTORY_AVG_RATE);
        /*
        if (!ObjectUtils.allNotNull(historyAvgRate)){
            System.out.println("===从数据库中获取===");
            //reids中没有数据
            historyAvgRate =   loanInfoMapper.selectHistoryAvgRate();
            //把数据库中的数据保存到redis中一份  给redis设置时间 不然会永久保存
            redisTemplate.opsForValue().set(Constants.HISTORY_AVG_RATE,historyAvgRate,7, TimeUnit.DAYS );
        }else {
            System.out.println("===从redis中获取===");
        }

         */

        if (!ObjectUtils.allNotNull(historyAvgRate)){
            synchronized (this){
                historyAvgRate = (Double) redisTemplate.opsForValue().get(Constants.HISTORY_AVG_RATE);
                if(!ObjectUtils.allNotNull(historyAvgRate)){
                    System.out.println("===从数据库中获取===");
                    //reids中没有数据
                    historyAvgRate =   loanInfoMapper.selectHistoryAvgRate();
                    //把数据库中的数据保存到redis中一份  给redis设置时间 不然会永久保存
                    redisTemplate.opsForValue().set(Constants.HISTORY_AVG_RATE,historyAvgRate,7,
                            TimeUnit.DAYS );
                }else {
                    System.out.println("===从redis中获取===");
                }
            }
        }else {
            System.out.println("===从redis中获取===");
        }
        return historyAvgRate;
    }
}
