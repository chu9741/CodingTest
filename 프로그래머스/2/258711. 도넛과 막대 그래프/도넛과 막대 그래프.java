import java.util.*;

class Structure{
    int cnt;
    List<Integer> list = new ArrayList<>();
    
    public Structure(){}
}

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        List<Structure> strList = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        Map<Integer, int[]> map = new HashMap<>();
        for(int[] e : edges){
                int[] arr1 = map.getOrDefault(e[0],new int[2]);
                arr1[1]++;
                map.put(e[0],arr1);
                int[] arr2 = map.getOrDefault(e[1],new int[2]);
                arr2[0]++;
                map.put(e[1],arr2);

            // queue.offer(e);
        }
        
        //생성한 정점의 번호, 도넛 모양 그래프의 수, 막대 모양 그래프의 수, 8자 모양 그래프의 수
        int total =0;
        for(Integer i : map.keySet()){
            int[] tmp = map.get(i);
            if(tmp[0]==0 && tmp[1]>1){
                answer[0]=i;
                total=tmp[1];
            }
            else if(tmp[1]==0 && tmp[0]>0){
                answer[2]++;
            }
            else if(tmp[0]>1 && tmp[1]>1){
                answer[3]++;
            }
            // System.out.println(tmp[0]+"/"+tmp[1]);
        }
        answer[1]=total-answer[2]-answer[3];
        
        
        //donut = n -> n , n
        //stick = n -> n , n-1
        //eight = n -> 2n+1, 2n+2
        
        //기준에서 출발 -> 개수 세기 , 
        
        // int idx = edges[0][0];
        // answer[0]=idx;
        
        
        
        
//         while(!queue.isEmpty()){
//             int[] tmp = queue.poll();
//             boolean isAdded = false;
//             if(tmp[0] == idx){
//                 // STACK으로,,
//                 Structure newStr = new Structure();
//                 newStr.cnt=1;
//                 newStr.list.add(tmp[1]);
//                 strList.add(newStr);
//                 // 시작점
//             }
//             else{
//                 // try{
//                     for(Structure str : strList){
//                         if(str.list.contains(tmp[0])){
//                             if(!str.list.contains(tmp[1])){
//                                 str.cnt++;
//                             }
//                             str.list.add(tmp[1]);
//                             isAdded=true;
//                             break;
//                         }else if(str.list.contains(tmp[1])){
//                             if(!str.list.contains(tmp[0])){
//                                 str.cnt++;
//                             }
//                             str.list.add(tmp[0]);
//                             isAdded=true;
//                             break;
//                         }
//                     }
//                 if(!isAdded){
//                     queue.offer(tmp);
//                 }
//                     // Structure getStr = strList.stream().filter(str->str.list.contains(tmp[0])).findFirst().orElseThrow(()-> new IllegalArgumentException());
//                     // if(!getStr.list.contains(tmp[1])){
//                     //     getStr.cnt++;
//                     // }
//                     // getStr.list.add(tmp[1]);
//                 // }catch(IllegalArgumentException e){
//                 //     queue.offer(tmp);
//                 // }

//                 //[[4, 11], [1, 12], [8, 3], [12, 7], [4, 2], [7, 11], [4, 8], [9, 6], [10, 11], [6, 10], [3, 5], [11, 1], [5, 3], [11, 9], [3, 8]]
//             }
//         }
        
//         for(Structure str : strList){
//             if(str.cnt == str.list.size()){
//                 answer[2]++;
//             }
//             else if(str.cnt+1 == str.list.size()){
//                 answer[1]++;
//             }
//             else{
//                 answer[3]++;
//             }
//             // System.out.println(str.cnt+"/"+str.list.size());
            
//         }
        
    
        return answer;
    }
}