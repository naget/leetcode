package addTwoNumbers;

/**
 * created by tianfeng on 2019/7/28
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 版本：1
 * 状态：通过
 * 思路：一位一位的加，注意进位就可以了。
 * 注意(代码中的坑)：
 * ①比如答案是345，我代码中构建出的就是3->4->5,而题目要求5->4->3，所以return时进行了
 * 一步反转链表。
 * ②getNumberOfindex是个多余的方法，最终没有用
 * ③代码看起来复杂
 *
 * 优点：简单修改就可以完成拓展（数字顺序存储）
 */
public class Version1 {
    
      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
     
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode l1r = l1;
            ListNode l2r = l2;
            ListNode result = new ListNode(0);
            int x = 0;
            while (true) {
                int tem = l1r.val + l2r.val + x;
                x = 0;
                if (tem > 9) {
                    int one = tem % 10;
                    result.val = one;
                    l1r = l1r.next;
                    l2r = l2r.next;
                    x = 1;
                    if (l1r == null && l2r == null) break;
                    if (l1r == null) l1r = new ListNode(0);
                    if (l2r == null) l2r = new ListNode(0);
                    ListNode nresult = new ListNode(0);
                    nresult.next = result;
                    result = nresult;


                } else {
                    result.val = tem;
                    ListNode nresult = new ListNode(0);
                    nresult.next = result;
                    result = nresult;
                    l1r = l1r.next;
                    l2r = l2r.next;
                    if (l1r == null && l2r == null) break;
                    if (l1r == null) l1r = new ListNode(0);
                    if (l2r == null) l2r = new ListNode(0);
                }
            }


            if (x != 0) {
                ListNode nresult = new ListNode(x);
                nresult.next = result;
                result = nresult;
            }
            while (result != null && result.val == 0) result = result.next;
            if (result == null) result = new ListNode(0);
            return revertLink(result);
        }

        private int getNumberOfindex(int number, int index) {
            int left = number & ((int) Math.pow(10, index) - 1);
            return left / (int) Math.pow(10, index - 1);
        }

        private ListNode revertLink(ListNode l) {
            ListNode current = l;
            ListNode next = l.next;
            l.next = null;
            return revertCore(current, next);
        }

        private ListNode revertCore(ListNode pre, ListNode curr) {
            if (curr == null) return pre;
            ListNode next = curr.next;
            curr.next = pre;
            return revertCore(curr, next);
        }
    }
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(7);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode fix = new ListNode(6);

        one.next = two;
        two.next = three;
        four.next = five;
        five.next = fix;

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(one,four);
        while (result!=null){
            System.out.print(result.val);
            result = result.next;
        }
    }
}
