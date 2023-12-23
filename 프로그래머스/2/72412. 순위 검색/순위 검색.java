import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int iLen = info.length;
        int qLen = query.length;
        int[] answer = new int[qLen];
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i=0;i <iLen; i++){
            String[] tmp = info[i].split(" ");
            StringBuilder sb = new StringBuilder();            
            generateCombinations(tmp, 0, new StringBuilder(), map);
        }
        
        for(String str : map.keySet()){
            Collections.sort(map.get(str));
        }

        for(int i=0; i<qLen; i++){
            String[] tmp = query[i].split(" "); // and Idx = 1,3,5 / length = 8

            StringBuilder sb = new StringBuilder();
            String str = sb.append(tmp[0]).append(tmp[2]).append(tmp[4]).append(tmp[6]).toString();
            int qScore = Integer.parseInt(tmp[7]);
            if(!map.containsKey(str)){
                continue;
            }
            
            int size=map.get(str).size();
            int start=0;
            int end=size;
            int idx=(size/2);
            while(start<end){
                idx=(start+end)/2;
                if(map.get(str).get(idx)>=qScore){
                    end=idx;
                }else{
                    start=idx+1;
                }
            }
            answer[i]+=size-start; 
        }
                      
        return answer;
    }
    
    private void generateCombinations(String[] input, int index, StringBuilder current, Map<String, ArrayList<Integer>> map) {
        if (index == input.length-1) {
            if(!map.containsKey(current.toString())){
                map.put(current.toString(),new ArrayList<>());
            }
            map.get(current.toString()).add(Integer.parseInt(input[4]));
            return;
        }

        current.append(input[index]);
        generateCombinations(input, index + 1, current, map);
        current.delete(current.length() - input[index].length(), current.length()); // 백트래킹

        current.append("-");
        generateCombinations(input, index + 1, current, map);
        current.deleteCharAt(current.length() - 1); // 백트래킹
    }
}