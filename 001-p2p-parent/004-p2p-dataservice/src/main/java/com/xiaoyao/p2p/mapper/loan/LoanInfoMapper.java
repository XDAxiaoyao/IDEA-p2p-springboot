package com.xiaoyao.p2p.mapper.loan;

import com.xiaoyao.p2p.model.loan.LoanInfo;

public interface LoanInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoanInfo record);

    int insertSelective(LoanInfo record);

    LoanInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoanInfo record);

    int updateByPrimaryKey(LoanInfo record);


    /**
     * 获取平台历史年化收益率
     * @return
     */
    Double selectHistoryAvgRate();
}
