import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static double option;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        option = Double.parseDouble(br.readLine());

        System.out.println(String.format("%.10f\n%.10f", 100 / option, 100 / (100 - option)));
    }
}