package org.example;

import org.example.Validator.MoneyInputValidator;
import org.example.Validator.OptionValidator;

import static org.example.IO.*;

public class Main {
    static void main() {
        PrintIntro();
        String userChoice ="";
         while(userChoice.isBlank()){
             try{
                 userChoice= GetOption();
                 new OptionValidator(userChoice);
                 if(!userChoice.equals("3")){
                     progress(userChoice);
                 }
             } catch (Exception e) {
                PrintErrorMsg(e.getMessage());
                 userChoice ="";
             }
         }
        PrintQuit();
    }

    static void progress(String userChoice){
        String userMoney ="";
        while(userMoney.isBlank()){
            try {
                userMoney = GetMoney();
                new MoneyInputValidator(userMoney);
            }catch (Exception e){
                PrintErrorMsg(e.getMessage());
                userMoney = "";
            }
        }

        startGame(userChoice, Integer.parseInt(userMoney));
    }

    static void startGame (String userChoice, int userMoney){
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

    static void lotteryGame (int userMoney){
        Lottery lottery = new Lottery(userMoney);
        lottery.draw();
        lottery.match();
        lottery.makeResultMsg();
    }
}

