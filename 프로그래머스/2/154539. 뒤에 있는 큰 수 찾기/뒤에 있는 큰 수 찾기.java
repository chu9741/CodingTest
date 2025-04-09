class Solution {
    public int[] solution(int[] numbers) {
        
        int n = numbers.length;         
        int[] answer = new int[n];
        int max=1000001;
        for(int i=n-1; i>=0; i--){
            boolean flag=false;
            for(int j=i; j<n; j++){
                int temp= answer[j];
                if(temp==-1){
                    if(numbers[i]<numbers[j]){
                        answer[i]=numbers[j];
                        flag=true;
                        break;
                    }
                    else{
                        answer[i]=-1;
                        flag=true;
                        break;
                    }
                }
                else if(numbers[i]<temp){
                    if(numbers[i]<numbers[j]){
                        answer[i]=numbers[j];
                    }else{
                        answer[i]=temp;
                    }
                    flag=true;
                    break;
                }
            }
            if(!flag){
                answer[i]=-1;
            }
        }
        return answer;
    }
}