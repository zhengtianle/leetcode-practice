package topInterviewQuestionsEasy.linkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-11-28
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/44/
 */
public class Four {
    /*遍历实现*/
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        ListNode head = new ListNode(0);  //作为头结点
        ListNode tempNode = head;  //作为临时节点，移动的末尾指针
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tempNode.next = l1;
                l1 = l1.next;
            } else{
                tempNode.next = l2;
                l2 = l2.next;
            }
            tempNode = tempNode.next;
        }

        if(l1 != null){
            tempNode.next = l1;
        }
        if(l2 != null){
            tempNode.next = l2;
        }

        return head.next;
    }

    /*递归实现*/
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            head.next = mergeTwoLists1(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists1(l1, l2.next);
        }

        return head;
    }


    /*打印测试*/
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
        ListNode listNode3 = new ListNode(4);

        ListNode listNode11 = new ListNode(1);
        ListNode listNode22 = new ListNode(3);
        ListNode listNode33 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        listNode11.next = listNode22;
        listNode22.next = listNode33;

        //printList(mergeTwoLists(listNode1,listNode11));
        printList(mergeTwoLists1(listNode1,listNode11));
    }
}
