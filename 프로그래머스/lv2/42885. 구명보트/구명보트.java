import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int n=people.length;
        
        Integer[] arr = new Integer[n];
        ArrayList<Integer> arrList = new ArrayList<>();
        for(int k=0; k<n; k++){
            arr[k]=people[k];
            arrList.add(people[k]);
        }
        // arrList.sort(Collections.reverseOrder());
        Arrays.sort(arr, Collections.reverseOrder());
        
        int cnt=0;
        int lt=0;
        int rt=arr.length;
        while(lt<rt){
            int remain=limit - arr[lt];
            if(remain>=arr[rt-1]){
                rt--;
            }
            cnt++;
            lt++;
        }
        
//         while(!arrList.isEmpty()){
//             int remain= limit-arrList.get(0);
//             arrList.remove(0);

//             ArrayList<Integer> trash = new ArrayList<>();
//             int size = arrList.size();
            
//             if(arrList.size()>0 && remain>=arrList.get(size-1)){
//                 arrList.remove(size-1);
//             }
//             cnt++;
//         }
        return cnt;
    }
}