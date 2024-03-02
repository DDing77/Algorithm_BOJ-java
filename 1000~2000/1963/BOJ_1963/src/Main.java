import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int MAX_LENGTH = 10_000;

    int T;
    int source;
    int destination;
    boolean[] isNotPrime;
    int res;

    private void makePrimeArray() {
        for (int i = 2; i <= Math.sqrt(MAX_LENGTH); i++) {
            if (!isNotPrime[i]) {
                for (int j = i * 2; j < MAX_LENGTH; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }

    private int changePasswd(int[] splitNumber) {
        int nextNumber = 0;

        for (int i = 0; i < 4; i++) {
            nextNumber += splitNumber[i] * Math.pow(10, 3 - i);
        }

        return nextNumber;
    }

    private void execBFS(int source, int destination) {
        Queue<Info> que = new ArrayDeque<>();
        que.add(new Info(source, 0));

        boolean[] isVisited = new boolean[MAX_LENGTH];
        isVisited[source] = true;

        res = 0;
        while (!que.isEmpty()) {
            Info cur = que.poll();

            if (cur.number == destination) {
                res = cur.changedCount;
                return;
            }

            int[] splitNumber = new int[]{cur.number / 1_000, (cur.number / 100) % 10, (cur.number / 10) % 10, cur.number % 10};

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 10; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    int temp = splitNumber[i];
                    splitNumber[i] = j;

                    int nextNumber = changePasswd(splitNumber);
                    splitNumber[i] = temp;

                    if (isNotPrime[nextNumber]) {
                        continue;
                    }

                    if (isVisited[nextNumber]) {
                        continue;
                    }

                    que.add(new Info(nextNumber, cur.changedCount + 1));
                    isVisited[nextNumber] = true;
                }
            }
        }

        sb.append("Impossible").append("\n");
    }

    private void solution() throws IOException {

        isNotPrime = new boolean[MAX_LENGTH];
        makePrimeArray();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            source = Integer.parseInt(st.nextToken());
            destination = Integer.parseInt(st.nextToken());

            execBFS(source, destination);
            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Info {

        int number;
        int changedCount;

        public Info(int number, int changedCount) {
            this.number = number;
            this.changedCount = changedCount;
        }
    }
}
