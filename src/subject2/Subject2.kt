package subject2

/**
 * 2. 两数相加
 *
 * 给定两个非空链表来代表两个非负数，位数按照逆序方式存储，它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 示例：
 *     输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *     输出：7 -> 0 -> 8
 *     原因：342 + 465 = 807
 */
fun main(args: Array<String>) {
//    println(createRandomRectangle().isSquare)
    val l1 = ListNode(2)
    l1.next = ListNode(4)
    l1.next?.next = ListNode(3)

    val l2 = ListNode(5)
    l2.next = ListNode(6)
    l2.next?.next = ListNode(4)

    // 输出运算结果
    println(addTwoNumbers(l1, l2).toString())
}

class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null

    override fun toString(): String {
        return "[val=${`val`}, next=${next?.toString()}]"
    }
}

/**
 * 测试方法
 */
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val returnNodeHeader = ListNode()
    var p: ListNode? = returnNodeHeader

    // 进位
    var carry = 0
    var p1 = l1
    var p2 = l2
    while (p1 != null || p2 != null || carry != 0) {
        var numBit = (p1?.`val` ?: 0) + (p2?.`val` ?: 0) + carry
        if (numBit > 9) {
            carry = 1
            numBit %= 10
        } else {
            carry = 0
        }

        val newNode = ListNode(numBit)
        p?.next = newNode
        p = p?.next

        p1?.let { p1 = it.next }
        p2?.let { p2 = it.next }
    }

    return returnNodeHeader.next
}