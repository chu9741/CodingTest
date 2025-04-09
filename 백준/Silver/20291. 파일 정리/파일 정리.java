
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        // map.containsKey()

        for (int i = 0; i < n; i++) {
            String fileExtension = br.readLine().split("\\.")[1];
            if (map.containsKey(fileExtension)) {
                map.put(fileExtension, map.get((fileExtension)) + 1);
            } else {
                map.put(fileExtension, 1);
            }
        }

        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        for (String str : keys) {
            System.out.println(str + " " + map.get(str));
        }
    }
}
