import java.util.*;
class Solution {
    
    int result=0;
    public int solution(int[] order) {
        int answer = 0;
        int len = order.length;
        
        // 보조 => stack  / 1,2,3 -> 3,2,1
        // main =>  queue / 1,2,3 => 1,2,3
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> mainBelt = new LinkedList<>();
        Stack<Integer> subBelt = new Stack<>();
    
        for(int i=0; i<len; i++){
            queue.offer(i+1);
        }
        
        // 벨트에 들어갈수있는 경우의수 2가지 -> 5개면 2의5승개 4 3
        int i=0;
        while(!(queue.size()==0 && subBelt.size()==0)){
            
            // 메인 벨트의 값이 order와 일치하는 경우
            if(queue.size()!=0 && queue.peek()==order[i]){
                result++;
                i++;
                queue.poll();
            }
            // 서브 벨트의 값이 order와 일치하는 경우
            else if (subBelt.size() !=0 && subBelt.peek()==order[i]){
                result++;
                i++;
                subBelt.pop();
            }
            
            // 둘 다 일치하지 않는 경우
            else{
                if(queue.size()!=0){
                    subBelt.push(queue.poll());
                }else{
                    break;
                }
            }
            
        }
        
        return result;
    }
}