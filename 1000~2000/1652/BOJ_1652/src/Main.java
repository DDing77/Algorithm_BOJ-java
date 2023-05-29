import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String[] map;
    static int N;
    static int row, col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new String[N];
        for (int i = 0; i < N; i++) map[i] = br.readLine();

        row = 0;
        col = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i].charAt(j) == '.') {
                    if (j + 1 < N && map[i].charAt(j + 1) == '.') {
                        if (j + 2 >= N || (j + 2 < N && map[i].charAt(j + 2) == 'X')) {
                            row++;
                        }
                    }

                    if (i + 1 < N && map[i + 1].charAt(j) == '.') {
                        if (i + 2 >= N || (i + 2 < N && map[i + 2].charAt(j) == 'X')) {
                            col++;
                        }
                    }
                }
            }
        }

        System.out.println(row + " " + col);
    }
}
