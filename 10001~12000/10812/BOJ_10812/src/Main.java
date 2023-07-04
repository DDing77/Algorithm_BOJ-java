import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int i;
    static int j;
    static int k;
    static int remainIdx;
    static int[] origin;
    static int[] temp;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        origin = new int[N + 1];
        for (int l = 1; l <= N; l++) {
            origin[l] = l;
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            remainIdx = i;

            temp = new int[N + 1];
            temp = origin.clone();
            for (int l = 0; l < j - i + 1; l++) {
                if (k + l <= j) {
                    temp[l + i] = origin[k + l];
                } else {
                    temp[l + i] = origin[remainIdx++];
                }
            }
            origin = temp.clone();
        }

        for (int l = 1; l <= N; l++) {
            sb.append(origin[l] + " ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}

