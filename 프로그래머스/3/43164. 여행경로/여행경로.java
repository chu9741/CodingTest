class Solution {
    boolean[] isVisited;
    int count=0;
    String[] answer;
    public String[] solution(String[][] tickets) {
        answer = new String[tickets.length+1];
        for(int i=0; i<answer.length; i++){
            answer[i]="ZZZ";
        }
        isVisited = new boolean[tickets.length];
        // from  iCN -> isVisited,,, 
        // st1.compareTo(str2) < 0
        String[] result = new String[answer.length];
        result[0]="ICN";
        goTo("ICN",tickets,result,1);
        
        return answer;
    }
    // DFS로 할게요
    
    void goTo(String from, String[][] tickets, String[] result, int idx){
        if(idx==tickets.length+1){
            // 오름차순 비교
            for(int i=0; i<result.length; i++){
                if(answer[i].compareTo(result[i]) < 0){
                    break;
                }
                else if(answer[i].compareTo(result[i]) > 0){
                    // 전체 바꾸기
                    // System.out.println(i + " " + result[i] + " " + answer[i]);
                    update(result);
                    break;
                }
            }
        }
        else{
            for(int i=0; i<tickets.length; i++){
                if(tickets[i][0].equals(from) && !isVisited[i]){
                    isVisited[i]=true;
                    result[idx]=tickets[i][1];
                    goTo(tickets[i][1],tickets,result,idx+1);
                    isVisited[i]=false;
                }
            }
        }
    }
    
    void update(String[] result){
        for(int s=0; s<result.length; s++){
            answer[s]=result[s];
        }
    }
}