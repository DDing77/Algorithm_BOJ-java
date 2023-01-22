import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static String input;
    static String bomb;
    static String res;

    public static String getResult() {
        int idx = 0;
        char[] temp = new char[input.length()];

        for (int i = 0; i < input.length(); i++) {
            temp[idx] = input.charAt(i);

            boolean isBomb = true;
            if (idx >= bomb.length() - 1) {
                for (int j = 0; j < bomb.length(); j++) {
                    if (bomb.charAt(j) != temp[idx - bomb.length() + 1 + j]) {
                        isBomb = false;
                        break;
                    }
                }
                if (isBomb) idx -= bomb.length();
            }
            idx++;
        }
        return String.valueOf(temp, 0, idx);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        bomb = br.readLine();

        res = getResult();

        if (res.length() == 0) System.out.println("FRULA");
        else System.out.println(res);
    }
}
