import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int K;
    private Queue<Node> customerQue = new ArrayDeque<>();

    private PriorityQueue<Node> counterPQ = new PriorityQueue<>((o1, o2) -> {
        if (o1.doneTime == o2.doneTime) {
            return o2.counterNum - o1.counterNum;
        }
        return o1.doneTime - o2.doneTime;
    });

    private Stack<Integer> outIdOrder = new Stack<>();
    private int curTime = 0;
    private int outCnt = 0;
    private long res = 0L;


    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int customerId = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            customerQue.add(new Node(customerId, weight));
        }

        for (int i = 0; i < K; i++) {
            if (customerQue.isEmpty()) {
                break;
            }

            Node customer = customerQue.poll();
            customer.counterNum = i;
            customer.doneTime = customer.weight;
            counterPQ.add(customer);
        }

        while (!customerQue.isEmpty()) {
            if (!counterPQ.isEmpty()) {
                curTime = counterPQ.peek().doneTime;
            }

            while (!counterPQ.isEmpty()) {
                if (curTime == counterPQ.peek().doneTime) {
                    Node counter =  counterPQ.poll();
                    outIdOrder.push(counter.counterNum);
                    res += ((long) ++outCnt * counter.id);
                } else {
                    break;
                }
            }

            while (!outIdOrder.isEmpty() && !customerQue.isEmpty()) {
                Node customer = customerQue.poll();
                customer.counterNum = outIdOrder.pop();
                customer.doneTime = customer.weight + curTime;
                counterPQ.add(customer);
            }
        }

        while (!counterPQ.isEmpty()) {
            res += ((long) ++outCnt * counterPQ.poll().id);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Node {
        int id;
        int counterNum;
        int weight;
        int doneTime;

        public Node(int id, int weight) {
            this.id = id;
            this.weight = weight;
        }
    }
}
