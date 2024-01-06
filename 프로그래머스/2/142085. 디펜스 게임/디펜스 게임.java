import java.util.*;
class Solution {
    int max=-1;

    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> kQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<enemy.length; i++){
            // n은 enemy를 감당할 수 있음
            if(n>=enemy[i]){
                n-=enemy[i];
                kQueue.offer(enemy[i]);
            }
            //n으로 지불이 안될 때
            else{
                // k로는 지불이 가능할 때
                if(k>0){
                    if(!kQueue.isEmpty()){
                        // queue.peek을 k를 사용하면 살릴 수 있을 때
                        if(enemy[i]<=kQueue.peek()){
                            n+=kQueue.poll()-enemy[i];
                            kQueue.offer(enemy[i]);
                        }
                    }
                    k--;
                }
                // n도 안되고 k도 안될 때 그냥 종료
                else{
                    max=Math.max(i,max);
                    break;
                }
            }
        }
        if(max==-1){
            max=enemy.length;
        }
        return max;
    }
}