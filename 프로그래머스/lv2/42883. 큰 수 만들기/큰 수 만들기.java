import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int n=number.length();
        
        int idx=0;
        int cnt=0;
        StringBuilder sb=new StringBuilder();
        int[] arr = new int[n-k];
        int idxInt=Character.getNumericValue(number.charAt(0)); // 가장 큰 값 뽑아냄
        arr[0]=idxInt;
        
        for(int i=0; i<n-k; i++){ // n-k번 뽑기 위해 
            for(int j=idx+1; j<=k+i; j++){ // 특정 값부터 남은 길이만큼 총 문자열 길이가 n-k나올때까지 해야함
                int jInt = Character.getNumericValue(number.charAt(j));
                // System.out.print(jInt+","+idx+"/");
                // n-k만큼 길이의 String만들어야해  -> n-k
                if(jInt>idxInt){
                    idx=j; //가장 큰 값의 number idx
                    idxInt=jInt; // 가장 큰값 변경
                    arr[i]=idxInt; // 가장 큰값을 arr에 넣음 
                }
            }
            // System.out.println();
            if(idx-(i+1)>=k){ // idx위치의 값 앞에서 뽑은 숫자들을 제외한 개수가 k개보다 적어야함
                break;
            }
            idxInt=0; // 비교할 최대값 초기화
            // idx-i<k
            //0부터 max idx까지 < n-k -> idx부터 max idx까지 < n-k-1 .... k번 반복             
        }
        for(int b=0; b<n-k; b++){
            sb.append(String.valueOf(arr[b]));
        }
                
        return sb.toString();
    }
}