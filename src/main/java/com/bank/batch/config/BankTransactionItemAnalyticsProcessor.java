package com.bank.batch.config;

import com.bank.batch.dao.BankTransaction;
import lombok.Getter;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

//@Component
public class BankTransactionItemAnalyticsProcessor implements ItemProcessor<BankTransaction, BankTransaction> {
    @Getter
    private double totalDebit;
    @Getter
    private double totalCredit;
    @Override
    public BankTransaction process(BankTransaction bankTransaction) throws Exception {
        if(bankTransaction.getTransactionType().equalsIgnoreCase("D"))
            totalDebit += bankTransaction.getAmount();
        else if(bankTransaction.getTransactionType().equalsIgnoreCase("C"))
            totalCredit += bankTransaction.getAmount();
        return bankTransaction;
    }
}
