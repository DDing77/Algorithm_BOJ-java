import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static Set<String> set;
    static String input;
    static int startX, startY;
    static int nowX, nowY;
    static int preX, preY;

    public static boolean isCorrect(int preX, int preY, int nowX, int nowY) {
        if ((Math.abs(preX - nowX) == 1 && Math.abs(preY - nowY) == 2) || (Math.abs(preX - nowX) == 2 && Math.abs(preY - nowY) == 1)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        set = new HashSet<>();

        input = br.readLine();
        startX = input.charAt(0);
        startY = input.charAt(1);

        preX = startX;
        preY = startY;

        for (int i = 0; i < 35; i++) {
            input = br.readLine();

            if (set.contains(input)) {
                System.out.println("Invalid");
                return;
            }

            set.add(input);
            nowX = input.charAt(0);
            nowY = input.charAt(1);

            if (!isCorrect(preX, preY, nowX, nowY)) {
                System.out.println("Invalid");
                return;
            }

            preX = nowX;
            preY = nowY;
        }

        if (!isCorrect(preX, preY, startX, startY)) {
            System.out.println("Invalid");
            return;
        }

        System.out.println("Valid");
    }
}
