import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Register {
        int number;
        String str;

        public Register(int number, String str) {
            this.number = number;
            this.str = str;
        }

        public int D() {
            return (number * 2) % 10000;
        }

        public int S() {
            if (this.number == 0) {
                return 9999;
            }
            return this.number - 1;
        }

        public int L() {
            return (this.number % 1000) * 10 + (this.number / 1000);
        }

        public int R() {
            return (this.number % 10) * 1000 + (this.number / 10);
        }
    }

    static int T;
    static int A, B;
    static boolean[] isVisited;
    static String res;

    static void bfs(Register register) {
        Queue<Register> que = new LinkedList<>();
        que.add(register);
        while (!que.isEmpty()) {
            Register cur = que.poll();
            if (cur.number == B) {
                res = cur.str;
                return;
            }

            if (!isVisited[cur.D()]) {
                isVisited[cur.D()] = true;
                que.add(new Register(cur.D(), cur.str + "D"));
            }

            if (!isVisited[cur.S()]) {
                isVisited[cur.S()] = true;
                que.add(new Register(cur.S(), cur.str + "S"));
            }

            if (!isVisited[cur.L()]) {
                isVisited[cur.L()] = true;
                que.add(new Register(cur.L(), cur.str + "L"));
            }

            if (!isVisited[cur.R()]) {
                isVisited[cur.R()] = true;
                que.add(new Register(cur.R(), cur.str + "R"));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            Register register = new Register(A, "");
            isVisited = new boolean[10000];

            bfs(register);

            sb.append(res).append('\n');
        }
        System.out.print(sb);
    }
}
