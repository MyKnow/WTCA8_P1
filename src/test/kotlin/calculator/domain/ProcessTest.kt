package calculator.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ProcessTest {
    // -----------------------
    // extractCustomDelimiters 테스트
    // -----------------------
    @Test
    fun `extractCustomDelimiters 정상 케이스`() {
        val input = "//;\\n1;2;3"
        val expected = arrayOf(';')

        val result = Calculator.extractCustomDelimiters(input)  // object명 사용

        assertArrayEquals(expected, result)
    }

    @Test
    fun `extractCustomDelimiters 빈배열 케이스`() {
        // 커스텀 구분자 없음
        val input = "//\\n1;2;3"
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

    // -----------------------
    // parseNumbersFromInput 테스트
    // -----------------------
    @Test
    fun `parseNumbersFromInput 기본 구분자 케이스`() {
        val input = "1,2:3"
        val expected = arrayOf(1, 2, 3)

        val result = Calculator.parseNumbersFromInput(input)

        assertArrayEquals(expected, result)
    }

    @Test
    fun `parseNumbersFromInput 커스텀 구분자 케이스`() {
        val input = "//;\\n1;2;3"
        val expected = arrayOf(1, 2, 3)

        val result = Calculator.parseNumbersFromInput(input)

        assertArrayEquals(expected, result)
    }

    @Test
    fun `parseNumbersFromInput 잘못된 입력 예외 케이스`() {
        val input = "1,a,3"

        val exception = assertThrows<IllegalArgumentException> {
            Calculator.parseNumbersFromInput(input)
        }

        assertEquals("잘못된 입력: a", exception.message)
    }

    @Test
    fun `parseNumbersFromInput 빈 문자열 케이스`() {
        val input = ""

        val exception = assertThrows<IllegalArgumentException> {
            Calculator.parseNumbersFromInput(input)
        }

        assertEquals("입력이 비어있습니다", exception.message)
    }
}