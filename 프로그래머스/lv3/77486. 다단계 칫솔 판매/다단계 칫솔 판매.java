import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String, Integer> enrollMap = new HashMap<>();
        HashMap<String, String> recommend = new HashMap<>();
                
        for(int i=0; i<enroll.length; i++){
            enrollMap.put(enroll[i],i);
            recommend.put(enroll[i],referral[i]);
        }
        
        for(int j=0; j<seller.length; j++){
            int money = amount[j]*100;
            String person = seller[j];
            while(!person.equals("-")){
                int idx=enrollMap.get(person);
                
                //recommend에 하나씩 넣어서 val찾고 돈 주고 다시 ->  
                // enrollMap.put(person,enrollMap.get(person)+(money-money/10));
                // System.out.println(enrollMap.get(person)+" "+j+" "+person+"!");
                answer[idx]+=money-money/10;
                money/=10;       
                if(money==0){
                    break;
                }
                person=recommend.get(person);
                
            }
            
        }
        // for(String e: enrollMap.keySet()){
        //     System.out.print(enrollMap.get(e)+", ");
        // }
        
        // for(int k=0; k<enroll.length; k++){
        //     answer[k]=enrollMap.get(enroll[k]);
        // }
        
        return answer;
    }
}