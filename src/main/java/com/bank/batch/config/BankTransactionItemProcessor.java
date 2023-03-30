package com.bank.batch.config;

import com.bank.batch.dao.BankTransaction;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

//@Component
public class BankTransactionItemProcessor implements ItemProcessor<BankTransaction, BankTransaction> {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-H:mm");
    @Override
    public BankTransaction process(BankTransaction bankTransaction) throws Exception {
        bankTransaction.setTransationDate(dateFormat.parse(bankTransaction.getStrTransactionDate()));
        return bankTransaction;
    }
}
