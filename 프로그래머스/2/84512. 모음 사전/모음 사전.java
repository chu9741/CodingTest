import java.util.*;
class Solution {
    public int solution(String word) {
        int answer = 0;
        int[] arr = new int[5];
        int idx=0;
        for(String w : word.split("")){
            int tmp = w.compareTo("A")==0 ? 1 : w.compareTo("E")==0 ? 2 : w.compareTo("I")==0 ? 3 : w.compareTo("O")==0 ? 4 : 5;
            arr[idx++] = tmp;
        }
        // String[] alpha = {"A","E","I","O","U"};
        int count = 0;
        int[] frame = new int[5];
        boolean isCorrect =false;
        while(!isCorrect){
            count++;
            // frame에 있는 값이 0이면 채우기
            for(int i=0; i<5; i++){
                if(frame[i]==0){
                    frame[i]=1;
                    break;
                }
            // frame[4]에 있는 값이 5이면 0으로 바꾸고 위로 올라가서 하나 더함 
                else if(frame[4]==5){
                    frame[4]=0;
                    for(int j=3; j>=0; j--){
                        if(frame[j]==5){
                            frame[j]=0;
                            continue;
                        }else{
                            frame[j]++;
                            break;
                        }    
                    }
                    break;
                }
            // ++
                else if(i==4){
                    frame[i]++;
                    break;
                }
            }
            
            isCorrect = check(arr,frame);
        }
        answer=count;
        return answer;
        
    }
    boolean check(int[] arr, int[] frame){
        for(int i=0; i<5; i++){
            if(arr[i]!=frame[i]){
                return false;
            }
        }
        return true;
    }
}