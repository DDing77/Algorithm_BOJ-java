import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int D;
    int K;
    int[] coA;
    int[] coB;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (D == 3) {
            sb.append(1).append("\n").append(K - 1);
            System.out.println(sb);
            return;
        }

        coA = new int[D + 1];
        coB = new int[D + 1];

        //day3
        coA[3] = 1;
        coB[3] = 1;
        //day4
        coA[4] = 1;
        coB[4] = 2;

        for (int i = 5; i <= D; i++) {
            coA[i] = coA[i - 2] + coA[i - 1];
            coB[i] = coB[i - 2] + coB[i - 1];
        }


        for (int i = 1; i <= K; i++) {
            int temp = K - coA[D] * i;
            if (temp % coB[D] == 0) {
                sb.append(i).append("\n").append(temp / coB[D]);
                break;
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
