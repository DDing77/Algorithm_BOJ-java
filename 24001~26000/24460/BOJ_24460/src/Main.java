import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int[][] chairs;
    List<Integer> temp;

    private int execDQ(int length, int row, int col) {

        if (length == 1) {
            return chairs[row][col];
        }

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(execDQ(length / 2, row, col));
        temp.add(execDQ(length / 2, row, col + length / 2));
        temp.add(execDQ(length / 2, row + length / 2, col));
        temp.add(execDQ(length / 2, row + length / 2, col + length / 2));

        Collections.sort(temp);
        return temp.get(1);
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        chairs = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                chairs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(execDQ(N, 0, 0));
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
