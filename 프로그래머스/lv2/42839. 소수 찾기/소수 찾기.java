import java.util.*;

class Solution {
    
    ArrayList<Integer> arrList = new ArrayList<>();

    boolean[] isVisited;
    
    public int solution(String numbers) {
        int answer = 0;
        String[] stArr = numbers.split("");
        
        isVisited=new boolean[stArr.length];
        
        for(int i=0; i<numbers.length(); i++){
            // isVisited=new boolean[i+1];
            String[] res = new String[i+1];    
            Permutation(0,stArr,res,isVisited);
            
        }
        
        // System.out.println("SIZE list "+arrList.size());
        
        for(int s : arrList){
            boolean checkPrime = isPrime(s);
            
            if(checkPrime){
                System.out.println(s);
                answer++;
            }
        }
        
        // 숫자를 엮어서 num을 만들고 이를 소수인지 체크
        return answer;
    }
    
    
    public void Permutation(int L, String[] arr, String[] res, boolean[] isVisited){
        
        if(L==res.length){
            // String tmp = Arrays.toString(res);
            StringBuilder st = new StringBuilder();
            for(int a=0; a<res.length; a++){
                st.append(res[a]);
            }
            int tmp = Integer.parseInt(st.toString());
            if(!arrList.contains(tmp)){
                // System.out.println(tmp);
                arrList.add(tmp);
            }
        }
        else{
            for(int j=0; j<arr.length; j++){
                if(!isVisited[j]){
                    isVisited[j]=true;
                    res[L]=arr[j];
                    Permutation(L+1,arr,res,isVisited);
                    isVisited[j]=false;
                }
            }
        }     
    }
    
    
    public boolean isPrime(int a){
        if(a<2)
            return false;
        if(a==2)
            return true;
        
        for(int i=2; i<=Math.sqrt(a); i++){
            if(a%i==0)
                return false;
        }
        return true;
    }
}