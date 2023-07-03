import java.util.*;

class House{
    int d;
    int p;
    public House(int d, int p){
        this.d=d;
        this.p=p;
    }
}


class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        ArrayList<House> houses = new ArrayList<>();
        House[] houseArr = new House[n];
        
        // for(int i=0; i<n; i++){
        //     houses.add(new House(deliveries[i],pickups[i]));
        //     House temp = new House(deliveries[i],pickups[i]);
        //     houseArr[i] = temp;
        // }
        
        // 끝집부터 cap이 될때 까지 일단 d,p가 있을때 d가 있으면 cap을 줄이고 p가 있으면 어떡하지,, 
        // 둘다 확인하고 만약에 decap이나 picap이 0보다 클때 까지 수용가능
        Iterator<House> iter = houses.iterator();
        int d=0;
        int p=0;
        
        for(int i=n-1; i>=0; i--){
            
            int cnt=0;
            
            d-=deliveries[i];
            p-=pickups[i];
            
            while(d<0 || p<0){
                d+=cap;
                p+=cap;
                cnt++;
                
            }
            answer+=(i+1)*2*cnt;
        }
        
        // answer=sum;
        return answer;
    }
}