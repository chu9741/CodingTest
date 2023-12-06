class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;      
        
        int[][] newBoard = new int[board.length][board[0].length];
        
        for(int[] s : skill){
            apply(newBoard,s);
        }
        for(int x=0; x<board.length; x++){
            colSum(newBoard,x);
        }
        
        
        for(int y=0; y<board[0].length; y++){
            rowSum(newBoard,y);
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]+newBoard[i][j]>0){
                    answer++;
                }
            }
        }
        return answer;
    }
    //skill의 각 행은 [type, r1, c1, r2, c2, degree]
    void colSum(int[][] board, int x){
        for(int i=0; i<board[0].length-1; i++){
            board[x][i+1]+=board[x][i];
        }
    }
    
    void rowSum(int[][] board,int y){
        for(int i=0; i<board.length-1; i++){
            board[i+1][y]+=board[i][y];
        }
    }

    void apply(int[][] board, int[] skill){
        int type = skill[0];
        int r1=skill[1];
        int c1=skill[2];
        int r2=skill[3];
        int c2=skill[4];
        int deg=skill[5];
        
        if(type==1){
            board[r1][c1]-=deg;
            if(r2!=board.length-1){
                board[r2+1][c1]+=deg;    
            }
            if(c2!=board[0].length-1){
                board[r1][c2+1]+=deg;
            }
            if(r2!=board.length-1 && c2!=board[0].length-1){
                board[r2+1][c2+1]-=deg;
            }
        }else{
            board[r1][c1]+=deg;
            if(r2!=board.length-1){
                board[r2+1][c1]-=deg;    
            }
            if(c2!=board[0].length-1){
                board[r1][c2+1]-=deg;
            }
            if(r2!=board.length-1 && c2!=board[0].length-1){
                board[r2+1][c2+1]+=deg;
            }
        }
        // for(int i=0; i<board.length; i++){
        //     for(int j=0; j<board[0].length; j++){
        //         System.out.print(board[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
    }    
}