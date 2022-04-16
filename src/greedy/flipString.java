package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1439
public class flipString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int count0 = 0; // 0으로 바뀌는 경우
        int count1 = 0; // 1로 바뀌는 경우

        if (input.charAt(0) == '0') { // 0으로 시작 (0에서 1로 바뀌기 때문)
            count1++;
        } else if (input.charAt(0) == '1') { // 1로 시작 (1에서 0으로 바뀌기 때문)
            count0++;
        }

        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) != input.charAt(i + 1)) {
                if (input.charAt(i + 1) == '1') {
                    count0++;
                } else if (input.charAt(i + 1) == '0') {
                    count1++;
                }
            }
        }

        int answer = Math.min(count0, count1);
        System.out.println(answer);
    }
}
