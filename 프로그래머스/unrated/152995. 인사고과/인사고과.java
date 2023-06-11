import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = -1;
        
        int wanhoAttScore=scores[0][0];
        int wanhoEmpScore=scores[0][1];
        
        Arrays.sort(scores, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])
                    return o1[1] - o2[1];
                return o2[0]-o1[0];
            }
        });
        
        int cnt=0;
        int sameSumCount=1;  // 두점수의 합이 같을 때 ++
        int empMax=scores[0][1]; // 동료평가 점수
        int attMax=scores[0][0];
        boolean isSame=false; // 계산한 값이 이전의 두점수의 합과 같을 때
        for(int i=0; i<scores.length; i++){
            if(i==0){ 
                continue;
            }
            else{
                if(scores[i][0] < attMax && scores[i][1] < empMax){
                    scores[i][0]=0;
                    scores[i][1]=0;
                    continue;
                }
                else if(scores[i][1]>empMax){
                    //이전 값보다 empMax가 크거나 attScore이 같을 때
                    attMax=scores[i][0];
                    empMax=scores[i][1];    
                }  
            }
        }
        
        Arrays.sort(scores, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return (o2[0]+o2[1]) - (o1[0]+o1[1]);
            }
        });
        
        for(int j=0; j<scores.length; j++){
            if(j==0){
                sameSumCount++;
            }
            else if(scores[j][0]==0 && scores[j][1]==0){
                break;
            }
            else{
                // 두 점수 비교
                int sum=scores[j][0]+scores[j][1];

                if(scores[j-1][0]+scores[j-1][1]==sum){ // 이전 값과 같을 떄
                    sameSumCount++;
                    isSame=true;
                }
                else{ // 이전 값과 다를 때
                    cnt+=sameSumCount;
                    sameSumCount=1;
                    isSame=false;
                }
            }
            // System.out.println(scores[j][0]+" "+scores[j][1]+" "+cnt);

            if(wanhoAttScore==scores[j][0] && wanhoEmpScore==scores[j][1]){
                if(isSame==false){
                    answer = cnt==0 ? 1 : cnt;
                }
                else{
                    answer= cnt+1;
                }
                break;
            }
        }      
        return answer;
    }
}