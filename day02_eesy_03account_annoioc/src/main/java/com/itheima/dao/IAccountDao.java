package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

public interface IAccountDao {


    List<Account> findAllAccount();

    Account findAccountById(Integer accountID);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountID);

}
