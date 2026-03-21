import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int testCaseCount;

    private void solution() throws IOException {
        testCaseCount = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testCaseCount; tc++) {
            int money = Integer.parseInt(br.readLine());
            int[] prices = new int[13];

            st = new StringTokenizer(br.readLine());
            for (int month = 1; month <= 12; month++) {
                prices[month] = Integer.parseInt(st.nextToken());
            }

            int bestBuyMonth = -1;
            int bestSellMonth = -1;
            int bestProfit = 0;
            int bestBuyPrice = Integer.MAX_VALUE;

            for (int buyMonth = 1; buyMonth <= 11; buyMonth++) {
                for (int sellMonth = buyMonth + 1; sellMonth <= 12; sellMonth++) {
                    int buyPrice = prices[buyMonth];
                    int sellPrice = prices[sellMonth];

                    if (sellPrice <= buyPrice) {
                        continue;
                    }

                    int count = money / buyPrice;
                    int profit = count * (sellPrice - buyPrice);

                    if (profit > bestProfit) {
                        bestProfit = profit;
                        bestBuyMonth = buyMonth;
                        bestSellMonth = sellMonth;
                        bestBuyPrice = buyPrice;
                    } else if (profit == bestProfit && profit > 0) {
                        if (buyPrice < bestBuyPrice) {
                            bestBuyMonth = buyMonth;
                            bestSellMonth = sellMonth;
                            bestBuyPrice = buyPrice;
                        }
                    }
                }
            }

            sb.append("Case #").append(tc).append(": ");
            if (bestProfit == 0) {
                sb.append("IMPOSSIBLE");
            } else {
                sb.append(bestBuyMonth).append(' ')
                        .append(bestSellMonth).append(' ')
                        .append(bestProfit);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}