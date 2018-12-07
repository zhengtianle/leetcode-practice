package topInterviewQuestionsEasy.linkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-11-19
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/43/
 */
public class Third {

    /*耗时多、耗空间多*/
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

    /*耗时少、占空间少，只额外增加了标签，没有增加内存*/
    public static ListNode reverseList1(ListNode head){
        if(head == null)
            return null;

        ListNode listNode = head;
        head = head.next;
        listNode.next = null;
        while(head != null){
            ListNode listNode1 = head;
            head = head.next;
            listNode1.next = listNode;
            listNode = listNode1;
        }
        return listNode;
    }

    /*递归实现*/
    public static ListNode reverseList2(ListNode head){
        if(head == null || head.next == null)//链表为空直接返回，而head->next为空是递归终点
            return head;
        ListNode listNode =  reverseList2(head.next);//一直递归到链尾
        head.next.next = head;//翻转链表指向
        head.next = null;//防止环形链表
        return listNode;//返回当前翻转链表的头
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
        printList(reverseList2(listNode1));
    }
}
