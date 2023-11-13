import java.util.*;

class Solution {
    
    int[] sp = new int[2];
    int[] lp = new int[2];
    int[] ep = new int[2];
    int[] dx={-1,0,1,0};
    int[] dy={0,1,0,-1};
    int min=10000;
    
    public int solution(String[] maps) {
        int answer = 0;
        int len = maps.length;
        
        String[][] board = new String[len][];
        boolean[][] isVisited=new boolean[len][maps[0].length()];
   
        
        for(int i=0; i<len; i++){
            board[i] = maps[i].split("");
            for(int j=0; j<board[i].length; j++){
                if(board[i][j].equals("S")){
                    sp[0]=i;
                    sp[1]=j;
                }
                if(board[i][j].equals("E")){
                    ep[0]=i;
                    ep[1]=j;
                }
                if(board[i][j].equals("L")){
                    lp[0]=i;
                    lp[1]=j;
                }
            }
        }
        
        //BFS를 위한 Queue
        Queue<int[]> queue = new LinkedList<>();
        
        //시작점에서 레버까지 최단거리 구하기, Queue에는 x좌표,y좌표,걸음수가 들어간다
        int[] start = {sp[0],sp[1],0};
        queue.offer(start);
        int sum1=0;
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            if(tmp[0]==lp[0] && tmp[1]==lp[1]){
                sum1+=tmp[2];
                break;
            }
            
            for(int i=0; i<4; i++){
                int tmpx = tmp[0]+dx[i];
                int tmpy = tmp[1]+dy[i];
                if(tmpx>=0 && tmpy>=0 && tmpx<board.length && tmpy<board[0].length){
                    if(!board[tmpx][tmpy].equals("X") && !isVisited[tmpx][tmpy]){
                        queue.offer(new int[]{tmpx, tmpy, tmp[2]+1});
                        isVisited[tmpx][tmpy]=true;
                    }
                }                
            }
        }
        
        //레버에서 endpoint까지 가기 , queue를 비우고 다시 넣는다, isVisited도 초기화 해서 시작
        int[] lever = {lp[0],lp[1],0};
        queue.clear();
        queue.offer(lever);
        isVisited= new boolean[board.length][board[0].length];

        if(sum1==0){
            return -1;
        }
        
        int sum2=0;
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            if(tmp[0]==ep[0] && tmp[1]==ep[1]){
                sum2+=tmp[2];
                break;
            }
            
            for(int i=0; i<4; i++){
                int tmpx = tmp[0]+dx[i];
                int tmpy = tmp[1]+dy[i];
                if(tmpx>=0 && tmpy>=0 && tmpx<board.length && tmpy<board[0].length){
                    if(!board[tmpx][tmpy].equals("X") && !isVisited[tmpx][tmpy]){
                        queue.offer(new int[]{tmpx, tmpy, tmp[2]+1});
                        isVisited[tmpx][tmpy]=true;
                    }
                }                
            }
        }
        
        if(sum2==0){
            return -1;
        }
        return sum1+sum2;
        
        
        // DFS(board,isVisited,sp[0],sp[1],0, lp);
        // answer+=min;
        // min=10000;
        // isVisited=new boolean[len][maps[0].length()];
        // if(answer==10000){
        //     return -1;
        // }
        // DFS(board,isVisited,lp[0],lp[1],0, ep);
        // return answer+min>=10000 ? -1 : answer+min;
    }
    
    
    public void DFS(String[][] board, boolean[][] isVisited, int x, int y, int cnt, int[] end){
        isVisited[x][y]=true;
        
        //종점을 만나고 레버가 당겨져있으면 탈출
        if(x==end[0] && y==end[1]){
            min = Math.min(min,cnt);
        }
        else{
            //상하좌우 방향으로 방문하지 않은 길중에 X가 아닌것을 방문해서 넣기
            for(int i=0; i<4; i++){
                if(cnt>=min){
                    return;
                }
                if(x+dx[i]>=0 && x+dx[i]<board.length && y+dy[i]>=0 && y+dy[i]<board[0].length){
                    if(!isVisited[x+dx[i]][y+dy[i]] && !board[x+dx[i]][y+dy[i]].equals("X")){
                        DFS(board,isVisited,x+dx[i],y+dy[i],cnt+1, end);
                        isVisited[x+dx[i]][y+dy[i]]=false;
                    }
                } 
            }
        }
    }
}