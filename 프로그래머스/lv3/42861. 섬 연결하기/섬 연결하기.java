import java.util.*;

class Node implements Comparable<Node>{
    int vs;
    int ve;
    int cost;
    public Node(int vs, int ve, int cost){
        int tmp =Math.min(vs,ve);
        ve=Math.max(vs,ve);
        vs=tmp;
        
        this.vs=vs;
        this.ve=ve;
        this.cost=cost;
    }
    
    @Override
    public int compareTo(Node n){
        return this.cost-n.cost;
    }
}


class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        boolean[] isVisited = new boolean[n];
        ArrayList<Node> arrList = new ArrayList<>();
        
        int min=Integer.MAX_VALUE;
        int idx=0;
        for(int i=0; i<costs.length; i++){
            int[] c = costs[i];
            arrList.add(new Node(c[0],c[1],c[2]));
            
            
            if(c[2]<min){
                min=c[2];
                idx=i;
            }
        }
        
      
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(arrList.get(idx));
    
        arrList.remove(idx);
        
        while(!pq.isEmpty()){
            //겹치는 점을 isVisited에 넣고,, 
            //offer -> Not visit, vs,ve== tmp..vs,ve
           
            Node tmp = pq.poll();
            if(isVisited[tmp.vs] && isVisited[tmp.ve])
                continue;
            
            isVisited[tmp.vs]=true;
            isVisited[tmp.ve]=true;
            // System.out.print(tmp.vs+" "+tmp.ve+" "+tmp.cost+" / ");

            arrList.remove(tmp);
            
            for(Node node : arrList){
                if(node.vs==tmp.vs || node.vs==tmp.ve || node.ve==tmp.vs || node.ve==tmp.ve){
                    pq.offer(node);
                    // arrList.remove(node);
                }
            }  
            answer+=tmp.cost;
        }
        return answer;
    }
}