import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int [][]HoleX = new int[11][2];
	static int [][]HoleY = new int[11][2];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			int [][]arr = new int[N+2][N+2];
			HoleX[6][0]=-1;
			HoleX[7][0]=-1;
			HoleX[8][0]=-1;
			HoleX[9][0]=-1;
			HoleX[10][0]=-1;
			for(int i =1; i<= N;i++) {
				StringTokenizer st =new StringTokenizer(br.readLine());
				for(int j =1; j<= N; j++) {
					int x = Integer.parseInt(st.nextToken());
					if(x>5) {
						if(HoleX[x][0]==-1) {
							HoleX[x][0]= i;
							HoleY[x][0]=j;
						}else {
							HoleX[x][1]=i;
							HoleY[x][1]=j;
						}
					}
					arr[i][j]=x;
				}
			}
			for(int i =0; i< N+2 ;i++) {
				arr[0][i] = 5;
				arr[N+1][i]  =5;
				arr[i][0] = 5;
				arr[i][N+1] = 5;
			}
			int []dj = {0,0,1,-1};
			int []di = {-1,1,0,0};
			//	0:상하좌우     1: 하,좌,우,상 2:좌,상,우,하 3:우,상,하,좌 4:하,우,상,좌  5:하,상,우,좌
			int [][]dir = new int[][] {{0,1,2,3},{1,2,3,0},{2,0,3,1},{3,0,1,2},{1,3,0,2},{1,0,3,2}};
			int ans = 0;
			int[][][] point = new int[N][N][4]; // 요기까지의 점수를 넣자
			for(int I =1 ;I<= N; I++) {
				for(int J =1; J<= N; J++) {
					if(arr[I][J]!=0)continue;
					for(int D = 0 ; D<4; D++) {
						//System.out.println(I+","+J+","+D+"로 시작");
						int p = 0; 
						int i = I;
						int j = J;
						int d = D;
						//boolean[][] v = new boolean[N+2][N+2];
						//v[i][j]= true;
						i+=di[d];j+=dj[d];
						while(!(i==I && j==J) && arr[i][j]!=-1) {
							int b = arr[i][j]; // 현재 블록 적힌거 
							if(b>5) {
								if(i!=HoleX[b][0])i=HoleX[b][0];
								else i=HoleX[b][1];
								if(j!=HoleY[b][0])j = HoleY[b][0];
								else j = HoleY[b][1];
								i+=di[d];j+=dj[d];
								//System.out.println("현재위치 블랙홀:"+i+","+j+"포인트 :"+p);
							}else {
								if(b!=0)p++;//블록이라면 더해주고
								if(b!=0) {
								//System.out.println("현재위치:"+i+","+j+"포인트 :"+p);
								}
								d = dir[b][d]; // 바뀔 방향 
								i+=di[d]; j+=dj[d]; // 방향에 따르기
							}
						}
						ans = p>ans?p:ans;
						//System.out.println("앤써 "+p);
					}
				}
			}
			sb.append('#').append(tc).append(" ").append(ans).append('\n');
			
		}
		System.out.println(sb);// |\  |/   \|  /|  | | 
	}
}