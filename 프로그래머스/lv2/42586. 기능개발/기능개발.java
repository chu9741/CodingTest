import java.util.*;

class Operation{
    int progress;
    int speed;
    public Operation(int p, int s){
        this.progress=p;
        this.speed=s;
    }
    
}

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Operation> queue = new LinkedList<>();

        for(int i=0; i<progresses.length; i++){
            queue.offer(new Operation(progresses[i], speeds[i]));
        }
        
        ArrayList<Integer> arrList = new ArrayList<>();
        
        while(!queue.isEmpty()){
            int count=0;
            
            while(!queue.isEmpty()){
                if(queue.peek().progress==100){
                    queue.poll();
                    count++;
                
                }
                else break;
            }
            
            //프로그래스의 각 밸류에 speed를 더한다. 
            for(int i=0; i<queue.size(); i++){
                Operation tmp = queue.poll();
                queue.offer(new Operation(Math.min(tmp.progress+tmp.speed,100),tmp.speed));
            }
            
            if(count!=0){
                arrList.add(count);            
            }
        }
        
        // for(int a=0; a<arrList.size(); a++)
        //     System.out.print(arrList.get(a)+" ");
             
        return arrList;
    }
}