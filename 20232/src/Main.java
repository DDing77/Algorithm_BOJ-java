import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    static HashMap<Integer, String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        list = new HashMap<>();
        list.put(1995, "ITMO");
        list.put(1996, "SPbSU");
        list.put(1997, "SPbSU");
        list.put(1998, "ITMO");
        list.put(1999, "ITMO");
        list.put(2000, "SPbSU");
        list.put(2001, "ITMO");
        list.put(2002, "ITMO");
        list.put(2003, "ITMO");
        list.put(2004, "ITMO");
        list.put(2005, "ITMO");
        list.put(2006, "PetrSU, ITMO");
        list.put(2007, "SPbSU");
        list.put(2008, "SPbSU");
        list.put(2009, "ITMO");
        list.put(2010, "ITMO");
        list.put(2011, "ITMO");
        list.put(2012, "ITMO");
        list.put(2013, "SPbSU");
        list.put(2014, "ITMO");
        list.put(2015, "ITMO");
        list.put(2016, "ITMO");
        list.put(2017, "ITMO");
        list.put(2018, "SPbSU");
        list.put(2019, "ITMO");

        int input = Integer.parseInt(br.readLine());

        System.out.println(list.get(input));
    }
}