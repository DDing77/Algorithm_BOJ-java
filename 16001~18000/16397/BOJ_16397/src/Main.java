import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int T;
    private int G;
    private boolean[] isVisited;
    private int res = -1;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());

        LED startLED = new LED(N);

        Queue<LED> que = new ArrayDeque<>();
        que.add(startLED);
        isVisited = new boolean[100_000];
        isVisited[N] = true;

        while (!que.isEmpty()) {
            LED cur = que.poll();

            if (cur.cnt > T) {
                continue;
            }

            if (cur.number == G) {
                res = cur.cnt;
                break;
            }

            // A
            LED nextA = cur.A();
            if (cur.valid(cur.number + 1) && !isVisited[nextA.number]) {
                que.add(nextA);
                isVisited[nextA.number] = true;
            }

            // B
            if (cur.number * 2 > 99_999) {
                continue;
            }
            LED nextB = cur.B();
            if (!isVisited[nextB.number]) {
                que.add(nextB);
                isVisited[nextB.number] = true;
            }

        }

        if (res == -1) {
            System.out.println("ANG");
            return;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class LED {
        int number;
        char[] numberChar;
        int cnt;

        public LED(int number) {
            initLED(number, 0);
        }

        public LED(int number, char[] numberChar, int cnt) {
            this.number = number;
            this.numberChar = numberChar;
            this.cnt = cnt;
        }

        public void initLED(int number, int cnt) {
            this.number = number;
            numberChar = intToChar(number);
            this.cnt = cnt;
        }

        public char[] intToChar(int number) {
            int temp = number;
            char[] tempChar = new char[5];
            for (int i = 4; i >= 0; i--) {
                int mod = temp % 10;
                tempChar[i] = (char) (mod + '0');
                temp /= 10;
            }
            return tempChar;
        }

        public int charToInt(char[] chars) {
            int number = 0;
            for (int i = 0; i < 5; i++) {
                number *= 10;
                number += chars[i] - '0';
            }
            return number;
        }

        public LED A() {
            int nextNumber = number + 1;
            char[] nextChar = intToChar(nextNumber);
            return new LED(nextNumber, nextChar, this.cnt + 1);
        }

        public boolean valid(int nextNumber) {
            return nextNumber <= 99_999;
        }

        public LED B() {
            int nextNumber = number * 2;
            char[] nextChar = intToChar(nextNumber);
            for (int i = 0; i < 5; i++) {
                if ('0' < nextChar[i]) {
                    nextChar[i]--;
                    break;
                }
            }
            nextNumber = charToInt(nextChar);
            return new LED(nextNumber, nextChar, this.cnt + 1);
        }
    }
}
