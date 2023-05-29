import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

// author : DDing
// solution : 해쉬, 트리

public class Main {
    static int N;
    static TreeMap<String, Integer> list = new TreeMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            String input = br.readLine();
//            String[] input = br.readLine().split("\\.");
//            list.put(input[1], list.getOrDefault(list[1], 0) + 1);
            String extension = input.substring(input.indexOf(".")+ 1);
            list.put(extension, list.getOrDefault(extension, 0) + 1);
        }
        for(String key : list.keySet()) {
            sb.append(key).append(" ").append(list.get(key)).append('\n');
        }
        System.out.print(sb);
    }
}
