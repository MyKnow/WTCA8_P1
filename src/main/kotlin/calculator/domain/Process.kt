package calculator.domain

object Calculator {
    val defaultDelimiters = arrayOf(',', ':')

    /**
     * 콘솔에서 입력된 문자열을 구분자를 기준으로 분리하여 정수 배열로 반환합니다.
     *
     * @param input 분석할 문자열
     * @return 구분자를 기준으로 분리된 정수 배열
     * @throws IllegalArgumentException 입력이 잘못된 경우
     */
    fun parseNumbersFromInput(input: String): Array<Int> {
        TODO()
    }

    /**
     * 주어진 문자열에서 구분자를 추출합니다.
     *
     * @param input 분석할 문자열
     * @return 구분자가 존재하면 해당 구분자를 요소로 가진 배열,
     *         존재하지 않는 경우 빈 배열
     * @throws IllegalArgumentException 올바른 포맷이 아닌 경우
     */
    fun extractCustomDelimiters(input: String): Array<Char> {
        val startWord = "//"
        val endWord = "\n"
        val startExists: Boolean = input.startsWith(startWord)
        val endIdx: Int = input.indexOf(endWord)

        // 1. 문자열 포맷 에러를 확인한다.
        if (startExists.xor(endIdx != -1)) {
            throw IllegalArgumentException("커스텀 구분자 지정 문자열 포맷 에러")
        }

        // 2. 시작 idx부터 끝 idx 사이의 문자들을 추출하여 반환한다.
        val startIdx = 2
        return input.substring(startIdx, endIdx).toCharArray().toTypedArray()
    }
}