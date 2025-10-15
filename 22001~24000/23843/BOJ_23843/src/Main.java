import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private PriorityQueue<Integer> devices = new PriorityQueue<>(Comparator.reverseOrder());
    private PriorityQueue<Integer> chargerPQ = new PriorityQueue<>();
    private int resTime;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            devices.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            if (devices.isEmpty()) {
                break;
            }

            int device = devices.poll();
            chargerPQ.add(device);
        }

        while (!devices.isEmpty()) {
            if (!chargerPQ.isEmpty()) {
                resTime = chargerPQ.peek();
            }

            while (!chargerPQ.isEmpty() && chargerPQ.peek() == resTime) {
                chargerPQ.poll();
            }

            while (!devices.isEmpty() && chargerPQ.size() < M) {
                int device = devices.poll();
                int nextTime = device + resTime;
                chargerPQ.add(nextTime);
            }
        }
        
        while (!chargerPQ.isEmpty()) {
            resTime = chargerPQ.poll();
        }

        System.out.println(resTime);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Node {
        int time;
    }
}
