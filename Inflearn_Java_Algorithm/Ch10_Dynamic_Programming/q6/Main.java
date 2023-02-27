package Inflearn_Java_Algorithm.Ch10_Dynamic_Programming.q6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Quest{
    int score;
    int time;
    public Quest(int s, int t){
        this.score=s;
        this.time=t;
    }
}

public class Main {

    public void Solution(int n, int m, ArrayList<Quest> arrList){
        int[][] arr  = new int[n+1][m+1];

        // 문제에 해당하는 인덱스는 시간, 문제를 들고있음 시간안에 문제를 풀어야되는데 문제를 포함하나 포함하지않나로 체크함
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                Quest tmp = arrList.get(i);
                if(tmp.time<=j){
                    arr[i][j] = Math.max(arr[i-1][j], arr[i-1][j-tmp.time]+tmp.score);

                }
//                System.out.print(arr[i][j]+" ");
            }
//            System.out.println();
        }
        System.out.println(arr[n][m]);
    }

    public void Solution2(int n, int m ,ArrayList<Quest> arrList){
        int[] arr = new int[m+1];

        for(int i=1; i<=n; i++){
            for(int j=m; j>0; j--){
                Quest tmp = arrList.get(i);
                if(j>=tmp.time){
                    arr[j]=Math.max(arr[j],arr[j-tmp.time]+tmp.score);
                }
//                System.out.print(arr[j]+" ");
            }
//            System.out.println();
        }
        System.out.println(arr[m]);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main main = new Main();
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Quest> arrayList=new ArrayList<>();
        arrayList.add(new Quest(0,0));
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            arrayList.add(new Quest(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        main.Solution(n,m,arrayList);
        main.Solution2(n,m,arrayList);


    }


}
