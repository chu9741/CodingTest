import java.util.*;

class Solution {
    
    long max=0;
    
    public long solution(String expression) {
        long answer = 0;
        int length=expression.length();
        //operator찾아서 Stack에 넣고 계산
        Deque<String> temp = new ArrayDeque<>();
        Deque<String> deque=new ArrayDeque<>();
        int idx=0;
        for(int i=0; i<length; i++){
            // String temp = expression.substring(idx,i);
            if(!Character.isDigit(expression.charAt(i))){
                temp.push(expression.substring(idx,i));    
                temp.push(expression.substring(i,i+1));
                idx=i+1;
                
            }
            if(i==length-1){
                temp.push(expression.substring(idx));
            }
        }
        
        //operand 조합,,,
        ArrayList<String[]> operators = new ArrayList<>();
        operators.add(new String[]{"*","+","-"});
        operators.add(new String[]{"+","*","-"});
        operators.add(new String[]{"-","+","*"});
        operators.add(new String[]{"*","-","+"});
        operators.add(new String[]{"+","-","*"});
        operators.add(new String[]{"-","+","*"});
        
        Deque<String> clone= new ArrayDeque<>();
        for(String[] operator : operators){
           temp.forEach(t->clone.push(t));
            
            //pop하면서 연산 -> 다시 push 
            for(int j=0; j<3; j++){
                while(!clone.isEmpty()){
                    // 최우선 연산자일 때 => 계산 진행
                    if(clone.peek().equals(operator[j])){
                        long oper1 = Long.parseLong(deque.pop());
                        String oper = clone.pop();
                        long oper2 = Long.parseLong(clone.pop());
                        // System.out.println(oper1+oper+oper2);
                        deque.push(operation(oper1,oper2,oper));
                    }
                    else{
                        deque.push(clone.pop());
                    
                    }                     
                }
                deque.forEach(d->clone.push(d));
                deque.clear();
            }
            // System.out.println("RES = "+clone.peek()+" MAX = "+max);
            max=Math.max(Math.abs(Long.parseLong(clone.pop())),max);
        }
        return max;
    }
        
    public String operation(long num1, long num2, String oper){
        if(oper.equals("*")){
            return String.valueOf(num1*num2);
        }
        if(oper.equals("+")){
            return String.valueOf(num1+num2);
        }
        if(oper.equals("-")){
            return String.valueOf(num1-num2);
        }
        return "0";
    }
}