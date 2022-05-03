package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

//Using HashMap
public class findOverlap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> hm = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            if (hm.contains(temp)) {
                result.add(temp);
            } else {
                hm.add(temp);
            }
        }

        Collections.sort(result);

        for (String s : result) {
            System.out.println(s);
        }
    }
}
