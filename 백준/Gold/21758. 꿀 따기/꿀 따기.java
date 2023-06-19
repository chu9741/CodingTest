
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Main{
    static int max=0;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            arrayList.add(Integer.parseInt(st.nextToken()));
        }

        int size = arrayList.size();
        if(size>3){
            int sum=0;
            for(int i=2; i<size; i++){ // 정방향
                sum+=arrayList.get(i)+arrayList.get(i);
            }
            max=Math.max(max,sum);

            for(int j=2; j<size-1; j++){ // 정방향 + 두번째 벌
                sum+=arrayList.get(j-1);
                sum-=arrayList.get(j)+arrayList.get(j);
                max=Math.max(max,sum);
            }

            sum=0;
            for(int x=2; x<size-1; x++){ // 역방향
                sum+=arrayList.get(x);
            }
            sum+=arrayList.get(0)*2;
            max=Math.max(max,sum);

            for(int y=2; y<size-1; y++){ // 역방향 + 두번째 벌
                sum-=arrayList.get(y);
                sum+=arrayList.get(y-1)+arrayList.get(y-1);
                max=Math.max(max,sum);
            }
//            findMax(idxA,idxB,arrayList);
            findMiddle(arrayList);
            System.out.println(max);
        }
        else{
            System.out.println(arrayList.stream().mapToInt(a->a).max().getAsInt()*2);
        }
    }

    public static void findMiddle(ArrayList<Integer> arrayList){
        int maxNum=0;
        int sum=0;
        int idx=0;
        for (Integer integer : arrayList) {
            sum += integer;
            if (maxNum > integer) {
                maxNum = integer;
            }
        }
        if(sum+maxNum>max){
            max=sum+maxNum;
        }
    }
}

