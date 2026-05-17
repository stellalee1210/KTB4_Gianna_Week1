package org.example.Validator;

public class OptionValidator implements Validator{
    public OptionValidator(String input){
        try{
            if(!(isInteger(input) && isUnderRange(input))) throw new Exception();
        } catch (Exception e) {
            throw new RuntimeException("오류 : 주어진 선택지 내의 숫자를 입력하세요.");
        }
    }


    @Override
    public boolean isInteger(String input) {
        try{
            Integer.parseInt(input);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    @Override
    public boolean isUnderRange(String input) {
        int inputAsNum = Integer.parseInt(input);
        return inputAsNum == 1 || inputAsNum == 2 || inputAsNum == 3;
    }
}
