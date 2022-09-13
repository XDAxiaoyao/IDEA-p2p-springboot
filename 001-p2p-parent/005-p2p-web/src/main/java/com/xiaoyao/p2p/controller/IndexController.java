package com.xiaoyao.p2p.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaoyao.cons.Constants;
import com.xiaoyao.p2p.service.impl.user.UserService;
import com.xiaoyao.p2p.service.loan.LoanInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Program:
 * @ClassName:
 * @Date: 2022/8/24 20:28
 * @Auther: 潇遙
 * @Project_Name: IDEA-p2p-springboot
 * @Description:
 */

@Controller
public class IndexController {

    @Reference(interfaceClass = LoanInfoService.class,version = "1.0.0",check = false,timeout = 15000)
    private LoanInfoService loanInfoService;



    @Reference(interfaceClass = UserService.class,version = "1.0.0",check = false,timeout = 15000)
    private UserService userService;



    @Reference(interfaceClass = BidInfoService.class,version = "1.0.0",check = false,timeout = 15000)
    private BidInfoService bidInfoService;



    @RequestMapping("/index")
    public String toIndex(Model model){
        //查询首页

/*         ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 1000; i++) {
       executorService.submit(new Runnable() {
           @Override
           public void run() {
               //查询平台历史平均收益率,所有的 不用传参数
               Double historyAvgRate = loanInfoService.queryHistoryAvgRate();
               model.addAttribute(Constants.HISTORY_AVG_RATE,historyAvgRate);
           }
       });
        }
//关闭资源
        executorService.shutdownNow(); */

        //查询平台历史平均收益率,所有的 不用传参数
        Double historyAvgRate = loanInfoService.queryHistoryAvgRate();
        model.addAttribute(Constants.HISTORY_AVG_RATE,historyAvgRate);

        //查询平台的用户数量

      Integer allUserCount =  userService.queryAllUserCount();
model.addAttribute(Constants.ALL_USER_COUNT,allUserCount);
        //查询平台的累计成交金额


       Double allBidMoney = bidInfoService.queryAllBidMoney();
       model.addAttribute(Constants.)
        //查询新手宝产品

        //查询优选类产品

        //查询散标类产品

        return "index";
    }
}
