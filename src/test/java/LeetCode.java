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

}
