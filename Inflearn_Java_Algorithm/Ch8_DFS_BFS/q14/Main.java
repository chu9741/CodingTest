package Inflearn_Java_Algorithm.Ch8_DFS_BFS.q14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class Main {
    Queue<Point> queue;
    static ArrayList<Point> list = new ArrayList<>();
    static Point[] tempList;
    static int n;
    static int[][] arr;
    static ArrayList<Integer> sumList = new ArrayList<>();

    public void DFS(int m,int v, int s){
        if(v==m){
            sumList.add(Solution(n,arr,tempList));
//            for(Point point : tempList)
//                System.out.print(point.x+","+point.y+" ");
//            System.out.println();
        }
        else{
            for(int i=s; i<list.size(); i++){
                tempList[v]=list.get(i);
                DFS(m,v+1,i+1);
            }
        }
    }


    public int Solution(int n, int[][] arr, Point[] tempList){
        int sum=0;
        queue=new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n;j++){
                if(arr[i][j]==1){
                    queue.offer(new Point(i,j));
                }
            }
        }

        while(!queue.isEmpty()){
            Point tmp = queue.poll();
            int min = n*2;

            for(Point point : tempList){
                int dis = Math.abs(point.x-tmp.x)+Math.abs(point.y-tmp.y);
                min = Math.min(min,dis);
            }
            sum+=min;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr =new int[n][n];

        for(int i=0; i<n;i++){
            StringTokenizer st2= new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j]=Integer.parseInt(st2.nextToken());
                if(arr[i][j]==2)
                    list.add(new Point(i,j));

            }
        }
        tempList=new Point[m];

        main.DFS(m,0,0);

        Collections.sort(sumList);

        System.out.println(sumList.get(0));
    }
}
