package Inflearn_Java_Algorithm.Ch9_Greedy_Algorithm.q1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Person implements Comparable<Person>{
    int height;
    int weight;
    public Person(int height, int weight){
        this.height=height;
        this.weight=weight;
    }

    @Override
    public int compareTo(Person o){
        Person person = (Person) o;
        if(this.height>person.height)
            return 1;
        else if(this.height==person.height)
            return 0;
        else return -1;

        //위 식은 아래와 같다.
        //return Integer.compare(this.height, person.height);
    }
}


public class Main {
    public void Solution(int n, ArrayList<Person> arrayList){
        int removeNum=0;
        arrayList.sort(Collections.reverseOrder());

        int max = arrayList.get(0).weight;

        for(int i=0; i<n; i++){
            if(arrayList.get(i).weight < max){
                removeNum++;
            }
            else{
                max=arrayList.get(i).weight;
            }
//            System.out.println(arrayList.get(i).height+" "+arrayList.get(i).weight );
        }
        System.out.println(n-removeNum);
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Person> arrayList =new ArrayList<>();

        for(int i=0; i<n; i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            int height=Integer.parseInt(st.nextToken());
            int weight=Integer.parseInt(st.nextToken());

            arrayList.add(new Person(height,weight));
        }
        main.Solution(n,arrayList);
    }
}
