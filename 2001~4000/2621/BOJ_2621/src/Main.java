import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int res;

    // 0 : R
    // 1 : B
    // 2 : Y
    // 3 : G
    static ArrayList<Integer>[] card;

    static void analysisCard(String str) {
        char color = str.charAt(0);
        int number = str.charAt(2) - '0';
        System.out.println(number);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        card = new ArrayList[4];

        for(int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            int color = st.nextToken().charAt(0) - 'A';
            int number = st.nextToken().charAt(0) - '0';
            card[color].add(number);
        }

        for(int i=0; i<5; i++) Collections.sort(card[i]);

        boolean allColor = false;
        for(int i=0; i<5; i++) {
            if(card[i].size() == 5) {
                allColor = true;
                break;
            }
        }

        if(allColor) { // color all equal

        } else {

        }
        analysisCard("B3");
    }
}
