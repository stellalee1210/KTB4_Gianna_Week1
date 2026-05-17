package org.example.Validator;

public class MoneyInputValidator implements Validator{
    public MoneyInputValidator(String input){
        try{
            if(!(isInteger(input) && isUnderRange(input))) throw new Exception();
        }catch (Exception e ){
            throw new RuntimeException("오류 : 잘못된 입력 값입니다. 1000원 단위의 양의 정수를 입력해주세요. ");
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

        return inputAsNum % 1000 == 0;
    }
}
