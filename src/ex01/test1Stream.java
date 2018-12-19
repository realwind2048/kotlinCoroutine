package ex01;

import java.util.Arrays;
import java.util.List;

public class test1Stream {

    public static int transform(int n) {
        sleep(1000);
        return n;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(
            numbers.stream()
                    .mapToInt(e -> transform(e))
                    .sum()
        );
        //numbers.parallelStream()
        //Java 8: 안드로이드에서는 API 24 (Android 7.0 Nougat)이상이 필요

    }

    private static boolean sleep(int ms) {
        try {
            Thread.sleep(ms);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }
}
