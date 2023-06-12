import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = -1;
        String convertKnum = kNumber(n,k);
        String[] primeCandidates = getNumbers(convertKnum);
        answer=primeNumbers(primeCandidates);

        return answer;
    }
    public int primeNumbers(String[] primeCandidates){
        ArrayList<Long> result = new ArrayList<>();
        
        for(String s : primeCandidates){
            if(s.equals("")){
                continue;
            }
            long num = Long.parseLong(s);
            if(isPrime(num)){
                result.add(num);
            }
        }
        return result.size();
        
    }
    
    public boolean isPrime(long n){
        if(n==1){
            return false;
        }
        else if(n==2){
            return true;
        }
        else{
            for(int i=2; i<=(int)Math.sqrt(n); i++){
                if(n%i==0){
                    return false;
                }
            }
            return true;
        }
    }
    
    
    public String[] getNumbers(String num){
        String[] numbers = num.split("0");
        return numbers;
    }
    
    
    public String kNumber(int n, int k){
        StringBuilder sb = new StringBuilder();
        while(n!=0){
            sb.append(n%k);
            n=n/k;
        }
        return sb.reverse().toString();
    }
}