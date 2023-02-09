package Inflearn_Java_Algorithm.Ch8_DFS_BFS.q11;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cnt=Integer.MAX_VALUE;
    boolean[][] isVisited=new boolean[9][9];
    static int tmp=0;

    public void DFS(int[][] arr, int x, int y){
        if(x==7 && y==7){
//            System.out.println("cnt ,tmp = " +cnt+ " "+tmp);
            cnt=Math.min(cnt,tmp);
//            tmp=0;
        }

        else{
//            System.out.println("x,y, tmp = "+x+" "+y+" "+tmp);
            isVisited[x][y]=true;
//            tmp++;
            if(!isVisited[x-1][y] && arr[x-1][y]==0){
                tmp++;
                DFS(arr,x-1,y);
                isVisited[x-1][y]=false;
                tmp--;
//                System.out.println("x,y, tmp = "+x+" "+y+" "+tmp);
            }
            if(!isVisited[x][y+1] && arr[x][y+1]==0){
                tmp++;
                DFS(arr,x,y+1);
                isVisited[x][y+1]=false;
                tmp--;
//                System.out.println("x,y, tmp = "+x+" "+y+" "+tmp);
            }
            if(!isVisited[x+1][y] && arr[x+1][y]==0){
                tmp++;
                DFS(arr,x+1,y);
                isVisited[x+1][y]=false;
                tmp--;
//                System.out.println("x,y, tmp = "+x+" "+y+" "+tmp);
            }
            if(!isVisited[x][y-1] && arr[x][y-1]==0){
                tmp++;
                DFS(arr,x,y-1);
                isVisited[x][y-1]=false;
                tmp--;
//                System.out.println("x,y, tmp = "+x+" "+y+" "+tmp);
            }
        }
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[9][9];

        for(int a=0; a<9; a++)
            arr[a][0]=arr[a][8]=arr[0][a]=arr[8][a]=1;

        for(int i=1; i<=7; i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            for(int j=1; j<=7; j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }

        }

        main.DFS(arr,1,1);
        if(cnt!=Integer.MAX_VALUE)
            System.out.println(cnt);
        else System.out.println(-1);
    }
}