public class Main {

    static int N;
    static int res;

    public static int read() throws Exception {
        int n = System.in.read() & 15;
        int c;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }

    public static void solution() throws Exception {
        N = read();

        res = 0;
        for (int i = 1; i <= N; i++) {
            if (i != read()) {
                res++;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
