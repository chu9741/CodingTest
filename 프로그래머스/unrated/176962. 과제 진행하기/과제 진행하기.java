import java.util.*;

class HW implements Comparable<HW>{
    String sub;
    int[] startTime = new int[2];
    int playtime;
    
    public HW(String sub, String startTime, String playtime){
        this.sub=sub;        
        String[] time=startTime.split(":");
        this.startTime[0]=Integer.parseInt(time[0]);
        this.startTime[1]=Integer.parseInt(time[1]);
        this.playtime=Integer.parseInt(playtime);
    }
    
    @Override
    public int compareTo(HW h){
        if(this.startTime[0]==h.startTime[0]){
            return this.startTime[1]-h.startTime[1];
        }
        return this.startTime[0]-h.startTime[0];
    }
}

class Solution {
    ArrayList<String> result;
    
    public ArrayList<String> solution(String[][] plans) {
        String[] answer = {};
        int n=plans.length;
        result = new ArrayList<>(); // 결과 값
        PriorityQueue<HW> hwQueue = new PriorityQueue<>(); // 처음 과제 리스트
        Stack<HW> stack = new Stack<>(); // 시간 초과 될 때 넣어놓는 과제
        for(int i=0; i<n; i++){
            hwQueue.add(new HW(plans[i][0], plans[i][1], plans[i][2]));
        }
        int size=hwQueue.size();
        
        for(int j=0; j<size; j++ ){
            HW tmp = hwQueue.poll(); // 과제를 꺼낸다.
            // System.out.print(tmp.sub+" ");
            if(j==size-1){ // queue의 마지막이라면 시간제한 상관 없으므로 그냥 result에 넣음
                result.add(tmp.sub);
            }
            else{
                HW nextHW = hwQueue.peek();
                
                int remainMinute = (nextHW.startTime[0]-tmp.startTime[0])*60+nextHW.startTime[1]-tmp.startTime[1];
                
                
                if(remainMinute<tmp.playtime){ // 시간 초과했을 떄
                    tmp.playtime-=remainMinute;
                    stack.push(tmp);
                }
                else{
                    remainMinute-=tmp.playtime;
                    result.add(tmp.sub);
                    solve(stack, remainMinute); 
                    // tmp.startTime은 이미 playtime이 더해짐
                }
            }
        }
        while(!stack.isEmpty()){
            result.add(stack.pop().sub);
        }
        
        return result;
    }
    
    
    public void solve(Stack<HW> stack, int remainMinute){
        
        while(!stack.isEmpty()){
            HW hw = stack.pop();
            if(hw.playtime <= remainMinute){
                remainMinute-=hw.playtime;
                result.add(hw.sub);
            }
            else {
                hw.playtime-=remainMinute;
                stack.push(hw);
                break;
            }
        }
        
    }
}