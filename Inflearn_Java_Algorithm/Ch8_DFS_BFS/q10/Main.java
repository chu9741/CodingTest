package Inflearn_Java_Algorithm.Ch8_DFS_BFS.q10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    boolean[][] isVisited = new boolean[9][9];
    static int cnt=0;

    public void DFS(int[][] arr, int x, int y){
        if(x==7 && y==7){
            cnt++;
        }
        else {
//            System.out.println("x,y = "+x+" "+y);
            isVisited[x][y]=true;

            if(arr[x+1][y]==0 && !isVisited[x+1][y]){
                DFS(arr,x+1,y);
                isVisited[x+1][y]=false;
            }
            if(arr[x][y+1]==0 && !isVisited[x][y+1]){
                DFS(arr,x,y+1);
                isVisited[x][y+1]=false;
            }
            if(arr[x-1][y]==0 && !isVisited[x-1][y]){
                DFS(arr, x-1,y);
                isVisited[x-1][y]=false;
            }
            if(arr[x][y-1]==0 && !isVisited[x][y-1]){
                DFS(arr,x,y-1);
                isVisited[x][y-1]=false;
            }
            return;
        }
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[9][9];
        for(int a=0; a<9; a++){
            arr[0][a]=1; arr[a][0]=1; arr[8][a]=1; arr[a][8]=1;
        }

        for(int i=1; i<=7; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=7; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                //1,1 -> 7, 7
            }
        }

        main.DFS(arr,1,1);
        System.out.println(cnt);
    }
}
