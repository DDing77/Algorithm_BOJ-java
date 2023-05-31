public class Main {

    static int N;
    static int A;
    static int B;
    static int cntA;
    static int cntB;

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
        cntA = 0;
        cntB = 0;

        while (N-- > 0) {
            A = read();
            B = read();

            if (A > B) {
                cntA++;
            } else if (A < B) {
                cntB++;
            }
        }

        System.out.println(cntA + " " + cntB);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
