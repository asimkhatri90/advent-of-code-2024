package day01

import println
import readInput
import kotlin.math.abs

fun main() {

    fun checkIfLineIsSafe(line: List<Int>): Boolean {
        val diffList = mutableListOf<Int>()
        line.windowed(2, 1) { list ->
            val diff = list[0] - list[1]
            diffList.add(diff)
        }

        val isSafe = when {
            diffList.any {abs(it) > 3} -> false
            diffList.any {it == 0} -> false
            diffList.any { it > 0 } && diffList.any { it < 0 } -> false
            else -> true
        }
        return isSafe
    }

    fun part1(input: List<String>): Int {
        var safeSum = 0
        input.map { item ->
            val line = item.split(" ").map { it.toInt() }
            if (checkIfLineIsSafe(line)) {
                safeSum += 1
            }
        }
        return safeSum
    }

    fun part2(input: List<String>): Int {
        var safeSum = 0
        input.map { item ->
            val line = item.split(" ").map { it.toInt() }
            var safe = false
            for (i in 0..line.lastIndex) {
                safe = checkIfLineIsSafe(line.toMutableList().apply { removeAt(i) })
                if (safe) break
            }

            if (safe) {
                safeSum += 1
            }

        }
        return safeSum
    }

    // Or read a large test input from the `src/Day02_test.txt` file:
    val testInput = readInput("day02/Day02_test")
    check(part1(testInput) == 2)

    // Read the input from the `src/Day02.txt` file.
    val input = readInput("day02/Day02")
    part1(input).println()


    // Or read a large test input from the `src/Day02P2_test.txt` file:
    val testInputP2 = readInput("day02/Day02P2_test")
    check(part2(testInputP2) == 4)

    // Read the input from the `src/Day02P2.txt` file.
    val inputP2 = readInput("day02/Day02P2")
    part2(inputP2).println()
}
