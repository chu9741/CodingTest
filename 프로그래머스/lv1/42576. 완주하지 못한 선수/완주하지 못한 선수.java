import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        //일단 참가-완주 자 의 서로 차이를 확인해야함 그러면 일단 참가자 해쉬를 만들고 key를 int로
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0; i<participant.length; i++){
            // hm.put(participant[i], hm.getOrDefault(participant[i], 0)+1);
            
            if(hm.containsKey(participant[i])){
                int newValue = hm.get(participant[i]);
                hm.put(participant[i], ++newValue);
                
            }
            else{
                hm.put(participant[i],1);
            }
        }
        
        
        for(int j=0; j<completion.length; j++){
            if(hm.get(completion[j]) > 1){
                int tmp = hm.get(completion[j]);
                hm.put(completion[j], --tmp);
            }
            else{
                hm.remove(completion[j]);
            }
        }
        
        
        String answer = "";
        answer += hm.keySet().toArray()[0];
        return answer;
    }
}