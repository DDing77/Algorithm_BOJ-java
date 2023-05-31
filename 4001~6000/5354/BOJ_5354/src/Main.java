public class Main {

    static int T;
    static int N;


    public static int read() throws Exception {
        int n = System.in.read() & 15;
        int c;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }

    public static void solution() throws Exception {
        StringBuilder sb = new StringBuilder();

        T = read();
        while (T-- > 0) {
            N = read();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
                        sb.append("#");
                    } else {
                        sb.append("J");
                    }
                }
                sb.append('\n');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
