import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int temp = 0;
        for (int i = 0; i < 4; i++) temp += Integer.parseInt(br.readLine());

        int min = 0;
        int second = 0;

        min = temp / 60;
        second = temp % 60;

        System.out.println(min);
        System.out.println(second);
    }
}
