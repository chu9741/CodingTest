package Inflearn_Java_Algorithm.Ch8_DFS_BFS.q13;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}


public class Main {
    static boolean[][] isVisited;
    static int cnt=0;

    public void BFS(int x, int y,int n, int[][] arr){
        Queue<Point> queue =new LinkedList<>();
        Queue<Point> countQueue = new LinkedList<>();
        int[] dx = {-1,-1,0,1,1,1,0,-1};
        int[] dy = {0,1,1,1,0,-1,-1,-1};

        for(int q=1; q<=n; q++){
            for(int w=1; w<=n; w++){
                if(arr[q][w]==1)
                    countQueue.offer(new Point(q,w));
            }
        }

        while(!countQueue.isEmpty()){
            Point tmp = countQueue.poll();
            if(arr[tmp.x][tmp.y]==1 && !isVisited[tmp.x][tmp.y]){
                isVisited[tmp.x][tmp.y]=true;
                queue.offer(tmp);
//                System.out.println("tmp = "+tmp.x+"  "+tmp.y);
                cnt++;
            }

            while (!queue.isEmpty()){
                Point tmpPoint = queue.poll();

                for(int a=0; a<8; a++){
                    int nx = tmpPoint.x+dx[a];
                    int ny = tmpPoint.y+dy[a];

                    if(arr[nx][ny]==1 && !isVisited[nx][ny]){
                        queue.offer(new Point(nx, ny));
                        isVisited[nx][ny]=true;
                    }
                }
            }
//            for(int i=1; i<=n; i++){
//                for(int j=1; j<=n; j++){
//                    System.out.printf("%8b",isVisited[i][j]);
//                }
//                System.out.println();
//            }
//            System.out.println();
        }



    }

//    public void DFS(int x, int y, int n, int[][] arr){
//        isVisited[x][y]=true;
//
//        if(arr[x][y]==1 && !isVisited[x][y]){
//            if(arr[x-1][y]==1 && !isVisited[x-1][y]){
//                DFS(x-1,y,n,arr);
////                isVisited[x-1][y]=false;
//            }
//            if(arr[x][y+1]==1 && !isVisited[x][y+1]){
//                DFS(x,y+1,n,arr);
////                isVisited[x][y+1]=false;
//
//            }
//            if(arr[x+1][y]==1 && !isVisited[x+1][y]){
//                DFS(x+1,y,n,arr);
////                isVisited[x+1][y]=false;
//
//            }
//            if(arr[x][y-1]==1 && !isVisited[x][y-1]){
//                DFS(x,y-1,n,arr);
////                isVisited[x][y-1]=false;
//            }
//            //빠져나와쓸때
//        }
//        else {
//
//        }
//        for()
//
//
//
////        for(int i=1; i<=n; i++){
////            for(int j=1; j<=n; j++){
////                if(arr[i][j]==1 && !isVisited[i][j]){
////                    DFS
////
////
////                }
////            }
//    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+2][n+2];

        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        isVisited=new boolean[n+2][n+2];

        main.BFS(1,1,n,arr);
        System.out.println(cnt);

    }

}