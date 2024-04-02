import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int maxHp=0;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int atk = Integer.parseInt(str[1]);
        long curHp = 0;
        long curMin =0;
        board = new int[n][3];

        for(int i=0 ;i<n; i++){
            String[] tmp = br.readLine().split(" ");
            board[i][0] = Integer.parseInt(tmp[0]);
            board[i][1] = Integer.parseInt(tmp[1]);
            board[i][2] = Integer.parseInt(tmp[2]);
        }

        for(int i=0 ;i<n; i++){
            if(board[i][0]==1){
                int times = board[i][2]/atk;
                if(board[i][2]%atk==0) {
                    times--;
                }
                curHp-= (long) board[i][1] *times;
                curMin= Math.min(curHp,curMin);
            }else{
                curHp+=Math.min(board[i][2], Math.abs(curHp));
                atk+=board[i][1];
            }
        }
        System.out.println(Math.abs(curMin)+1);
    }
}