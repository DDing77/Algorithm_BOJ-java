import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[5][15];

        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) map[i][j] = input.charAt(j);
        }

        String res = "";
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[j][i] == '\0' || map[j][i] == ' ') continue;
                res += map[j][i];
            }
        }
        System.out.println(res);
    }
}
