import java.util.*;

class Solution {
    
    int[] dx= {-1,0,1,0};
    int[] dy= {0,1,0,-1};
    
    int score=0;
    int lenX=0;
    int lenY=0;
    
    public Integer[] solution(String[] maps) {
        lenX = maps.length;
        lenY = maps[0].length();
        boolean[][] isVisited = new boolean[lenX][lenY];
        Integer[] answer = {};
        ArrayList<Integer> scoreArr = new ArrayList<>();
        String[][] arr = new String[lenX][lenY];
        
        for(int i=0; i<maps.length; i++){
            arr[i] = maps[i].split("");
        }
        
       
        for(int a=0; a<lenX; a++){
            for(int b=0; b<lenY; b++){
                score=0;
                if(!arr[a][b].equals("X") && !isVisited[a][b]){
                    dfs(arr,isVisited,a,b);
                }
                if(score==0) {continue;}
                else {scoreArr.add(score);}
            }
        }
        Collections.sort(scoreArr);
        answer = scoreArr.toArray(new Integer[scoreArr.size()]);
        if(answer.length==0){
            return new Integer[]{-1};
        }
        return answer;
    }
    
    public void dfs(String[][] arr , boolean[][] isVisited, int a,int b){
        
        score+=Integer.parseInt(arr[a][b]);
        isVisited[a][b]=true;
        // System.out.println(score);
        
        for(int i=0; i<4; i++){
            if(a+dx[i]<0 || a+dx[i]>=lenX || b+dy[i]<0 || b+dy[i]>=lenY){
                continue;
            }
            if(!arr[a+dx[i]][b+dy[i]].equals("X") && !isVisited[a+dx[i]][b+dy[i]]){
                // System.out.println(arr[a][b]);
                dfs(arr,isVisited,a+dx[i],b+dy[i]);
            }
        }
        
    }
}