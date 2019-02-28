package codingInterviews;

import java.util.HashMap;
import java.util.Map;
/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-2-28
 * @Author ZhengTianle
 * Description:
 * 复杂链表的复制
 * https://www.nowcoder.com/practice/f836b2c43afc4b35ad6adc41ec941dba?tpId=13&tqId=11178&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 */
public class TwentyFive {
    /**
     * 哈希法：
     * 先遍历一次，复制一个直链(只复制next)
     * 遍历过程中建立旧节点->新节点的映射
     * 再次遍历旧链表，复制random，通过map.get(oldHead.random)获得新链表的random节点
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) {
            return null;
        }
        RandomListNode head = new RandomListNode(0);//头结点
        RandomListNode newHead = head;//遍历指针
        Map<RandomListNode, RandomListNode> map = new HashMap<>();//存储新旧链表节点的对应关系 旧->新
        RandomListNode oldHead = pHead;
        //按照next遍历复制普通链表
        while(oldHead != null) {
            RandomListNode node = new RandomListNode(oldHead.label);
            map.put(oldHead, node);//建立旧->新映射关系
            newHead.next = node;
            newHead = node;
            oldHead = oldHead.next;
        }
        //复制random
        newHead = head.next;
        oldHead = pHead;
        while(oldHead != null) {
            newHead.random = map.get(oldHead.random);
            oldHead = oldHead.next;
            newHead = newHead.next;
        }
        return head.next;
    }

    /**
     * 1.遍历链表在每个节点后面插入当前节点的复制节点，例如：旧链表为a->b->c 变为a->a'->b->b'->c->c'
     * 2.遍历改变后的链表，参照旧链表中节点的random将其下一个节点的random指向旧链表的random节点的下一个节点
     * 3.拆分链表，奇数节点为旧链表，偶数节点为复制的新链表
     */
    public RandomListNode Clone1(RandomListNode pHead) {
        if(pHead == null) {
            return null;
        }
        //第一步
        RandomListNode head = pHead;
        RandomListNode p = null;
        while(head != null) {
            p = head.next;
            RandomListNode tmp = new RandomListNode(head.label);
            head.next = tmp;
            tmp.next = p;
            head = p;
        }

        //第二步
        head = pHead;
        while(head.next != null) {
            head.next.random = head.random == null?null:head.random.next;
            head = head.next.next;
        }

        //第三步
        p = pHead;
        RandomListNode newHead = pHead.next;
        RandomListNode tmp = null;
        while(p != null) {
            tmp = p.next;
            p.next = tmp.next;
            tmp.next = tmp.next==null?null:tmp.next.next;
            p = p.next;
        }
        return newHead;
    }
}
