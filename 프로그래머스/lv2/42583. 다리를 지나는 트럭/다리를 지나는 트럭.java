import java.util.*;
class Solution {
    
    Queue<int[]> queue = new LinkedList<>();

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int n = truck_weights.length;
        int idx=0;
        int time=0;
        int limit=0;
        
        // int[] firstTruck = {idx, 1};
        // queue.offer(firstTruck);
        // limit+=truck_weights[0];
        // time++;
        // idx++;
        while(!queue.isEmpty() || idx<n){
            if(idx==n){
                int size=queue.size();
                for(int s=0; s<size-1; s++){
                    queue.poll();
                }
                // int[] last= ;
                time+=bridge_length-queue.poll()[1]; 
            }
            else{
                if(limit+truck_weights[idx]<=weight){ // 다리에 올라갈 수 있을 떄
                    limit+=truck_weights[idx]; // 다리 무게 올림
                    addTime(); // queue에 모두 시간 올림
                    queue.offer(new int[]{idx,1}); // queue에 값 추가
                    // System.out.println();
                    time++; // 실제 시간 올림
                    idx++;
                    if(queue.peek()[1]>bridge_length){
                        limit-=truck_weights[queue.peek()[0]];
                        // System.out.println(queue.peek()[0]+"@@@");
                        queue.poll();
                    }
                    // System.out.println(idx+"E "+limit+" | "+time+" / ");
                }
                else{ // 다리에 올라갈 수 없을 때
                    int[] firstInQueue = queue.peek();
                    int restTime = bridge_length-firstInQueue[1]; // 다리 length까지 남은 시간
                    addTime(restTime); // 남은시간 더하기
                    limit-=truck_weights[queue.poll()[0]]; // 트럭무게만큼 limit빼기
                    time+=restTime; // 
                    // System.out.println(idx+"X "+limit+" | "+time+" / ");
                }
            }
            
        }  
        return time+1;
    }
    
    public void addTime(){
        int n=queue.size();
        for(int i=0; i<n; i++){
            int[] temp = queue.poll();
            queue.offer(new int[]{temp[0],++temp[1]});
        }
    }
    public void addTime(int restTime){
        int n=queue.size();
        for(int i=0; i<n; i++){
            int[] temp = queue.poll();
            queue.offer(new int[]{temp[0],temp[1]+restTime});
        }
    }
}