import javax.swing.*;
import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N, L;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        st= new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            while(!deque.isEmpty() && arr[deque.peekLast()] > arr[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if(deque.peekFirst() <= i- L ) {
                deque.removeFirst();
            }
            sb.append(arr[deque.getFirst()]).append(" ");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}
