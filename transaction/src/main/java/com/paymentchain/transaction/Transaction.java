package com.paymentchain.transaction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Transaction extends PanacheEntity{

    public enum TransactionChannel {
	    WEB,CAJERO,OFICINA
	}


    private String reference;

    public Transaction(String reference, String ibanAccount, LocalDateTime date, double amount, double fee,
            String description, String status, TransactionChannel channel) {
        this.reference = reference;
        this.ibanAccount = ibanAccount;
        this.date = date;
        this.amount = amount;
        this.fee = fee;
        this.description = description;
        this.status = status;
        this.channel = channel;
    }

    public Transaction(){
        
    }

    private String ibanAccount;
    private LocalDateTime date;
    private double amount ;
    private double fee;
    private String description;
    private String status;
    @Enumerated(EnumType.STRING)
    private TransactionChannel channel;


    


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("Transaction [amount=").append(amount).append(", channel=" ).append(channel ).append(", date=" )
        .append(date.toString() ).append(", description=").append(description)
                .append(fee).append("fee ").append("ibanAccount=" ).append(ibanAccount)
                .append(", id=" ).append(id ).append(", reference=")
                .append(reference ).append(", status=").append(status)
                .append("]");
                return sb.toString();
    }

 

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getIbanAccount() {
        return ibanAccount;
    }

    public void setIbanAccount(String ibanAccount) {
        this.ibanAccount = ibanAccount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TransactionChannel getChannel() {
        return channel;
    }

    public void setChannel(TransactionChannel channel) {
        this.channel = channel;
    }


    public Transaction(String reference2, String ibamnAccount, double amount2, double fee2, String description2,
            String status2, TransactionChannel channel2) {
    }

    public List<Transaction> findByReference(String reference){
        return list("reference", reference);
    }

    public List<Transaction> findByIbanAccount(String ibanAccount){
        return list("ibanAccount", ibanAccount);

    }

    public static void update( final Transaction transaction ) { 
        Optional<Transaction> previous = Transaction.findByIdOptional( transaction.id ); 
      
        previous.ifPresentOrElse(( update ) -> { 
            update.id = transaction.id;
            update.reference = transaction.reference;
            update.ibanAccount =  transaction.ibanAccount;
            update.date =  transaction.date;
            update.amount =  transaction.amount;
            update.fee =  transaction.fee;
            update.description =  transaction.description;
            update.status =  transaction.status;
            update.channel =  transaction.channel;
            update.persist();
        }, () -> { 
                throw new WebApplicationException( Response.Status.NOT_FOUND );
        });
      }

      public static List<Transaction> findReference(String reference){
        return list("reference", reference);
    }

    public static List<Transaction> findIban(String iban){
        return list("ibanAccount", iban);
    }

}
