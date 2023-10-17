
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int res =2;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        Main m = new Main();
        m.method(n);

    }
    public void method(int n){
        while(res<Math.pow(10,n) && res!=1) {
            if (checkPrime(n)) {
                if (res >= Math.pow(10, n - 1) && res <= Math.pow(10, n)) {
                    System.out.println(res);
                    res++;
//                    return;
                } else {
                    res *= 10;
                    res++;
                }
            } else {
                if(isDivededBy10(n)==0){
                    res++;
                }
                else{
                    res/=Math.pow(10,isDivededBy10(n));
                }
//                method(n);
            }
        }
    }

    private int isDivededBy10(int n) {
        for(int i=n-1; i>0; i--){
            if(res%Math.pow(10,i)==0){
               return i;
            }
        }
        return 0;
    }

    public boolean checkPrime(int n){
        int tmp=res;
        while(tmp>0){
            if(tmp==2){
                return true;
            }
            if(tmp==1){
                return false;
            }
            int nSq = (int) Math.sqrt(tmp);
            for(int j=2; j<=nSq; j++){
                if(tmp%j==0){

                    return false;
                }
            }
            tmp/=10;
        }
        return true;
    }
}    