import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[]{"119", "97674223", "1195524421" }));
    }

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i; j < phone_book.length; j++) {
                if (phone_book[j].startsWith(phone_book[i])) return false;
            }
        }
        return true;
    }
}
