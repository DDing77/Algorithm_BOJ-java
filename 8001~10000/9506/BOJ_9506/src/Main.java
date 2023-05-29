import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    private int n;
    private ArrayList<Integer> divisors;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while ((n = Integer.parseInt(br.readLine())) != -1) {
            divisors = new ArrayList<>();
            int sum = 0;
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    divisors.add(i);
                    sum += i;
                }
            }

            if (sum != n) {
                sb.append(n).append(" is NOT perfect.").append('\n');
                continue;
            }

            StringBuilder tempSb = new StringBuilder();
            tempSb.append(n).append(" = ");
            for (int i = 0; i < divisors.size(); i++) {
                tempSb.append(divisors.get(i));
                if (i == divisors.size() - 1) {
                    break;
                }
                tempSb.append(" + ");
            }
            sb.append(tempSb).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
