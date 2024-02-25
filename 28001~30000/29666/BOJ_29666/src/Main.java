import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//java9 이상

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    static final Set<String> successNumbers = new HashSet<>(Set.of(
            "123", "456", "789",
            "147", "258", "369",
            "058"));

    String passwd;

    private void solution() throws IOException {

        passwd = br.readLine();

        String sortedPasswd = passwd.chars()
                .mapToObj(c -> (char) c)
                .sorted()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();

        if (successNumbers.contains(sortedPasswd)) {
            System.out.println("Unlocked");
        } else {
            System.out.println("Locked");
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
