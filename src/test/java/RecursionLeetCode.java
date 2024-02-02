import org.junit.jupiter.api.Test;

public class RecursionLeetCode {


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

        void add(int val){
            ListNode newNode = new ListNode(val);
            ListNode current = this;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }
    }

    /**
     * Merge Two Sorted Lists
     * <p>
     * Input: list1 = [1,2,4], list2 = [1,3,4]
     * Output: [1,1,2,3,4,4]
     * <p>
     * https://leetcode.com/problems/merge-two-sorted-lists/
     */

    @Test
    public void mergeTwoLists(){
        ListNode node1 = new ListNode();
        node1.add(1);
        node1.add(2);
        node1.add(4);
        ListNode node2 = new ListNode();
        node2.add(1);
        node2.add(3);
        node2.add(4);
        ListNode listNode = mergeTwoLists(node1, node2);
        while (listNode != null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode answer = new ListNode();
        if (list1 == null && list2 == null) return null;
        mergeTwoListsHelper(list1, list2, answer);
        return answer.next;
    }

    public void mergeTwoListsHelper(ListNode list1, ListNode list2, ListNode answer) {
        ListNode current = answer;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
    }

}
