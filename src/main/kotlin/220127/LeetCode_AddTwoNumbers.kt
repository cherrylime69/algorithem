package `220127`

fun main() {
    val a = ListNode(9)
    a.apply {this.next = ListNode(4).apply {this.next = ListNode(3)}}
    val b = ListNode(9)
    b.apply {this.next = ListNode(6).apply {this.next = ListNode(4)}}
    val s = Solution()
//    s.addTwoNumbers(a,b)

    val c = ListNode(0)
    val d = ListNode(1)
    s.addTwoNumbers(c,d)

}


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var l1 = l1
        var l2 = l2
        var v1 = l1!!.`val`
        var v2 = l2!!.`val`
        val result = arrayListOf<ListNode?>()
        var plus = false

        if ((v1 == 0) && (v2 == 0)) return ListNode(0)

        while (((v1 != 0) && (v2 != 0)) || plus) {
            println("안녕나")
            var `val` = v1 + v2

            if (plus) {
                `val` += 1
                plus = false
            }

            if (`val` >= 10) {
                `val` %= 10
                plus = true
            }

            l1 = if (l1!!.next != null) l1.next else ListNode(0)
            l2 = if (l2!!.next != null) l2.next else ListNode(0)
            v1 = l1!!.`val`
            v2 = l2!!.`val`
            println("안녕나")
            println(`val`)
            result.add(ListNode(`val`))
        }
        println(result.size)

        for (i in result.indices) {
            if (result.size == 1) {
                println("여기아나?")
                return result[i]
            }
            if (i==result.size-1) break
            result[i]?.next = result[i+1]
        }

        return ListNode(0)
    }
}