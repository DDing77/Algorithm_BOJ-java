import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int decimal;
    static int standard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        decimal = Integer.parseInt(st.nextToken());
        standard = Integer.parseInt(st.nextToken());

        StringBuilder res = new StringBuilder();
//        System.out.println((char) (decimal % 36 - 10 + 'A'));
        while (decimal > 0) {
            int temp = decimal % standard;
            if (temp >= 10) res.append((char) (temp - 10 + 'A'));
            else res.append(temp);

            decimal /= standard;
        }

        System.out.println(res.reverse());
    }
}
