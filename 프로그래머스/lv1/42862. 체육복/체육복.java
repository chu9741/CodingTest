import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 배열 1부터 n까지 시작 
        boolean[] isVisited = new boolean[reserve.length];
        boolean[] isVisitedLost = new boolean[lost.length];
        // reserve를 사용하면 true
        
        for(int c=0; c<lost.length; c++){
            for(int d=0; d<reserve.length; d++){
                if(lost[c] == reserve[d]){
                    isVisited[d]=true;
                    isVisitedLost[c]=true;
                    break;
                } // 도난당한 학생이 여벌옷 가지고 있으면
            }
        }
        
        //lost한쪽에만 reserve가 있는 lost를 찾아서 먼저 넣어줌
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(!isVisited[j] &&  !isVisitedLost[i]){ // 여벌 옷이 남아있을때     
                    if(lost[i]-1==reserve[j]){ // 도난당한 학생의 이전 번호가 여벌옷이 있으면
                        if(j != reserve.length-1){ // j가 마지막 인덱스가 아닐 때 
                            if(lost[i]+1==reserve[j+1] && !isVisited[j+1]){
                                // lost[i]애 뒤의 애가 여벌옷 가지고 있을 때 
                                continue;
                            } 
                            else{
                                isVisited[j]=true;
                                isVisitedLost[i]=true;
                            } // lost[i] 뒤의 애가 빌려줄 옷이 없을 때
                        }
                        else {
                            isVisited[j]=true;
                            isVisitedLost[i]=true;
                        } // j가 마지막 인덱스면 옷 빌려준다.
                    }
                    else if(lost[i]+1==reserve[j]){
                        if( j!= 0){
                            if(lost[i]-1 == reserve[j-1] && !isVisited[j-1]){
                                continue;
                            }
                            else {
                                isVisited[j]=true;
                                isVisitedLost[i]=true;
                            }
                        }
                        else{
                            isVisited[j]=true;
                            isVisitedLost[i]=true;
                        }           
                    }
                }        
            }   
        }
        
        //lost양쪽에 reserve가 있는 경우
        for(int a=0; a<lost.length; a++){
            for(int b=0; b<reserve.length; b++){
                if(!isVisitedLost[a] && !isVisited[b]){
                    if((lost[a]+1 == reserve[b] || lost[a]-1 == reserve[b])){
                        isVisited[b]=true;
                        break;
                    }
                }     
            }
        }
        answer = n - lost.length;
        for(boolean b : isVisited){
            if(b){
                answer++;
                // System.out.println(b);
            }
        }
        
        return answer;
    }
}