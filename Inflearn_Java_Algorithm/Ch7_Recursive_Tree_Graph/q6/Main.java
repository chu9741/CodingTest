package Inflearn_Java_Algorithm.Ch7_Recursive_Tree_Graph.q6;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] ch;

    public void DFS(int L){
        //ch에 원소를 1,0을 인덱스에 맞춰 넣는다.
        //DFS재귀를 돈다

        if(L==n+1){
            StringBuilder tmp = new StringBuilder("");
            for(int i=1; i<=n; i++)
                if(ch[i]==1)
                    tmp.append(i).append(" ");
            if(tmp.length() > 0)
                System.out.println(tmp);
        }
        else {
            ch[L] = 1;
            DFS(L + 1); // L+1을 포함하는 func
            ch[L] = 0;
            DFS(L + 1); // L+1을 포함하지 않는 func
        }
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        ch = new int[n+1];
        int L =Integer.parseInt(br.readLine());

        main.DFS(L);
    }
}