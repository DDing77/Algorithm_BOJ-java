import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] sorted;
    static HashMap<Integer, Integer> map  =new HashMap<>();
    static void solution(StringBuilder sb) {
        int rank = 0;
        for(int value : sorted) {
            if(!map.containsKey(value)) {
                map.put(value, rank);
                rank++;
            }
        }
        for(int key : arr) {
            sb.append(map.get(key)).append(' ');
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N= Integer.parseInt(br.readLine());
        arr = new int[N];
        sorted = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;
            sorted[i] = input;
        }
        Arrays.sort(sorted);
        solution(sb);
    }
}
