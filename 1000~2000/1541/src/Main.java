import java.io.*;
public class Main {
    public static void main(String[] args) throws  IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int sum =0;
        Boolean isFirst = true;
        String[] sub = br.readLine().split("-");

        for(int i=0; i< sub.length; i++) {
            int temp = 0;

            String[] add = sub[i].split("\\+");

            for(int j= 0; j< add.length; j++) {
                temp += Integer.parseInt(add[j]);
            }
            if(isFirst) {
                sum = temp;
                isFirst = false;
            }
            else {
                sum -=temp;
            }
        }
        System.out.println(sum);
    }
}
