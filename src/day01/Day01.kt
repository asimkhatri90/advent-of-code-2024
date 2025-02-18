package day01

import println
import readInput
import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {

        val (firstList, secondList) = input.map { pair ->
            val (first, second) = pair.trim().split("\\s+".toRegex()).map { it.toInt() }
            first to second
        }.unzip()

        val sortedFirstList = firstList.sorted()
        val sortedSecondList = secondList.sorted()

        var sum = 0
        sortedFirstList.forEachIndexed { index, item ->
            sum += abs(item - sortedSecondList[index])
        }

        return sum
    }

    fun part2(input: List<String>): Int {

        val (firstList, secondList) = input.map { pair ->
            val (first, second) = pair.trim().split("\\s+".toRegex()).map { it.toInt() }
            first to second
        }.unzip()

        var similarity = 0

        firstList.forEach {
            val count = secondList.count { secondIt -> it == secondIt }
            similarity += (count * it)
        }


        return similarity
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("day01/Day01_test")
    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("day01/Day01")
    part1(input).println()


    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInputP2 = readInput("day01/Day01P2_test")
    check(part2(testInputP2) == 31)

    // Read the input from the `src/Day01.txt` file.
    val inputP2 = readInput("day01/Day01P2")
    part2(inputP2).println()
}
