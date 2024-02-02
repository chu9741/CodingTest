class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0,sequence.length};
        
        // 가장 길이가 짧은 수열 중에서 인덱스가 작은 수열을 찾는다
        // sliding window
        int start = 0;
        int end = 0;
        int sum =sequence[0];
        
        while(end<sequence.length){
            // System.out.println(start+" / "+end);
            
            if(sum>k){
                if(start==sequence.length-1) break;
                sum-=sequence[start++];
            }
            else if(sum<k){
                if(end==sequence.length-1) break;
                sum+=sequence[++end];
            }
            
            if(sum==k){
                // System.out.println(end + " " + start);
                if(answer[1]-answer[0] > end-start){
                    answer[0]=start;
                    answer[1]=end;
                }
                sum-=sequence[start++];
            }
            
        }
        
        return answer;
    }
}