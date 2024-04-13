import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        int tmp = k;
        List<int[]> list = new ArrayList<>();
        List<Double> sumList = new ArrayList<>();
        
        int n=0;
        list.add(new int[]{n,tmp});
        while(tmp!=1){
            int prev = tmp;
            if(tmp%2==0){
                tmp/=2;
                list.add(new int[]{++n,tmp});
            }else{
                tmp=tmp*3+1;
                list.add(new int[]{++n,tmp});
            }
            sumList.add((double)Math.abs(prev-tmp)/2 + Math.min(prev,tmp));
        }
        // System.out.println(n+"###"+sumList.size());
        for(int i=0; i<ranges.length; i++){
            int a = ranges[i][0];
            int b = ranges[i][1];
            if(a>n+b){
                answer[i]=-1;
                continue;
            }
            int max=0;
            for(int j=a; j<n+b; j++){
                // max=Math.max(list.get(i)[1],max);
                answer[i]+=sumList.get(j);
                // System.out.println(sumList.get(j));
            }
            
            // double sq = (double)(n+b-a)*(double)max/2;
            // System.out.println(max+" "+sq);
            // answer[Arrays.asList(ranges).indexOf(range)] = sq;
            // 정적분,, 
        }
        return answer;
    }
}