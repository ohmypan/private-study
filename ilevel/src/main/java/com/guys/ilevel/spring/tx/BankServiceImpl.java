package com.guys.ilevel.spring.tx;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

/**
 * File：BankServiceImpl <br>
 * Created on 2019/3/21.
 * Title:  <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 潘国忠
 * @version 1.0
 */
public class BankServiceImpl implements BankService {
    private BankDao bankDao;
    private TransactionDefinition txDefinition;
    private PlatformTransactionManager txManager;

    public boolean transfer(Long fromId, Long toId,double amount) {
        // 获取一个事务
        TransactionStatus txStatus = txManager.getTransaction(txDefinition);
        boolean result = false;
        try {
            result = bankDao.transfer(fromId, toId,amount);
            // 事务提交
            txManager.commit(txStatus);
        } catch (Exception e) {
            result = false;
            // 事务回滚
            txManager.rollback(txStatus);
            System.out.println("Transfer Error!");
        }
        return result;
    }
}
