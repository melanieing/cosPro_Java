package num;

/**
 * 75064. 소수의 개수_빈칸채우기
 * a 이상 b 이하인 수 중 소수의 개수
 */
public class PirmeNum75064 {
    public static void main(String[] args) {
        PirmeNum75064 q = new PirmeNum75064();
        int a = 1;
        int b = 11;

        System.out.println(q.countPrimes(a, b));
    }

    private int countPrimes(int a, int b) { // 소수 개수 구하기
        int cnt = 0;
        for (int i = a; i <= b; i++) {
            if (isPrime(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean isPrime(int n) { // 소수인지 판별
        if (n == 1) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
