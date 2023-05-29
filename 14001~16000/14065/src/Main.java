import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final double GALLON2LITER = 3.785411784;
    static final double MILE2KM = 1.609344;
    static final double HUNDRED_KM = 100.00;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double milesPerGallon = Double.parseDouble(br.readLine());
        double result = HUNDRED_KM / ((MILE2KM / GALLON2LITER) * milesPerGallon);

        System.out.printf("%.6f", result);
    }
}
