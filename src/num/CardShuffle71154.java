package num;
/**
 * 71154. 카드셔플_디버깅
 * 아래에서부터 k번째에 있는 카드에 적힌 숫자
 */
public class CardShuffle71154 {
    public static void main(String[] args) {
        CardShuffle71154 q = new CardShuffle71154();
        int n = 6;
        int mix = 3;
        int k = 3;

        System.out.println(q.solution(n, mix, k));
    }

    private int solution(int n, int mix, int k) {
        int answer = 0;

        int[] card = new int[n];
        for (int i = 0; i < n; i++) {
            card[i] = i+1;
        }

        while (mix-- != 0) {
            int[] cardA = new int[n/2];
            int[] cardB = new int[n/2];

            for (int i = 0; i < n; i++) {
                if (i < n / 2) {
                    cardA[i] = card[i];
                } else {
                    cardB[i%(n/2)] = card[i];
                }
            }

            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    card[i] = cardA[i/2];
                } else {
                    card[i] = cardB[i/2];
                }
            }

        }

        answer = card[k-1];
        return answer;
    }
}
