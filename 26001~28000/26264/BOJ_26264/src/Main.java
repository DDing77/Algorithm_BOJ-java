import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private int securityCount;
    private int bigdataCount;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        String input = br.readLine().replaceAll(" ", "");
        input = input.replaceAll("security", "+");
        input = input.replaceAll("bigdata", "-");

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+') {
                securityCount++;
            } else {
                bigdataCount++;
            }
        }

        if (securityCount > bigdataCount) {
            System.out.println("security!");
        } else if (securityCount < bigdataCount) {
            System.out.println("bigdata?");
        } else {
            System.out.println("bigdata? security!");
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
