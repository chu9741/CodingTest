class Solution {
    
    int cnt=0;
    public int solution(int storey) {
        int answer = 0;
        // 1의 자리부터 돌면서 위로 갈지 아래로 갈지 체크
        int i=0;
        
        while(storey>0){
            if(storey%10>5){
                int remain = 10-(storey%10);
                cnt+=remain;
                storey+=remain; 
                // System.out.println(remain+" "+storey);
            }
                        
            else if(storey%10<5){
                int remain = storey%10;
                cnt+=remain;
                storey-=remain;
                
                // System.out.println(remain+" "+storey);
            }            
            else{
                if((storey/10)%10>=5){
                    int remain = 10-(storey%10);
                    cnt+=remain;
                    storey+=remain;                }
                else{
                    int remain = storey%10;
                    cnt+=remain;
                    storey-=remain;
                }
            }
            storey/=10;
        }
        
        cnt+=Math.min(storey, 10-storey);
        return cnt;
    }
}