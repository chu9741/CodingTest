import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        //구간으로 정렬해서 s->e가 가장많이 겹치는것부터 찌르고 빼야됨
        PriorityQueue<Bomb> bombList = new PriorityQueue<>();
        for(int[] t : targets){
            bombList.add(new Bomb(t[0],t[1]));
        }
        
        // bombList.sort();
        int cnt=0;
        boolean isDone=false;
        int s=0;
        int e=0;
        while(!bombList.isEmpty()){
            Bomb tmp = bombList.peek();
           // System.out.println(tmp.s+" "+tmp.e+" "+cnt);

            if(!isDone){
                if(tmp.s<e){
                    if(tmp.e<e){
                        e=tmp.e;
                    }
                    isDone=false;
                    bombList.poll();
                    continue;
                }
                else{
                    cnt++;
                    isDone=true;
                }
                // System.out.println(tmp.s+" "+tmp.e+" "+cnt);

            }
            else{
                s=tmp.s;
                e=tmp.e;
                bombList.poll();
                isDone=false;
            }       
        }
        System.out.println();      
        
        
        answer=cnt;
        return answer;
    }
    
    public void func(){
            
    }

}
class Bomb implements Comparable<Bomb>{
        int s;
        int e;
        
        public Bomb(int s, int e){
            this.s=s;
            this.e=e;
        }
        
        @Override
        public int compareTo(Bomb b){
            if(this.s==b.s){
                return this.e-b.e;
            }
            return this.s-b.s;
        }
    }