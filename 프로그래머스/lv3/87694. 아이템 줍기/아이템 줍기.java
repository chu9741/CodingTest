import java.util.*;

class Solution {
    
    HashSet<HashMap<Integer,Integer>> set = new HashSet<>();
    HashSet<HashMap<Integer,Integer>> noSet = new HashSet<>();
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        // 직사각형을 따라가는 선을 만들어야될거같은데.. [x,y] 를 Set을 만들고 
        // 일단 직사각형 모든좌표를 넣는다. -> 그리고 안에 있는걸 빼자
        // 좌표값을 모두 *2 해서 넣는다. 
        
        addAllCoord(rectangle);  // 직사각형의 모서리 + 내부 점까지 넣음 (모두 *2 해서)
        removeCoord(); // 내부의 점 삭제 ( 모두 *2 해서 )
        int[][] isVisited = new int[102][102]; // 방문한 좌표까지의 거리 저장
        // 모서리만 남음
        
        Queue<HashMap<Integer,Integer>> queue = new LinkedList<>(); //set에서 queue에 넣고 BFS로
        HashMap<Integer,Integer> start = new HashMap<>(); // 시작점 만들기 
        start.put(characterX*2,characterY*2); 
        isVisited[characterX*2][characterY*2]=1;
        queue.offer(start); // 시작점 넣기
        
        while(!queue.isEmpty()){  
            HashMap dir = queue.poll();
            int key = (int)dir.keySet().toArray()[0];
            int value = (int)dir.get(key);
            //dir은 현재위치 , key value는 현재 위치의 x,y값
            
            int[] disX = {-1,0,1,0}; // 동서남북
            int[] disY = {0,1,0,-1};
            
            if( key == itemX*2 && value == itemY*2)
                break;
            
            for(int i=0; i<4; i++){ // 동서남북 좌표 확인하며 길찾기
                HashMap<Integer,Integer> dirTmp = new HashMap<>();
                dirTmp.put(key+disX[i],value+disY[i]);
                
                if(key+disX[i] == itemX*2 && value+disY[i] == itemY*2){
                    //도착
                    if(isVisited[key+disX[i]][value+disY[i]]==0)
                        isVisited[key+disX[i]][value+disY[i]] =isVisited[key][value]+1;
                    else{
                        isVisited[key+disX[i]][value+disY[i]] =Math.min(isVisited[key][value]+1,isVisited[key+disX[i]][value+disY[i]]);                       
                    }
                }
                else{
                    if(isVisited[key+disX[i]][value+disY[i]]==0 && set.contains(dirTmp)){
                        //방문하지않았고 다음 길이 존재할 때
                        queue.offer(dirTmp);
                        isVisited[key+disX[i]][value+disY[i]] =isVisited[key][value]+1;
                    }
                }
      
            }
        } 
        
        // for(int y=20; y>=0; y--){
        //     for(int x=0; x<=20; x++){
        //         System.out.printf("%3d",isVisited[x][y]);
        //     }
        //     System.out.println();
        // }
        answer = (isVisited[itemX*2][itemY*2]-1)/2;
        return answer;
    }
    
    
    public void addAllCoord(int[][] rectangle){
        for(int[] rec : rectangle){
            // x,y x,y
            
            int xLength = rec[2]-rec[0];
            int yLength = rec[3]-rec[1];
            
            for(int i=0; i<=xLength*2; i++){
                HashMap<Integer,Integer> tmp = new HashMap<>();
                HashMap<Integer,Integer> tmp2 = new HashMap<>();
                tmp.put(rec[0]*2+i,rec[1]*2);
                tmp2.put(rec[2]*2-i,rec[3]*2);
        
                set.add(tmp);
                set.add(tmp2);
            }
            
            for(int j=0; j<=yLength*2; j++){
                HashMap<Integer,Integer> tmp3 = new HashMap<>();
                HashMap<Integer,Integer> tmp4 = new HashMap<>();
                tmp3.put(rec[0]*2,rec[1]*2+j);
                tmp4.put(rec[2]*2,rec[3]*2-j);
                
                set.add(tmp3);
                set.add(tmp4);
            }
            
            for(int a=1; a<xLength*2; a++){
                for(int b=1; b<yLength*2; b++){
                    HashMap<Integer,Integer> noTmp = new HashMap<>();
                    noTmp.put(rec[0]*2+a,rec[1]*2+b);
                    noSet.add(noTmp);
                }
            } 
        }
    }
    
    public void removeCoord(){
        HashSet<HashMap<Integer,Integer>> tmpSet = new HashSet<>();
        for(HashMap hm : set){
            if(noSet.contains(hm)){
                tmpSet.add(hm);
            }
        }
        set.removeAll(tmpSet);     
    }      
}