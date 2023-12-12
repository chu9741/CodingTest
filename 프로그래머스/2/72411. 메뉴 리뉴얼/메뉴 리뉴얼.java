    import java.util.*;
    class Node implements Comparable<Node>{
        String str;
        int cnt;

        public Node(String s, int c){
            this.str=s;
            this.cnt=c;
        }

        @Override
        public int compareTo(Node node){
            return node.cnt-this.cnt;
        }
    }

    class Solution {
        
        Map<String,Integer> map = new HashMap<>();

        public String[] solution(String[] orders, int[] course) {
            ArrayList<String> answer = new ArrayList<>();
            // String[] tmp= new String[n];
            //사전 순으로 오름차순 정렬해
            // answer.toArray();

            for(int i=0; i<course.length; i++){

                ArrayList<String> res = combi(orders,course[i]);
                // System.out.println(res.size());
                for(String r : res){
                    // System.out.println(r+"=====================");
                    answer.add(r);
                }
            }
            // course보고 조합을 짜야함? 
            Collections.sort(answer);
            return answer.toArray(new String[answer.size()]);
        }

        ArrayList<String> combi(String[] orders, int c){
            //맵을 통해서 값은 나눠서 넣고? -> 개수를 찾아서 밸류에 넣고 키셋으로 돌면서 가장 큰 값을 찾는데 같은 값이 
            ArrayList<String> result = new ArrayList<>();
            ArrayList<Node> nodes = new ArrayList<>();
            for(String order : orders){
                char[] tmp = order.toCharArray();
                Arrays.sort(tmp);
                order=new String(tmp);
                boolean[] isVisited = new boolean[order.length()];
                StringBuilder sb = new StringBuilder();
                DFS(order,c,sb,isVisited,0);

                
            }
            for(String str : map.keySet()){
                    // result.add(str);
                    //Node가 들어가야함
                    // System.out.println(str+" "+map.get(str));
                    nodes.add(new Node(str,map.get(str)));
            }
            Collections.sort(nodes);
            for(int i=0; i<nodes.size(); i++){
                // System.out.println("DDDDDDDDDDD"+nodes.get(0).cnt);
                
                if(nodes.get(0).cnt==nodes.get(i).cnt && nodes.get(i).cnt>1){
                    result.add(nodes.get(i).str);
                    // System.out.println("// "+nodes.get(i).cnt+" "+nodes.get(i).str);
                }
            }
            map.clear();
            // System.out.println(map.size()+"@@@"+result.size()+"/"+nodes.size());
            
            return result;   
        }

        void DFS(String order ,int c, StringBuilder sb, boolean[] isVisited, int k){
            
            if(sb.length()==c){
                map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
                // System.out.println(sb.toString());
            }
            else{
                for(int i=k; i< order.length(); i++){
                    if(!isVisited[i]){
                        isVisited[i]=true;
                        sb.append(order.charAt(i));

                        DFS(order, c, sb, isVisited, i);
                        sb.deleteCharAt(sb.length()-1);
                        isVisited[i]=false;
                    }
                }
            }
        }
    }