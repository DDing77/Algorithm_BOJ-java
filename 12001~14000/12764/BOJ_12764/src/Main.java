import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private PriorityQueue<People> peopleQue = new PriorityQueue<>(Comparator.comparingInt(o -> o.startTime));
    private PriorityQueue<Computer> computerPQ  = new PriorityQueue<>((Comparator.comparingInt(o -> o.endTime)));
    private PriorityQueue<Computer> tempQue = new PriorityQueue<>(Comparator.comparingInt(o -> o.computerId));
    private HashMap<Integer, Computer> map = new HashMap<>();

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            peopleQue.add(new People(start, end));
        }

        int idx = 0;

        while (!peopleQue.isEmpty()) {
            People p = peopleQue.poll();

            while (!computerPQ.isEmpty() && computerPQ.peek().endTime <= p.startTime) {
                Computer c = computerPQ.poll();
                tempQue.add(c);
            }

            if (tempQue.isEmpty()) {
                Computer newComputer = new Computer(idx, p.endTime);
                newComputer.usedCnt++;
                map.put(idx++, newComputer);
                computerPQ.add(newComputer);
            } else {
                Computer c = tempQue.poll();
                c.usedCnt++;
                c.endTime = p.endTime;
                computerPQ.add(c);
            }
        }

        sb.append(idx).append("\n");
        for (int i = 0; i < idx; i++) {
            Computer c = map.get(i);
            sb.append(c.usedCnt).append(" ");
        }
        System.out.println(sb);

    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class People {
        int startTime;
        int endTime;

        public People(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    static class Computer {
        int computerId;
        int endTime;
        int usedCnt;

        public Computer(int computerId, int endTime) {
            this.computerId = computerId;
            this.endTime = endTime;
        }

        public void incUsed() {
            usedCnt++;
        }
    }
}
