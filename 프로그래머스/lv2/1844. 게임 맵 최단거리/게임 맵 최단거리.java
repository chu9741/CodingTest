import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        //bfs 
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        
        int n= maps.length;
        int m= maps[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        //(0,0)
        int[] start = {0,0};
        int[][] score = new int[n][m];
        q.offer(start);
        score[0][0]=1;
        
        while(!q.isEmpty()){
            int[] tmp = q.poll(); // 현재 위치 
            if(tmp[0]==n && tmp[1]==m){
                break;
            }
            for(int i=0; i<4; i++){
                int nx= tmp[0]+dx[i];
                int ny= tmp[1]+dy[i];
                if(nx>=0 && nx< n && ny>=0 && ny<m && maps[nx][ny] ==1){ // boundary내의 path
                    // System.out.println(score[nx][ny]+" "+nx+" "+ny);
                    if(score[nx][ny]==0){ // 한번도 가지 않은 path
                        score[nx][ny] = score[tmp[0]][tmp[1]]+1; // update path
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }
        
        // for(int[] i: score){
        //     for(int j: i){
        //         System.out.print(j+"  ");
        //     }
        //     System.out.println();
        // }
        
        int answer = score[n-1][m-1]==0 ? -1 : score[n-1][m-1];
        return answer;
    }
}