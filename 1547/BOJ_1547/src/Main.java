import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        for (int i = 1; i <= 3; i++) map.put(i, i);
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int target1 = Integer.parseInt(st.nextToken()); // 3
            int target2 = Integer.parseInt(st.nextToken()); // 1

            int target1Idx = map.get(target1); // 1
            int target2Idx = map.get(target2); // 3
            map.replace(target1, target2Idx);
            map.replace(target2, target1Idx);
        }

        for(int i=1; i<=3; i++) {
            if(map.get(i) == 1) System.out.println(i);
        }
    }
}