import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private String[] message = {
            "Yes",
            "No"
    };
    private int N, M, K;
    private Stack<Integer>[] stacks;
    private HashMap<Integer, Integer> stackInfo;
    private boolean[] chk;

    public void solutionB() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        while (M-- > 0) {
            K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int min = Integer.MAX_VALUE;
            while (st.hasMoreTokens()) {
                int cur = Integer.parseInt(st.nextToken());
                if (cur > min) {
                    System.out.println(message[1]);
                    return;
                }
                min = cur;
            }
        }

        System.out.println(message[0]);
    }

//    public void solutionA() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        chk = new boolean[N + 1];
//        stacks = new Stack[M];
//        stackInfo = new HashMap<>();
//
//        for (int i = 0; i < M; i++) {
//            stacks[i] = new Stack<>();
//            K = Integer.parseInt(br.readLine());
//
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < K; j++) {
//                stacks[i].add(Integer.parseInt(st.nextToken()));
//                stackInfo.put(stacks[i].peek(), i);
//            }
//            chk[stacks[i].peek()] = true;
//        }
//
//        int idx = 1;
//        while (idx <= N) {
//            if (chk[idx]) {
//                stacks[stackInfo.get(idx)].pop();
//
//                if (!stacks[stackInfo.get(idx)].isEmpty()) {
//                    chk[stacks[stackInfo.get(idx)].peek()] = true;
//                }
//
//                idx++;
//                continue;
//            }
//            System.out.println(message[1]);
//            return;
//        }
//
//        System.out.println(message[0]);
//    }

    public static void main(String[] args) throws IOException {
        new Main().solutionB();
    }
}
