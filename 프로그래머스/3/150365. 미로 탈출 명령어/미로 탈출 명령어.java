import java.util.*;

class Solution {
    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,-1,1,0};
    static String[] dir= {"d","l","r","u"};
    static String answer="";
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        // n*m 의 미로 -> x,y 에서 r,c로 이동해서 탈출 
        // 격자 바깥으로 나갈 수 없음, 이동 거리 k 
        // 문자열 사전순으로 가장 빠른 경로
        // x,y 좌표를 l,r,u,d를 활용하여 움직이고 r,c까지 k가 되는 방법을 찾는다.. 
        // visited는 의미가 없음,, 
        //  . . . . 
        //  . . S .
        //  E . . .
        //
        if((Math.abs(x-r)+Math.abs(y-c))%2 != k%2){
            return "impossible";
        }
        StringBuilder sb = new StringBuilder();
        dfs(n,m,x,y,r,c,k,sb);
        
        if(answer.length()==0){
            return "impossible";
        }
        return answer;
        
//         Queue<Node> queue = new LinkedList<Node>();
//         Node startNode =new Node(x,y);
//         if(k<Math.abs(x-r)+Math.abs(y-c)){
//             return "impossible";
//         }
//         queue.add(startNode);
        
//         while(!queue.isEmpty()){
//             Node node= queue.poll();
//             if(node.cnt==k){
//                 if(node.x==r && node.y==c){
//                     String result = node.sb.toString();
//                     return result;
//                 }
//             }else{
//                 if(node.x<n && (Math.abs(node.x-r)+Math.abs(node.y-c))<=(k-node.cnt)){
//                     StringBuilder tmp = new StringBuilder(node.sb);
//                     queue.add(new Node((node.x+1),node.y,tmp.append("d"),(node.cnt+1)));
//                 }
//                 if(node.y>1 && (Math.abs(node.x-r)+Math.abs(node.y-c))<=(k-node.cnt)){
//                     StringBuilder tmp = new StringBuilder(node.sb);
//                     queue.add(new Node(node.x,(node.y-1),tmp.append("l"),(node.cnt+1)));
//                 }
//                 if(node.y<m && (Math.abs(node.x-r)+Math.abs(node.y-c))<=(k-node.cnt)){
//                     StringBuilder tmp = new StringBuilder(node.sb);
//                     queue.add(new Node(node.x,(node.y+1),tmp.append("r"),(node.cnt+1)));
//                 }
//                 if(node.x>1 && (Math.abs(node.x-r)+Math.abs(node.y-c))<=(k-node.cnt)){
//                     StringBuilder tmp = new StringBuilder(node.sb);
//                     queue.add(new Node((node.x-1),node.y,tmp.append("u"),(node.cnt+1)));
//                 }
//             }
//         }
        
//         if(answer.equals("")){
//             return "impossible";
//         }
//         return answer;
    }
    
    void dfs(int n, int m ,int curX, int curY, int r, int c, int k, StringBuilder sb){
        if(answer.length()!=0){
            return;
        }
        if(k==0){
            if(curX==r && curY==c){
                answer = sb.toString();
            }
        }else{
            for(int i=0 ;i<4 ;i++){
            // d l r u
                StringBuilder tmp = sb;
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                int remain = Math.abs(nx-r)+Math.abs(ny-c);
                if(remain>k){
                    continue;
                }
                
                if(nx>0 && ny>0 && nx<=n && ny<=m){
                    dfs(n,m,nx,ny,r,c,k-1,sb.append(dir[i]));
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
    
    class Node{
        int x;
        int y;
        StringBuilder sb;
        int cnt;
        
        Node(int x, int y){
            this.x = x;
            this.y = y;
            this.sb = new StringBuilder();
            this.cnt=0;
        }
        
        Node(int x, int y, StringBuilder sb , int cnt){
            this.x = x;
            this.y = y;
            this.sb =sb;
            this.cnt=cnt;
        }
    }
}