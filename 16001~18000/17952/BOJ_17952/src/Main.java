import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    Stack<int[]> stack;
    Queue<int[]> jobs;
    int res;

    private void solution() throws IOException {

        stack = new Stack<>();
        jobs = new ArrayDeque<>();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());

            if (op == 0) {
                if (jobs.isEmpty()) {
                    if (stack.isEmpty()) {
                        continue;
                    } else {
                        int[] curJob = stack.pop();
                        curJob[2]++;
                        if (curJob[1] == curJob[2]) {
                            res += curJob[0];
                        } else {
                            jobs.add(curJob);
                        }
                    }
                } else {
                    int[] curJob = jobs.poll();
                    curJob[2]++;
                    if (curJob[1] == curJob[2]) {
                        res += curJob[0];
                    } else {
                        jobs.add(curJob);
                    }
                }
            } else {
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                if (time == 1) {
                    res += score;
                    continue;
                }

                int[] newJob = new int[]{score, time, 1};
                if (jobs.isEmpty()) {
                    jobs.add(newJob);
                } else {
                    stack.add(jobs.poll());
                    jobs.add(newJob);
                }
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
