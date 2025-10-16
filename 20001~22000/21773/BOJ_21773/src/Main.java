import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int N;

    private PriorityQueue<Process> processPQ = new PriorityQueue<>((p1, p2) -> {
        if (p1.priority == p2.priority) {
            return p1.processId - p2.processId;
        }
        return p2.priority - p1.priority;
    });

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int processId = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            int priority = Integer.parseInt(st.nextToken());
            processPQ.add(new Process(processId, time, priority));
        }

        for (int i = 0; i < T; i++) {
            Process curProcess = processPQ.poll();
            sb.append(curProcess.processId).append("\n");

            curProcess.time--;

            if (curProcess.time != 0) {
                curProcess.priority--;
                processPQ.add(curProcess);
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Process {
        int processId;
        int time;
        int priority;

        public Process(int processId, int time, int priority) {
            this.processId = processId;
            this.time = time;
            this.priority = priority;
        }
    }
}
