import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        //어떤 번호가 다른 번호의 접두어인 경우,,, 
        
        // int cnt=0;
        Arrays.sort(phone_book);
    //     Arrays.sort(phone_book, new Comparator<String>() {
    // @Override
    // public int compare(String o1, String o2) {
    //     return o1.length()-o2.length();            // 내림차순으로 정렬
    // }}); // 왜 sort?
        
        for(int i=0; i<phone_book.length-1; i++){
            int cnt=0;
            int ilen = phone_book[i].length();
            int j=i+1;
                int jlen=phone_book[j].length();
                // System.out.println(phone_book[j]);

                if(ilen<=jlen){
                    if(phone_book[i].equals(phone_book[j].substring(0,ilen))){
                        return false;
                    
                }
                    // if(Integer.parseInt(phone_book[i])<Integer.parseInt(phone_book[j].substring(0,ilen))){
                    //     break;
                    // }
                }                
            
        }
        // if(phone_book)
        
        
        
        return answer;
    }
}