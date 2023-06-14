class Solution {
    public int[] solution(int n, int[] info) {
        int[] result= new int[11];        
        DFS(0,n,info,result);        
        if(max==0){
            return new int[]{-1};
        }
        return finalArr;
    }
    
    int max=0;
    int[] finalArr = new int[11];

    
    public void DFS(int k, int n, int[] info, int[] result){
        if(k==n){ // n으로 바꾸자
            int score = compare(info,result);  
            if(score>max || (score==max && isMoreLowerNumbers(finalArr, result))){
                max=score;
                for(int l=0; l<=10; l++){
                    finalArr[l]=result[l];
                }
            }
        }
        else{
            for(int i=10; i>=0 && result[i]<=info[i]; i--){
                // if (i!=10 && info[i+1]!=0 && info[i+1]==result[i+1]){
                //     break; // 문제 있음 
                // }
                
//                 if(result[i]>info[i]){
//                     continue;
//                 }
                
                // else{
                    result[i]+=1;
                    DFS(++k, n, info, result);
                    result[i]-=1;
                    --k;
                // } 
            }
        }
    }
    
    public boolean isMoreLowerNumbers(int[] finalArr, int[] result){
        for(int i=10; i>=0; i--){
            if(result[i]>finalArr[i]){
                return true;
            }
            else if(finalArr[i] > result[i]){
                return false;
            }
        }
        return false;
    }
    
    public int compare(int[] info, int[] result){
        int rionScore=0; // result
        int apeachScore=0; // info
        
        for(int i=0; i<=9; i++){
            // if(result[i]==0 && info[i]==0){
            //     continue;
            // }
            if(result[i]>info[i]){
                rionScore+=10-i;
            }
            else{
                if(info[i]!=0){
                    apeachScore+=10-i;
                }
            }
        }
        return rionScore-apeachScore;
    }
    
    // k번째가 동점일 때 , 어피치
    // 최종 점수가 동점일 때 어피치
    // 큰점수차로 우승할 수 있는 방법 여러가지 => 가장 낮은 점수 더 맞힌 경우 return
}