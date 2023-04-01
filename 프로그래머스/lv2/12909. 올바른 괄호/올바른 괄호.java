import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char temp : arr){
            if(temp=='('){
                stack.push(temp);
            }
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        
        if(!stack.isEmpty())
            return false;
            

        return answer;
    }
}