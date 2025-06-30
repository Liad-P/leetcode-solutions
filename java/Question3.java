import java.util.Arrays;

// https://leetcode.com/problems/add-two-numbers/description/
public class Question3 {
    public static void main(String[] args) {
        Question3 q = new Question3();

        int[] input = new int[] { 2, 4, 3 };
        q.printLinkedList(q.intArrayToLinkedList(input));
        
        int[] l1 = new int[] { 2, 4, 3 };
        int[] l2 = new int[] { 5, 6, 4 };
        q.printLinkedList(q.addTwoNumbers(q.intArrayToLinkedList(l1), q.intArrayToLinkedList(l2)));

        l1 = new int[] { 0 };
        l2 = new int[] { 0 };
        q.printLinkedList(q.addTwoNumbers(q.intArrayToLinkedList(l1), q.intArrayToLinkedList(l2)));

        l1 = new int[] { 9, 9, 9, 9, 9, 9, 9 };
        l2 = new int[] { 9, 9, 9, 9 };
        q.printLinkedList(q.addTwoNumbers(q.intArrayToLinkedList(l1), q.intArrayToLinkedList(l2)));

        l1 = new int[] { 9 };
        l2 = new int[] { 9};
        q.printLinkedList(q.addTwoNumbers(q.intArrayToLinkedList(l1), q.intArrayToLinkedList(l2)));

    }

    public void printLinkedList(ListNode ln) {
        StringBuilder sb = new StringBuilder();
        while (ln != null) {
            sb.append(ln.val);
            ln = ln.next;
            if (ln == null) {
                break;
            }
            sb.append("->");
        }
        System.out.println(sb);

    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if ((l1 == null && l2 == null)) {
            return l1;
        }

        if (l1 == null || l2 == null) {
            ListNode tempNode = null;
            if (l1 == null) {
                tempNode = l2;
            } else {
                tempNode = l1;
            }

            if (tempNode.val > 9) {
                if (tempNode.next == null) {
                    tempNode.next = new ListNode(1);
                } else {
                    tempNode.next.val += 1;
                }
                tempNode.val = tempNode.val % 10;
            }

            return new ListNode(tempNode.val, addTwoNumbers(null, tempNode.next));
        } else {
            int sum = l1.val + l2.val;
            if (sum >= 10) {
                if (l1.next == null && l2.next == null) {
                    return new ListNode(sum % 10, new ListNode(1));
                }
                else if (l1.next == null) {
                    l2.next.val += 1;
                    return new ListNode(sum % 10, addTwoNumbers(l1.next, l2.next));
                } else {
                    l1.next.val += 1;
                    return new ListNode(sum % 10, addTwoNumbers(l1.next, l2.next));
                }
            } else {
                return new ListNode(sum, addTwoNumbers(l1.next, l2.next));
            }
        }
    }
    
    public ListNode intArrayToLinkedList(int[] intArray) {
        if (intArray.length == 1) {
            return new ListNode(intArray[0]);
        }
        return new ListNode(intArray[0], intArrayToLinkedList(Arrays.copyOfRange(intArray, 1, intArray.length)));

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
