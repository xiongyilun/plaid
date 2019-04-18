package com.example.plaid.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author nolan
 * @date 2019-04-18
 */
@Entity
@Data
@Table(name = "bank_account")
@DynamicInsert
@DynamicUpdate
public class BankAccount implements Serializable {

    @Id
    @GeneratedValue
    private Long bankAccountId;
    private String remittanceType;
    private String accountType;
    private String accountName;
    private String bankName;
    private String nickName;
    private String routingNumber;
    private String accountNumber;
    private String accountShortNumber;

}
