import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int T;
    int N;
    int[] A;
    int[] B;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            A = new int[5];
            B = new int[5];

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                A[Integer.parseInt(st.nextToken())]++;
            }

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                B[Integer.parseInt(st.nextToken())]++;
            }

            if (A[4] > B[4]) {
                sb.append("A");
            } else if (A[4] < B[4]) {
                sb.append("B");
            } else {
                if (A[3] > B[3]) {
                    sb.append("A");
                } else if (A[3] < B[3]) {
                    sb.append("B");
                } else {
                    if (A[2] > B[2]) {
                        sb.append("A");
                    } else if (A[2] < B[2]) {
                        sb.append("B");
                    } else {
                        if (A[1] > B[1]) {
                            sb.append("A");
                        } else if (A[1] < B[1]) {
                            sb.append("B");
                        } else {
                            sb.append("D");
                        }
                    }
                }
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
