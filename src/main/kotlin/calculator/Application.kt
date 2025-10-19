package calculator

import calculator.io.InputView
import calculator.io.OutputView
import calculator.domain.Calculator

fun main() {
    // 1. Console로부터 문자열 입력 받음
    val input: String = InputView.readNonEmptyLine()

    // 2. 기본 구분자 + 커스텀 구분자로 숫자 구분함
    val parsedNumbers: Array<Int> = Calculator.parseNumbersFromInput(input)

    // 3. 구분된 숫자들을 모두 더하여 출력함
    OutputView.printResult(parsedNumbers)
}