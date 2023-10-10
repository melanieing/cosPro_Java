package charString;
/**
 * 87154. 애너그램_빈칸채우기
 * 애너그램인 단어 쌍들은 총 몇 개인지?
 */
public class Anagram87154 {
    public static void main(String[] args) {
        Anagram87154 q = new Anagram87154();
        String[][] anagram = {{"Dog", "God"}, {"ate", "cat"}, {"friend", "finder"}};

        System.out.println(q.solution(anagram));
    }

    private int solution(String[][] anagram) {
        int answer = 0;

        for (int i = 0; i < anagram.length; i++) {
            int[] alpha = new int[26];
            // 첫 번째 단어 알파벳 카운트
            for (int j = 0; j < anagram[i][0].length(); j++) {
                char c = anagram[i][0].charAt(j);
                if (c >= 'A' && c <= 'Z') {
                    alpha[c - 'A']++;
                } else if (c >= 'a' && c <= 'z') {
                    alpha[c - 'a']++;
                }
            }
            // 두 번째 단어 알파벳 카운트
            for (int j = 0; j < anagram[i][1].length(); j++) {
                char c = anagram[i][1].charAt(j);
                if (c >= 'A' && c <= 'Z') {
                    alpha[c - 'A']--;
                } else if (c >= 'a' && c <= 'z') {
                    alpha[c - 'a']--;
                }
            }

            int check = 1;
            for (int j = 0; j < 26; j++) {
                if (alpha[j] != 0) { // 일치하지 않는 게 하나라도 있다면 애너그램이 아님
                    check = 0;
                    break;
                }
            }
            if (check == 1) { // 모두 일치하므로 애너그램에 해당
                answer++;
            }
        }
        return answer;
    }
}
