import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int T;
    double number;
    String type;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            number = Double.parseDouble(st.nextToken());
            type = st.nextToken();

            if (type.equals("kg")) {
                sb.append(String.format("%.04f lb", number * 2.2046));
            } else if (type.equals("g")) {
                sb.append(String.format("%.04f l", number * 3.7854));
            } else if (type.equals("l")) {
                sb.append(String.format("%.04f g", number * 0.2642));
            } else if (type.equals("lb")) {
                sb.append(String.format("%.04f kg", number * 0.4536));
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
