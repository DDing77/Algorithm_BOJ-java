import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String input;
    static String res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        input = br.readLine();

        res = "";
        boolean isBracket = false;
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
//            System.out.println(cur);
            if (cur == '<') { // '<' 을 만나면 sb에 들어있던 스트링을 뒤집고 초기화
                res += sb.reverse().toString();
                sb.setLength(0);
                res += cur;
                isBracket = true;
            } else if (cur == '>') {
                isBracket = false;
                res += cur;
            } else if (isBracket) {
                res += cur;
                continue;
            } else if (cur == ' ') {
                res += sb.reverse().toString();
                sb.setLength(0);
                res += cur;
            } else {
                sb.append(cur);
            }
        }
        res += sb.reverse().toString();
        System.out.println(res);
    }
}