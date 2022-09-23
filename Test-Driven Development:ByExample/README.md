# Test-Driven Development:ByExample - Kent Beck

- [Test-Driven Development:ByExample - Kent Beck](#test-driven-developmentbyexample---kent-beck)
  - [1. 화폐 예제](#1-화폐-예제)
    - [1장. 다중통화를 지원하는 Money 객체](#1장-다중통화를-지원하는-money-객체)
      - [다중통화를 지원하는 보고서](#다중통화를-지원하는-보고서)
      - [1-1. 테스트 작성하기](#1-1-테스트-작성하기)
      - [1-1 컴파일 에러 없애기 위한 클래스 생성하기](#1-1-컴파일-에러-없애기-위한-클래스-생성하기)
      - [1-1 테스트를 통과시키기 위한 주기](#1-1-테스트를-통과시키기-위한-주기)
      - [1-1. 지금까지 한 작업들](#1-1-지금까지-한-작업들)
  - [2. 타락한 객체](#2-타락한-객체)

## 1. 화폐 예제

---

테스트 주도개발의 리듬

1. 재빨리 테스트를 하나 추가한다.
2. 모든 테스트를 실행하고 새로 추가한 것이 실패하는지 확인한다.
3. 코드를 조금 바꾼다.
4. 모든 테스트를 실행하고 전부 성공하는지 확인한다.
5. 리팩토링을 통해 중복을 제거한다.

---

### 1장. 다중통화를 지원하는 Money 객체

#### 다중통화를 지원하는 보고서

| 종목     | 주   | 가격   | 합계    |
| -------- | ---- | ------ | ------- |
| IBM      | 1000 | 25USD  | 2500USD |
| Novartis | 400  | 150CHF | 6000CHF |
|          |      | 합계   | 6500USD |

| 기준 | 변환 | 환율 |
| ---- | ---- | ---- |
| CHF  | USD  | 1.5  |

#### 1-1. 테스트 작성하기

```text
기능 리스트
- [ ] $5 + 10CHF = $10
- [ ] $5 x 2 = $10  *
```

- 객체를 만들면서 시작하는 것이 아니라 테스트를 먼저 만들어야 한다.
- 테스트를 작성할 때는 오퍼레이션의 완벽한 인터페이스에 대해 상상해보는 것이 좋다.
- 가능한 최선의 API에서 시작해서 거꾸로 작업하는 것이 애초부터 일을 복잡하고 보기 흉하며 '현실적' 이게 하는 것보다 낫다.

```java
// $5 x 2 = $10
public void testMultiiplication() {
  Dollar five = new Dollar(5);
  five.times(2);
  assertEquals(10, five.amount);
}
```

- 테스트 작성 후 필요한 기능 추가하기

```text
기능 리스트
- [ ] $5 + 10CHF = $10
- [ ] $5 x 2 = $10  *
- [ ] amount를 private으로 만들기
- [ ] Dollar 의 side effect ?
- [ ] Money 반올림 ?
```

- 컴파일시 에러 목록

  - Dollar 클래스가 없음
  - 생성자가 없음
  - times(int) 메서드가 없음
  - amount 필드가 없음

#### 1-1 컴파일 에러 없애기 위한 클래스 생성하기

```java
class Dollar {
  int amount;
  Dollar(int amount) { }
  void times(int multiplier) { }
}
```

- 이제 테스트를 실행해서 테스트가 실패하는 모습을 볼 수 있다.
- 실패에 대한 구체적인 척도를 갖게 된 것.
- 당장의 목표는 완벽한 해법이 아닌 테스트를 통과하는 것.

#### 1-1 테스트를 통과시키기 위한 주기

> TDD의 핵심은 이런 작은 단계를 밟아야 한다는 것이 아니라, 이런 작은 단계를 밟을 능력을 갖추어야 한다는 것이다.

1. 작은 테스트를 하나 추가한다.
2. 모든 테스트를 실행해서 테스트가 실패하는 것을 확인한다.
3. 조금 수정한다.
4. 모든 테스트를 실행해서 테스트가 성공하는 것을 확인한다.
5. 중복을 제거하기 위해 리팩토링을 한다.

```java
int amount = 10;
```

- 이렇게 하면 최소의 작업으로 'testMultiiplication' 테스트를 통과시킬수 있다.

```java
int amount = 5 * 2;
```

- 10은 사실 5와 2를 곱한값이다.

```java
int amount;

void times(int multiplier) {
  amount = 5 * 2;
}
```

- 5와 2를 곱한는 것을 times 메서드로 옮긴다

```java
Dollar (int amount) {
  this.amount = amount;
}

void times (int multiplier) {
  amount = amount * 2;
}
```

- amount는 생성자에서 넘어가는 값이다

```java
void times (int multiplier) {
  amount = amount * multiplier;
}
```

- multiplier의 값이 2이므로 상수는 이 인자로 대체할 수 있다

```java
void times (int multiplier) {
  amount *= multiplier;
}
```

- 자바 문법을 완벽히 알고 있다는 것을 보여주자

```text
기능 리스트
- [ ] $5 + 10CHF = $10
- [x] $5 x 2 = $10
- [ ] amount를 private으로 만들기
- [ ] Dollar 의 side effect ?
- [ ] Money 반올림 ?
```

#### 1-1. 지금까지 한 작업들

- 우리가 알고 있는 작업해야 할 테스트 목록을 만들었다.
- 오퍼레이션이 외부에서 어떻게 보이길 원하는지 말해주는 이야기를 코드로 표현했다.
- JUnit에 대한 상세한 사항들은 잠시 무시하기로 했다.
- 스텁 구현을 통해 테스트를 컴파일했다.
- 끔찍한 죄악을 범하여 테스트를 통과시켰다.
- 돌아가는 코드에서 상수를 변수로 변경하여 점진적으로 일반화했다.
- 새로운 할일들을 한번에 처리하는 대신 할일 목록에 추가하고 넘어갔다.

## 2. 타락한 객체