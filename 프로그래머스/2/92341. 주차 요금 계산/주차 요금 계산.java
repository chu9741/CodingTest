import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int len = records.length;
        String[] time = new String[records.length];
        String[] carNum = new String[records.length];
        String[] inOuts = new String[records.length];
        
        for(int i=0; i<len; i++){
            time[i] = records[i].substring(0,5);
            carNum[i] = records[i].substring(6,10);
            inOuts[i] = records[i].substring(11);
        }
        
        HashMap<String, String[]> carInOuts = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        for(int i=0; i<len; i++){
            if(inOuts[i].equals("IN")){
                // IN이면 입차시간 넣기
                if(carInOuts.containsKey(carNum[i])){
                    String[] tmp = carInOuts.get(carNum[i]);
                    tmp[0]=time[i];
                    carInOuts.put(carNum[i],tmp);
                }
                else{
                    list.add(carNum[i]);
                    carInOuts.put(carNum[i],new String[]{time[i],"0"});
                }
            }
            else{
                // OUT이면 시간 계산
                String[] in = carInOuts.get(carNum[i]);
                // System.out.println(in[0]+"/"+in[1]);
                
                in[1]=addTime(in,time[i]);
                in[0]="99:99";
                // System.out.println(carNum[i]+"시간 : "+in[1]);
                carInOuts.put(carNum[i],in);
                
            }
    
        }
        
        int[] answer = new int[carInOuts.size()];
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            String[] inOut = carInOuts.get(list.get(i));
            // System.out.println(list.get(i)+" 입차"+inOut[0]+"sum= "+inOut[1]); 
            if(!inOut[0].equals("99:99")){
                inOut[1] = addTime(inOut,"23:59");
            }
            //기본시간, 기본요금, 단위시간, 단위요금 = fee
            int remainTime = Integer.parseInt(inOut[1])-fees[0];
            
            answer[i]=fees[1];
            if(remainTime>0){
                int cnt = (int)Math.ceil((double)remainTime/(double)fees[2]);
                answer[i]+=fees[3]*cnt;
            }
        }
        
        return answer;
    }
    
    String addTime(String[] in, String time){
        int outHour = Integer.parseInt(time.substring(0,2));
        int outMin = Integer.parseInt(time.substring(3));

        int inHour = Integer.parseInt(in[0].substring(0,2));
        int inMin = Integer.parseInt(in[0].substring(3));

        // 주차시간(분)
        int sum = Integer.parseInt(in[1])+(outHour-inHour)*60 + (outMin-inMin);
        return String.valueOf(sum);
    }
}