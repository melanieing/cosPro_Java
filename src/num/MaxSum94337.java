package num;

/**
 * 94337. 최대합_디버깅
 * 배열에서 한 개 이상의 연속된 수들의 합이 최대가 되는 부분을 찾아 그 합을 구하기
 */
public class MaxSum94337 {
    public static void main(String[] args) {
        MaxSum94337 q = new MaxSum94337();
        int[] sequence = {4,-3,7,-3};

        System.out.println(q.solution(sequence));

    }

    private int solution(int[] sequence) {
        int answer = 0;

        for (int i = 0; i < sequence.length; i++) {
            int temp = sequence[i];
//            answer = temp;
            for (int j = i + 1; j < sequence.length; j++) {
                temp += sequence[j];
                answer = Math.max(answer, temp);
            }
        }

        return answer;
    }
}
