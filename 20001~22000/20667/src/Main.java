import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] cpuDP;
    static int[][] memDP;

    static class Cpu {
        int cW;
        int cP;

        public Cpu(int cW, int cP) {
            this.cW = cW;
            this.cP = cP;
        }
    }

    static class Mem {
        int mW;
        int mP;

        public Mem(int mW, int mP) {
            this.mW = mW;
            this.mP = mP;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

    }
}
