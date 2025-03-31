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

fun nextLong(): Long {
    return nextString().toLong()
}

fun nextDouble(): Double {
    return nextString().toDouble()
}


fun nextLongArray(len: Int): Array<Long> {
    val ans = Array<Long>(len) { 0L }
    for (i in 0..<len) {
        ans[i] = nextLong()
    }
    return ans
}