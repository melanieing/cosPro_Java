package num;

/**
 * 94340. 배수의 합_함수 작성
 * num보다 작은 k의 배수들의 합
 */
public class MultipleSum94340 {
    public static void main(String[] args) {
        MultipleSum94340 q = new MultipleSum94340();
        int num = 20;
        int k = 5;

        System.out.println(q.solution(num, k));
    }

    public int solution(int num, int k) {
        int answer = 0;
        int tmp = 1;

        while (tmp < num) {
            if (tmp % k == 0) { // k의 배수이면 더하기
                answer += tmp;
            }
            tmp++;
        }

        return answer;
    }
}
