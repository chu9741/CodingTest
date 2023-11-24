import java.util.*;
class Solution {
    
    Map<Integer,ArrayList<Integer>> nodes;
    boolean[] isVisited;
         

    Stack<ArrayList<Integer>> parentStack;
    int max=0;
    
    public int solution(int[] info, int[][] edges) {
        // 부모 방문 한적있음? , 자식 처음 방문? 양>늑?         
        // 노드를 돌면서, 새로운 양>늑이 될수있게 DFS? 완탐이 맞음 
        // 노드를 본다 -> 부모 노드는? 자식 노드는? 
        int len = info.length;
        isVisited = new boolean[len];
        nodes = new HashMap<>();
        
        for(int i=0; i<len; i++){
            nodes.put(i, new ArrayList<>());
        }
        for(int[] temp : edges){
            nodes.get(temp[0]).add(temp[1]);
        }
   
        
        for(int key: nodes.keySet()){
            System.out.println(key+ " "+nodes.get(key).size()+" "+nodes.get(key));
        }
        int sheep=0;
        int wolves = 0; 

        DFS(info,0,edges, sheep+1, wolves);
        
        return max;
    }
    
    public void DFS(int[] info, int idx, int[][] edges, int sheep, int wolves){
        isVisited[idx]=true;
        if(sheep>wolves){
            max=Math.max(max,sheep);
            // System.out.println(max+" "+idx+" "+wolves);
        }
        else{
            return;
        }
        for(int[] edge : edges){
            if(isVisited[edge[0]] && !isVisited[edge[1]]){
                // isVisited[edge[1]]=true;
                if(checkSheep(edge[1],info)){
                    DFS(info,edge[1],edges, sheep+1, wolves);
                }else{
                    DFS(info,edge[1],edges, sheep, wolves+1);
                }
                isVisited[edge[1]]=false;

            }
        }
            // isVisited[idx]=true;
            
         // 루트부터 돌고 밑에 애들 확인 -> Sheep쪽으로 보고 없으면 늑대로 -> 쉽늑 체크 -> 쉽늑 오바되면 위로 올라오기
        // 부모 리스트 있어야될거같은데 isVisited도 필요하긴한데.. 부모 스택으로 들고있자?
        
    }
    
    
    public int childSize(int idx){
        if(nodes.get(idx).size()==0){
            return 0;
        }
        if(nodes.get(idx).size()==1){
            return 1;
        }
        return 2;
    }
    
    public boolean checkSheep(int idx, int[] info){
        if(info[idx]==0){
            return true;
        }
        return false;
    }
    
    public int returnVisited(){
        int score=0;
        for(boolean v : isVisited){
            if(v){
                score++;
            }
        }
        return score;
    }
    
}