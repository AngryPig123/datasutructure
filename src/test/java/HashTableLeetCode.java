import org.example.datastructuresandalgorithms.hash.HashTable;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class HashTableLeetCode {


    @Test
    public void itemInCommon() {
        Assertions.assertTrue(itemInCommon(new int[]{1, 2, 3}, new int[]{3, 4, 5}));
    }

    public boolean itemInCommon(int[] arr1, int[] arr2) {
        HashMap<Integer, Boolean> maps = new HashMap<>();
        for (int j : arr1) {
            maps.put(j, true);
        }
        for (int j : arr2) {
            if (maps.get(j) != null) {
                return true;
            }
        }
        return false;
    }


    @Test
    public void findDuplicates() {
        System.out.println(findDuplicates(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5}));
    }

    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Integer> maps = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        for (int num : nums) {
            maps.put(num, maps.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : maps.entrySet()) {
            if (entry.getValue() > 1) {
                answer.add(entry.getKey());
            }
        }
        return answer;
    }

    @Test
    public void firstNonRepeatingChar() {
        Assertions.assertEquals('l', firstNonRepeatingChar("leetcode"));
        Assertions.assertEquals('h', firstNonRepeatingChar("hello"));
        Assertions.assertNull(firstNonRepeatingChar("aabbcc"));
    }

    public Character firstNonRepeatingChar(String str) {
        HashMap<Character, Integer> maps = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            maps.put(c, maps.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (maps.get(str.charAt(i)) == 1) {
            }
            return str.charAt(i);
        }
        return null;
    }


    //  ToDO https://www.udemy.com/course/data-structures-and-algorithms-java/learn/quiz/5829434#content
    @Test
    public void groupAnagrams() {

    }

    public List<List<String>> groupAnagrams(String[] strings) {
        return null;
    }

}
