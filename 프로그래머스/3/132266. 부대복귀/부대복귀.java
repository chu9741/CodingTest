import java.util.*;

class Solution {
    
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        for(int i=0 ;i<sources.length; i++){
            answer[i]=-1;
        }

        // 한 점에서 갈 수 있는 점들
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        boolean isVisited[];
        for(int[] r : roads){
            if(!map.containsKey(r[0])){
                map.put(r[0],new ArrayList<>());
            }
            if(!map.containsKey(r[1])){
                map.put(r[1],new ArrayList<>());
            }
            map.get(r[0]).add(r[1]);
            map.get(r[1]).add(r[0]);
        }
        
        int dst = destination;
        // dst ->  src
        
        Queue<int[]> queue = new LinkedList<>();
        isVisited = new boolean[n+1];
        isVisited[0]=true;
        // 시작 점 , 움직인 횟수
        queue.offer(new int[]{dst, 0});
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            // System.out.println(i+" "+node[0]+" "+node[1]);
            for(int i=0; i<sources.length; i++){
                if(node[0]==sources[i] && answer[i]==-1){
                    answer[i]=node[1];
                    // System.out.println(i+" "+node.cnt);
                    break;
                }
            }
            if(map.containsKey(node[0])){
                // 시작점에서 갈 수 있는 값들 
                for(Integer tmp : map.get(node[0])){
                    if(!isVisited[tmp]){
                        isVisited[tmp]=true;                                
                        queue.offer(new int[]{tmp,node[1]+1});
                    }
                }
            }
        }
            // BFS
        return answer;
    }
}