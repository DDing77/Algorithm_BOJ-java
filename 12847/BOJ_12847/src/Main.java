public class Main {
    private int n;
    private int m;
    private long[] prefixSum;
    private long max;

    public void solution() throws Exception {
        n = read();
        m = read();

        prefixSum = new long[n + 1];

        max = 0L;
        for (int i = 1; i <= n; i++) {
            prefixSum[i] += prefixSum[i - 1] + read();
            if (i >= m) {
                max = Math.max(max, prefixSum[i] - prefixSum[i - m]);
            }
        }

        System.out.println(max);
    }

    public static int read() throws Exception {
        int c;
        int n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}

