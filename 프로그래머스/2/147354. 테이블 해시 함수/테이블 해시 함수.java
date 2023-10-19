import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2)->{
            if(arr1[col-1]==arr2[col-1]){
                return arr2[0]-arr1[0];
            }
            return arr1[col-1]-arr2[col-1];
        });
        
        for(int i=0;i<data.length;i++){
            pq.offer(data[i]);
        }
        
        Queue<Integer> queue= new LinkedList<>();
        
        for(int i=0; i<row_begin-1; i++){pq.poll();}
        for(int i=row_begin; i<=row_end; i++){
            int[] tmp = pq.poll();
            int sum=0;
            for(int t : tmp){
                sum+=t%i;
            }
            queue.offer(sum);
        }
        
        while(queue.size()!=1){
            int a = queue.poll();
            int b = queue.poll();
            
            queue.offer(XOR(a,b));
        }
        return queue.poll();
    }
    
    
    public int XOR(int a, int b){
        Stack<Integer> aStack = new Stack<>();
        Stack<Integer> bStack = new Stack<>();
        while(!(a==0 && b==0)){
            aStack.push(a == 0 ? 0 : a%2);
            bStack.push(b == 0 ? 0 : b%2);
            
            a/=2;
            b/=2;            
        }
        
        Stack<Integer> sumStack = new Stack<>();
        while(!aStack.isEmpty()){
            int tmpA = aStack.pop();
            int tmpB = bStack.pop();
            if(tmpA == tmpB){
                sumStack.push(0);
            }
            else{
                sumStack.push(1);
            }
        }
        
        int sum=0;
        int staticSize = sumStack.size();
        for(int i=0; i<staticSize; i++){
            sum+=Math.pow(2,i)*sumStack.pop();
        }
        return sum;
    }
}