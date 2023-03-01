import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int length = nums.length;
        ArrayList<Integer> arrList = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i=0; i<length; i++){
            hm.put(i,nums[i]);
        }
        
        for(int j=0; j<length; j++){
            if(!arrList.contains(hm.get(j)) && arrList.size() < hm.size()/2){
                arrList.add(hm.get(j));
            }
        }
        
        // hm에서 같은 value값을 가진 값을 빼고 골라주면된다... 
        
        return arrList.size();
        
    }
}