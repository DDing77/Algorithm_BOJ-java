import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 1; i <= N; i++) {
            int curValue = Integer.parseInt(br.readLine());

            if (maxHeap.size() == minHeap.size()) maxHeap.add(curValue);
            else minHeap.add(curValue);

            if(!maxHeap.isEmpty() && !minHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
                minHeap.add(maxHeap.poll());
                maxHeap.add(minHeap.poll());
            }
            sb.append(maxHeap.peek()).append('\n');
        }
        System.out.println(sb);
    }
}
