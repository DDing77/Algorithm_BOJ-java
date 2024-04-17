import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    int N;
    ArrayList<String> numberList;

    private void solution() throws IOException {

        numberList = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("[\\D+]");

            for (String s : input) {
                if (!s.isEmpty()) {
                    while (s.length() > 1 && s.charAt(0) == '0') {
                        s = s.substring(1);
                    }
                    numberList.add(s);
                }
            }
        }

        numberList.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        for (String number : numberList) {
            sb.append(number).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
