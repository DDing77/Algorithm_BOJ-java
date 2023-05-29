import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int n;
    static ArrayList<Integer> tab;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tab = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            tab.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;

        for (int i : tab) sum += i;
        int result = sum - tab.size() + 1;
        System.out.println(result);
    }

}