import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int[] preId;
    private int[] nextId;
    private int[] inputStationArr;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        preId = new int[1_000_001];
        nextId = new int[1_000_001];
        inputStationArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputStationArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int curStationId = inputStationArr[i];
            int nextStationId = inputStationArr[(i + 1) % N];
            nextId[curStationId] = nextStationId;
            preId[nextStationId] = curStationId;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            int a;
            int b;
            int c;
            if (op.equals("BN")) {
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                c = nextId[a];

                nextId[a] = b;
                preId[b] = a;
                nextId[b] = c;
                preId[c] = b;

                sb.append(c);
            } else if (op.equals("BP")) {
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                c = preId[a];

                preId[a] = b;
                nextId[b] = a;
                preId[b] = c;
                nextId[c] = b;

                sb.append(c);
            } else if (op.equals("CN")) {
                a = Integer.parseInt(st.nextToken());
                b = nextId[a];
                c = nextId[b];

                nextId[a] = c;
                preId[c] = a;

                sb.append(b);
            } else if (op.equals("CP")) {
                a = Integer.parseInt(st.nextToken());
                b = preId[a];
                c = preId[b];

                preId[a] = c;
                nextId[c] = a;

                sb.append(b);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
