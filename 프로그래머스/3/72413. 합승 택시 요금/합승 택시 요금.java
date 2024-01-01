import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        // fares정보를 담은 map들
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        // 최소 거리 체크
        int[][] board = new int[n+1][n+1];
        boolean [] isVisited = new boolean[n+1];
        Map<Integer, ArrayList<Integer>> path = new HashMap<>();

        for(int i=0; i<n+1; i++){
            for(int j=0; j<n+1; j++){
                if(i==j) board[i][j]=0;
                else board[i][j]=200*100000;
            }
            path.put(i, new ArrayList<>());
        }
        
        for(int[] fare : fares){
            board[fare[0]][fare[1]]=fare[2];
            board[fare[1]][fare[0]]=fare[2];
            
            if(!map.containsKey(fare[0])){
                map.put(fare[0], new HashMap<>());
            }
            if(!map.containsKey(fare[1])){
                map.put(fare[1], new HashMap<>());
            }
            map.get(fare[0]).put(fare[1],fare[2]);
            map.get(fare[1]).put(fare[0],fare[2]);
        }
        
        // i=거쳐가는  노드 , j= 출발 노드 , k는 도착 노드
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    board[i][j]=Math.min(board[i][k]+board[k][j], board[i][j]);
//                     if(board[i][k]+board[k][j] < board[i][j]){
                        
//                     }
                }
            }
        }
        
        int min = 200*100000;
        int idx=-1;
        for(int i=1; i<=n; i++){
            if(board[s][i]+board[i][a]+board[i][b]<min){
                min=Math.min(min, board[s][i]+board[i][a]+board[i][b]);
                idx=i;
            }
        }
        
        answer=min;
        
        // sk + ka + kb = MINIMUM // i=s -> a, b
        
        
        // for(int i=1; i<=n; i++){
        //     for(int j=1; j<=n; j++){
        //         System.out.print(board[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
        // s에서 연결된 노드
//         Set<Integer> tmp = map.get(s).keySet();
        
//         //방문하지 않은 최소cost를 가진 다음 노드
                
//         // 현재 위치
//         int point = s;
        
//         for(int i=0; i<n; i++){    
//             //dijkstra
//             isVisited[s]=true;
//             int nonVisitMinIdx = -1;
            
//             // t = tmp
            
//             for(int t : tmp){
//                 // 현재 위치까지의 cost + 새로운 점까지의 cost < 기존의 새로운 점까지의 cost 
//                 if(map.get(point).get(t)+ board[point] < board[t]){
//                     // 경로를 추가해줌 
//                     board[t]=map.get(point).get(t)+board[point];
//                     path.get(t).addAll(path.get(point));
//                     path.get(t).add(point);
//                 }
//                 if(!isVisited[t]){
//                     // 방문하지 않는 노드 중에서 최소 cost를 가진 next node 
//                     if(nonVisitMinIdx==-1){
//                         nonVisitMinIdx=t;
//                     }
//                     else{
//                         if(map.get(point).get(t) < map.get(point).get(nonVisitMinIdx))
//                             nonVisitMinIdx = t;
//                     }
//                 }
//             }
            
//             tmp = map.get(nonVisitMinIdx).keySet();
//             point = nonVisitMinIdx;
            
//         }
        
//         for(int i : path.get(b)){
//             System.out.print(i+" ");
//         }
//         System.out.println();
        
        //지점의 개수 n, 출발지점을 나타내는 s, A의 도착지점을 나타내는 a, B의 도착지점을 나타내는 b, 지점 사이의 예상 택시요금을 나타내는 fares가 매개변수 , [c,d,f] = c에서d까지 cost = f
        
        // s->a랑 s->b경로의 최솟값을 파악 , 다익스트라? 
        // 
        
        //다익스트라를 생각하겠지? s에서 a로 가는거 해보기+ s에서 b로 가는거 해보기 , 각 점을 이어서 
        
        return answer;
    }
}