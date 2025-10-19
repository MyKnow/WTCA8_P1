package calculator.io

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputViewTest {
    @Test
    fun `printResult 출력 테스트`() {
        val result = arrayOf(1, 2, 3)

        // System.out 캡처
        val outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))
        OutputView.printResult(result)

        // 출력 내용 검증
        val outputString = outContent.toString().trim()
        assertThat(outputString).isEqualTo("결과 : 6")

        // System.out 원복
        System.setOut(System.out)
    }
}