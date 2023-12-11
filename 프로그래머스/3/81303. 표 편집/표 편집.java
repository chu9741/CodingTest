import java.util.*;

class Solution {
    // int idx2;
    int move=0;
    Stack<Integer> stack2 = new Stack<>();
    public String solution(int n, int k, String[] cmd) {        
        StringBuilder sb = new StringBuilder();
        int[] cpy = new int[n];
        // int idx2=k;
        // idx2=k;
        for(int i=0; i<n; i++){
            cpy[i]=i+1;
            sb.append("O");
        }
        // int move=0;
        
        for(String c : cmd){
            // command2(cmd[i],n,cpy,sb);
            if(c.startsWith("U")){
            int cnt = Integer.parseInt(c.substring(2));
            move-=cnt;
            }
            else if(c.startsWith("D")){
                int cnt = Integer.parseInt(c.substring(2));
                move+=cnt;
            }
            else{
                //"D"가 더 클 때
                if(move>=0){
                    while(move!=0){
                        if(cpy[++k]>0){
                            move--;
                        }
                    }
                }
                //"U"가 더 클 때
                else{
                    while(move!=0){
                        if(cpy[--k]>0){
                            move++;
                        }
                    }
                }
            }

            if(c.equals("C")){
                stack2.push(cpy[k]);
                // set.add(cpy[idx2]);
                cpy[k]*=-1;
                boolean flag=false;
                sb.setCharAt(k,'X');
                int tmpIdx=k;
                // for(int i=tmpIdx+1; i<n; i++){
                //     if(cpy[i]>0){
                //         flag=true;
                //         idx2=i;
                //         break;
                //     }
                // }


                while(tmpIdx<n-1){
                    if(cpy[++tmpIdx]>0){
                        flag=true;
                        k=tmpIdx;
                        break;
                    }
                }

                while(k>0 && !flag){
                    if(cpy[--k]>0){
                        break;
                    }
                }
            }
            else if(c.equals("Z")){
                int tmp = stack2.pop();
                cpy[tmp-1]*=-1;
                sb.setCharAt(tmp-1,'O');
            }
        }
        
        return sb.toString();
    }
    
//     void command2(String cmd, int n, int[] cpy, StringBuilder sb){
        
//     }
}