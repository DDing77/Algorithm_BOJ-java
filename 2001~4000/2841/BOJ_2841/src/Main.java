import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Stack;
        import java.util.StringTokenizer;
        import java.util.stream.IntStream;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int P;
    Stack<Integer>[] guitar;
    int res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        guitar = IntStream.rangeClosed(0, 6)
                .mapToObj(i -> new Stack<>())
                .toArray(Stack[]::new);

        res = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int lineNumber = Integer.parseInt(st.nextToken());
            int fretNumber = Integer.parseInt(st.nextToken());

            if (guitar[lineNumber].isEmpty()) {
                guitar[lineNumber].add(fretNumber);
                res++;
                continue;
            }

            while (!guitar[lineNumber].isEmpty() && guitar[lineNumber].peek() > fretNumber) {
                res++;
                guitar[lineNumber].pop();
            }

            if (guitar[lineNumber].isEmpty() || guitar[lineNumber].peek() < fretNumber) {
                guitar[lineNumber].add(fretNumber);
                res++;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
