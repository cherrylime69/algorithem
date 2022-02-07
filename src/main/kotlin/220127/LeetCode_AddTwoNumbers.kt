package `220127`

fun main() {
    val a = ListNode(2)
    a.apply {this.next = ListNode(4)}
    val b = ListNode(5)
    b.apply {this.next = ListNode(6)}
    val s = Solution()
    println(s.addTwoNumbers(a,b)!!.`val`)

}


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var result:ListNode? = ListNode(0)
        val listOfVal = arrayListOf<Int>()
        var l1 = l1
        var l2 = l2
        var plus = false

        if ((l1!!.next == null) && (l2!!.next == null)) {
            return result
        }

        while ((l1!!.next != null) && (l2!!.next != null)) {
            result!!.`val` = l1.`val` + l2.`val`

            if (plus) {
                result.`val` += + 1
                plus = false
            }

            if (result.`val` >= 10) {
                result.`val` %= 10
                plus = true
            }

            l1 = if (l1.next != null) l1.next else ListNode(0)
            l2 = if (l2.next != null) l2.next else ListNode(0)
            //TODO val 값들을 배열로 만들자.
        }


        return result
    }
}