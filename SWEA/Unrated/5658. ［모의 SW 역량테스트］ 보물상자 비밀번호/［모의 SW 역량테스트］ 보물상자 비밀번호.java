
import java.util.ArrayList;
import java.util.HashSet;
/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution {
    public static void main(String args[]) throws Exception {
        /*
         * 아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
         * 여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
         * 이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
         * 따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
         * 단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
         */
        // System.setIn(new FileInputStream("res/input.txt"));

        /*
         * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
         */
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        // T=sc.nextInt();
        ArrayList<Integer> sumArr = new ArrayList<>();
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            String nums = br.readLine().trim();

            button(n, nums);
            sumArr.add(findK(k));
            set.clear();

        }
        for (int sum : sumArr) {

            System.out.println("#" + (sumArr.indexOf(sum) + 1) + " " + sum);
        }
    }

    static Set<String> set = new HashSet<String>();

    public static void button(int n, String str) {
        int len = n / 4; // 숫자 하나의 길이
        // 숫자의 길이만큼 회전해야됨 ,, 숫자가 7자리 숫자면 6번 회전
        char[] strToArr = str.toCharArray();
        char[] first = new char[len];
        char[] second = new char[len];
        char[] third = new char[len];
        char[] fourth = new char[len];

        for (int i = 0; i <= len; i++) { // set에 넣기
            // 숫자 하나는 len만큼의 길이를 갖는다
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder();
            for (int j = 0; j < len; j++) { // 숫자 넣어주기

                first[j] = strToArr[(n + j - i) % n]; // 0-> 11 / 1 -> 0 / 2 -> 1 / 3 -> 2. .... 012 -> 11,2,3
                second[j] = strToArr[(len * 1 + j - i) % n];
                third[j] = strToArr[(len * 2 + j - i) % n];
                fourth[j] = strToArr[(len * 3 + j - i) % n];
            }
            set.add(sb1.append(first).toString());
            set.add(sb2.append(second).toString());
            set.add(sb3.append(third).toString());
            set.add(sb4.append(fourth).toString());
        }
    }

    public static int findK(int k) {
        ArrayList<char[]> sortArr = new ArrayList<>();
        for (String str : set) {
            sortArr.add(str.toCharArray());
        }
        // 어떻게 정렬하지?
        int sum = 0;
        for (int i = 0; i < sortArr.size(); i++) {
            char[] tmp = sortArr.get(i);
            int idx = 0;
            for (int j = 0; j < sortArr.size(); j++) {
                if (compare(tmp, sortArr.get(j)) == -1) { // 뒤의 값이 크면 -1 -> tmp가 작으니까 idx가 밀림
                    idx++;
                }
            }

            if (idx == k - 1) {
                int len = tmp.length;
                for (int l = 0; l < len; l++) { 
                    if (tmp[l] == 'A') {
                        sum += Math.max(Math.pow(16, (len - 1 - l)) * 10, 10);
                    } else if (tmp[l] == 'B') {
                        sum += Math.max(Math.pow(16, (len - 1 - l)) * 11, 11);
                    } else if (tmp[l] == 'C') {
                        sum += Math.max(Math.pow(16, (len - 1 - l)) * 12, 12);
                    } else if (tmp[l] == 'D') {
                        sum += Math.max(Math.pow(16, (len - 1 - l)) * 13, 13);

                    } else if (tmp[l] == 'E') {
                        sum += Math.max(Math.pow(16, (len - 1 - l)) * 14, 14);
                    } else if (tmp[l] == 'F') {
                        sum += Math.max(Math.pow(16, (len - 1 - l)) * 15, 15);
                    } else {
                        sum += Math.max(Math.pow(16, (len - 1 - l)) * (tmp[l] - '0'), tmp[l] - '0');
                    }

                }
            }

        }
        return sum;
    }

    public static int compare(char[] tmp1, char[] tmp2) {
        for (int i = 0; i < tmp1.length; i++) {
            if (tmp1[i] < tmp2[i]) {
                return -1;
            } else if (tmp1[i] > tmp2[i]) {
                return 1;
            }

        }
        return 0;
    }

}