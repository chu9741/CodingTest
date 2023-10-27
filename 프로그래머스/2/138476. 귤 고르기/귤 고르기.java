import java.util.*;
class Solution {
    // boolean isVisited[];
    // int min = Integer.MAX_VALUE;
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        // isVisited = new boolean[tangerine.length];
        // tangerine 개수를 k개 만큼,, 정렬해서  가져가기
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int t : tangerine){
            if(map.get(t)==null){
                map.put(t,1);
            }
            else{
                map.put(t,map.get(t)+1);
            }
        }
        List<Integer> keyList = new ArrayList<>(map.keySet());

        keyList.sort((Integer i1,Integer i2)-> map.get(i2)-map.get(i1));
        
        for(int key : keyList){
            if(k>0){
                answer++;
                k-=map.get(key);
            }
        }
        // combi(k,tangerine,0);
        
        return answer;
    }
}