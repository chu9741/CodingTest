import java.util.*;
class Solution {
    public int[] solution(String[][] places) {
        int n = places.length;
        int[] answer = new int[n];
        
        for(int i=0; i<n; i++){ // place의 케이스마다 진행
            String[] place = places[i];
            int plen = place.length;
            String[][] board = new String[plen][plen]; // 5*5 board
            for(int a=0; a<plen; a++){
                board[a]=place[a].split("");
            }
            
            ArrayList<int[]> pList = findP(board); // p의 좌표
            answer[i]=1;
            for(int p=0; p<pList.size(); p++){ //p중 하나의 p에 대해서
                int[] root = pList.get(p);
                ArrayList<int[]> under2List = Under2List(p,pList);
                // System.out.println("#######"+pList.size()+""+i);
                //파티션 체크 -> false면 바로 brak;
                if(isPartitioned(board, root, under2List)){
                    continue;
                }
                else{
                    answer[i]=0;
                    break;
                }
            }
        }
        //p의 좌표 찾기,,? findP
        //p끼리 비교  => 2초과면 그냥 하고 2이하면 파티션 확인
        return answer;
    }
    public boolean isPartitioned(String[][] board, int[] root, ArrayList<int[]> arrList){
        for(int[] a : arrList){
            // System.out.println(a[0]+""+a[1]+" "+root[0]+""+root[1]);
            int[] path = {a[0]-root[0], a[1]-root[1]}; // +-(0,2),(2,0),(1,1),(1,0),(0,1) 경우
            if(Math.abs(path[0])+Math.abs(path[1])==1){ //  +-(0,1) (1,0)
                return false;
            }
            else{
                if(path[0]==0 || path[1]==0){ // +- (0,2) (2,0)
                    if(board[root[0]+path[0]/2][root[1]+path[1]/2].equals("X")){
                        continue;
                    }
                    else return false;
                }
                else{ // +- (1,1)
                    if(board[root[0]][root[1]+path[1]].equals("X") && board[root[0]+path[0]][root[1]].equals("X")){
                        continue;
                    }
                    else return false;
                }
            }   
        }
        return true;
    }

    
    public ArrayList<int[]> Under2List(int idx, ArrayList<int[]> pList){
        int[] root = pList.get(idx);
        // stream filter쓸까 
        ArrayList<int[]> arr = new ArrayList<>();
        
        for(int a=idx; a<pList.size(); a++){
            int[] temp = pList.get(a);
             // System.out.print(temp[0]+""+temp[1]+" "+root[0]+""+root[1]+"###");
            if(Math.abs(root[0]-temp[0])+Math.abs(root[1]-temp[1])<=2 
               && Math.abs(root[0]-temp[0])+Math.abs(root[1]-temp[1]) !=0){
                arr.add(temp);
                // System.out.print(temp[0]+""+temp[1]+" "+root[0]+""+root[1]);
            }
            
        }
        // System.out.println();
        return arr;
    }    
    
    public ArrayList<int[]> findP(String[][] board){
        ArrayList<int[]> arrList = new ArrayList<>();
        
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(board[i][j].equals("P")){
                    arrList.add(new int[]{i,j});
                }
            }
        }
        return arrList;
    }
}