package com.example.plaid.entity.Embed;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
public class BankAccountOwnerId implements Serializable {

    private Long ownerId;
    private Long bankAccountId;

    public BankAccountOwnerId(Long ownerId, Long bankAccountId) {
        this.ownerId = ownerId;
        this.bankAccountId = bankAccountId;
    }

    public BankAccountOwnerId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankAccountOwnerId that = (BankAccountOwnerId) o;
        return ownerId.equals(that.ownerId) &&
                bankAccountId.equals(that.bankAccountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerId, bankAccountId);
    }
}
