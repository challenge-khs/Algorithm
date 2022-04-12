package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class ExchangeMoney1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        Integer[] money = {500, 100, 50, 10};

        Arrays.sort(money, Collections.reverseOrder());

        for (int i = 0; i < money.length; i++) {
            count += n / money[i];
            n %= money[i];
        }

        System.out.println(count);

    }
}
