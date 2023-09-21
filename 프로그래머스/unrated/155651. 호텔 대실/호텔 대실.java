    import java.util.*;

    class Solution {
        public int solution(String[][] book_time) {
            int room = 0;

            Arrays.sort(book_time,(o1,o2) -> {
                int intO1 = Integer.parseInt(o1[0].substring(0,2));
                int intO2 = Integer.parseInt(o2[0].substring(0,2));
                // System.out.println(intO1+" "+intO2);

                if(intO1 < intO2) return -1;
                else if(intO1 > intO2) return 1;

                int min1 = Integer.parseInt(o1[0].substring(3,5));
                int min2 = Integer.parseInt(o2[0].substring(3,5));

                if(min1 < min2) return -1; 
                if(min1 > min2) return 1;
                return 0;
            });

            // Arrays.stream(book_time).forEach(o1-> System.out.println(o1[0]+o1[1]));
            ArrayList<String> endTime = new ArrayList<>();
            for(String[] time : book_time){
                if(room==0){
                    room++;
                    endTime.add(time[1]);
                    continue;
                }

                String idx="";

                // 종료시간 재기
                for(String end : endTime){
                    if(compareAdd10Min(end,time[0]) <= 0){
                        // System.out.println(end+time[0]);
                        idx=end;
                        break;
                    }
                }
                if(idx.isEmpty()){
                    room++;
                }
                else{
                    endTime.remove(idx);
                }
                endTime.add(time[1]);
            }
            return room;  
        }

        public int compareAdd10Min(String tmp1, String tmp2){
            String[] partTime = tmp1.split(":");
            int hour = Integer.parseInt(partTime[0]);
            int minute = Integer.parseInt(partTime[1])+10;
        
            if(minute>=60){
                hour+=1;
                minute-=60;
            }
            
            String newTmp1= String.format("%02d:%02d",hour,minute);
            
            return newTmp1.compareTo(tmp2);
        }
    }