package org.example;
import java.util.Scanner;

public class IO {
    static Scanner sc = new Scanner(System.in);

    static String PrintIntro() {
        System.out.println("----- <<KTB 로또 키오스크>> -----");
        System.out.println("안녕하십니까. 어떤 기능을 사용하시겠습니까?");
        System.out.print("1.스피또 발행\n2.로또(자동) 발행\n3.종료\n");
        return GetOption();
    }

    static void PrintResult(String result){
        System.out.println(result);
    }

    static String GetOption() {
        System.out.print(">>> ");
        return sc.next();
    }

    static String GetMoney(){
        System.out.print("\n구매하실 금액을 입력해주세요. (1000원 단위)\n>>> ");
        return sc.next();
    }

    static void PrintQuit(){
        System.out.println("\n----- <<프로그램 종료>> -----");
        System.out.print("이용해주셔서 감사합니다.\n좋은 하루 보내세요!");
    }
}