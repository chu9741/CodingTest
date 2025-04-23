import java.util.*;

class Solution {
    static Set<List<Integer>> set = new HashSet<>();

    public int solution(String dirs) {
        int answer = 0;
        int curX=0, curY=0;
        char[] way = dirs.toCharArray();
        for(int i=0; i<way.length;i++){
            int nX = curX;
            int nY = curY;
            switch(way[i]){
                case 'R':
                    curX= Math.min(5,curX+1);
                    break;
                case 'D':
                    curY=Math.max(-5,curY-1);
                    break;
                case 'U' :
                    curY=Math.min(5,curY+1);
                    break;
                case 'L':
                    curX=Math.max(-5,curX-1);
                    break;
            }
            if(curY==nY && curX == nX) continue;
            set.add(Arrays.asList(curX, curY, nX, nY));
            set.add(Arrays.asList(nX, nY, curX, curY));
        }
        
//         for(int[] s : set){
//             System.out.println(s[0]+"/"+s[1]+"/"+s[2]+"/"+s[3]+"/");
//         }
        
        answer = set.size()/2;
        return answer;
    }
}