import java.io.FileInputStream
import java.io.PrintStream

fun main() {
    System.setIn(FileInputStream("input.txt"))
    System.setOut(PrintStream("output.txt"))
    var ia = IntArray(3) { 3 }
    var la = ia.toLongArray();
    println(la.contentToString())
}