package com.bank.batch.config;

import com.bank.batch.dao.BankTransaction;
import com.bank.batch.dao.BankTransactionRepository;
import org.springframework.batch.core.step.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BankTransactionItemWriter implements ItemWriter<BankTransaction> {
    @Autowired
    private BankTransactionRepository bankTransactionRepository;
/*
    @Override
    public void write(Chunk<? extends BankTransaction> list) throws Exception {
        bankTransactionRepository.saveAll(list);
    }*/

    @Override
    public void write(List<? extends BankTransaction> list) throws Exception {
        bankTransactionRepository.saveAll(list);
    }
}
