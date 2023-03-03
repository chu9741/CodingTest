class Solution {
    
    boolean[] isVisited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        isVisited = new boolean[n];
        
        // for(int i=0; i<n; i++){
        //     computers[i][i]=0;
        // }
        
        for(int i=0; i<n; i++){
            if(!isVisited[i]){
                DFS(i,computers,isVisited);
                answer++;
            }
        }
        //연결되어있으면 같은 네트워크..
        // 1부터 n까지 네트워크 확인해서 해당되는 값은 isVisited로 넣고 network를 하나로 선언한다 
        // isVisted에 해당하지않은 값을 다시 네트워크 추가해서 돌리기        
        return answer;
    }
    
    public void DFS(int i,int[][] computers, boolean[] isVisited){
        isVisited[i]=true;
        for(int j=0; j<computers.length; j++){
            if(!isVisited[j] && computers[i][j]==1){
                // System.out.print(j+" ");
                DFS(j,computers,isVisited);
            }
        }
    }    
}