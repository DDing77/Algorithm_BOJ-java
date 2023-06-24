import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int h;
    static int w;
    static int res;
    static String input;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        res = 0;
        for (int i = 0; i < h; i++) {
            input = br.readLine();
            for (int j = 0; j < w; j++) {
                if (input.charAt(j) == '/' || input.charAt(j) == '\\') {
                    j++;
                    res++;
                    int cnt = 0;

                    while (j < w && input.charAt(j) == '.') {
                        cnt++;
                        j++;
                    }

                    res += cnt;
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}