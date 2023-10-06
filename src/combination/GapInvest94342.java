package combination;

import java.util.Arrays;

/**
 * 94342. 갭투자_함수 작성
 * 가지고 있는 돈으로 최대한 많은 아파트에 갭투자, 살 수 있는 아파트 개수는?
 */
public class GapInvest94342 {
    public static void main(String[] args) {
        GapInvest94342 q = new GapInvest94342();
        int[][] apartments = {{100000, 70}, {15000, 90}, {20000, 50}};
        int money = 30000;

        System.out.println(q.solution(apartments, money));
    }

    private int solution(int[][] apartments, int money) {
        int answer = 0;
        int[] investPrices = new int[apartments.length];
        int idx = 0;

        for (int[] apartment : apartments) {
            int salePrice = apartment[0];           // 매매가
            int ratio = apartment[1];               // 전세가율
            int fixPrice = salePrice * ratio / 100; // 전세가
            int investPrice = salePrice - fixPrice; // 투자금액
            investPrices[idx++] = investPrice;
        }

        Arrays.sort(investPrices); // 오름차순 정렬

        for (int investPrice : investPrices) {
            if (money >= investPrice) { // 가지고 있는 돈으로 살 수 있다면
                money -= investPrice; // 돈에서 차감하고
                answer++; // 개수에 추가
            }
        }

        return answer;
    }
}
