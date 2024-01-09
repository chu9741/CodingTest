import java.util.*;
class Solution {
    public int solution(int[] topping) {
        
        // sliding window
        Map<Integer, Integer> aMap = new HashMap<>();
        Map<Integer, Integer> bMap = new HashMap<>();
        
        for(int i=0; i<topping.length; i++){
            bMap.put(topping[i], bMap.getOrDefault(topping[i], 0)+1);
        }
        
        int cnt=0;
        
        for(int i=0; i<topping.length; i++){
            bMap.put(topping[i],bMap.get(topping[i])-1);
            // System.out.println(topping[i]+" "+bMap.get(topping[i]));
            if(bMap.get(topping[i])==0){
                bMap.remove(Integer.valueOf(topping[i]));
            }

            aMap.put(topping[i], aMap.getOrDefault(topping[i],0)+1);
            // System.out.println(aMap.size()+" "+bMap.size());
            if(aMap.size()==bMap.size()){
                cnt++;
            }
        }

        return cnt;
    }
}