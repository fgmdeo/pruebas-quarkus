package com.paymentchain.transaction;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class TransactionService {


    public List<Transaction> listAll() {
        return Transaction.listAll();
    }

    public Transaction findById(long id) {
        return Transaction.findById(id);
    }

    public boolean delete(long id) {
        return Transaction.deleteById(id);
    }

    public List<Transaction> findAllByReferenceIban(String reference, String ibanAccount) {
        if (!reference.equals("reference"))
            return Transaction.findReference(reference);
        else
            return Transaction.findIban(ibanAccount);
    }

    public void update(Transaction transaction) {
        Transaction.update(transaction);
    }

    public Transaction save(Transaction newTransaction) {
        newTransaction.persist();
        return newTransaction;
    }
        

    
}