class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n+2][m+2];
        
        for(int[] temp : puddles){
            map[temp[1]][temp[0]]=-1;
        }
        map[1][1]=1;
        // x,y까지 가는 최단 거리 구하기 dp[x][y] = dp[x-1][y]+dp[x][y-1] 
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(map[i][j] == -1 || (i==1 && j==1)){
                    continue;
                }
                
                if(map[i-1][j]<1 && map[i][j-1]<1){ // 좌상의값이 없을때 -> 내값도 없음
                    continue;
                }
                else if(map[i-1][j]==-1 && map[i][j-1]!=-1){ // 상값이 -1일때 좌값을 받음
                    map[i][j]=map[i][j-1];
                }
                else if(map[i][j-1]==-1 && map[i-1][j]!=-1){ // 좌값이 -1일때 상값을 받음
                    map[i][j]=map[i-1][j];
                }
                else{
                    map[i][j]=( map[i-1][j]+map[i][j-1] )%1000000007; // 그 모든 이외의 경우 좌상값을 받음
                }
            }
        }   
        
        // for(int i=1; i<=n; i++){
        //     for(int j=1; j<=m; j++){
        //         if(i==0 && j==0){
        //             continue;
        //         }
        //         System.out.print(map[i][j]+"  ");
        //     }
        //     System.out.println();
        // }
        
        answer=map[n][m];
        return answer;
    }  
}