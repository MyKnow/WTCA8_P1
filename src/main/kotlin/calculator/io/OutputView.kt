package calculator.io

object OutputView {
    /**
     * 주어진 정수 배열의 합계를 계산하여 콘솔에 출력합니다.
     * ### 예시
     * - arrayOf(1, 2, 3)
     * ```
     * 결과 : 6
     * ```
     *
     * @param result 합계를 출력할 정수 배열
     */
    fun printResult(result: Array<Int>) {
        println("결과 : " + result.sum().toString())
    }
}