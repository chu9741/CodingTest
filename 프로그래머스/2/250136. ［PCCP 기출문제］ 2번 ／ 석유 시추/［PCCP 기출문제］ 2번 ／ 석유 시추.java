import java.util.*;

class Solution {
    
    static int width=0;
    static int height=0;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public int solution(int[][] land) {
        
        int width = land[0].length;
        int height = land.length;
        
        // BFS로 돌린다.. 
        // BFS로 land가 1인곳을 돌면서 Id값을 넣고, Cnt를 MAP으로 넣는다.
        // 석유 첫칸을 Queue에 넣고 주변 값들을 넣는다. 
        
        int[][] isVisited = new int[height][width];
        
        // id, x, y
        Queue<int[]> queue = new LinkedList<>();
        HashMap<Integer, Integer> idOilMap = new HashMap<>();
        
        int id=0;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(isVisited[i][j]==0 && land[i][j]==1){
                    ++id;
                    queue.add(new int[]{i,j});
                    int count=0;
                    while(!queue.isEmpty()){
                        int[] tmp = queue.poll();
                        // queue의 값이 이미 지난 곳일 수도 있음
                        if(isVisited[tmp[0]][tmp[1]]!=0){
                            continue;
                        }
                        // 방문한 곳에 id를 표시함.
                        isVisited[tmp[0]][tmp[1]]=id;
                        // id값들을 카운트함
                        count++;
                        for(int k=0; k<4; k++){
                            int nx = tmp[0]+dx[k];
                            int ny = tmp[1]+dy[k];
                            if(nx>=0 && ny>=0 && nx<height && ny < width){
                                // id값을 공유하는 같은 범위 내의 석유를 찾는다.
                                if(isVisited[nx][ny]==0 && land[nx][ny]==1){
                                    queue.add(new int[]{nx,ny});
                                }
                            }
                        }
                    }
                    idOilMap.put(id,count);
                }
            }
        }
        
        int max=0;
        for(int i=0; i<width; i++){
            // 한 Column에서 중복된 id값을 뽑지 않기 위함
            Set<Integer> idSet = new HashSet<>();
            int sum=0;
            for(int j=0; j<height; j++){
                // 중복된 id값이 아니라면 Set에 넣고 Sum에 해당 하는 값을 추가
                if(!idSet.contains(isVisited[j][i]) && isVisited[j][i]!=0){
                    idSet.add(isVisited[j][i]);
                    sum+=idOilMap.get(isVisited[j][i]);
                }
            }
            max=Math.max(sum,max);
        }
        return max;
        
    }
}