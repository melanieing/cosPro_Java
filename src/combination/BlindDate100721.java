package combination;
/**
 * 100721. 소개팅_디버깅
 * 소개팅에 매칭되는 남성 조합의 수 (male 중 female 만큼 뽑아서 나오는 조합의 수, 중복X)
 */
public class BlindDate100721 {
    public static void main(String[] args) {
        BlindDate100721 q = new BlindDate100721();
        int male = 5;
        int female = 2;

        System.out.println(q.solution(male, female));
    }

    private int solution(int male, int female) {
        return factorial(male) / (factorial(male - female) * factorial(female));
    }

    private int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }


}
