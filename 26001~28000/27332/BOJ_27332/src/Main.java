import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    int currentDay;

    private void solution() throws IOException {
        currentDay = Integer.parseInt(br.readLine());
        currentDay += Integer.parseInt(br.readLine()) * 7;

        if (currentDay <= 30) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
