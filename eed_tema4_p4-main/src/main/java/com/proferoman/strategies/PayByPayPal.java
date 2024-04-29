package com.proferoman.strategies;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PayByPayPal implements PayStrategy {
    private String email;
    private String password;
    private boolean signedIn;

public PayByPayPal(){
        collectPaymentDetails();
    }

    private static final Map<String, String> DATA_BASE = new HashMap<>();
static {
    DATA_BASE.put("alice", "alice@alice.com");
    DATA_BASE.put("bob", "bob@bob.com");
}

@Override
public boolean pay(int amount) {
    if (signedIn == true) {
        return true;
    }else{
        return false;
    }
}

@Override
public void collectPaymentDetails() {
    Scanner sc = new Scanner(System.in);
    System.out.println("escribe el email");
    email = sc.nextLine();

    System.out.println("escribe la contraseña");
    password = sc.nextLine();

    if (email.equals(DATA_BASE.get(password))){
        signedIn = true;
        System.out.println("correcto");
    }else{
        System.out.println("incorrecto");
    }

}
}
