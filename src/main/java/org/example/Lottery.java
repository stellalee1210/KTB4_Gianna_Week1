package org.example;

import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.example.IO.PrintResult;

public class Lottery extends Gamble{
    protected ArrayList<ArrayList<Integer>> gameList = new ArrayList<>();
    protected ArrayList<Integer> winningNumbers = new ArrayList<>();
    protected int[] matchCount;
    protected int maxLimit =0;

    public Lottery(int money){
        saveBet(money);
        this.matchCount= new int[money/1000];
        this.setPricePerGame(1000);
        this.maxLimit = 45;
    }
    public void saveBet(int money){
        super.setBetMoney(money);
    }
    protected void draw(){
        for(int i =0; i<this.betMoney / super.pricePerGame; i++) {
            //6자리 랜덤 뽑기
            ArrayList<Integer> rowsList = makeSortedRow();
            this.gameList.add(rowsList);
        }
    }

    private ArrayList<Integer> makeSortedRow(){
        HashSet<Integer> hashSet = new HashSet<>();
        while (hashSet.size() < 6) {
            int number = pickRandomNum();
            hashSet.add(number);
        }
        ArrayList<Integer> sortedList = new ArrayList<>(hashSet);
        sortedList.sort(Comparator.naturalOrder());
        return sortedList;
    }
    protected int pickRandomNum(){
        Random random = new Random();
        return random.nextInt(this.maxLimit) + 1;
    }

    protected void setWinningNumber(){
        this.winningNumbers = makeSortedRow();
    }

    public void match(){
        this.setWinningNumber();
        for(int i =0; i<this.gameList.size(); i++){
            int dupCount = 0;
            for(int j = 0; j< this.winningNumbers.size(); j++){
                if(this.gameList.get(i).contains(this.winningNumbers.get(j))){
                    dupCount++;
                }
            }
            this.matchCount[i] = dupCount;
        }
    }

    public void makeResultMsg(){
        StringBuilder sb = new StringBuilder("\n  <<뽑은 내역 - 맞은 개수>>\n");
        for(int i=0; i<this.gameList.size();i++){
            String endWord ="\n";
            if(this.matchCount[i]>=3){ endWord = " - "+this.matchCount[i] + "개 맞음\n"; }
            String result = this.gameList.get(i).toString() +  endWord;
            sb.append(result);
        }

        sb.append("\n      <<당첨 번호>>\n");
        sb.append(this.winningNumbers);

        sb.append(""" 
                \n===== 상금 안내 =====
                3개 일치 - 5,000원
                4개 일치 - 50,000원
                5개 일치 - 500,000원
                6개 일치 - 5,000,000원
                ===================
               """);

        int[] prizeResult = sumPrize();
        sb.append(makePrizeMsg(prizeResult));
        PrintResult(sb.toString());
    }

    private int[] sumPrize(){
        //박싱 필요
        List<Integer> list = Arrays.stream(this.matchCount)
                .boxed()
                .toList();
        int countOfThree = Collections.frequency(list,3);
        int countOfFour = Collections.frequency(list,4);
        int countOfFive = Collections.frequency(list,5);
        int countOfSix  = Collections.frequency(list,6);

        //총 상금 금액만 출력하면 됨.
        return new int[]{countOfThree, countOfFour, countOfFive,countOfSix};
    }

    private StringBuilder makePrizeMsg(int[] result){
        StringBuilder sb = new StringBuilder();
        int totalPrize = 0;
        for(int i =0; i<result.length; i++){
            sb.append( String.format("%d개 일치한 개수 : %d 개\n", i+3, result[i] ));
            totalPrize += result[i] * (5000 * (int)Math.pow(5000,i));
        }
        sb.append(String.format("\n총 상금은 %d원 입니다.", totalPrize));
        return sb;
    }
}
