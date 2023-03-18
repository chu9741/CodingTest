class Solution {
    
    int max=0;
    boolean[] isVisited;
    
    public int solution(int k, int[][] dungeons) {
        // 피로도 높은순으로 주고 시작 => 만약에 피로도가 낮은데 소모량 높은게 있을수 있음 
        // 완전 탐색 -> 
        // 피로도 >= 소모피로도
   
        isVisited = new boolean[dungeons.length];
        
        search(k,dungeons,0);
        
        return max;
    }
    
    public void search(int k , int[][] dgs, int cnt){      
        max=Math.max(max,cnt);

        for(int i=0; i<dgs.length; i++){
            if(!isVisited[i] && k-dgs[i][1]>=0 && k>=dgs[i][0]){
                // System.out.println(k+" "+cnt+" "+dgs[i][0]+" "+dgs[i][1]);
                isVisited[i]=true;
                search(k-dgs[i][1], dgs, ++cnt); // 소모값을 쓰면서 DFS
                // System.out.println(--cnt);
                --cnt;
                isVisited[i]=false;

            }
        }

    }
    
    
}