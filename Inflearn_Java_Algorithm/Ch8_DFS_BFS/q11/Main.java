package Inflearn_Java_Algorithm.Ch8_DFS_BFS.q11;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int x;
    int y;
    int tmp;
    public Node(int x, int y, int tmp){
        this.x=x;
        this.y=y;
        this.tmp=tmp;
    }
}

public class Main {
    static int cnt=Integer.MAX_VALUE;
    boolean[][] isVisited=new boolean[9][9];
//    static int tmp=0;

    Queue<Node> queue = new LinkedList<>();

    public void DFS(int[][] arr, int x, int y, int tmp) {
        if (x == 7 && y == 7) {
//            System.out.println("cnt ,tmp = " +cnt+ " "+tmp);
            cnt = Math.min(cnt, tmp);
//            tmp=0;
        } else {
//            System.out.println("x,y, tmp = "+x+" "+y+" "+tmp);
            isVisited[x][y] = true;
//            tmp++;
            if (!isVisited[x - 1][y] && arr[x - 1][y] == 0) {
                DFS(arr, x - 1, y, ++tmp);
                isVisited[x - 1][y] = false;
                tmp--;
//                System.out.println("x,y, tmp = "+x+" "+y+" "+tmp);
            }
            if (!isVisited[x][y + 1] && arr[x][y + 1] == 0) {
                DFS(arr, x, y + 1, ++tmp);
                isVisited[x][y + 1] = false;
                tmp--;
//                System.out.println("x,y, tmp = "+x+" "+y+" "+tmp);
            }
            if (!isVisited[x + 1][y] && arr[x + 1][y] == 0) {
                DFS(arr, x + 1, y, ++tmp);
                isVisited[x + 1][y] = false;
                tmp--;
//                System.out.println("x,y, tmp = "+x+" "+y+" "+tmp);
            }
            if (!isVisited[x][y - 1] && arr[x][y - 1] == 0) {
                DFS(arr, x, y - 1, ++tmp);
                isVisited[x][y - 1] = false;
                tmp--;
//                System.out.println("x,y, tmp = "+x+" "+y+" "+tmp);
            }
        }
    }

    public void BFS(int[][] arr, int x, int y,int tmp){
        Node root = new Node(x,y,tmp);
        queue.offer(root);
        isVisited[1][1]=true;

        while (!queue.isEmpty()){
            Node tempNode = queue.poll();

//            System.out.println("x y tmp = "+tempNode.x+" "+tempNode.y+" "+tempNode.tmp);
            if(tempNode.x==7 && tempNode.y==7)
                cnt=Math.min(cnt,tempNode.tmp);

            ++tempNode.tmp;

            if(arr[tempNode.x-1][tempNode.y]==0 && !isVisited[tempNode.x-1][tempNode.y]){
                queue.offer(new Node(tempNode.x-1,tempNode.y,tempNode.tmp));
                isVisited[tempNode.x-1][tempNode.y]=true;
            }
            if(arr[tempNode.x][tempNode.y+1]==0 && !isVisited[tempNode.x][tempNode.y+1]){
                queue.offer(new Node(tempNode.x,tempNode.y+1,tempNode.tmp));
                isVisited[tempNode.x][tempNode.y+1]=true;
            }
            if(arr[tempNode.x+1][tempNode.y]==0 && !isVisited[tempNode.x+1][tempNode.y]){
                queue.offer(new Node(tempNode.x+1,tempNode.y,tempNode.tmp));
                isVisited[tempNode.x+1][tempNode.y]=true;
            }
            if(arr[tempNode.x][tempNode.y-1]==0 && !isVisited[tempNode.x][tempNode.y-1]){
                queue.offer(new Node(tempNode.x,tempNode.y-1,tempNode.tmp));
                isVisited[tempNode.x][tempNode.y-1]=true;
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

//        main.DFS(arr,1,1,0);
        main.BFS(arr,1,1,0);

        if(cnt!=Integer.MAX_VALUE)
            System.out.println(cnt);
        else System.out.println(-1);
    }
}