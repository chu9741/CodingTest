class Solution {
    int[] answer = {0,0};
    
    
    public int[] solution(int[][] users, int[] emoticons) {
        // 가입자 늘리기 -> 판매액 늘리기 
        int n = users.length;
        int m = emoticons.length;
       
        //7개 -> 4개의 할인율,, 4의 7승의 경우의수 16000개의 경우의수,, 
        //다 적용한다 치자 그냥 일단은,, 
        int[] discount = {10,20,30,40};
        int[][] dcPriceAndDiscount = new int[m][2];
        int[] userBuy = new int[n];
        
        DFS(0,users,emoticons,discount,dcPriceAndDiscount);
        
        return answer;
    }
    
    
    public int dc(int price, int per){
        double percentage= ((100.0-per)/100.0);
        // System.out.print(percentage);
        return (int)Math.round(price*percentage);
    }
    
    int sum=0; 
    int max=0;
    
    
    public void comparePrice(int[] userBuy, int[][] u){
        
        int[] temp = {0,0};
        for(int i=0; i<u.length; i++){
            // System.out.print(userBuy[i]+", ");
            if(u[i][1]<=userBuy[i]){ // 멤버십보다 산게 더 많을 떄 
                temp[0]++; // 멤버십 추가
            }
            else{
                temp[1]+=userBuy[i]; // 돈으로 추가 
            }
        }
        // System.out.println(temp[0]+" "+temp[1]);
        if(temp[0]==answer[0]){
            if(temp[1]>answer[1]){
                answer[0]=temp[0];
                answer[1]=temp[1];
            }
        }
        else if(temp[0]>answer[0]){
            answer[0]=temp[0];
            answer[1]=temp[1];
        }
    }
    
    
    public void DFS(int L,int[][] u, int[] e, int[]discount, int[][] dcPriceAndDiscount){
        //L=emoticons까지 
        // 변화는 할인율,,, 10 20 30 40 
        if(L==e.length){ // 모든 이모티콘에 대해서 할인율을 적용했을 때 
            int[] userBuy = new int[u.length];
            for(int a=0; a<u.length; a++){
                for(int b=0; b<e.length; b++){ // 이모티콘에 대해서 
                    if(u[a][0]<=dcPriceAndDiscount[b][0]){  //유저의 할인 퍼센트보다 물건 할인이 클때
                        userBuy[a]+=dcPriceAndDiscount[b][1]; // 해당 유저의 구매금액에 더해줌
                        // System.out.println(dcPriceAndDiscount[b][0]+" "+dcPriceAndDiscount[b][1]+" "+b);
                    }
                }
            }
            // for(int[] d : dcPriceAndDiscount)
                // System.out.print(d[0]+" "+d[1]+" / ");
            // System.out.println();
            int[] temp = {0,0};
            comparePrice(userBuy, u);
            
        }
        else{
            for(int i=0; i<discount.length; i++){
                int dcPrice=dc(e[L],discount[i]);
                dcPriceAndDiscount[L][0] = discount[i];
                dcPriceAndDiscount[L][1] = dcPrice;
                DFS(L+1,u,e,discount,dcPriceAndDiscount);    
            }
        }
    }
}