import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
var st: StringTokenizer? = null

fun nextString(): String {
    while (st == null || !st!!.hasMoreElements()) {
        st = StringTokenizer(br.readLine())
    }
    return st!!.nextToken()
}

fun nextInt(): Int {
    return nextString().toInt()
}

fun nextLong(): Long {
    return nextString().toLong()
}
fun nextDouble(): Double {
    return nextString().toDouble()
}

fun nextIntArray(len: Int): IntArray {
    val ans = IntArray(len)
    for (i in 0..<len) {
        ans[i] = nextInt()
    }
    return ans
}

fun nextLongArray(len: Int): LongArray {
    val ans = LongArray(len)
    for (i in 0..<len) {
        ans[i] = nextLong()
    }
    return ans
}