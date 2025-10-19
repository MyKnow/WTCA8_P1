package calculator.domain

object Calculator {
    val defaultDelimiters = arrayOf(',', ':')
    const val STARTWORD = "//"
    const val ENDWORD = "\\n"

    /**
     * 콘솔에서 입력된 문자열을 구분자를 기준으로 분리하여 정수 배열로 반환합니다.
     *
     * @param input 분석할 문자열
     * @return 구분자를 기준으로 분리된 정수 배열
     * @throws IllegalArgumentException 입력이 잘못된 경우
     */
    fun parseNumbersFromInput(input: String): Array<Int> {
        // 1. 빈 문자열인 경우 에러 반환
        if (input.trim().count() == 0) {
            throw IllegalArgumentException("입력이 비어있습니다")
        }

        // 2. 커스텀 구분자 추출 및 구분자 리스트 생성
        val customDelimiters = extractCustomDelimiters(input)
        val delimiterList = defaultDelimiters + customDelimiters

        // 3. input에서 커스텀 구분자 추출을 위한 헤더 삭제
        val numbersPart = if (customDelimiters.isNotEmpty()) {
            val endIdx = input.indexOf(ENDWORD)
            input.substring(endIdx + ENDWORD.length)
        } else {
            input
        }

        // 4. delimiterSet을 안전하게 Regex로 변환
        val escapedDelimiters = delimiterList.map { Regex.escape(it.toString()) }
        val regexPattern = "[${escapedDelimiters.joinToString("")}]".toRegex()

        // 5. 문자열 분리
        val tokens = numbersPart.split(regexPattern)
            .filter { it.isNotEmpty() }

        // 6. 각 토큰을 Int로 변환하며, 변환 실패 시 예외 발생
        val numbers = tokens.map { token ->
            if (!token.matches(Regex("\\d+"))) {
                throw IllegalArgumentException("잘못된 입력: $token")
            }
            token.toInt()
        }

        // 7. Array<Int>로 변환하여 반환
        return numbers.toTypedArray()
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
        val startExists = input.startsWith(STARTWORD)
        val endIdx = input.indexOf(ENDWORD)

        // 1. 시작만 있거나 종료만 있는 경우 포맷 에러
        if (startExists.xor(endIdx != -1)) {
            throw IllegalArgumentException("커스텀 구분자 지정 문자열 포맷 에러")
        }

        // 2. 시작/종료 구분자가 없거나, substring 범위가 잘못된 경우 빈 배열 반환
        val startIdx = 2
        if (!startExists || endIdx <= startIdx) {
            return emptyArray()
        }

        // 3. 안전하게 substring 후 Char 배열 반환
        return input.substring(startIdx, endIdx).toCharArray().toTypedArray()
    }
}