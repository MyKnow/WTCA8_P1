# Notion
- [노션에서 보기](https://myknow.notion.site/1-28c406c3c48881128b4def30ca65c93c?source=copy_link)

# 과제 요약

- 입력한 문자열에서 숫자를 추출하여 더하는 계산기 구현

## 기능 요구 사항

- 문자열에서 `기본 구분자` 나 `커스텀 구분자` 로 숫자를 구분하고, 분리된 숫자의 합을 반환해야 한다.
- 기본 구분자는 `,` 와 `:` 이다.
- 커스텀 구분자는 사용자가 입력한 문자열에서 `//` 와 `\n` 사이에 위치하는 문자를 사용한다.
    - 예시
        - `//;\n1;2;3`과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(`;`)이며, 결과 값은 `6`이 반환된다.
    - 커스텀 구분자가 지정되어도, 기본 구분자는 동일하게 기능하는 것으로 보인다.
- `IllegalArgumentException`
    1. 빈 문자열인 경우
    2. 기본/커스텀 구분자 외의 문자가 문자열에 포함된 경우
    3. 구분자가 연속해서 입력된 경우
    4. 커스텀 구분자 지정 부분에서 오타가 발생한 경우

## 입출력 요구사항

### 입력

- 구분자와 양수로 구성된 문자열

### 출력

- 덧셈 결과

### 실행 결과 예시

```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

## 프로그래밍 요구 사항

- Kotlin 2.2.0
- 프로그램의 시작점은 Application의 main()
- `build.gradle.kts 파일 변경` 및 `외부 라이브러리 사용` 금지.
    - 이번 미션에서는 `camp.nextstep.edu.missionutils` 에서 제공하는 `Console API`를 사용하여 구현해야 한다.
        - `camp.nextstep.edu.missionutils.Console`의 `readLine()` 을 활용하여 사용자 입력 값을 받는다.
- 프로그램 종료 시 `System.exit()` 또는 `exitProcess()` 호출 금지
- 요구사항에서 명시하지 않는 한, `파일 및 패키지`등의 이름 변경 또는 이동 금지
- [Kotlin Code Convention](https://kotlinlang.org/docs/coding-conventions.html)을 지키면서 프로그래밍한다.

---

# 구현

## 흐름

1. Console로부터 문자열을 입력 받는다.
    - 빈 문자열이 입력되면 `IllegalArgumentException`을 Throw한다.
2. 입력된 문자열에서 커스텀 구분자를 찾는다.
    - 정해진 커스텀 구분자 선언 형태가 아니라면 `IllegalArgumentException` 을 Throw한다.
3. 기본 구분자 + 커스텀 구분자로 숫자를 구분한다.
    - 숫자를 제외한 문자 중에서, 기본 구분자 + 커스텀 구분자 집합에 포함되지 않는 문자가 문자열에 존재하면 `IllegalArgumentException`을 Throw 한다.
    - 구분을 완료하고 나서 숫자가 존재하지 않는다면 `IllegalArgumentException` 을 Throw한다.
4. 구분된 숫자들을 모두 더하여 출력한다.

## 기능 목록
| 상태 | 기능 ID | 기능명                     | 주요 로직 요약                                        | 담당자 | 마감일           | 패키지               | 객체/클래스     | 입력 (Input) | 출력 (Output) | 의존 모듈 / API                            | 예외 처리 여부 | 테스트 완료 | 통합 테스트 완료 | 코드 리뷰 완료 | 비고 / 메모 |
| -- | ----- | ----------------------- | ----------------------------------------------- | --- | ------------- | ----------------- | ---------- | ---------- | ----------- | -------------------------------------- | -------- | ------ | --------- | -------- | ------- |
| 완료 | 1     | readNonEmptyLine        | 콘솔에서 입력된 문자열이 공백이라면 에러를, 아니라면 String으로 반환.      | 정민호 | 2025년 10월 20일 | calculator.io     | InputView  |            | String      | camp.nextstep.edu.missionutils.Console | Yes      | Yes    | Yes       | No       |         |
| 완료 | 2     | parseNumbersFromInput   | 문자열을 입력 받고, 구분자를 기준으로 숫자를 Parsing하여, 정수 배열로 반환. | 정민호 | 2025년 10월 20일 | calculator.domain | Calculator | String     | Array<Int>  | camp.nextstep.edu.missionutils.Console | Yes      | Yes    | Yes       | No       |         |
| 완료 | 3     | extractCustomDelimiters | 문자열을 입력 받고, 커스텀 구분자를 찾아서, 각각 문자 배열로 반환.         | 정민호 | 2025년 10월 20일 | calculator.domain | Calculator | String     | Array<Char> |                                        | Yes      | Yes    | Yes       | No       |         |
| 완료 | 4     | printResult             | 주어진 정수 배열의 합계를 계산하여 콘솔에 출력.                     | 정민호 | 2025년 10월 20일 | calculator.io     | OutputView | Array<Int> |             |                                        | No       | Yes    | Yes       | No       |         |

# 후기

- Kotlin을 처음 접해봐서, 문법에 적응하는 데 시간이 조금 걸렸다. 웹 할까 안드로이드 할까 엄청 고민했었는데, 굉장히 잘한 선택인 것 같다!

# 배운 점

1. `package` : 파일이 속한 패키지(네임스페이스)를 선언할 때 사용하는 키워드
    - 다른 `package`에서 이 `package`에 접근하려면 `import` 키워드를 사용해야 한다.
        - 예시

            ```kotlin
            // 각각 별도의 파일
            
            // InputView.kt: 기본 패키지 하위의 io 패키지의 파일(정의)
            package calculator.io
            
            // Application.kt: 기본 패키지 하위의 진입점 파일(사용)
            import calculator.io.InputView
            ```

    - 파일 최상단에 위치해야 한다.
2. `import`: 패키지 경로를 지정하고 마지막 식별자를 가져오는 키워드
    - 와일드카드 `import`
        - 마지막에 `*` 키워드를 사용하여 해당 패키지 내 모든 클래스/함수를 한 번에 `import` 할 수 있다.
            - 예시

                ```kotlin
                import camp.nextstep.edu.missionutils.*
                ```

            - 하지만 보통 필요한 class만 구체적으로 `import`한다.
    - 정적 메소드 또는 상수 `import`
        - 예시

            ```kotlin
            import camp.nextstep.edu.missionutils.Console.readLine
            
            fun main() {
            		// Console. 생략 가능
                val input = readLine() 
            }
            ```

    - 클래스 이름 별칭(`as` )
        - 예시

            ```kotlin
            import camp.nextstep.edu.missionutils.Console as C
            
            fun main() {
                val input = C.readLine()
            }
            ```

3. `object`: Singleton 객체를 선언할 때 사용
    - Class instance를 한 개만 만들고, 이름으로 바로 접근할 수 있는 객체를 정의할 수 있음
    - 예시

        ```kotlin
        // 선언 시
        object InputView {
            fun readNumber(): Int {
                return 42
            }
        }
        
        // 사용 시
        val n = InputView.readNumber()
        ```

        - `object`로 선언된 InputView는, Class를 따로 만들고 new로 Instance를 생성하지 않아도 된다.
    - JVM에서는 내부적으로 private 생성자를 가진 Class + 정적 인스턴스로 컴파일된다.
4. `KDoc` : 코드의 문서화를 위한 언어
    - Markdown을 사용한다.
    - 첫번째 단락은 요약, 두번째 단락부터 자세한 설명
    - 예시

        ```kotlin
        /**
         * A group of *members*.
         *
         * This class has no useful logic; it's just a documentation example.
         *
         * @param T the type of a member in this group.
         * @property name the name of this group.
         * @constructor Creates an empty group.
         */
        class Group<T>(val name: String) {
            /**
             * Adds a [member] to this group.
             * @return the new size of the group.
             */
            fun add(member: T): Int { ... }
        }
        ```

    - 블록태그
   
| Block tag | Description |
| --- | --- |
| @param name | class, function 등에 사용되는 변수에 대한 설명 작성.다음과 같이 공백과 대괄호를 사용한 2가지 표현 방식이 있다.`ex) @param name description. @param[name] description.` |
| @return | 함수의 반환값에 대한 설명 작성 |
| @constructor | class의 기본 생성자에 대한 설명 작성 |
| @receiver | kotlin extention 함수의 receiver에 대한 설명 작성 |
| @property name | class 생성자에 있는 properties에 대한 설명 작성 |
| @throws class, @exception class | 메소드에 의해 발생 가능한 예외에 대한 설명 작성.모든 예외에 대한 설명을 작성하는 것이 아닌 유용한 정보만 필요에 의해 작성. |
| @sample identifier | 요소의 사용방법에 대한 예시 코드를 작성. |
| @see identifier | 원하는 클래스 혹은 메소드에 대한 링크를 작성. |
| @author | 문서의 작성자를 명시. |
| @since | 문서가 작성된 시점의 버전을 작성. |
| @suppress | 해당 요소를 생성된 문서에서 제외 시키고 싶은 경우 작성. |
    
    - `Dokka` 를 통해 html 등의 형태로 파일로 내보내기 가능
5. `const val`과 `val`의 차이


| **구분** | const val | val |
| --- | --- | --- |
| **평가 시점** | **컴파일 시점 상수** | **런타임 시점 값** |
| **사용 가능 위치** | object, top-level, companion object 안에서만 가능 | 어디서나 선언 가능 |
| **타입 제한** | 기본 타입(Int, Double, Boolean, String)만 가능 | 모든 타입 가능 |
| **JVM 처리 방식** | 리터럴로 코드에 직접 치환됨 (inlined) | 일반 필드처럼 접근됨 |
| **변경 가능 여부** | 불가능 (상수) | 불가능 (읽기 전용이지만 런타임 계산 가능) |
| **예시** | const val PI = 3.14 → 컴파일 시점에 코드에 직접 박힘 | val currentTime = System.currentTimeMillis() → 실행 시 평가됨 |

- `const val`은 컴파일 시점에 inlined되는 상수
    - 값을 참조할 때마다 상수에 접근하면서 발생하는 오버헤드를 줄일 수 있다는 장점
- `val`은 런타임에 한 번만 계산되는 상수

6. `Top-Level` : Class나 함수 밖, 파일 최상단에 선언된 것을 의미
    - 예시

        ```kotlin
        // 파일 최상단 (클래스 밖)
        const val PI = 3.14
        val version = "1.0.0"
        
        fun printHello() {
            println("Hello")
        }
        ```

        - Kotlin은 JAVA처럼 static 키워드가 없어서, top-level이 이를 대신함
        - `패키지.이름` 형태로 전역적으로 접근 가능함
7. `Companion Object`(동반객체): Class 내부에서 “정적 멤버”처럼 사용하기 위한 객체
    - 예시

        ```kotlin
        class MathUtil {
            companion object {
                const val PI = 3.14
                fun square(x: Int): Int = x * x
            }
        }
        
        fun main() {
            println(MathUtil.PI)       // 정적 접근처럼 사용 가능
            println(MathUtil.square(5)) // → 25
        }
        ```

        - Java의 static처럼 Class명으로 직접 접근 가능하지만, static 멤버가 아닌 객체의 property이다.
8. `CharArray` : 원시형 배열(`Primitive Array`)로, Char 타입의 값을 연속된 메모리 공간에 저장
    - 문법

        ```kotlin
        val chars: CharArray = charArrayOf('a', 'b', 'c')
        ```

    - 장점
        - 메모리 효율이 좋고 속도가 빠름
    - 단점
        - Kotlin의 제네릭 컬렉션(Array<T>)과 호환되지 않음
        - 이를 Array<Char>로 변환하려면 `toTypedArray()` 메서드 사용

            ```kotlin
            val input = "abc"
            val charArray: CharArray = input.toCharArray()       // CharArray
            val arrayChar: Array<Char> = input.toCharArray().toTypedArray()  // Array<Char>
            ```

9. `map` : 컬렉션의 각 요소를 변환(transform)하여 새로운 컬렉션으로 반환하는 고차 함수
    - 예제

        ```kotlin
        val numbers = listOf(1, 2, 3)
        val doubled = numbers.map { it * 2 }  // 각 요소에 2를 곱함
        println(doubled)  // [2, 4, 6]
        ```

        - it: 현재 처리 중인 요소
10. `Regex` : Kotlin에서 정규식을 나타내는 class
    - 생성 방법

        ```kotlin
        val pattern = "\\d+".toRegex()  // 하나 이상의 숫자
        ```

        - 문자열 뒤에 `.toRegex()`를 붙이면 `Regex` 객체가 생성된다.
        - Kotlin에서는 문자열 리터럴 내에서 `\`를 쓰려면 `\\`로 이스케이프 필요
            - 또는 Raw String 사용

                ```kotlin
                val pattern = """\d+""".toRegex()
                ```

    - 사용
        - 검색 / 매칭

            ```kotlin
            val text = "abc123"
            val regex = "\\d+".toRegex()
            
            println(regex.containsMatchIn(text))  // true, 숫자가 포함되어 있는지
            println(regex.matches("123"))         // true, 전체 문자열이 패턴과 일치하는지
            ```

        - 분리

            ```kotlin
            val text = "1,2:3"
            val delimiters = "[,:]".toRegex()  // ',' 또는 ':' 기준
            val tokens = text.split(delimiters)
            println(tokens)  // [1, 2, 3]
            ```

        - 치환

            ```kotlin
            val text = "abc123def"
            val result = text.replace("\\d+".toRegex(), "#")
            println(result)  // abc#def
            ```

    - `Regex.escape` : 패넡에 특수 문자가 포함될 수 있을 때, 안전하게 문자를 사용하기 위한 방법

        ```kotlin
        val special = ".+*?"
        val pattern = Regex.escape(special).toRegex()
        ```

        - 이렇게 해야 정규식에서 임의 문자나 메타 문자로 오해하지 않는다.
