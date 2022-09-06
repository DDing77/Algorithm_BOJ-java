import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<Integer> list;

    static int getGCD(int a, int b) {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) list.add(Integer.parseInt(st.nextToken()));

        for (int i = 1; i < N; i++) {
            int gcd = getGCD(list.get(0), list.get(i));
            sb.append(list.get(0) / gcd).append('/').append(list.get(i) / gcd).append('\n');
        }

        System.out.print(sb);
    }
}
