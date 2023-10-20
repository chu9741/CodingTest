import java.util.*;

class Solution {
    
    int[] answer;
    
    public int[] solution(long[] numbers) {
        answer = new int[numbers.length];
    
        for(int i=0; i<answer.length; i++){
            answer[i]=1;
        }

        for(int i=0; i<numbers.length; i++){
            long tmp = numbers[i];
            
            //이진수 변환해서 numStack에 넣음
            StringBuilder sb = new StringBuilder();
            while(tmp>0){
                sb.append(tmp%2);
                tmp/=2;
            }
            
            sb.reverse();
            
            // 포화 트리 만들기 위해서 numStack에 모자란 값을 0으로 채워 넣음
            int idx=0;
            int strLen = sb.toString().length();
            while(true){
                if(strLen>=Math.pow(2,idx) && strLen<Math.pow(2,idx+1)){
                    for(int k=1; k<Math.pow(2,idx+1)-strLen; k++){
                        sb.insert(0,"0");
                    }
                    break;
                }
                idx++;
            }
            String str = sb.toString();
            if(str.length()==1){
                continue;
            }
            
            //root노드가 0일수는 없음 -> 0 리턴
            if(str.charAt(str.length()/2)=='0'){
                answer[i]=0;                
                continue;
            }
            nodeMaker(str,i);
            
        }
        
        return answer;
        // 7= 111 = 012
        // 42 = 0101010  
        // 5 = 101
        
        // 63 = 0111111
        // 111 = 1101111
    }
    
    public void nodeMaker(String str, int i){
        if(str.length()==1){
            return;
        }
        char halfTmp = str.charAt(str.length()/2);
        String frontHalf = str.substring(0,str.length()/2);
        String backHalf = str.substring(((str.length()+1)/2), str.length());
        // System.out.println(str+"= "+" "+frontHalf.length()+" "+backHalf.length()+" "+i);
        if(halfTmp=='0'){
            if(frontHalf.charAt(frontHalf.length()/2)=='1' || backHalf.charAt(backHalf.length()/2)=='1'){
                answer[i]=0;
                return;
            }
        }
        nodeMaker(frontHalf,i);
        nodeMaker(backHalf,i);
    }
}