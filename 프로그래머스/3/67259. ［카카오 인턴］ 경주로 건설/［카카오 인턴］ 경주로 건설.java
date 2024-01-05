import java.util.*;
class Solution {
    
    int[] dx= {0,1,0,-1};
    int[] dy= {1,0,-1,0};
    int minCost=Integer.MAX_VALUE;
    int len;
    
    public int solution(int[][] board) {
        len=board.length;        
        int[][][] costBoard = new int[len][len][4];
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                for(int k=0; k<4; k++){
                    costBoard[i][j][k]=Integer.MAX_VALUE;
                }
            }
        }
        
        queue.offer(new int[]{0,0,0,0,0,0});
        // 현재 위치, cost, 이전 위치 
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int dir=tmp[5];
            
            for(int i=0; i<4; i++){
                int newX = tmp[0]+dx[i];
                int newY = tmp[1]+dy[i]; 
                if(newX>=0 && newX<len && newY>=0 && newY<len){
                    if(board[newX][newY]==0){
                        int newCost = (newX == tmp[3] || newY == tmp[4]) ?  tmp[2]+100 : tmp[2]+600;
                        
                        // 이건 통과되면 안되는데 왜 통과되지
                        if(newCost<=costBoard[newX][newY][i]){
                            costBoard[newX][newY][i]=newCost;
                            queue.offer(new int[]{newX, newY, newCost, tmp[0],tmp[1],i});
                        }
                    }
                }
            }
        }
        
        for(int i : costBoard[len-1][len-1]){
            minCost=Math.min(i,minCost);
        }
        return minCost;
    }
}