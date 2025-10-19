package calculator.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ProcessTest {
    @Test
    fun `extractCustomDelimiters 정상 케이스`() {
        val input = "//;\n1;2;3"
        val expected = arrayOf(';')

        val result = Calculator.extractCustomDelimiters(input)  // object명 사용

        assertArrayEquals(expected, result)
    }

    @Test
    fun `extractCustomDelimiters 빈배열 케이스`() {
        // 커스텀 구분자 없음
        val input = "//\n1;2;3"
        val expected = emptyArray<Char>()

        val result = Calculator.extractCustomDelimiters(input)  // object명 사용

        assertArrayEquals(expected, result)
    }

    @Test
    fun `extractCustomDelimiters 에러 Throw 케이스`() {
        // 종료 구분자 "\n" 없음
        val input = "//;1;2;3"

        val exception = assertThrows<IllegalArgumentException> {
            Calculator.extractCustomDelimiters(input)
        }

        assertEquals("커스텀 구분자 지정 문자열 포맷 에러", exception.message)
    }
}