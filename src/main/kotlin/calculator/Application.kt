package calculator

fun main() {
    try {
        // 1. Console로부터 문자열 입력 받음
        val input: String = TODO()

        // 2. 입력된 문자열에서 커스텀 구분자 찾음
        val customDelimiters: Array<Char> = TODO()

        // 3. 기본 구분자 + 커스텀 구분자로 숫자 구분함
        val parsedNumbers: Array<Int> = TODO()

        // 4. 구분된 숫자들을 모두 더하여 출력함
        val result: String = TODO()
    } catch (e: IllegalArgumentException) {
        println(e)
    }
}