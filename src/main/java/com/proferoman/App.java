package com.proferoman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.proferoman.order.Order;
import com.proferoman.strategies.PayByCreditCard;
import com.proferoman.strategies.PayByPayPal;
import com.proferoman.strategies.PayStrategy;

public class App {
    private static Map<Integer, Integer> priceOnProducts = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy strategy;

    static {
        priceOnProducts.put(1, 2200);
        priceOnProducts.put(2, 1850);
        priceOnProducts.put(3, 1100);
        priceOnProducts.put(4, 890);
    }

    public static void main( String[] args ) {
	try {
	    while (!order.isClosed()) {
		int cost;

		String continueChoice;
		do {
		    System.out.print("Selecciona un producto:" + "\n" +
				     "1 - Placa base" + "\n" +
				     "2 - CPU" + "\n" +
				     "3 - HDD" + "\n" +
				     "4 - Memoria" + "\n");
		    int choice = Integer.parseInt(reader.readLine());
		    cost = priceOnProducts.get(choice);
		    System.out.print("Count: ");
		    int count = Integer.parseInt(reader.readLine());
		    order.setTotalCost(cost * count);
		    System.out.print("Deseas seguir seleccionando más productos? S/N: ");
		    continueChoice = reader.readLine();
		} while (continueChoice.equalsIgnoreCase("S"));

		if (strategy == null) {
		    System.out.println("Selecciona un método de pago:" + "\n" +
				       "1 - PalPay" + "\n" +
				       "2 - Tarjeta de crédito");
		    String paymentMethod = reader.readLine();

		    // Client creates different strategies based on input from user,
		    // application configuration, etc.
		    if (paymentMethod.equals("1")) {
			strategy = new PayByPayPal();
		    } else {
			strategy = new PayByCreditCard();
		    }
		}

		// Order object delegates gathering payment data to strategy object,
		// since only strategies know what data they need to process a
		// payment.
		order.processOrder(strategy);

		System.out.print("Pagar " + order.getTotalCost() + " unidades o continuar comprando? P/C: ");
		String proceed = reader.readLine();
		if (proceed.equalsIgnoreCase("P")) {
		    // Finally, strategy handles the payment.
		    if (strategy.pay(order.getTotalCost())) {
			System.out.println("Pago realizado con éxito.");
		    } else {
			System.out.println("FALLÓ! Por favor, comprueba sus datos.");
		    }
		    order.setClosed();
		}
	    }
	} catch (java.io.IOException e) {
	    System.out.println("IOException: una excepción ha sido lanzada: " + e.getMessage());
	}
    }
}
