import java.util.*;


class Solution {
    
    int max=0; 
    int sum=0;
    
    public int[] solution(int m, int n, int[][] picture) {
        max=0;
        int cnt=0;
        boolean[][] isVisited= new boolean[m][n];
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        
        
        int[] answer = new int[2];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j]!=0 && !isVisited[i][j]){
                    sum=1;
                    DFS(i,j,picture[i][j],m,n,picture,isVisited,dx,dy);
                    cnt++;
                }
            }
        }
//         [1, 1, 1, 0], 
//         [1, 2, 2, 0], 
//         [1, 0, 0, 1], 
//         [0, 0, 0, 1], 
//         [0, 0, 0, 3], 
//         [0, 0, 0, 3]
        answer[0]=cnt;
        answer[1]=max;
        
        return answer;
            
    }
    
    public void DFS(int x, int y, int val, int m, int n, int pic[][], boolean[][] isVisited, int[] dx, int[] dy){
        isVisited[x][y]=true;
        max=Math.max(sum,max);
        
        // for(int a=0; a<m;a++){
//             for(int b=0; b<n; b++){
//                 System.out.print(isVisited[a][b]+"   ");
//             }
//             System.out.println();
//         }
//             System.out.println(max+" "+sum);
        

        for(int i=0; i<4; i++){ // 상하좌우를 살피고
            if(x+dx[i]>=0 && x+dx[i]<m && y+dy[i]>=0 && y+dy[i]<n 
               && !isVisited[x+dx[i]][y+dy[i]] 
               && pic[x+dx[i]][y+dy[i]]==val){ 
                // 다음 칸은 배열안에 들어있고, 방문하지 않은 값 중에 현재 칸의 값과 같은 것을 찾으면 
                ++sum;
                DFS(x+dx[i],y+dy[i],val,m,n,pic,isVisited,dx,dy);
            }
        }        
    }
}