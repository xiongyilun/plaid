package com.example.plaid.entity;

import com.example.plaid.entity.embed.BankAccountOwnerId;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "bank_account_owner")
@DynamicInsert
@DynamicUpdate
public class BankAccountOwner implements Serializable {


    private BankAccountOwnerId id;
    private Long updatedAt;
    private Long trackingId;

    @EmbeddedId
    public BankAccountOwnerId getId() {
        return id;
    }

    public void setId(BankAccountOwnerId id) {
        this.id = id;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(Long trackingId) {
        this.trackingId = trackingId;
    }
}
