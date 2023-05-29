import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static StringBuilder input;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        while (N-- > 0) {
            input = new StringBuilder();
            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') {
//                    System.out.println("test");
                    sb.append(input.reverse().toString());
                    sb.append(" ");
                    input.setLength(0);
                } else if (i == str.length() - 1) {
                    input.append(str.charAt(i));
                    sb.append(input.reverse().toString());
                } else if (str.charAt(i) != ' ') {
                    input.append(str.charAt(i));
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}