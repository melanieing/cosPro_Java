package twoPointer;
/**
 * 87158. 생일파티_디버깅
 * 참가비 총합이 생일파티 준비 비용보다 같거나 많아지려면
 * 참가비를 1인당 최소 얼마씩 걷어야 하는지?
 */
public class BirthdayParty87158 {
    public static void main(String[] args) {
        BirthdayParty87158 q = new BirthdayParty87158();
        int expense = 200000;
        int participants = 12;

        System.out.println(q.solution(expense, participants));
    }

    private int solution(int expense, int participants) {
       int answer = 0;

       int left = 100;
       int right = expense;

       while (left <= right) {
           int mid = (left + right) / 2;
           mid = mid / 100 * 100; // 100의 배수로 만들기
           if (mid * participants >= expense) { // 파티 준비비용보다 참가비 총합이 더 크다면
               answer = mid;
               right = mid - 100; // 줄이기
           } else { // 파티 준비비용이 참가비 총합보다 더 크다면
               left = mid + 100; // 늘리기
           }
       }

       return answer;
    }
}
