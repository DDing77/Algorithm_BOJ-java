import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String pattern;
    static int N;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        res = 0;

        pattern = br.readLine();
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String parent = br.readLine();
            String temp = pattern;
            for (int i = 0; i < temp.length(); i++) {
                if (parent.contains(pattern)) {
                    res++;
                    break;
                }
                String left = parent.substring(0, 1);
                String right = parent.substring(1);
                parent = right + left;

            }
        }

        System.out.println(res);
    }
}
