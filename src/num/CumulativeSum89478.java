package num;
/**
 * 89478. 누적합의 합_빈칸채우기
 * 각 구간들의 누적합의 총합?
 */
public class CumulativeSum89478 {
    public static void main(String[] args) {
        CumulativeSum89478 q = new CumulativeSum89478();
        int[] sequence = {3, 1, 5, 4, 2, 1};
        int[][] sections = {{0,2}, {3,5}, {2,4}};

        System.out.println(q.solution(sequence, sections));
    }

    private int solution(int[] sequence, int[][] sections) {
        int[] cumulativeSum = cumulateSum(sequence); // 누적합 구해서 기록
        int totalSum = 0;

        for (int[] section : sections) { // 구간별로 누적합의 합 구하기
            totalSum += getSum(cumulativeSum, section);
        }

        return totalSum;
    }

    private int getSum(int[] cumulativeSum, int[] section) {
        int start = section[0];
        int end = section[1];

        return cumulativeSum[end+1] - cumulativeSum[start]; // 인덱스 주의
    }

    private int[] cumulateSum(int[] sequence) {
        int size = sequence.length;
        int[] cumulativeSum = new int[size + 1];

        for (int i = 1; i <= size; i++) {
            cumulativeSum[i] = cumulativeSum[i-1] + sequence[i-1];
        }

        return cumulativeSum;
    }
}
