import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N, S;
    static long cnt;
    static int[] arr;
    static ArrayList<Long> leftList, rightList;

    static void getSum(int left, int right, long sum, String list) {
        if (left == right) {
            if (list == "leftList") {
                leftList.add(sum);
            } else rightList.add(sum);
            return;
        }

        getSum(left + 1, right, sum, list);
        getSum(left + 1, right, sum + arr[left], list);
    }

    static void solution() {
        cnt = 0;
        int leftPointer = 0;
        int rightPointer = rightList.size() - 1;

        while (leftPointer < leftList.size() && rightPointer >= 0) {
            if (leftPointer == leftList.size() || rightPointer < 0) break;

            long a = leftList.get(leftPointer);
            long b = rightList.get(rightPointer);

            if (a + b == S) {
                int leftCnt = 0;
                while (leftPointer < leftList.size() && leftList.get(leftPointer) == a) {
                    leftCnt++;
                    leftPointer++;
                }

                long rightCnt = 0;
                while (rightPointer >= 0 && rightList.get(rightPointer) == b) {
                    rightCnt++;
                    rightPointer--;
                }

                cnt += leftCnt * rightCnt;
            } else if (a + b > S) {
                rightPointer--;
            } else if (a + b < S) {
                leftPointer++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        leftList = new ArrayList<>();
        rightList = new ArrayList<>();

        getSum(0, N / 2, 0, "leftList");
        getSum(N / 2, N, 0, "rightList");

        Collections.sort(leftList);
        Collections.sort(rightList);
        solution();
        if (S == 0) System.out.println(cnt - 1);
        else System.out.println(cnt);
    }
}
