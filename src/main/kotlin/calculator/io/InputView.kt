package calculator.io

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readNonEmptyLine(): String {
        println("덧셈할 문자열을 입력해 주세요.")
        val input: String = Console.readLine().trim()

        if (input.isEmpty()) {
            throw IllegalArgumentException("빈 문자열은 입력할 수 없습니다.")
        }

        return input
    }
}