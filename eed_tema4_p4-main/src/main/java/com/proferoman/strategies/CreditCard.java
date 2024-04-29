package com.proferoman.strategies;

public class CreditCard {
    private int amount = 100000;
    private String number;
    private String date;
    private String cvv;

    CreditCard( String number, String date, String cvv){
        this.number = number;
        this.date = date;
        this.cvv = cvv;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public int getAmount(){
        return this.amount;
    }
}
