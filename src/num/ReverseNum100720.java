package num;
/**
 * 100720. 숫자 뒤집기_디버깅
 * 1. n보다 작거나 같은 수
 * 2. 해당 숫자를 뒤집은 숫자가 뒤집기 전보다 더 큰 숫자
 * 1, 2 조건을 만족하는 수 중 가장 큰 수
 */
public class ReverseNum100720 {
    public static void main(String[] args) {
        ReverseNum100720 q = new ReverseNum100720();
        int n = 100;

        System.out.println(q.solution(n));
    }

    private int solution(int n) {
        while (true) {
            int reversedN = Integer.parseInt(new StringBuilder(Integer.toString(n)).reverse().toString());
            if (n < reversedN) {
                return n;
            }
            n--;
        }
    }
}
