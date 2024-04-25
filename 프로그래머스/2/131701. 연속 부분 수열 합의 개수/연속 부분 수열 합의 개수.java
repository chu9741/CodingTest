import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int len = elements.length;
        Set<Integer> set = new HashSet<>();
        // 길이가 i인 수열 계산
        for(int i=0; i<len; i++){
            // 길이가 i인 j부터 시작하는 배열
            for(int j=0; j<i+len; j++){
                int sum=0;
                for(int k=j; k<j+i; k++){
                    sum+=elements[k%len];
                }
                set.add(sum);
            }
        }
        answer=set.size();
        // 0123456789
        // 0123401234
        return answer;
    }
}