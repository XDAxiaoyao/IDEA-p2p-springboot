package com.xiaoyao.p2p.service.loan;

/**
 * @Program:
 * @ClassName:
 * @Date: 2022/8/25 19:41
 * @Auther: 潇遙
 * @Project_Name: IDEA-p2p-springboot
 * @Description:
 */
public interface LoanInfoService {
    /**
     * 查询平台历史平均年化收益率
     * @return
     */
    Double queryHistoryAvgRate();
}
