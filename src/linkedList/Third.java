package linkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-11-19
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/43/
 */
public class Third {

    public static ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode listNode = new ListNode(head.val);
        head = head.next;
        while(head != null){
            ListNode p = new ListNode(head.val);
            p.next = listNode;
            listNode = p;
            head = head.next;
        }
        return listNode;
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        printList(reverseList(listNode1));
    }
}
