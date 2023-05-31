public class Main {

    static int C;
    static int K;
    static int P;
    static int res;


    public static int nextInt() throws Exception {
        int c;
        int n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }

    public static int calculate(int year) {
        return year * K + year * year * P;
    }

    public static void solution() throws Exception {
        C = nextInt();
        K = nextInt();
        P = nextInt();

        res = 0;
        for (int i = 1; i <= C; i++) {
            res += calculate(i);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
