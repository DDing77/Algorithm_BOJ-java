import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] p;
    static ArrayList<Integer> LIA;

    static int lowerBound(ArrayList<Integer> LIA, int start, int end, int target) {
        int L = start;
        int R = end;
        while (L < R) {
            int mid = (L + R) / 2;
            if (LIA.get(mid) >= target) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return R;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        p = new int[N + 1];
        LIA = new ArrayList<>();
        LIA.add(-1000000001);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            if (LIA.get(LIA.size() - 1) < arr[i]) {
                LIA.add(arr[i]);
                p[i] = LIA.size()-1;
            } else {
                int lia_idx = lowerBound(LIA, 1, LIA.size() - 1, arr[i]);
                LIA.set(lia_idx, arr[i]);
                p[i] = lia_idx;
            }
        }
        sb.append(LIA.size() - 1).append('\n');

        Stack<Integer> stack = new Stack<>();

        int size = LIA.size() - 1;
        for (int i = N; i >= 1; i--) {
            if (p[i] == size) {
                stack.push(arr[i]);
                size--;
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
//        System.out.println(sb);
//            System.out.println(Arrays.toString(p));

    }
}
