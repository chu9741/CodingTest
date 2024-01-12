import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    // 찾을 최소 변화값
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        Main main2 = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int n = Integer.parseInt((str.split(" ")[0]));
        int m = Integer.parseInt((str.split(" ")[1]));

        String[][] board = new String[n][m];

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = tmp[j];
            }
        }

        /////////////////////////////////////////////
        int x = n - 8;
        int y = m - 8;

        // 한칸씩 전체적으로 8*8로 옮기기
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                int cntB = main2.firstB(board,i,j);
                int cntW = main2.firstW(board,i,j);

                int localMin = Math.min(cntB,cntW);

//                System.out.println(cntB+" "+i+" "+cntW+" "+j);

                min= Math.min(localMin,min);
            }
        }

        System.out.println(min);


    }
    // 만약에 첫번째가 B라면
    // 그러면 ~~ 한다


    int firstB(String[][] board, int i, int j) {

        // i가 짝수일 때 , 홀수 일 때
        //  BWBWBWBW
        //  WBWBWBWB
        // i , j


        // 바꿔야되는 갯수
        int cnt = 0;

        //
        if(i%2 ==0 ){
            // 8*8 틀 -> (0,0)은 무조건 B
            for (int k = 0; k<8; k++) {
                for (int l = 0; l <8; l++) {
                    // k==짝, l==짝이면 B / k==홀, l==홀 B이어야 한다
                    if ((k % 2 == 0 && l % 2 == 0) || (k % 2 == 1 && l % 2 == 1)) {
                        // B 값이 아니면 바꿔야 하는 개수를 늘린다
                        if (!checkB(board, k+i, l+j)) {
                            cnt++;
                        }
                    }
                    // k==짝, l==홀  W / k==홀, l==짝 W
                    else{
                        if(!checkW(board,k+i,l+j)){
                            cnt++;
                        }
                    }
                }
            }
        }
        else{
            for (int k = 0; k < 8; k++) {
                for (int l = 0; l < 8; l++) {
                    // k==짝, l==짝이면 B / k==홀, l==홀 W이어야 한다
                    if ((k % 2 == 0 && l % 2 == 0) || (k % 2 == 1 && l % 2 == 1)) {
                        // B 값이 아니면 바꿔야 하는 개수를 늘린다
                        if(!checkW(board,k+i,l+j)){
                            cnt++;
                        }
                    }
                    // k==짝, l==홀  W / k==홀, l==짝 B
                    else{
                        if (!checkB(board, k+i, l+j)) {
                            cnt++;
                        }
                    }
                }
            }

        }
        return cnt;
    }


    int firstW(String[][] board, int i, int j) {

        // i가 짝수일 때 , 홀수 일 때
        //  BWBWBWBW
        //  WBWBWBWB

        // 바꿔야되는 갯수
        int cnt = 0;

        //
        if(i%2 ==0){
            for (int k = 0; k < 8; k++) {
                for (int l = 0; l < 8; l++) {
                    // k==짝, l==짝이면 B / k==홀, l==홀 W이어야 한다
                    if ((k % 2 == 0 && l % 2 == 0) || (k % 2 == 1 && l % 2 == 1)) {

                        // B 값이 아니면 바꿔야 하는 개수를 늘린다
                        if (!checkW(board, k+i, l+j)) {
                            cnt++;
                        }
                    }
                    // k==짝, l==홀  W / k==홀, l==짝 B
                    else{
                        if(!checkB(board,k+i,l+j)){
                            cnt++;
                        }
                    }
                }
            }
        }
        else{
            for (int k = 0; k < 8; k++) {
                for (int l = 0; l < 8; l++) {
                    // k==짝, l==짝이면 B / k==홀, l==홀 B이어야 한다
                    if ((k % 2 == 0 && l % 2 == 0) || (k % 2 == 1 && l % 2 == 1)) {
                        // B 값이 아니면 바꿔야 하는 개수를 늘린다
                        if(!checkB(board,k+i,l+j)){
                            cnt++;
                        }
                    }
                    // k==짝, l==홀  W / k==홀, l==짝 W
                    else{
                        if (!checkW(board, k+i, l+j)) {
                            cnt++;
                        }
                    }
                }
            }

        }
        return cnt;
    }





    boolean checkB(String[][] board,int i, int j){
        if(board[i][j].equals("B")){
            return true;
        }
        return false;
    }

    boolean checkW(String[][] board,int i, int j){
        if(board[i][j].equals("B")){
            return false;
        }
        return true;
    }
}
