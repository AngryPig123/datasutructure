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
    }   //  ToDO


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
     * Binary Tree Inorder Traversal
     * The number of nodes in the tree is in the range [0, 100].
     * -100 <= Node.val <= 100
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {  //  https://leetcode.com/problems/binary-tree-inorder-traversal/description/
        List<Integer> returnList = new ArrayList<>();
        helper(root, returnList);
        return returnList;
    }

    public void helper(TreeNode root, List<Integer> answer) {
        if (root != null) {
            inorderTraversal(root.left);
            answer.add(root.val);
            inorderTraversal(root.right);
        }
    }


    /**
     * Same Tree
     * <p>
     * The number of nodes in both trees is in the range [0, 100].
     * -104 <= Node.val <= 104
     */
    public boolean isSameTree(TreeNode p, TreeNode q) { //  https://leetcode.com/problems/same-tree/
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    /**
     * Symmetric Tree
     * <p>
     * The number of nodes in the tree is in the range [1, 1000].
     * -100 <= Node.val <= 100
     */
    public boolean isSymmetric(TreeNode root) { //  https://leetcode.com/problems/symmetric-tree/
        return isSymmetricHelper(root, root);
    }

    public boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return (left.val == right.val) && isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }

    /**
     * Maximum Depth of Binary Tree
     * <p>
     * The number of nodes in the tree is in the range [0, 104].
     * -100 <= Node.val <= 100
     */
    public int maxDepth(TreeNode root) {    //  https://leetcode.com/problems/maximum-depth-of-binary-tree/
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * Convert Sorted Array to Binary Search Tree
     * <p>
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums is sorted in a strictly increasing order.
     */

    public TreeNode sortedArrayToBST(int[] nums) {  //  ToDO, https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/solutions/4027619/easy-solution/
        return null;
    }

    /**
     * Merge Sorted Array
     * <p>
     * nums1.length == m + n
     * nums2.length == n
     * 0 <= m, n <= 200
     * 1 <= m + n <= 200
     * -109 <= nums1[i], nums2[j] <= 109
     */

    public void merge(int[] nums1, int m, int[] nums2, int n) { //  https://leetcode.com/problems/merge-sorted-array/
        for (int j = 0, i = m; j < n; j++, i++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
    }

    /**
     * Pascal's Triangle
     * <p>
     * 1 <= numRows <= 30
     */
    public List<List<Integer>> generate(int numRows) {
        return null;
    }   //  ToDO


    /**
     * Valid Palindrome
     * <p>
     * 1 <= s.length <= 2 * 105
     * s consists only of printable ASCII characters.
     */
    @Test
    public void validPalindrome() { //  https://leetcode.com/problems/valid-palindrome/
        System.out.println("123노형욱21".toUpperCase());

        System.out.println((int) 'A');

        Assertions.assertTrue(validPalindrome("0P"));
    }

    public boolean validPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            add(charAt, sb);
        }
        return sb.toString().contentEquals(new StringBuilder(sb).reverse());
    }

    private void add(char charAt, StringBuilder sb) {
        if (65 <= charAt && charAt <= 90) {
            charAt = (char) (charAt + 32);
            sb.append(charAt);
        } else if (97 <= charAt && charAt <= 122) {
            sb.append(charAt);
        } else if (48 <= charAt && charAt <= 57) {
            sb.append(charAt);
        }
    }


    /**
     * Excel Sheet Column Title
     * <p>
     * 1 <= columnNumber <= 231 - 1
     */
    public String convertToTitle(int columnNumber) {    //  https://leetcode.com/problems/excel-sheet-column-title/
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            char charAt = (char) ((columnNumber - 1) % 26 + 'A');
            sb.insert(0, charAt);
            columnNumber = (columnNumber - 1) / 26;
        }
        return sb.toString();
    }


    /**
     * Reverse String
     * 공간 복잡도 : O(1)
     */
    public void reverseString(char[] s) {
        int right = s.length - 1;
        int left = 0;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * Longest Common Prefix
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (String str : strs) {
            while (str.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    /**
     * Repeated DNS Sequences
     * https://leetcode.com/problems/repeated-dna-sequences/
     */
    @Test
    public void findRepeatedDnaSequences() {
        Assertions.assertEquals(List.of("AAAAACCCCC", "CCCCCAAAAA"), findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        Assertions.assertEquals(List.of("AAAAAAAAAA"), findRepeatedDnaSequences("AAAAAAAAAAA"));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);
            if (map.containsKey(substring)) {
                map.put(substring, map.get(substring) + 1);
            } else {
                map.put(substring, 1);
            }
        }
        List<String> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                answer.add(entry.getKey());
            }
        }
        return answer;
    }


    /**
     * Valid Anagram
     * https://leetcode.com/problems/valid-anagram/
     */
    @Test
    public void validAnagram() {

        Assertions.assertTrue(isAnagram("anagram", "naagram"));
        Assertions.assertFalse(isAnagram("rat", "car"));

    }

    public boolean isAnagram(String s, String t) {
        char[] str1 = s.toCharArray();
        Arrays.sort(str1);
        char[] str2 = t.toCharArray();
        Arrays.sort(str2);
        return new String(str1).equals(new String(str2));
    }

    /**
     * Logest Palindromic Substring
     * https://www.udemy.com/course/leetcode-coding-interview-question-solution-explanation/learn/lecture/21250474?start=45#overview
     */
    public String logestPalindromicSubstring(String str) {
        String answer = "";
        Map<String, Integer> maps = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {

        }
        return answer;
    }   //  ToDO

    /**
     * Excel Sheet Column Number
     * https://leetcode.com/problems/excel-sheet-column-number/description/
     */
    @Test
    public void titleToNumber() {
        Assertions.assertEquals(1, titleToNumber("A"));
        Assertions.assertEquals(28, titleToNumber("AB"));
        Assertions.assertEquals(701, titleToNumber("ZY"));
    }

    public int titleToNumber(String columnTitle) {
        int answer = 0;
        int temp = 0;
        while (temp < columnTitle.length()) {
            int value = columnTitle.charAt(temp) - 64;
            answer = (answer * 26) + (value);
            temp = temp + 1;
        }
        return answer;
    }

    /**
     * Isomorphic Strings
     * https://leetcode.com/problems/isomorphic-strings/description/
     */
    @Test
    public void isIsomorphic() {
        Assertions.assertTrue(isIsomorphic("egg", "add"));
        Assertions.assertFalse(isIsomorphic("foo", "bar"));
        Assertions.assertTrue(isIsomorphic("paper", "title"));
    }

    public boolean isIsomorphic(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            s = s.replace(s.charAt(i), (char) ((char) 44032 + i));
            t = t.replace(t.charAt(i), (char) ((char) 44032 + i));
        }
        return s.equals(t);
    }

    /**
     * Word Pattern
     * https://leetcode.com/problems/word-pattern/description/
     */
    @Test
    public void wordPattern() {
        Assertions.assertTrue(wordPattern("abba", "dog cat cat dog"));
        Assertions.assertFalse(wordPattern("abba", "dog cat cat fish"));
        Assertions.assertFalse(wordPattern("aaaa", "dog cat cat dog"));
        Assertions.assertFalse(wordPattern("abba", "dog dog dog dog"));
    }

    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        Map<Character, String> maps = new HashMap<>();
        if (pattern.length() != split.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char charAt = pattern.charAt(i);
            if (!maps.containsKey(charAt)) {
                if (maps.containsValue(split[i])) {
                    return false;
                }
                maps.put(pattern.charAt(i), split[i]);
            } else {

                if (!maps.get(charAt).equals(split[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Reverse Vowels of a String
     * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
     */
    @Test
    public void reverseVowels() {
        Assertions.assertEquals("holle", reverseVowels("hello"));
    }

    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        List<Character> vowelsList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (vowels.contains(String.valueOf(charAt))) {
                vowelsList.add(charAt);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (vowels.contains(String.valueOf(charAt))) {
                int last = vowelsList.size() - 1;
                sb.append(vowelsList.get(last));
                vowelsList.remove(last);
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    /**
     * Ransom Note
     * https://leetcode.com/problems/ransom-note/description/
     */
    @Test
    public void canConstruct() {
        Assertions.assertFalse(canConstruct("a", "b"));
        Assertions.assertFalse(canConstruct("aa", "bb"));
        Assertions.assertTrue(canConstruct("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> maps = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char charAt = magazine.charAt(i);
            if (!maps.containsKey(charAt)) {
                maps.put(charAt, 1);
            } else {
                maps.put(charAt, maps.get(charAt) + 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char charAt = ransomNote.charAt(i);
            if (!maps.containsKey(charAt)) {
                return false;
            } else {
                int value = maps.get(charAt);
                if (value > 0) {
                    maps.put(charAt, value - 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * First Unique Character in a String
     * https://leetcode.com/problems/first-unique-character-in-a-string/description/
     */
    @Test
    public void firstUniqChar() {
        Assertions.assertEquals(0, firstUniqChar("leetcode"));
        Assertions.assertEquals(2, firstUniqChar("loveleetcode"));
        Assertions.assertEquals(-1, firstUniqChar("aabb"));
    }

    public int firstUniqChar(String s) {
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int charAt = s.charAt(i) - 'a';
            array[charAt]++;
        }
        for (int i = 0; i < s.length(); i++) {
            int charAt = s.charAt(i) - 'a';
            if (array[charAt] == 1) return i;
        }
        return -1;
    }

    /**
     * Find the Difference
     * https://leetcode.com/problems/find-the-difference/description/
     */
    @Test
    public void findTheDifference() {
        Assertions.assertEquals('e', findTheDifference("abcd", "abcde"));
        Assertions.assertEquals('y', findTheDifference("", "y"));
    }

    public char findTheDifference(String s, String t) {
        int[] array1 = new int[26];
        int[] array2 = new int[26];
        if (s.isEmpty()) return t.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            array1[t.charAt(i) - 'a']++;
            array2[s.charAt(i) - 'a']++;
            if (i == s.length() - 1) {
                array1[t.charAt(i + 1) - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (array2[i] - array1[i] < 0) {
                return (char) (i + 'a');
            }
        }
        return ' ';
    }

    /**
     * Binary Search
     * https://leetcode.com/problems/binary-search/description/
     * 시간 복잡도  O(log n)
     */
    @Test
    public void binarySearch() {
        Assertions.assertEquals(4, binarySearch(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        Assertions.assertEquals(-1, binarySearch(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        Assertions.assertEquals(1, binarySearch(new int[]{2, 5}, 5));
    }

    public int binarySearch(int[] nums, int target) {
        int length = nums.length;
        if (length == 1 && nums[0] == target) {
            return 0;
        }
        int l = 0;
        int r = length - 1;
        while (r >= l) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Unique Binary Search Trees
     * https://leetcode.com/problems/unique-binary-search-trees/description/
     */
    @Test
    public void numTrees() {

    }

    public int numTrees(int n) {
        return (int) Math.pow(2d, n) - n;
    }   //  ToDO

}




