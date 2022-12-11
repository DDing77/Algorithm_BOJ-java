import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static List<Integer> numbers;
    static StringBuilder sb;

    static void bt(int depth, int[] res) {
        if (depth == M) {
            for (int i = 0; i < res.length; i++) {
                sb.append(res[i] + " ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < numbers.size(); i++) {
            res[depth] = numbers.get(i);
            bt(depth + 1, res);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) numbers.add(Integer.parseInt(st.nextToken()));

        Collections.sort(numbers);

        sb = new StringBuilder();

        bt(0, new int[M]);
        System.out.print(sb);

    }
}
