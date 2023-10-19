import java.util.*;


class Location{
    int x;
    int y;
    int cnt;
    
    public Location(int x, int y, int cnt){
        this.x=x;
        this.y=y;
        this.cnt=cnt;
    }
}

class Solution {
    
    int[] dx={-1,0,1,0};
    int[] dy={0,1,0,-1};
    
    String[][] arr;
    boolean[][] isVisited;
    
    int min=-1;
    public int solution(String[] board) {
        int answer = 0;
        int boardLen=board.length;
        arr = new String[board.length][];
        isVisited = new boolean[board.length][board[0].length()];
        
        int startX=0;
        int startY=0;
        for(int i=0; i<board.length; i++){
            arr[i]=board[i].split("");
            for(int j=0; j<arr[i].length; j++){
                if(arr[i][j].equals("R")){
                    startX=i;
                    startY=j;
                }
            }
        }
        
        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(startX,startY,0));
        while(!queue.isEmpty()){
            Location tmp = queue.poll();
            isVisited[tmp.x][tmp.y]=true;
            if(arr[tmp.x][tmp.y].equals("G")){
                return tmp.cnt;
            }
            // System.out.println("###"+tmp.x+" "+tmp.y+" "+tmp.cnt);
            for(int i=0; i<4; i++){
                int[] newLoc = slideIdx(tmp.x,tmp.y,dx[i],dy[i]);
                if((newLoc[0]!=tmp.x || newLoc[1]!=tmp.y) && (!isVisited[newLoc[0]][newLoc[1]])){
                    // System.out.println(newLoc[0]+""+newLoc[1]+""+tmp.cnt);
                    queue.offer(new Location(newLoc[0],newLoc[1],tmp.cnt+1));
                }
            }
        }
        isVisited[startX][startY]=true;
        // DFS(0,startX,startY);
        
        return min;
    }
    
    
    public void DFS(int cnt,int x, int y){
        if(cnt>=min){
            return;
        }
        if(arr[x][y].equals("G")){
            min=cnt;
            return;
        }
        
        for(int i=0; i<4; i++){
            //미끄러져가기
            
            //새로운 좌표로 이동 ( isVisited가 false여야 함, 아니면 제자리던가)
            int[] newLocation = slideIdx(x,y,dx[i],dy[i]);
            
            // 제자리라면 다른 방향으로 가야함
            if((newLocation[0]==x && newLocation[1]==y)){
                continue;
            }
            // cnt++;
            System.out.println(newLocation[0]+" "+newLocation[1]);
            isVisited[newLocation[0]][newLocation[1]]=true;
            DFS(cnt+1,newLocation[0],newLocation[1]);
            isVisited[newLocation[0]][newLocation[1]]=false;
        }
                
    }
    
    public int[] slideIdx(int x, int y, int dirX, int dirY){
        while(true){
            int tmpX=x+dirX;
            int tmpY=y+dirY;
            // System.out.println(x+" "+y+" "+dirX+" "+dirY);
            if(tmpX < 0 || tmpX>=arr.length || tmpY<0 || tmpY>=arr[0].length){
                //벽을 넘게 되면
                return new int[]{x,y};
            }
            
            else if(arr[tmpX][tmpY].equals("D")){
                //장애물 만나면
                return new int[]{x,y};
            }
            else{
                x+=dirX;
                y+=dirY;
                continue;
            }
        }
    }
}