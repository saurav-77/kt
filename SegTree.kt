import java.util.function.BinaryOperator

class SegTree(val MAX: Int, val op: BinaryOperator<Long>, val E: Long) {
    val N: Int
    var seg: Array<Long>

    init {
        var k = 1
        while (k < MAX) {
            k = k shl 1
        }
        this.N = k
        seg = Array<Long>(N * 2) { E }

    }
    constructor(dat: Array<kotlin.Long>, op: BinaryOperator<kotlin.Long>, e: kotlin.Long) : this(dat.size, op, e) {
        build(dat)
    }

    private fun build(dat: Array<Long>) {
        val l = dat.size
        System.arraycopy(dat, 0, seg, N, l)
        for (i in N - 1 downTo 1) {
            seg[i] = op.apply(seg[i shl 1 or 0], seg[i shl 1 or 1])
        }
    }

    fun add(P: Int, x: Long) {
        var p = P + N;
        exclusiveRangeCheck(P)
        seg[p] += x
        p = p shr 1
        while (p > 0) {
            seg[p] = op.apply(seg[p shl 1 or 0], seg[p shl 1 or 1])
            p = p shr 1
        }
    }

    fun set(P: Int, x: Long) {
        var p = P + N;
        exclusiveRangeCheck(P)
        seg[p] = x
        p = p shr 1
        while (p > 0) {
            seg[p] = op.apply(seg[p shl 1 or 0], seg[p shl 1 or 1])
            p = p shr 1
        }
    }

    fun get(p: Int): Long {
        exclusiveRangeCheck(p)
        return seg[p + N]
    }

    fun prod(l: Int, r: Int): Long {
        var l = l
        var r = r
        require(l <= r) { String.format("Invalid range: [%d, %d)", l, r) }
        inclusiveRangeCheck(l)
        inclusiveRangeCheck(r)
        var sumLeft = E
        var sumRight = E
        l += N
        r += N
        while (l < r) {
            if ((l and 1) == 1) sumLeft = op.apply(sumLeft, seg[l++])
            if ((r and 1) == 1) sumRight = op.apply(seg[--r], sumRight)
            l = l shr 1
            r = r shr 1
        }
        return op.apply(sumLeft, sumRight)
    }


    private fun exclusiveRangeCheck(p: Int) {
        if (p < 0 || p >= MAX) {
            throw IndexOutOfBoundsException(
                String.format("Index %d out of bounds for the range [%d, %d).", p, 0, MAX)
            )
        }
    }

    private fun inclusiveRangeCheck(p: Int) {
        if (p < 0 || p > MAX) {
            throw IndexOutOfBoundsException(
                String.format("Index %d out of bounds for the range [%d, %d].", p, 0, MAX)
            )
        }
    }
}