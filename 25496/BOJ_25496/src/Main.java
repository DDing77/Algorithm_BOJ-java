    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;
    import java.util.StringTokenizer;

    public class Main {

        private int P, N;
        private int[] arr;
        private int res;

        public void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int idx = 0;
            while (P < 200 && idx < N) {
                P += arr[idx++];
                res++;
            }

            System.out.println(res);
        }

        public static void main(String[] args) throws IOException {
            new Main().solution();
        }
    }
