import java.util.*;

class Solution {
    ArrayList<int[]> arr = new ArrayList<>();
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        // n*m
        int n=storage.length;
        int m=storage[0].length();
        int total=n*m;
        
        String[][] table = new String[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                table[i][j]=storage[i].split("")[j];
            }
        }
        
        for(String req: requests){
            // 지게차
            arr = new ArrayList<>();

            if(req.length()==1){
                for(int i=0; i<n; i++){
                    for(int j=0; j<m; j++){
                        if(table[i][j].compareTo(req)==0){
                            if(i==0 || j==0 || i==n-1 || j==m-1){
                                // table[i][j]="0";
                                arr.add(new int[]{i,j});
                            }
                            else{
                                boolean[][] isVisited = new boolean[n][m];
                                dfs(i,j,table,i,j,isVisited);
                            }
                        }
                    }
                }
            }else{
                String alpha = req.split("")[0];
                // 크레인
                for(int i=0; i<n; i++){
                    for(int j=0; j<m;j++){
                        if(table[i][j].compareTo(alpha)==0){
                            arr.add(new int[]{i,j});

                        }
                    }
                }
            }
            
            for(int[] a : arr){
                table[a[0]][a[1]]="0";
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(table[i][j].compareTo("0")==0){
                    total--;
                }
            }
        }
        return total;
    }
    
    void dfs(int a, int b, String[][] table, int originA, int originB, boolean[][] isVisited){
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        
        if(isVisited[a][b]){
            return;
        }
        
        for(int i=0; i<4; i++){
            if(a+dx[i] == -1 || a+dx[i]==table.length || b+dy[i]==-1 || b+dy[i]==table[0].length){
                // 탈출성공
                arr.add(new int[]{originA,originB});
            }
            else if(table[a+dx[i]][b+dy[i]].compareTo("0")==0){
                isVisited[a][b]=true;
                dfs(a+dx[i],b+dy[i],table, originA, originB, isVisited);
            }
        }
    }
}