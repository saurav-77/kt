class SegTree(val MAX: Int, val op: (a: Long, b: Long) -> Long, val E: Long) {
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

    constructor(dat: Array<kotlin.Long>, op: (a: Long, b: Long) -> Long, e: kotlin.Long) : this(dat.size, op, e) {
        build(dat)
    }

    private fun build(dat: Array<Long>) {
        val l = dat.size
        System.arraycopy(dat, 0, seg, N, l)
        for (i in N - 1 downTo 1) {
            seg[i] = op(seg[i shl 1 or 0], seg[i shl 1 or 1])
        }
    }

    fun add(ind: Int, value: Long) {
        var p = ind + N;
        exclusiveRangeCheck(ind)
        seg[p] += value
        p = p shr 1
        while (p > 0) {
            seg[p] = op(seg[p shl 1 or 0], seg[p shl 1 or 1])
            p = p shr 1
        }
    }

    operator fun set(ind: Int, value: Long) {
        var p = ind + N;
        exclusiveRangeCheck(ind)
        seg[p] = value
        p = p shr 1
        while (p > 0) {
            seg[p] = op(seg[p shl 1 or 0], seg[p shl 1 or 1])
            p = p shr 1
        }
    }

    operator fun get(p: Int): Long {
        exclusiveRangeCheck(p)
        return seg[p + N]
    }

    //[l, r)
    fun query(l: Int, r: Int): Long {
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
            if ((l and 1) == 1) sumLeft = op(sumLeft, seg[l++])
            if ((r and 1) == 1) sumRight = op(seg[--r], sumRight)
            l = l shr 1
            r = r shr 1
        }
        return op(sumLeft, sumRight)
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