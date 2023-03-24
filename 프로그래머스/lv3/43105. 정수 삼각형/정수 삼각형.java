class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int height=triangle.length;
        int width=triangle[height-1].length;
        result = new int[height][width];
        isVisited = new boolean[height][width];

        // 맨위 -> 왼,오 -> triangle length만큼 -> DFS로 하면 안되나..?
        
        result[0][0]=triangle[0][0];
        
        // DFS(0,0,triangle);
        DP(1,triangle);
        int max=0;
        
        for(int res : triangle[height-1]){
            // System.out.print(res+" ");
            max=Math.max(max,res);
        }
        
        return max;
    }
    
    int[][] result;
    boolean[][] isVisited;
    int sum=0;
    int max=0;
    
    public void DP(int level,int[][] tri){
        // 현재값에서 다음 값을 더할 때 최대 값으로,,
        if(level==tri.length){
            return;
        }
        else{
            for(int i=0; i<=level; i++){
                if(i==0){ // 다음 레벨의 첫번째 원소의 값은 반드시 이전 레벨의 값에 더해진다.  
                    tri[level][0]+=tri[level-1][0];
                    // System.out.print(tri[level][i]+" , ");

                }
                if(i==level){ // 다음 레벨의 마지막 원소의 값은 반드시 이전의 마지막 값에 더해진다.
                    tri[level][level]+=tri[level-1][level-1];  
                    // System.out.print(tri[level][i]+" , ");

                }
            }
            
            for(int j=1; j<level; j++){
                 
                tri[level][j] += Math.max(tri[level-1][j-1],tri[level-1][j]); 
                // System.out.print(tri[level][j]+" / ");
                
            }
            System.out.println();
            DP(level+1,tri);
        } 
    }
    
   
    
    
    public void DFS(int level, int idx, int[][] tri){
        sum+=tri[level][idx];
        isVisited[level][idx]=true;
        // System.out.println(level+" "+idx+" ");
        if(level==tri.length-1){
            max=Math.max(sum,max);
            // 지금깍지 Sum 최대값 
        }
        else{
            if(!isVisited[level+1][idx]){
                DFS(level+1,idx,tri);
                isVisited[level+1][idx]=false;
                sum-=tri[level+1][idx];
                // level--;
            }
            if(!isVisited[level+1][idx+1]){
                DFS(level+1,idx+1,tri);
                isVisited[level+1][idx+1]=false;
                sum-=tri[level+1][idx+1];
                // level--;
                // idx--;
            }     
        } 
    }
}