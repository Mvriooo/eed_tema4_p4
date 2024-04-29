package com.proferoman.order;

import com.proferoman.strategies.PayStrategy;

public class Order {
    private int totalcost;
    private boolean isClosed;

    public Order(){
    }

    public void processOrder(PayStrategy strategy){

    }

    public void setTotalCost(int cost){
        this.totalcost = cost;
    }

    public int getTotalCost(){
        return this.totalcost;
    }

    public boolean isClosed(){
        return isClosed;
    }

    public void setClosed(){
        this.isClosed = true;
    }
}
