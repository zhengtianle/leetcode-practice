package linkedList;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-11-30
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/45/
 */
public class Five {

    public static boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;

        //找出中心节点
        ListNode node1 = head;
        ListNode node2 = head;  //循环完毕node2指向链表中心节点
        while(node1 != null && node1.next != null){
            node1 = node1.next.next;
            node2 = node2.next;
        }

        //翻转从node2之后的节点
        node1 = node2;      //翻转后的头结点
        node2 = node2.next;
        node1.next = null;
        ListNode tempNode;
        while(node2 != null){
            tempNode = node2;
            node2 = node2.next;
            tempNode.next = node1;
            node1 = tempNode;
        }

        //比较
        while(node1 != null){
            if(node1.val != head.val){
                return false;
            }
            head = head.next;
            node1 = node1.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        System.out.println(isPalindrome(listNode1));
    }
}
