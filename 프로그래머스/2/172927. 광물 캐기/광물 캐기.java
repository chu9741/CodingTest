import java.util.*;

class Solution {
    
    int min = 0; //최소 피로도
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int tiring = 0; //피로도
        int minLength  = minerals.length;
        int remainPicks = totalPicks(picks) - (int)Math.ceil(minLength/5.0);
        if(remainPicks>0){
            for(int i=2; i>=0; i--){
                if(remainPicks==0){
                    break;
                }
                if(picks[i]<remainPicks){
                    remainPicks-=picks[i];
                    picks[i]=0;
                }
                else{
                    picks[i]-=remainPicks;
                    remainPicks=0;
                }
            }
        }
        
        System.out.println(picks[0]+" "+picks[1]+" "+picks[2]);
        int picksLen=totalPicks(picks);
        ArrayList<Integer> arrList=new ArrayList<>();
        PriorityQueue<Integer> pq  = new PriorityQueue<>();
        // PriorityQueue<HashMap<Integer,Integer>> pq = 
        for(int i=0; i<picksLen; i++){
            int sum=stoneScore(minerals,i*5);
            arrList.add(sum);
            pq.offer(sum);
        }
        
        for(int i=0; i<arrList.size(); i++){
            int tmp = pq.poll();
            for(int j=0; j<arrList.size(); j++){
                if(tmp==arrList.get(j)){
                    if(picks[2]!=0){
                        min+=tmp;
                        picks[2]-=1;
                        break;
                    }
                    else if(picks[1]!=0){
                        min+=ironScore(minerals,j*5);
                        picks[1]-=1;
                        break;
                    }
                    else{
                        min+=diaScore(minerals,j*5);
                        picks[0]-=1;
                        break;
                    }
                }
                // System.out.println(tmp+" "+min);
                
            }
            
        }
        
        return min;
    }
    
    public void DFS(int[] picks, String[] minerals,int minIdx, int score){
        // pick 3개중에 고름 
        // pick 하나도 없으면 min체크함
        if(totalPicks(picks)==0){
            min=Math.min(min,score);
            System.out.println(score+" $$$$");
        }
        System.out.println(picks[0]+" "+picks[1]+" "+picks[2] + " "+ minIdx);

        if(picks[0]!=0){
            picks[0]-=1;
            score+=diaScore(minerals, minIdx);
            DFS(picks,minerals,minIdx+5,score);
        }
        if(picks[1]!=0){
            picks[1]-=1;
            score+=ironScore(minerals,minIdx);
            DFS(picks,minerals,minIdx+5,score);
        }
        if(picks[2]!=0){
            picks[2]-=1;
            score+=stoneScore(minerals,minIdx);
            DFS(picks,minerals,minIdx+5,score);
        }
        // 내가 고른 pick에 대해서 min 5번 진행 해서 스코어 계산 -> 남은 개수만큼

    }
    
    public int totalPicks(int[] picks){
        return Arrays.stream(picks).sum();
    }
    
    public int diaScore(String[] minerals,int minIdx){
        int score=0;
        int cnt = Math.min(minerals.length-minIdx,5);
            for(int i=minIdx; i<minIdx+cnt; i++){
                score++;
        }
        return score;
    }
    
    public int ironScore(String[] minerals, int minIdx){
        int score=0;
        int cnt = Math.min(minerals.length-minIdx,5);
            for(int i=minIdx; i<minIdx+cnt; i++){
                if(minerals[i].equals("diamond")){
                    score+=5;
                }
                else{
                    score++;
                }
            }
        return score;
    }
    
    public int stoneScore(String[] minerals, int minIdx){
        int score=0;
        int cnt = Math.min(minerals.length-minIdx,5);
            for(int i=minIdx; i<minIdx+cnt; i++){
                if(minerals[i].equals("diamond")){
                    score+=25;
                }
                else if(minerals[i].equals("iron")){
                    score+=5;
                }
                else{
                    score++;
                }
            }
        return score;
    }
    
    
}