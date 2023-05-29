import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
    static int N;
    static TreeMap<String,Integer> list = new TreeMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String input = br.readLine();
            list.put(input, list.getOrDefault(input, 0) + 1);
        }
        int max = -1;
        String res = "";
        for(String key : list.keySet()){
            if(max < list.get(key)) {
                max = list.get(key);
                res = key;
            }
        }
        System.out.println(res);
    }
}
