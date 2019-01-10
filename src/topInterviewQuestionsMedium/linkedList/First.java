package topInterviewQuestionsMedium.linkedList;

import sun.reflect.generics.tree.Tree;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-12-11
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/31/linked-list/82/
 * 两数相加
 */
public class First {
    /*有的链表非常长，long类型根本放不下*/
    /*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long number1 = listToNum(l1);
        long number2 = listToNum(l2);
        number1 = number1 + number2;
        ListNode head = new ListNode((int) (number1 % 10));
        ListNode temp = head;
        ListNode p = null;
        number1 = number1 / 10;
        while(number1 != 0){
            p = new ListNode((int) (number1 % 10));
            p.next = null;
            temp.next = p;
            temp = p;
            number1 = number1 / 10;
        }
        return head;
    }
    public long listToNum(ListNode l){
        long i = 1;
        long number = 0;
        while(l != null){
            number += l.val * i;
            l = l.next;
            i *= 10;
        }
        return number;
    }*/

    /*leetcode报错：error: cannot find symbol: class BigInteger
    * 可能不允许使用大数*/
    /*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger bigInteger1 = new BigInteger(listToNum(l1));
        BigInteger bigInteger2 = new BigInteger(listToNum(l2));
        bigInteger1 = bigInteger1.add(bigInteger2);
        BigInteger ten = new BigInteger("10");
        ListNode head = new ListNode(bigInteger1.mod(ten).intValue());
        ListNode temp = head;
        ListNode p = null;
        bigInteger1 = bigInteger1.divide(ten);
        while(bigInteger1.signum() != 1 || bigInteger1.intValue() != 0){
            p = new ListNode(bigInteger1.mod(ten).intValue());
            p.next = null;
            temp.next = p;
            temp = p;
            bigInteger1 = bigInteger1.divide(ten);
        }
        return head;
    }
    public String listToNum(ListNode l){
        StringBuilder number = new StringBuilder();
        while(l != null){
            number.append(l.val);
            l = l.next;
        }
        return number.toString();
    }*/

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;       //头结点
        ListNode temp = null;       //移动指针
        int carry = 0;              //进位
        int num;
        while(l1 != null || l2 != null || carry != 0){
            num = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = num / 10;

            ListNode listNode = new ListNode(num % 10);
            if(head == null){
                temp = listNode;
                head = temp;
            } else {
                temp.next = listNode;
                temp = temp.next;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return head;
    }

}
