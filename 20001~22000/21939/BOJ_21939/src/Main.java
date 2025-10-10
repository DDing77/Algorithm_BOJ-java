import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private HashMap<Integer, Subject> map = new HashMap<>();

    private PriorityQueue<Subject> ascSubject = new PriorityQueue<>((o1, o2) -> {
        if (o1.L == o2.L) {
            return o1.P - o2.P;
        }
        return o1.L - o2.L;
    });

    private PriorityQueue<Subject> descSubject = new PriorityQueue<>((o1, o2) -> {
        if (o1.L == o2.L) {
            return o2.P - o1.P;
        }
        return o2.L - o1.L;
    });

    private void add(int P, int L) {
        Subject subject = new Subject(P, L);
        map.put(P, subject);
        ascSubject.add(subject);
        descSubject.add(subject);
    }

    private void solved(int P) {
        Subject subject = map.get(P);
        subject.isAlive = false;
    }

    private int recommend(int x) {
        if (x == 1) {
            while (!descSubject.isEmpty()) {
                Subject subject = descSubject.poll();
                if (subject.isAlive) {
                    descSubject.add(subject);
                    return subject.P;
                }
            }
        } else if (x == -1) {
            while (!ascSubject.isEmpty()) {
                Subject subject = ascSubject.poll();
                if (subject.isAlive) {
                    ascSubject.add(subject);
                    return subject.P;
                }
            }
        }
        return -1;
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            Subject subject = new Subject(P, L);
            map.put(P, subject);
            ascSubject.add(subject);
            descSubject.add(subject);
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            if (op.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                add(P, L);
            } else if (op.equals("solved")) {
                int P = Integer.parseInt(st.nextToken());
                solved(P);
            } else if (op.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                int result = recommend(x);
                sb.append(result).append("\n");
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Subject {
        boolean isAlive;
        int P;
        int L;

        public Subject(int p, int l) {
            isAlive = true;
            P = p;
            L = l;
        }
    }
}
