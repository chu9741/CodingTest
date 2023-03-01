import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                
        for(int i=0; i<priorities.length; i++){
            queue.offer(priorities[i]);
            // min=Math.min(min,priorities)
            pq.offer(priorities[i]);
        }
        
        while(!pq.isEmpty() && !queue.isEmpty()){
            int pqTemp = pq.peek();
            int queueTemp = queue.poll();
            // System.out.print(location+" ");
            if(pqTemp==queueTemp){
                if(location==0){
                    answer++;
                    break;
                }
                
                pq.poll();
                location--;
                answer++;
            }
            else{
                if(location==0)
                    location=queue.size();
                else
                    location--;
                queue.offer(queueTemp);
            }
        }
        
        return answer;
    }
}