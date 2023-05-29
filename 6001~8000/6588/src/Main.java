import java.io.*;

public class Main {

    private final int LENGTH = 1000000;
    private boolean[] prime;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        prime = new boolean[LENGTH + 1];
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= Math.sqrt(LENGTH); i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= LENGTH; j += i) {
                    prime[j] = true;
                }
            }
        }

        while (true) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            boolean check = false;
            for (int i = 3; i <= N / 2; i += 2) {
                if (!prime[i] && !prime[N - i]) {
                    bw.write(N + " = " + i + " + " + (N - i) + "\n");
                    check = true;
                    break;
                }
            }

            if (!check) {
                bw.write("Goldbach's conjecture is wrong.");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}