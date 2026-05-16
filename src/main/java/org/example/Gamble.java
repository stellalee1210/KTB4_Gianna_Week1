package org.example;

public class Gamble {
    protected int betMoney = 0;
    protected int pricePerGame = 0;

    protected void setBetMoney(int money){
        this.betMoney = money;
    }
    protected void setPricePerGame(int price){this.pricePerGame = price; }
}
