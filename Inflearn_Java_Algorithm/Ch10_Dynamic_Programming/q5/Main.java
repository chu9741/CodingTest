package Inflearn_Java_Algorithm.Ch10_Dynamic_Programming.q5;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static boolean[] isVisited;
    static int answer = Integer.MAX_VALUE;
    int cnt=0;
    public void solution(int n, int m, int tmpSum, int[] arr){
        //동전을 쓴다 , 안쓴다 -> 5원부터 ,, 그리고 안쓰는걸로 넘어간다 -> DFS
        if(tmpSum==m){
            answer=Math.min(answer, cnt);
            //동전의 합이 m이면 출력이 아니라 min에 넣기 그리고 min 중에 min 최종 출력
        }
        if(tmpSum>m || cnt>answer)
            return;
        else{
            //동전의 합이 m보다 작을 때 해당 sum에서 동전을 넣어준다....
            for(int i=n-1; i>=0; i--){
                cnt++;
                solution(n,m,tmpSum+arr[i],arr);
                cnt--;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i]=Integer.parseInt(st.nextToken());

        int m= Integer.parseInt(br.readLine());

        Main main= new Main();
        main.solution(n,m,0,arr);

//        for(int a=0; a<n; a++){
//            for(int b=0; b<m; b++){
//                System.out.print(board[a][b]+" ");
//            }
//            System.out.println();
//        }
        System.out.println(answer);
    }
}
