class Solution {
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        // 양의정수 a 중 가장 큰 값, 
        // A를 1부터 돌면서 둘 중의 min값까지 수를 올리면서 TempA를 찾아서 B에 대입 -> 성공 시 A출력
        // 1억 * 50만 = 
        int n = arrayA.length;
        int oper=1;
        while(true){
            // !Sort가 안되어있을수 있음
            boolean isDividedA=false;
            boolean isDividedB=false; 
            oper++;
            if(arrayA[0]<oper && arrayB[0]<oper){
                break;
            }
            if((arrayA[0]/oper)*oper == arrayA[0]){
                isDividedA=true;
            }
            if((arrayB[0]/oper)*oper == arrayB[0]){
                isDividedB=true;
            }
            if(isDividedA==isDividedB){
                continue;
            }
            if(isDividedA){
                boolean flag = true;
                for(int i=1; i<n; i++){
                    if((arrayA[i]/oper)*oper != arrayA[i] || (arrayB[i]/oper)*oper==arrayB[i]){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    answer=oper;
                }
            }
            
            if(isDividedB){
                boolean flag = true;

                for(int i=1; i<n; i++){
                    if((arrayB[i]/oper)*oper != arrayB[i] || (arrayA[i]/oper)*oper==arrayA[i]){
                        flag=false;
                        break;
                    }
                }           
                if(flag){
                    answer=oper;
                }
            }
        }
        
        return answer;
    }
}