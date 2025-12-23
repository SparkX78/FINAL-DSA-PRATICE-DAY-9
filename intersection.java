public class intersection {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode intersection_with(ListNode l1, ListNode l2) {
        int len1 = getLength(l1);
        int len2 = getLength(l2);

        ListNode headA = l1;
        ListNode headB = l2;

        // Align both lists
        while (len1 > len2) {
            headA = headA.next;
            len1--;
        }
        while (len2 > len1) {
            headB = headB.next;
            len2--;
        }

        // Traverse together
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA; // either intersection node or null
    }

    private static int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static void main(String[] args) {
        // Create first list: 1 -> 2 -> 3 -> 4
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode common = new ListNode(3);
        common.next = new ListNode(4);
        l1.next.next = common;

        // Create second list: 5 -> 3 -> 4 (sharing same nodes!)
        ListNode l2 = new ListNode(5);
        l2.next = common;

        ListNode result = intersection_with(l1, l2);
        if (result != null) {
            System.out.println("Intersection at node with value: " + result.val);
        } else {
            System.out.println("No intersection");
        }
    }
}
