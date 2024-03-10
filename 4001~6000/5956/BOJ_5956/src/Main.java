import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int M;
    int res;

//    private int recur(int rowSize, int colSize, int rowOffset, int colOffset) {
//        if (rowSize == 1 || colSize == 1) {
//            return 1;
//        }
//
//        return 1 + recur(rowSize / 2, colSize / 2, rowOffset, colOffset) +
//                recur(rowSize / 2, colSize / 2, rowOffset + rowSize / 2 + 1, colOffset)
//                + recur(rowSize / 2, colSize / 2, rowOffset, colOffset + colSize / 2 + 1)
//                + recur(rowSize / 2, colSize / 2, rowOffset + rowSize / 2 + 1, colOffset + colSize / 2 + 1);
//    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        res = 0;
        int q = 1;
        while (N % 2 == 1 && M % 2 == 1) {
            res += q;
            q *= 4;
            N /= 2;
            M /= 2;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
