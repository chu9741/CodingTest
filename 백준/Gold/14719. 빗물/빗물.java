
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 세로 ,가로

        String[] temp = br.readLine().split(" ");

        int h, w = 0;
        h = Integer.parseInt(temp[0]);
        w = Integer.parseInt(temp[1]);

        String[] table = br.readLine().split((" "));

        int count = 0;
        // 바닥부터 긁으면서 올라가기
        for (int i = 0; i < h; i++) {
            int cnt = 0;
            boolean isOpen = false;

            for (int j = 0; j < w; j++) {
                // 블록이 현재높이에 있거나 높은 경우
                if (Integer.parseInt(table[j]) > i) {
                    // flag가 막혀 있을때
                    if (!isOpen) {
                        isOpen = true;
                    }
                    // Open되어있을때
                    else {
                        // isOpen=false;
                        count += cnt;
                        cnt = 0;
                        // System.out.println(count);
                    }

                }
                // 블록이 현재 높이보다 낮은 경우
                else {
                    if (isOpen) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
