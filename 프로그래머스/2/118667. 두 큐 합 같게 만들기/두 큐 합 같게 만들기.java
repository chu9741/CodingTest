import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        
        //완탐
        //  1 ≤ queue1의 길이 = queue2의 길이 ≤ 300,000
        //  1 ≤ queue1의 원소, queue2의 원소 ≤ 109
        long sum=0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i=0;i<queue1.length; i++){
            sum+=queue1[i];
            q1.offer(queue1[i]);
        }
        for(int i=0;i<queue2.length; i++){
            sum+=queue2[i];
            q2.offer(queue2[i]);
        }
        if(sum%2==1){
            return -1;
        }
        
        long res=sum/2;
        int cnt=0;
        long qSum=returnSum(q1);
        while(qSum!=res){
            if(qSum>res){
                // if(q1.isEmpty()) return -1;
                int tmp=q1.poll();
                q2.offer(tmp);
                qSum-=tmp;
            }else{
                // if(q2.isEmpty()) return -1;
                int tmp= q2.poll();
                q1.offer(tmp);
                qSum+=tmp;
            }
            cnt++;
            // qSum=returnSum(q1);
            // System.out.println(qSum+" "+q1.size()+" "+q2.size());
            if(cnt>600000){
                return -1;
            }
        }
        return cnt;
    }
    
    long returnSum(Queue<Integer> queue){
        long sum=0;
        for(int i=0; i<queue.size(); i++){
            int tmp = queue.poll();
            sum+=tmp;
            queue.offer(tmp);
        }
        return sum;
    }
}