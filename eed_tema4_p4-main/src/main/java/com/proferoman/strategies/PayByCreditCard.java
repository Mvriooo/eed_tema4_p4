package com.proferoman.strategies;

import java.util.Scanner;

public class PayByCreditCard implements PayStrategy {
    private CreditCard card;

    public PayByCreditCard(){
        collectPaymentDetails();
    }

    @Override
public boolean pay(int amount) {
    if ( card != null){
        int resta = card.getAmount()-amount;
        return true;
    }else{
        return false;
    }
    
}

    @Override
public void collectPaymentDetails() {
    Scanner sc = new Scanner(System.in);

    System.out.println("Introduzca el numero de la tarjeta");
    String num = sc.nextLine();

    System.out.println("introduzca la fecha de expiracion");
    String date = sc.nextLine();

    System.out.println("introduzca el CVV");
    String cvv = sc.nextLine();

    CreditCard card = new CreditCard(num, date, cvv);
    
}
}
