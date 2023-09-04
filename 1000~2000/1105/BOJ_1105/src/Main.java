import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    String left;
    String right;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        left = st.nextToken();
        right = st.nextToken();

        res = 0;

        if (left.length() == right.length()) {
            for (int i = 0; i < left.length(); i++) {
                if (left.charAt(i) == right.charAt(i) && left.charAt(i) == '8') {
                    res++;
                } else if(left.charAt(i) != right.charAt(i)){
                    break;
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
