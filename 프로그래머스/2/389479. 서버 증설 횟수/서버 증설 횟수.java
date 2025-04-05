class Solution {
    public int solution(int[] players, int m, int k) {        
        // Players = 0~23시
        int count=0; // 서버 증설 횟수
        int currServer = 0 ; // 현재 서버 개수
        int[] cap = new int[24]; // 현재 이용 가능한 인원
        
        for(int time=0; time<24; time++){
            if(players[time]<m){
                continue;
            }
            else if(cap[time]<=players[time]-m){
                while(cap[time]<=players[time]-m){                    
                    count++;
                    for(int i=0; i<k; i++){
                        if(time+i<24){
                            cap[time+i]+=m;
                        }
                    }
                }
            }
        }
        return count;
    }
}