import java.util.ArrayList;

public class Main {
    static String a, b;
    static String ans = "";

    static void LCS(int l1, int r1, int l2, int r2) {
        if(l1 > r1) return;
        if (l1 == r1) {
            for (int i = l2; i <= r2; i++) {
                if (b.charAt(i) == b.charAt(l1)) {
                    ans.concat(String.valueOf(b.charAt(i)));
                    break;
                }
            }
            return;
        }

        int mid = (l1 + r1 ) >> 1;
        ArrayList<Integer> LCS1;
    }


    public static void main(String[] args) {

    }
}
