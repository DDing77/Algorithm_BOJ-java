import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Guitar[] guitars;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        guitars = new Guitar[N];

        for (int i = 0; i < N; i++) {
            guitars[i] = new Guitar(br.readLine());
        }

        Arrays.sort(guitars);

        for (int i = 0; i < N; i++) {
            sb.append(guitars[i].serial).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }

    static class Guitar implements Comparable<Guitar> {
        String serial;

        public Guitar(String serial) {
            this.serial = serial;
        }

        public boolean isNumber(char c) {
            if ('0' <= c && c <= '9') {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int compareTo(Guitar o) {
            if (this.serial.length() < o.serial.length()) {
                return -1;
            } else if (this.serial.length() == o.serial.length()) {
                int ASum = 0;
                int BSum = 0;

                for (int i = 0; i < o.serial.length(); i++) {
                    if (isNumber(this.serial.charAt(i))) {
                        ASum += this.serial.charAt(i) - '0';
                    }
                    if (isNumber(o.serial.charAt(i))) {
                        BSum += o.serial.charAt(i) - '0';
                    }
                }

                if (ASum == BSum) {
                    return this.serial.compareTo(o.serial);
                } else {
                    return ASum - BSum;
                }
            }
            return 1;
        }
    }
}

