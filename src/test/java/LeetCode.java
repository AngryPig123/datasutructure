import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

public class LeetCode {

    /**
     * 2 <= nums.length <= 104
     * -10^9 <= nums[i] <= 10^9
     * -10^9 <= target <= 10^9
     * Only one valid answer exists.
     */
    @Test
    public void twoSum() {  //  보수 관계 문제,   https://leetcode.com/problems/two-sum/description/
        Assert.assertArrayEquals(new int[]{0, 1}, this.twoSum(new int[]{2, 7, 11, 15}, 9));
        Assert.assertArrayEquals(new int[]{1, 2}, this.twoSum(new int[]{3, 2, 4}, 6));
        Assert.assertArrayEquals(new int[]{0, 1}, this.twoSum(new int[]{3, 3}, 6));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    /**
     * -231 <= x <= 231 - 1
     */
    @Test
    public void isPalindrome() {    //  while 문 + palindrome, https://leetcode.com/problems/palindrome-number/description/
        Assert.assertTrue(isPalindrome(121));
        Assert.assertFalse(isPalindrome(-121));
        Assert.assertFalse(isPalindrome(-10));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            int temp = 0;
            int copy = x;
            while (x != 0) {
                temp = (temp * 10) + (x % 10);
                x /= 10;
            }
            return copy == temp;
        }
    }

    /**
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * <p>
     * 'I': 1
     * 'V': 5
     * 'X': 10
     * 'L': 50
     * 'C': 100
     * 'D': 500
     * 'M': 1000
     */

    @Test
    public void romanToInt() {  //  https://leetcode.com/problems/roman-to-integer/
        Assert.assertEquals(3, romanToInt("III"));
        Assert.assertEquals(58, romanToInt("LVIII"));
        Assert.assertEquals(1994, romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int answer = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            int currentValue = map.get(currentChar);

            if (i < s.length() - 1 && currentValue < map.get(s.charAt(i + 1))) {
                answer -= currentValue;
            } else {
                answer += currentValue;
            }
        }
        return answer;
    }

    /**
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] consists of only lowercase English letters.
     */

