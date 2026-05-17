package org.example;

import static org.example.IO.*;

public class Main {
    static void main() {
        String userChoice = PrintIntro();
        if(userChoice.equals("3")){
            PrintQuit();
        }else{
            progress(userChoice);
        }
    }

    static void progress(String userChoice){
        int userMoney = Integer.parseInt(GetMoney());
        switch (userChoice){
            case "1" :
                spitoGame(userMoney);
                break;
            case "2":
                lotteryGame(userMoney);
                break;
            default:
                PrintQuit();
        }
    }

    static void spitoGame (int userMoney){
        Spito spito = new Spito(userMoney);
        spito.make();
        spito.match();
        spito.makeResultMsg();
    }

    static  void lotteryGame (int userMoney){
        Lottery lottery = new Lottery(userMoney);
        lottery.draw();
        lottery.match();
        lottery.makeResultMsg();
    }
}

