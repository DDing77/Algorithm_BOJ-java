import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;

public class Main {

    static class Info {
        int value;
        int mul;

        public Info(int value, int mul) {
            this.value = value;
            this.mul = mul;
        }
    }

    static HashMap<String, Info> light;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        light = new HashMap<>();
        light.put("black", new Info(0, 1));
        light.put("brown", new Info(1, 10));
        light.put("red", new Info(2, 100));
        light.put("orange", new Info(3, 1_000));
        light.put("yellow", new Info(4, 10_000));
        light.put("green", new Info(5, 100_000));
        light.put("blue", new Info(6, 1_000_000));
        light.put("violet", new Info(7, 10_000_000));
        light.put("grey", new Info(8, 100_000_000));
        light.put("white", new Info(9, 1_000_000_000));


        String first = br.readLine();
        String second = br.readLine();
        String third = br.readLine();
        int mul = light.get(third).mul;

        BigInteger res1 = new BigInteger("1");
        res1 = res1.multiply(BigInteger.valueOf(Long.parseLong(String.valueOf(10))));
        res1 = res1.multiply(BigInteger.valueOf(light.get(first).value));
        res1 = res1.multiply(BigInteger.valueOf(mul));

        BigInteger res2 = new BigInteger("1");
        res2 = res2.multiply(BigInteger.valueOf(light.get(second).value));
        res2 = res2.multiply(BigInteger.valueOf(mul));

        res1 = res1.add(res2);
        System.out.println(res1);
    }
}