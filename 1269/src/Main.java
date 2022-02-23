import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int nA, nB;
    static Set<Integer> A = new HashSet<>();
    static Set<Integer> B = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nA = Integer.parseInt(st.nextToken());
        nB = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nA; i++) A.add(Integer.parseInt(st.nextToken()));

        int AtoB = 0;
        int BtoA = 0;

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < nB; i++) {
            int input = Integer.parseInt(st.nextToken());
            B.add(input);
            if (A.contains(input)) cnt++;
        }
        AtoB = A.size() - cnt;
        cnt = 0;

        for (int key : A) {
            if (B.contains(key)) cnt++;
        }
        BtoA = B.size() - cnt;

        int res = AtoB + BtoA;
        System.out.println(res);
    }
}
