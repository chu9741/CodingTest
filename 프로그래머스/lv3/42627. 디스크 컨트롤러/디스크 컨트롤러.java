import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        Arrays.sort(jobs, new Comparator<int[]>(){
            @Override
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0]==arr2[0]){
                    return arr1[1]-arr2[1];
                }
                return arr1[0]-arr2[0];
            }
        });

        return method(jobs);
    }

    public int method(int[][] jobs){
        int count=0;
        int idx=1;
        int end=0;
        int sum=0;
        int len = jobs.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] arr1, int[] arr2){
                return arr1[1]-arr2[1];
            }
        });
        
        pq.offer(jobs[0]);
        end=jobs[0][0];
        
        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            end+=tmp[1];
            sum+=end-tmp[0];
            // System.out.println(sum);
            
            while(idx<len && jobs[idx][0] <= end){ //job이 하나 수행될때 그 사이에 들어갈 수 있는 job을 pq에 추가
                pq.offer(jobs[idx++]);
            }
            
            if(idx<len && pq.isEmpty()){ // end보다 작업요청시점이 더 클때 
                end=jobs[idx][0]; // 작업 끝나는 시간을 jobs[idx]의 작업요청시점으로 설정
                pq.offer(jobs[idx++]);
            }  
        }
        return sum/jobs.length;
    }
}