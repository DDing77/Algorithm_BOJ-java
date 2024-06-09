import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int D;
    private int N;
    private int[] temp;
    private int[] minTemp;
    private int[] maxTemp;
    private int[] score;
    private ArrayList<Integer>[] wearList;
    private int[][] dp;
    private int res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        temp = new int[D];
        for (int i = 0; i < D; i++) {
            temp[i] = Integer.parseInt(br.readLine());
        }

        minTemp = new int[N];
        maxTemp = new int[N];
        score = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            minTemp[i] = Integer.parseInt(st.nextToken());
            maxTemp[i] = Integer.parseInt(st.nextToken());
            score[i] = Integer.parseInt(st.nextToken());
        }

        wearList = new ArrayList[D];
        for (int i = 0; i < D; i++) {
            wearList[i] = new ArrayList<>();
        }
        for (int i = 0; i < D; i++) {
            for (int j = 0; j < N; j++) {
                if (minTemp[j] <= temp[i] && temp[i] <= maxTemp[j]) {
                    wearList[i].add(j);
                }
            }
        }

        dp = new int[D][N];
        for (int i = 1; i < D; i++) {
            for (int curIdx : wearList[i]) {
                for (int preDix : wearList[i - 1]) {
                    dp[i][curIdx] = Math.max(dp[i][curIdx], dp[i - 1][preDix] + Math.abs(score[curIdx] - score[preDix]));
                }
            }
        }

        for (int i = 0; i < N; i++) {
            res = Math.max(res, dp[D - 1][i]);
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
