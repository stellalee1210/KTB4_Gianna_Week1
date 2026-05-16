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
                Spito spito = new Spito(userMoney);
                spito.make();
                spito.match();
                spito.makeResultMsg();
                break;
            case "2":
                Lottery lottery = new Lottery(userMoney);
                lottery.draw();
                lottery.match();
                lottery.makeResultMsg();
                break;
            default:
                PrintQuit();
        }
    }
}

