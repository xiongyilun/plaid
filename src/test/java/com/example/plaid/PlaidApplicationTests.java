package com.example.plaid;

import com.example.plaid.dao.AccountDao;
import com.example.plaid.entity.BankAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlaidApplicationTests {

	@Autowired
	private AccountDao accountDao;
	@Test
	public void contextLoads() {
		//保存数据进bank_account以及bank_account_owner表
		BankAccount bankAccount = new BankAccount();
		bankAccount.setBankAccountId(123L);
		bankAccount.setAccountName("Plaid");
		bankAccount.setAccountNumber("12335645633121111");
		bankAccount.setRoutingNumber("12312312");
		accountDao.save(bankAccount);
	}

}
