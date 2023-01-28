package Inflearn_Java_Algorithm.Ch6_Sorting_and_Searching.q7;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Coord{
    int x;
    int y;

    public Coord(int x, int y){
        this.x=x;
        this.y=y;
    }
}


public class Main {
    public void Solution(int n,ArrayList<Coord> arrayList){
        int j=0;
        for(int i=1; i<n; i++){
            Coord tmp = arrayList.get(i);
            for(j=i-1; j>=0; j--){
                if(tmp.x < arrayList.get(j).x)
                    arrayList.set(j+1, arrayList.get(j));
                else if( tmp.x == arrayList.get(j).x){
                    if (tmp.y < arrayList.get(j).y)
                        arrayList.set(j+1,arrayList.get(j));
                    else
                        break;
                }
                else break;
            }
            arrayList.set(j+1,tmp);
        }
        for( Coord c : arrayList)
            System.out.println(c.x+ " "+c.y);
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Coord> arrayList =new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arrayList.add(new Coord(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        main.Solution(n,arrayList);
    }
}