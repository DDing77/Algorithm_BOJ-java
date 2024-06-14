import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private long N;
    private int[] dice;
    private int type1;
    private int type2;
    private int type3;

    private int getType1() {

        int min = dice[0];
        for (int i = 1; i < 6; i++) {
            min = Math.min(min, dice[i]);
        }
        return min;
    }

    private int getType2() {

        List<Integer> type2Values = new LinkedList<>();
        // A
        type2Values.add(dice[0] + dice[1]);
        type2Values.add(dice[0] + dice[2]);
        type2Values.add(dice[0] + dice[3]);
        type2Values.add(dice[0] + dice[4]);
        // B
        type2Values.add(dice[1] + dice[2]);
        type2Values.add(dice[1] + dice[3]);
        type2Values.add(dice[1] + dice[5]);
        // C
        type2Values.add(dice[2] + dice[4]);
        type2Values.add(dice[2] + dice[5]);
        // D
        type2Values.add(dice[3] + dice[4]);
        type2Values.add(dice[3] + dice[5]);
        // E
        type2Values.add(dice[4] + dice[5]);

        Collections.sort(type2Values);
        return type2Values.get(0);
    }

    private int getType3() {
        List<Integer> type3Values = new LinkedList<>();
        // ABC
        type3Values.add(dice[0] + dice[1] + dice[2]);
        // ABD
        type3Values.add(dice[0] + dice[1] + dice[3]);
        // ADE
        type3Values.add(dice[0] + dice[3] + dice[4]);
        // ACE
        type3Values.add(dice[0] + dice[2] + dice[4]);
        // BCF
        type3Values.add(dice[1] + dice[2] + dice[5]);
        // BDF
        type3Values.add(dice[1] + dice[3] + dice[5]);
        // CEF
        type3Values.add(dice[2] + dice[4] + dice[5]);
        // DEF
        type3Values.add(dice[3] + dice[4] + dice[5]);

        Collections.sort(type3Values);
        return type3Values.get(0);
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        dice = new int[6];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        type1 = getType1();
        type2 = getType2();
        type3 = getType3();

        if (N == 1) {
            int sum = 0;
            int max = 0;
            for (int i = 0; i < 6; i++) {
                sum += dice[i];
                max = Math.max(max, dice[i]);
            }
            System.out.println(sum - max);
        } else {
            long sum = 0;
            // 꼭짓점
            sum += (long) type3 * 4;

            // 옆면 모서리
            sum += (long) type2 * (N - 1) * 4;

            // 상단 모서리
            sum += (long) type2 * (N - 2) * 4;

            // 옆면 면
            sum += (long) type1 * ((N - 1) * (N - 2)) * 4;

            // 상단 면
            sum += (long) type1 * ((N - 2) * (N - 2));
            System.out.println(sum);
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
