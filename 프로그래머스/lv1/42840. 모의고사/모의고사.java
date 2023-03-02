import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        int[] answer = {}; 
        ArrayList<Integer> arrList = new ArrayList<>();
        
        int count1=0; 
        int count2=0;
        int count3=0;
        
        int[] arr1 = {1,2,3,4,5}; // 5
        int[] arr2 = {2,1,2,3,2,4,2,5}; // 8
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5}; // 10
        
        for(int i=0; i<answers.length; i++){
            if(arr1[i%5]==answers[i])
                count1++;
            if(arr2[i%8]==answers[i])
                count2++;
            if(arr3[i%10]==answers[i])
                count3++;
        }
        
        if(count1 >= count2 && count1 >= count3)
            arrList.add(1);
        if(count2 >= count1 && count2 >= count3)
            arrList.add(2);
        if(count3 >= count2 && count3 >= count1)
            arrList.add(3);
        //답안 배열, 정답 배열
        
        return arrList;
    }
}