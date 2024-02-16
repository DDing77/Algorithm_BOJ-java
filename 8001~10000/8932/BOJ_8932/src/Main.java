import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    int T;
    int res;

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            res = 0;
            for (Sport value : Sport.values()) {
                res += value.calculate(Integer.parseInt(st.nextToken()));
            }
            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    enum Sport {

        HURDLE("track", 9.23076, 26.7, 1.835) {
            public double calculate(int P) {
                return Math.floor(HURDLE.A * Math.pow((HURDLE.B - P), HURDLE.C));
            }
        },
        HIGH_JUMP("field", 1.84523, 75, 1.348) {
            public double calculate(int P) {
                return Math.floor(HIGH_JUMP.A * Math.pow((P - HIGH_JUMP.B), HIGH_JUMP.C));
            }
        },
        SHOT_PUT("field", 56.0211, 1.5, 1.05) {
            public double calculate(int P) {
                return Math.floor(SHOT_PUT.A * Math.pow((P - SHOT_PUT.B), SHOT_PUT.C));
            }
        },
        RUN_200M("track", 4.99087, 42.5, 1.81) {
            public double calculate(int P) {
                return Math.floor(RUN_200M.A * Math.pow((RUN_200M.B - P), RUN_200M.C));
            }
        },
        LONG_JUMP("field", 0.188807, 210, 1.41) {
            public double calculate(int P) {
                return Math.floor(LONG_JUMP.A * Math.pow((P - LONG_JUMP.B), LONG_JUMP.C));
            }
        },
        JAVELIN_THROW("field", 15.9803, 3.8, 1.04) {
            public double calculate(int P) {
                return Math.floor(JAVELIN_THROW.A * Math.pow((P - JAVELIN_THROW.B), JAVELIN_THROW.C));
            }
        },
        RUN_800M("track", 0.11193, 254, 1.88) {
            public double calculate(int P) {
                return Math.floor(RUN_800M.A * Math.pow((RUN_800M.B - P), RUN_800M.C));
            }
        };

        private final String type;
        private final double A;
        private final double B;
        private final double C;

        Sport(String type, double A, double B, double C) {
            this.type = type;
            this.A = A;
            this.B = B;
            this.C = C;
        }

        public abstract double calculate(int P);
    }
}
