package calculator.io

import camp.nextstep.edu.missionutils.Console

object InputView {

    /**
     * 사용자로부터 빈 문자열이 아닌 입력을 한 줄 받아 반환함.
     *
     * @return 공백이 제거된, 빈 문자열이 아닌 사용자 입력 문자열
     * @throws IllegalArgumentException 입력이 빈 문자열인 경우 예외가 발생.
     */
    fun readNonEmptyLine(): String {
        println("덧셈할 문자열을 입력해 주세요.")
        val input: String = Console.readLine().trim()

        if (input.isEmpty()) {
            throw IllegalArgumentException("빈 문자열은 입력할 수 없습니다.")
        }

        return input
    }
}
