class Solution {
    
    int count=Integer.MAX_VALUE;
    boolean[] isVisited=new boolean[50];
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        String[] beginArr = begin.split("");
        String[] targetArr = target.split("");
        
        // words에 있는 단어들중 바꿀수 있으면 cnt올리고 DFS다시 돌린다. cnt==1
        // 그렇게 해서 target이랑 맞추면된다. 안되면 뭐 다시 되돌려서 돌리기,,,
        
        DFS(beginArr,targetArr,words,0);
        
        if(count==Integer.MAX_VALUE)
            return 0;

        return count;
    }
            
    public void DFS(String[] beginArr, String[] targetArr, String[] words, int cnt){
        int countLength=0; // beginArr와 taretArr의 길이를 세준다.
        
        for(int i=0;  i<beginArr.length; i++){
            if(beginArr[i].equals(targetArr[i])){
                countLength++;
            }
        }
        if(countLength==beginArr.length){
            count=Math.min(count, cnt);
            // begin이 target이랑 일치할 때
        }
        else{
            // 일치하지않을때
            // 한자리만 바꿔준다. 
            for(int j=0; j<words.length; j++){
                String[] tmpArr = words[j].split(""); // words의 하나를 가져와서 split해줌
                int tmpCnt=checkExistence(beginArr,tmpArr); // 두 arr가 서로 얼마나 다른지 확인
                if(tmpCnt==tmpArr.length-1 && !isVisited[j]){ // 한자리만 다르고 방문하지 않았을때
                    isVisited[j]=true;
                    DFS(tmpArr,targetArr,words,++cnt); // 여기서 cnt가 상승한다.
                    cnt--;
                    isVisited[j]=false;
                }
            }   
        }
    }
    
    public int checkExistence(String[] beginArr, String[] tmpArr){
        int count=0;
        
        for(int i=0; i<beginArr.length; i++){
            if(beginArr[i].equals(tmpArr[i]))
                count++;
        }
        return count;
    }
}