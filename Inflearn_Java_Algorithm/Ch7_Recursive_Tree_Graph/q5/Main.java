package Inflearn_Java_Algorithm.Ch7_Recursive_Tree_Graph.q5;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public void preOrder(int n, int limit){
        if(n<=limit){
            System.out.print(n+" ");
            preOrder(n*2, limit);
            preOrder(n*2+1, limit);
        }
    }

    public void postOrder(int n,int limit){
        if(n<=limit){
            postOrder(n*2, limit);
            postOrder(n*2+1, limit);
            System.out.print(n+" ");
        }
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int limit = Integer.parseInt(br.readLine()); // 노드의 총 개수 , 예제에선 7

        System.out.print("전위순회 : ");
        main.preOrder(n ,limit);
        System.out.println();
        System.out.print("후위순회 : ");
        main.postOrder(n, limit);
    }

}