## 생성자
* 기본적으로 private 생성만 가능함
* 외부에선 생성자호출이 불가
* 각 enum 항목은 추가정보를 갖을수 있음
* 이를 이용해 순서, 코드, 설명 등 부가정보를 사용할 수 있음

## 비교연산
### `==` vs `equals()`
* 둘다 가능한 방법
* enum 은 하나의 인스턴스를 갖음
* 즉, == 을 사용해도 동일한 인스턴스를 비교 (참조값 비교)
* `NullPointerException` 를 피하려면 == 연산자가 더 나은 선택

https://stackoverflow.com/questions/1750435/comparing-java-enum-members-or-equals

## JSON 표현
* JSON 표현시 toString() 항목인 enum 필드가 값으로 나타남
* 상세한 값을 표현하기 위해서 object 형식으로 만들어주면 됨
* @JsonFormat(shape=JsonFormat.OBJECT) 를 사용

## 참고자료
* https://www.baeldung.com/a-guide-to-java-enums
* https://www.baeldung.com/jackson-serialize-enums
