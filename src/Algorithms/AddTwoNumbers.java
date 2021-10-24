package Algorithms;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 * <p>
 * 2. Add Two Numbers
 */
public class AddTwoNumbers {

    public class ListNode {
      int val;
      ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode curr = null;
        ListNode l1Curr = l1, l2Curr = l2;
        int cary = 0;
        while (l1Curr != null || l2Curr != null) {

            int resultVal = 0;
            if (l1Curr != null) {
                resultVal = resultVal + l1Curr.val;
                l1Curr = l1Curr.next;
            }
            if (l2Curr != null) {
                resultVal = resultVal + l2Curr.val;
                l2Curr = l2Curr.next;
            }

            if (cary != 0) {
                resultVal = resultVal + cary;
            }

            int newCary = resultVal / 10;
            resultVal = resultVal % 10;
            cary = newCary;
            if (head == null) {
                System.out.println("Here 1");
                head = new ListNode(resultVal);
                head.next = null;
                curr = head;
            } else {
                System.out.println("Here 2");
                curr.next = new ListNode(resultVal);
                curr.next.next = null;
                curr = curr.next;
            }
        }

        if (cary != 0) {
            System.out.println("Here 3");
            curr = new ListNode(cary);
            curr.next = null;
        }
        System.out.println(head.next);
        return head;
    }

}
