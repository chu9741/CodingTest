import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {        
        int min=n;

        for(int i=0; i<n-1; i++){
            Set<Integer> setOne = new HashSet<>();
            Set<Integer> setTwo = new HashSet<>();
            Set<int[]> remains = new HashSet<>();

            setOne.add(wires[i][0]);
            setTwo.add(wires[i][1]);
            
            for(int j=0; j<n-1; j++){
                if(j==i){
                    continue;
                }
                if(setOne.contains(wires[j][0]) || setOne.contains(wires[j][1])){
                    setOne.add(wires[j][0]);
                    setOne.add(wires[j][1]);
                }
                if(setTwo.contains(wires[j][0]) || setTwo.contains(wires[j][1])){
                    setTwo.add(wires[j][0]);
                    setTwo.add(wires[j][1]);
                }
                else{
                    remains.add(wires[j]);
                }
            }
            
            while(!remains.isEmpty()){
                ArrayList<int[]> trash = new ArrayList<>();
                remains.forEach(arr-> {if(setOne.contains(arr[0]) || setOne.contains(arr[1])){
                    setOne.add(arr[0]);
                    setOne.add(arr[1]);
                    trash.add(arr);
                }});
                remains.forEach(arr-> {if(setTwo.contains(arr[0]) || setTwo.contains(arr[1])){
                    setTwo.add(arr[0]);
                    setTwo.add(arr[1]);
                    trash.add(arr);
                }});
                remains.removeAll(trash);
                
            }
            int a = setOne.size();
            int b = setTwo.size();
            // System.out.println(setOne.size());

            int abs = Math.abs(a-b);
            if(abs<min){
                min=abs;
            }
        }
        return min;
    }
}