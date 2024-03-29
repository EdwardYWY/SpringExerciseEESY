package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class AccountDaoImpl implements IAccountDao {

    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public List<Account> findAllAccount() {
        try {
            return runner.query("SELECT * FROM account",new BeanListHandler<Account>(Account.class));
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Account findAccountById(Integer accountID) {
        try {
            return runner.query("SELECT * FROM account WHERE id = ?",new BeanHandler<Account>(Account.class),accountID);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try {
            runner.update("INSERT into account(name,money)values(?,?)",account.getName(),account.getMoney());
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {
        try {
            runner.update("UPDATE account SET name=?, money=?, WHERE id=?",account.getName(),account.getMoney(),account.getId());
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(Integer accountID) {
        try {
            runner.update("DELETE FROM account WHERE id=?",accountID);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
