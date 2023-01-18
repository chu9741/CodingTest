import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int lines = Integer.parseInt(br.readLine());
        int[][] area = new int[lines][lines];
        for(int i=0; i<lines; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<lines; j++)
                area[i][j] = Integer.parseInt(st.nextToken());
        }


    }
}