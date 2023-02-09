package Inflearn_Java_Algorithm.Ch8_DFS_BFS.q12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int cnt = 0;
    static int[][] arr;
    static boolean[][] isVisited;

    public void BFS(int n, int m, int[][] arr) {
        Point root = new Point(1, 1);
        ArrayList<Integer> realTomatoList = new ArrayList<>();
        Queue<Point> indexQueue = new LinkedList<>();

        int totalEmpty = 0;
        for(int a=1;a<=n;a++){
            for(int b=1;b<=m;b++){
                if(arr[a][b]==-1)
                    totalEmpty++;
            }
        }

        while (true) {
            int totalRealTomato=0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (arr[i][j] == 1) {
                        totalRealTomato++;
                        if(!isVisited[i][j])
                            indexQueue.offer(new Point(i, j));
                    }
                }
            }
            realTomatoList.add(totalRealTomato);

            if (realTomatoList.size() >= 2 &&
                    (Objects.equals(realTomatoList.get(realTomatoList.size() - 1), realTomatoList.get(realTomatoList.size() - 2)))) {
                cnt = -1;
                break;
            }

            int totalTomato = n * m - totalEmpty;

            if (totalTomato == totalRealTomato)
                break;

            while (!indexQueue.isEmpty()) {
                Point index = indexQueue.poll();
                change(index.x, index.y);
                isVisited[index.x][index.y]=true;
            }
            cnt++;
        }
    }

    public void change(int x, int y) {
        if (arr[x - 1][y] != -1)
            arr[x - 1][y] = 1;
        if (arr[x][y - 1] != -1)
            arr[x][y - 1] = 1;
        if (arr[x][y + 1] != -1)
            arr[x][y + 1] = 1;
        if (arr[x + 1][y] != -1)
            arr[x + 1][y] = 1;
    }


    public static void main(String[] args) throws Exception {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n + 2][m + 2];

        for (int a = 0; a < n + 2; a++)
            arr[a][0] = arr[a][m + 1] = -1;
        for (int b = 0; b < m + 2; b++)
            arr[0][b] = arr[n + 1][b] = -1;

        for (int i = 1; i <= n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        isVisited = new boolean[n+2][m+2];

        main.BFS(n, m, arr);

        if (cnt == 0)
            System.out.println(0);
        else System.out.println(cnt);
    }
}