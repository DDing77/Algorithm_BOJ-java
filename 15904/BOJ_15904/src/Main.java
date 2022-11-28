import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine().split("");

        int i = 0;
        for (String str : input) {
            if (i == 0 && str.equals("U")) i++;
            if ((i == 1 || i == 3) && str.equals("C")) i++;
            if (i == 2 && str.equals("P")) i++;
        }
        if (i == 4) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }
    }
}