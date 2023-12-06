import java.util.*;
class Solution {
    
    int max=0;
    
    public int solution(int[] cards) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<cards.length; i++){
            // System.out.println("--");
            // isVisited[i]=1;
            // DFS(isVisited,cards,i,false);
            int[] isVisited = new int[cards.length];
            boolean flag=false;
            while(true){                
                isVisited[i]=1;
                if(isVisited[cards[i]-1]==0){
                    i=cards[i]-1;
                }else{
                    for(int j=0; j<cards.length; j++){
                        if(isVisited[j]==0){
                            int[] tmp = copy(isVisited);
                            second(tmp,cards,j);
                            max=Math.max(result(tmp),max);
                        }                   
                    }
                    break;
                }
            }
            // max=Math.max(max,result(isVisited));
        }
        
        return max;
    }
    
    void second(int[] isVisited, int[] cards, int i){
        while(true){
            isVisited[i]=2;
            if(isVisited[cards[i]-1]==0){
                i=cards[i]-1;
            }else{
                break;
            }
        }
        // return isVisited;
    }
    
    void print(int[] isVisited){
        for(int i: isVisited){
            System.out.print(i);
        }
        System.out.println();
    }
    
    int[] copy(int[] isVisited){
        int[] tmp=new int[isVisited.length];
        for(int i=0; i<isVisited.length; i++){
            tmp[i]=isVisited[i];
        }
        return tmp;
    }
    
    //[8,6,3,7,2,5,1,4]
    // 1,2,3,4,5,6,7,8
    void DFS(int[] isVisited, int[] cards, int x, boolean flag){
        System.out.println(isVisited[x]+" "+x+"//");
        if(!flag){
            isVisited[x]=1;
            if(isVisited[cards[x]-1]==0){
                DFS(isVisited,cards,cards[x]-1, flag);
            }
            else{
                for(int i=0; i<cards.length; i++){
                    if(isVisited[i]==0){
                        // System.out.println(i+"dd ");
                        DFS(isVisited,cards,cards[i]-1, true);
                    }
                }
            }
        }
        else{
            isVisited[x]=2;
            if(isVisited[cards[x]-1]==0){
                DFS(isVisited,cards,cards[x]-1, flag);
            }else{
                max=Math.max(max,result(isVisited));
                

            }
        }
    }
    
    int result(int[] isVisited){
        int one=0;
        int two=0;
        for(int v : isVisited){
            if(v==1){
                one++;
                // System.out.print("#");
            }else if(v==2){
                two++;
                // System.out.print("@");
            }else{
                // System.out.print("!");
            }
        }
        // System.out.println(one+" "+two);
        return one*two;
    }
   
}