    @Test
    public void longestCommonPrefix() { //  https://leetcode.com/problems/longest-common-prefix/
        Assert.assertEquals("fl", longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        Assert.assertEquals("", longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, Comparator.comparing(String::length));
        if (strs.length < 1 || strs[0].isEmpty()) return "";

        String answer = "";

        for (int i = 0; i < strs[0].length(); i++) {
            boolean valid = true;
            String str = String.valueOf(strs[0].charAt(i));
            for (int j = 1; j < strs.length; j++) {
                if (!str.equals(String.valueOf(strs[j].charAt(i)))) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                answer = answer + str;
            }
        }

        return answer;
    }


    /**
     * 1 <= s.length <= 104
     * s consists of parentheses only '()[]{}'.
     */
    @Test
    public void isValid() { //  stack,  https://leetcode.com/problems/valid-parentheses/description/
        Assert.assertTrue(isValid("()"));
        Assert.assertTrue(isValid("()[]{}"));
        Assert.assertFalse(isValid("(]"));
        Assert.assertTrue(isValid("{([]())}"));
        Assert.assertTrue(isValid("{([]())}"));
    }

    public boolean isValid(String s) {

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || map.get(stack.pop()) != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }


    /**
     * The number of nodes in both lists is in the range [0, 50].
     * -100 <= Node.val <= 100
     * Both list1 and list2 are sorted in non-decreasing order.
     */

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) { //  https://leetcode.com/problems/merge-two-sorted-lists/

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = new ListNode(list1.val);
                list1 = list1.next;
            } else if (list1.val > list2.val) {
                current.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                current.next = new ListNode(list1.val);
                current = current.next;
                current.next = new ListNode(list2.val);
                list1 = list1.next;
                list2 = list2.next;
            }
            current = current.next;
        }

        while (list1 != null) {
            current.next = new ListNode(list1.val);
            list1 = list1.next;
            current = current.next;
        }

        while (list2 != null) {
            current.next = new ListNode(list2.val);
            list2 = list2.next;
            current = current.next;
        }

        return dummy.next;

    }


    /**
     * 1 <= nums.length <= 3 * 104
     * -100 <= nums[i] <= 100
     * nums is sorted in non-decreasing order.
     */
    @Test
    public void removeDuplicates() {    //  https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
        Assertions.assertEquals(2, removeDuplicates(new int[]{1, 1, 2}));
        Assertions.assertEquals(5, removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int uniqueIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }
        return uniqueIndex + 1;
    }

    /**
     * 0 <= nums.length <= 100
     * 0 <= nums[i] <= 50
     * 0 <= val <= 100
     */
    @Test
    public void removeElement() {   //  https://leetcode.com/problems/remove-element/
        Assertions.assertEquals(2, removeElement(new int[]{3, 2, 2, 3}, 3));
        Assertions.assertEquals(5, removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
        Assertions.assertEquals(9, removeElement(new int[]{1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 2}, 2));
    }

    public int removeElement(int[] nums, int val) {
        int count = 0;
        int lastIndex = nums.length - 1;
        for (int i = 0; i < lastIndex; i++) {   //  해당 분기
            if (nums[i] == val) {
                if (nums[lastIndex] != val) {
                    nums[i] = nums[lastIndex];
                    nums[lastIndex] = val;
                    lastIndex--;
                } else {
                    lastIndex--;
                    i--;    //  해당 부분
                }
                count++;
            }
        }
        return nums.length - count;
    }

    /**
     * 1 <= haystack.length, needle.length <= 104
     * haystack and needle consist of only lowercase English characters.
     */
    @Test
    public void strStr() {  //  https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
        Assertions.assertEquals(0, strStr("sadbutsad", "sad"));
        Assertions.assertEquals(-1, strStr("leetcode", "leeto"));
    }

    public int strStr(String haystack, String needle) {
        if (haystack.contains(needle)) {
            return 0;
        } else {
            return -1;
        }
    }


    /**
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums contains distinct values sorted in ascending order.
     * -104 <= target <= 104
     */
    @Test
    public void searchInsert() {    //  https://leetcode.com/problems/search-insert-position/
        Assert.assertEquals(2, searchInsert(new int[]{1, 3, 5, 6}, 5));
        Assert.assertEquals(1, searchInsert(new int[]{1, 3, 5, 6}, 2));
        Assert.assertEquals(4, searchInsert(new int[]{1, 3, 5, 6}, 7));
    }

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }


    /**
     *
     */
    @Test
    public void lengthOfLastWord() {    //  https://leetcode.com/problems/length-of-last-word/
        Assert.assertEquals(5, lengthOfLastWord("Hello World"));
        Assert.assertEquals(4, lengthOfLastWord("   fly me   to   the moon  "));
        Assert.assertEquals(6, lengthOfLastWord("luffy is still joyboy"));
    }

    public int lengthOfLastWord(String s) {
        int temp = 0;
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                temp = 0;
            } else {
                temp = temp + 1;
                answer = temp;
            }
        }
        return answer;
    }

    /**
     * 1 <= digits.length <= 100
     * 0 <= digits[i] <= 9
     * digits does not contain any leading 0's.
     */
    @Test
    public void plusOne() { //  https://leetcode.com/problems/plus-one/description/
        Assert.assertArrayEquals(new int[]{1, 2, 4}, plusOne(new int[]{1, 2, 3}));
        Assert.assertArrayEquals(new int[]{4, 3, 2, 2}, plusOne(new int[]{4, 3, 2, 1}));
        Assert.assertArrayEquals(new int[]{1, 0}, plusOne(new int[]{9}));
        Assert.assertArrayEquals(new int[]{1, 0, 0, 0}, plusOne(new int[]{9, 9, 9}));
        Assert.assertArrayEquals(new int[]{9, 8, 9}, plusOne(new int[]{9, 8, 8}));
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 == 10) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    /**
     * 1 <= a.length, b.length <= 104
     * a and b consist only of '0' or '1' characters.
     * Each string does not contain leading zeros except for the zero itself.
     * <p>
     * & : AND 연산 (논리곱)
     * 두 비트가 모두 1일 때만 결과가 1이 됩니다.
     * <p>
     * | : OR 연산 (논리합)
     * 두 비트 중 하나 이상이 1이면 결과가 1이 됩니다.
     * <p>
     * ^ : XOR 연산 (배타적 논리합)
     * 두 비트가 서로 다르면 결과가 1이 됩니다.
     * <p>
     * ~ : NOT 연산 (논리 부정)
     * 비트를 반전시킵니다. 1은 0으로, 0은 1로 변합니다.
     * <p>
     * << : 왼쪽 시프트 연산
     * 비트를 왼쪽으로 이동시킵니다.
     * <p>
     * >> : 오른쪽 시프트 연산 (부호 있는 오른쪽 시프트)
     * 비트를 오른쪽으로 이동시키고 부호 비트를 유지합니다.
     * <p>
     * >>> : 오른쪽 시프트 연산 (부호 없는 오른쪽 시프트)
     * 비트를 오른쪽으로 이동시키고 부호 비트를 0으로 채웁니다.
     */
    @Test
    public void addBinary() {   //  https://leetcode.com/problems/add-binary/,  비트연산.
        Assert.assertEquals("100", addBinary("11", "1"));
        Assert.assertEquals("10101", addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        char temp = '0';
        StringBuilder answer = new StringBuilder();

        int maxLength = Math.max(a.length(), b.length());
        for (int i = 0; i < maxLength; i++) {
            char aChar = (i < a.length()) ? a.charAt(a.length() - 1 - i) : '0';
            char bChar = (i < b.length()) ? b.charAt(b.length() - 1 - i) : '0';
            char sum = (char) (aChar ^ bChar ^ temp);
            temp = (char) ((aChar & bChar) | (temp & (aChar ^ bChar)));
            answer.insert(0, sum);
        }
        if (temp == '1') answer.insert(0, '1');

        return answer.toString();
    }


    /**
     * 0 <= x <= 231 - 1
     */
    @Test
    public void mySqrt() {  //  https://leetcode.com/problems/sqrtx/description/
        Assert.assertEquals(10, mySqrt(101));
    }

    public int mySqrt(int x) {
        if (x == 1) return 1;
        int left = 1, right = x / 2, result = 0;
        while (left <= right) {
            int value = left + (right - left) / 2;
            if (value == x / value) {
                return value;
            } else if (value < x / value) {
                left = value + 1;
                result = value;
            } else {
                right = value - 1;
            }
        }
        return result;
    }

    /**
     * 1 <= n <= 45
     */
    @Test
    public void climbStairs() { //  https://leetcode.com/problems/climbing-stairs/
        Assert.assertEquals(2, climbStairs(2));
        Assert.assertEquals(3, climbStairs(3));
        Assert.assertEquals(5, climbStairs(4));
        Assert.assertEquals(8, climbStairs(5));
        Assert.assertEquals(13, climbStairs(6));
    }

    public int climbStairs(int n) {
        int[] answer = new int[n + 1];
        answer[0] = 1;
        answer[1] = 1;
        for (int i = 2; i <= n; i++) {
            answer[i] = answer[i - 1] + answer[i - 2];
        }
        return answer[n];
    }

    /**
     * The number of nodes in the list is in the range [0, 300].
     * -100 <= Node.val <= 100
     * The list is guaranteed to be sorted in ascending order.
     */
    @Test
    public void deleteDuplicates() {    //  https://leetcode.com/problems/remove-duplicates-from-sorted-list/

        ListNode confirmNode = new ListNode(1);
        confirmNode.next = new ListNode(1);
        confirmNode.next.next = new ListNode(2);
        confirmNode.next.next.next = new ListNode(3);
        confirmNode.next.next.next.next = new ListNode(3);

        deleteDuplicates(confirmNode);

    }

    public ListNode deleteDuplicates(ListNode head) {   //  1,1,2,3,3

        return null;
    }

    @Test
    public void testtt() {
        int[] sort = new int[]{7, 1, 3, 2};
        Assert.assertArrayEquals(new int[]{1, 2, 3, 7}, sorting(sort));
    }

    public int[] sorting(int[] target) {



        return target;
    }

}
