import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int sum=0;
        int count=0;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<number.length; i++){
            sum+=number[i];
            map.put(want[i],number[i]);            
        }
        
        for(int i=0; i<10; i++){
            int dc = map.getOrDefault(discount[i],11);
            if(dc!=11){
                map.put(discount[i],map.get(discount[i])-1);
                if(dc>0){
                    sum=Math.max(sum-1,0);
                }
            }
        }
        
        if(sum==0) count++;
        for(int i=10; i<discount.length; i++){
            int pushDiscount = map.getOrDefault(discount[i-10],200000);
            if(pushDiscount!=200000){
                int tmp = map.get(discount[i-10]);
                map.put(discount[i-10],tmp+1);
                if(tmp>=0){
                    sum++;
                    // System.out.println(i+" "+sum+" ###");

                } 
                // System.out.println(tmp+"  "+discount[i-10]+"@@@@");

            }
            int popDiscount=map.getOrDefault(discount[i],200000);
            if(popDiscount!=200000){
                int tmp = map.get(discount[i]);
                map.put(discount[i],tmp-1);
                if(tmp>0){
                    sum--;
                    // System.out.println(i+" "+sum);
                } 
                // System.out.println(tmp+"  "+discount[i]+"@@");
            }
            if(sum==0) count++;
        }
            
        answer=count;
        // sliding window 
        return answer;
    }
}