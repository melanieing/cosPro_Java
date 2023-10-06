package charString;

/**
 * 100717. 비밀번호_빈칸채우기
 * 비밀번호의 형식이 올바른지 확인
 */
public class Password100717 {
    public static void main(String[] args) {
        Password100717 q = new Password100717();
        String[] password = {"abcd", "aaabbc", "abcde"};

        System.out.println(q.solution(password));
    }

    private int solution(String[] password) {
        int validCount = 0;

        for (String pw : password) {
            boolean[] charUsed = new boolean[26]; // 사용된 알파벳 체크 배열

            for (char c : pw.toCharArray()) {
                int index = c - 'a';
                charUsed[index] = true;
            }

            int uniqueCharCount = 0;
            for (boolean used : charUsed) {
                if (used) {
                    uniqueCharCount++;
                }
            }

            if (uniqueCharCount >= 5) { // 서로 다른 문자가 5개 이상
                validCount++;
            }
        }

        return validCount;
    }
}
