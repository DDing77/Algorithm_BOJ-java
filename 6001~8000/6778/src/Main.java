import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int antenna = Integer.parseInt(br.readLine());
        int eyes = Integer.parseInt(br.readLine());

        if(antenna >= 3 && eyes <=4)
            System.out.println("TroyMartian");
        if(antenna <= 6 && eyes >= 2)
            System.out.println("VladSaturnian");
        if(antenna <= 2 && eyes <= 3)
            System.out.println("GraemeMercurian");
    }
}
