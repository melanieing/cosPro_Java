package twoPointer;

import java.util.Arrays;

/**
 * 75067. 한도 금액_디버깅
 *  주어진 조건을 만족하는 한도 금액 중 가장 큰 값은?
 */
public class CardLimit75067 {
    public static void main(String[] args) {
        CardLimit75067 q = new CardLimit75067();
        int[] cards = {10000, 8000, 9000, 12000, 7000};
        int money = 5000;

        System.out.println(q.solution(cards, money));
    }

    private int solution(int[] cards, int money) {
        Arrays.sort(cards);

        int low = 0;
        int mid;
        int high = cards[cards.length - 1];

        while (low <= high) {
            mid = (low + high) / 2;
            int excess = 0;
            for (var k : cards) {
                if (k > mid) { // 초과사용분 합산하기
                    excess += (k - mid);
                }
            }

            if (excess < money) { // 한도금액보다 초과사용이 적으면 사용한도를 낮추기
                high = mid - 1;
            } else { // 한도금액보다 초과사용이 많으면 사용한도를 올리기
                low = mid + 1;
            }
        }
        return (high / 100) * 100;
    }
}
