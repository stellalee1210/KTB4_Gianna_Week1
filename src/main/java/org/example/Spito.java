package org.example;

import java.util.ArrayList;
import static org.example.IO.PrintResult;

public class Spito extends Lottery{
    final private ArrayList<Integer> result = new ArrayList<>();
    public Spito(int money){
        super(money);
        this.maxLimit = 9;
    }

    public void make() {
        this.draw();
    }

    public void makeResultMsg(){
        StringBuilder sb = new StringBuilder("\n   <<뽑은 내역>>\n");
        for(int i =0; i<this.gameList.size(); i++){
            String endWord = "\n";
            if(this.result.contains(i)) endWord = " - V\n";
            sb.append(this.gameList.get(i) + endWord);
        }
        sb.append("\n<<각 게임의 당첨 번호>>\n" + this.winningNumbers);
        PrintResult(sb.toString());
        this.sumPrize();
    }

    private void sumPrize(){
        PrintResult("\n맞춘 게임 당 당첨금은 1500원이므로, 총 당첨금은 " + this.result.size() * 1500 + "원 입니다.");
    }

    @Override
    protected void setWinningNumber(){
        int randNum = super.pickRandomNum();
        this.winningNumbers.add(randNum);
    }

    @Override
    public void match() {
        for(int i =0; i<this.gameList.size(); i++){
            this.setWinningNumber();
            int winningNumber = this.winningNumbers.getLast();
            if(this.gameList.get(i).contains(winningNumber)) this.result.add(i);
        }
    }
}
