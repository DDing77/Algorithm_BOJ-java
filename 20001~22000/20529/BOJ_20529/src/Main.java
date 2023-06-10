import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int N;
    static String[] mbti;
    static int res;

    public static int getDiff(String mbti1, String mbti2) {
        int cnt = 0;

        for (int i = 0; i < mbti1.length(); i++) {
            if (mbti1.charAt(i) != mbti2.charAt(i)) {
                cnt++;
            }
        }

        return cnt;
    }

    public static int getSum(String mbti1, String mbti2, String mbti3) {
        int sum = 0;

        sum += getDiff(mbti1, mbti2);
        sum += getDiff(mbti1, mbti3);
        sum += getDiff(mbti2, mbti3);

        return sum;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            mbti = new String[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                mbti[i] = st.nextToken();
            }

            if (N > 32) {
                sb.append("0").append('\n');
                continue;
            }

            res = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    for (int k = j + 1; k < N; k++) {
                        res = Math.min(res, getSum(mbti[i], mbti[j], mbti[k]));
                    }
                }
            }
            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
