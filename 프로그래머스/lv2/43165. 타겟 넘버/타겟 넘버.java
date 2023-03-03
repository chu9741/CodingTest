class Solution {
    
    int count = 0;
    boolean[] isVisited = new boolean[20];
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int res =0;
        //+,- numbers를 양쪽으로 나눈다-> 더하거나 빼거나 
        
        DFS(0,res,numbers,target);
        
        return count;
    }
    
    public void DFS(int level, int res, int[] numbers, int target){
        if(level==numbers.length){
            if(target==res)
                count++;
            // System.out.println("answer : "+res);
        }
        else{
            if(!isVisited[level]){
                // System.out.println(res+" "+level);
                DFS(level+1, res+numbers[level], numbers, target);
                // System.out.println(res+" "+level);
                DFS(level+1, res-numbers[level], numbers, target);
            }            
        }       
    }
}