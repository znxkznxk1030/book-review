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
    - [2-1. 테스트 작성하기](#2-1-테스트-작성하기)
    - [2-1. 테스트 통과하기](#2-1-테스트-통과하기)
    - [2-1. 지금까지 한 작업들](#2-1-지금까지-한-작업들)
  - [3. 모두를 위한 평등](#3-모두를-위한-평등)
    - [값 객체](#값-객체)
    - [3-1. 테스트 작성하기](#3-1-테스트-작성하기)
      - [삼각측량](#삼각측량)
    - [3-1. 지금까지 한 작업들](#3-1-지금까지-한-작업들)
  - [4. 프라이버시](#4-프라이버시)
    - [4-1. 테스트 작성하기](#4-1-테스트-작성하기)
      - [4-1. 지금까지 한 작업들](#4-1-지금까지-한-작업들)
  - [5. 솔직히 말하자면](#5-솔직히-말하자면)
    - [5-1. 테스트 작성하기](#5-1-테스트-작성하기)
    - [5-2. 테스트 통과하기](#5-2-테스트-통과하기)
      - [5-1. 지금까지 한 작업들](#5-1-지금까지-한-작업들)
  - [6. 돌아온 '모두를 위한 평등'](#6-돌아온-모두를-위한-평등)
    - [Dollar와 Franc의 공통 상위 클래스를 찾아내기](#dollar와-franc의-공통-상위-클래스를-찾아내기)
      - [6-1. 지금까지 한 작업들](#6-1-지금까지-한-작업들)
  - [7. 사과와 오렌지](#7-사과와-오렌지)
    - [7-1. 테스트 추가](#7-1-테스트-추가)
    - [7-1. 지금까지 한 일](#7-1-지금까지-한-일)
  - [8. 객체 만들기](#8-객체-만들기)
    - [Dollar/Franc 중복](#dollarfranc-중복)
    - [8. 지금까지 한 일](#8-지금까지-한-일)
  - [9. 우리가 사는 시간](#9-우리가-사는-시간)
    - [통화개념에 대한 테스트 추가하기](#통화개념에-대한-테스트-추가하기)
    - [통화개념 구현](#통화개념-구현)
    - [9. 지금까지 한 일](#9-지금까지-한-일)

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

---

To-Do List

- [ ] $5 + 10CHF = $10
- [ ] $5 x 2 = $10 \*

---

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

---

To-Do List

- [ ] $5 + 10CHF = $10
- [ ] $5 x 2 = $10 \*
- [ ] amount를 private으로 만들기
- [ ] Dollar 의 side effect ?
- [ ] Money 반올림 ?

---

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

- 이렇게 하면 최소의 작업으로 'testMultiiplication' 테스트를 통과시킬수 있다.

```java
int amount = 10;
```

- 10은 사실 5와 2를 곱한값이다.

```java
int amount = 5 * 2;
```

- 5와 2를 곱한는 것을 times 메서드로 옮긴다

```java
int amount;

void times(int multiplier) {
  amount = 5 * 2;
}
```

- amount는 생성자에서 넘어가는 값이다

```java
Dollar (int amount) {
  this.amount = amount;
}

void times (int multiplier) {
  amount = amount * 2;
}
```

- multiplier의 값이 2이므로 상수는 이 인자로 대체할 수 있다

```java
void times (int multiplier) {
  amount = amount * multiplier;
}
```

- 자바 문법을 완벽히 알고 있다는 것을 보여주자

```java
void times (int multiplier) {
  amount *= multiplier;
}
```

---

To-Do List

- [ ] $5 + 10CHF = $10
- [x] $5 x 2 = $10
- [ ] amount를 private으로 만들기
- [ ] Dollar 의 side effect ?
- [ ] Money 반올림 ?

---

#### 1-1. 지금까지 한 작업들

- 우리가 알고 있는 작업해야 할 테스트 목록을 만들었다.
- 오퍼레이션이 외부에서 어떻게 보이길 원하는지 말해주는 이야기를 코드로 표현했다.
- JUnit에 대한 상세한 사항들은 잠시 무시하기로 했다.
- 스텁 구현을 통해 테스트를 컴파일했다.
- 끔찍한 죄악을 범하여 테스트를 통과시켰다.
- 돌아가는 코드에서 상수를 변수로 변경하여 점진적으로 일반화했다.
- 새로운 할일들을 한번에 처리하는 대신 할일 목록에 추가하고 넘어갔다.

## 2. 타락한 객체

---

```text
To-Do List
- [ ] $5 + 10CHF = $10
- [x] $5 x 2 = $10
- [ ] amount를 private으로 만들기
- [ ] Dollar 의 side effect *
- [ ] Money 반올림 ?
```

---

```java
class Dollar {
  int amount;
  Dollar (int amount) {
    this.amount = amount;
  }

  void times (int multiplier) {
    amount *= multiplier;
  }
}
```

- Dollar에 대해서 연산을 수행한 수에 해당 Dollar의 값이 바뀌는 것이 이상하다.

### 2-1. 테스트 작성하기

```java
public void testMultiplicatioin() {
  Dollar five = new Dollar(5);
  five.times(2);
  assartEquals(10, product.amount);
  five.times(3);
  assartEquals(15, product.amount);
}
```

- times()를 처음 호출한 이후에는 five는 더 이상 5가 아니다. 그렇다면 times()에서 새로운 객체를 반환하게 만들면 어떨까?
- 어떤 구현이 올바른가에 대한 우리 추측이 완벽하지 못한 것과 마찬가지로 올바른 인터페이스에 대한 추측 역시 절대 완벽하기 못하다.

```java
public void testMultiplication() {
  Dollar five = new Dollar(5);
  Dollar product = five.times(2);
  assartEquals(10, product.amount);
  product = five.times(3);
  assartEquals(15, product.amount);
}
```

### 2-1. 테스트 통과하기

```java
  void times (int multiplier) {
    amount *= multiplier;
    return null;
  }
```

- 가짜로 구현하기
- 상수를 반환하게 만들고 진짜 코드를 얻을 때까지 단계적으로 상수를 변수로 바꾸어 간다.

```java
  void times (int multiplier) {
    return new Dollar(amount * multiplier);
  }
```

- 명백한 구현 사용하기: 실제 구현을 입력한다.

---

To-Do List

- [ ] $5 + 10CHF = $10
- [x] $5 x 2 = $10
- [ ] amount를 private으로 만들기
- [x] Dollar 의 side effect
- [ ] Money 반올림 ?

---

### 2-1. 지금까지 한 작업들

- 설계상의 결함을 그 결함으로 인해 실패하는 테스트로 변환했다.
- 스텁 구현으로 빠르게 컴파일을 통과하도록 만들었다.
- 올바르다고 생각하는 코드를 입력하여 테스트를 통과했다.

느낌을 테스트로 변환하는 것이 TDD의 일반적 주제이다. \
우선 시스템이 이런 식으로 동작해야 하는지 저런 식으로 동작해야 하는지 논의할 수 있다.

## 3. 모두를 위한 평등

### 값 객체

- 객체의 인스턴스 변수가 생성자를 통해서 일단 설정된 후에는 결코 변하지 않는 것.
- 값 객체를 사용하면 별칭 문제에 대해 걱정할 필요가 없다.
  > 수표가 하나 있는데 여기에 $5를 설정하고, 또다른 수표에도 아까 설정했던 $5를 설정했다고 치자. 내 경험 중에서 가장 형편없었던 버그는 부주의하게 두 번째 수표의 값을 변화시키는 바람에 첫 번째 수표의 값까지 변하게 되는 문제로 인한 것이었다. 이게 별칭 문제다.
- 값 객체가 암시하는 것 중 하나는 2장에서와 같이 모든 연산은 새 객체를 반환해야 한다는 것. ( equals() 구현 )

---

To-Do List

- [ ] $5 + 10CHF = $10
- [x] $5 x 2 = $10
- [ ] amount를 private으로 만들기
- [x] Dollar 의 side effect
- [ ] Money 반올림 ?
- [ ] equals() \*
- [ ] hashCode()

---

> 만약 Dollar를 해시 테이블의 키로 쓸 생각이라면 equals()를 구현할 때에 hashCode()를 같이 구현해야 한다.

### 3-1. 테스트 작성하기

```java
public void testEquality() {
  assertTrue(new Dollar(5).equals(new Dollar(5)));
}
```

- 가짜로 구현 ( true 반환 )

```java
public boolean equals(Object object) {
  return true;
}
```

#### 삼각측량

- 가장 신중한 세 번째 방법.
- 라디오 신호를 두 수신국이 감지하고 있을 때 수신국 사이의 거리와 방향을 안다면 신호의 거리와 방위를 알 수 있는 계산법
- 삼각측량을 이용하려면 예제가 두 개 있어야 코드를 일반화 할 수 있다.

```java
public void testEquality() {
  assertTrue(new Dollar(5).equals(new Dollar(5)));
  assertFalse(new Dollar(5).equals(new Dollar(6)));
}
```

- 동치성 일반화 하기

```java
public boolean equals(Object object) {
  Dollar dollar = (Dollar) object;
  return amount == dollar.amount;
}
```

동시성 문제는 일시적으로 해결됐다. 하지만 널 값이나 다른 객체들과 비교한다면 어떻게 될까?

---

To-Do List

- [ ] $5 + 10CHF = $10
- [x] $5 x 2 = $10
- [ ] amount를 private으로 만들기 \*
- [x] Dollar 의 side effect
- [ ] Money 반올림 ?
- [x] equals()
- [ ] hashCode()
- [ ] Equal null
- [ ] Equal object

---

### 3-1. 지금까지 한 작업들

- 우리의 디자인 패턴(값 객체)이 하나의 또 다른 오퍼레이션을 암시한다는 걸 알아챘다.
- 해당 오퍼레이션을 테스트했다.
- 해당 오퍼레이션을 간단히 구현했다.
- 곧장 리팩토링하는 대신 테스트를 조금 더 했다.
- 두 경우를 모두 수용할 수 있도록 리팩토링했다.

## 4. 프라이버시

---

To-Do List

- [ ] $5 + 10CHF = $10
- [x] $5 x 2 = $10
- [ ] amount를 private으로 만들기
- [x] Dollar 의 side effect
- [ ] Money 반올림 ?
- [x] equals()
- [ ] hashCode()
- [ ] Equal null
- [ ] Equal object

---

### 4-1. 테스트 작성하기

동치성 문제를 정의했으므로 이를 이용하여 테스트에 적용하자.\
개념적으로 Dollar.times() 연산은 호출을 받은 객체의 값에 인자로 받은 곱수만큼 곱한 값을 갖는 Dollar를 반환해야한다.

```java
public void testMultiplicatioin() {
  Dollar five = new Dollar(5);
  Dollar product = five.times(2);
  assartEquals(10, product.amount);
  product = five.times(3);
  assartEquals(15, procuet.amount);
}
```

- Dollar와 Dollar를 비교하는 것으로 재작성할 수 있다.

```java
public void testMultiplicatioin() {
  Dollar five = new Dollar(5);
  Dollar product = five.times(2);
  assartEquals(new Dollar(10), product);
  product = five.times(3);
  assartEquals(new Dollar(15), product);
}
```

- 임시변수인 product는 불필요 하다.

```java
public void testMultiplicatioin() {
  Dollar five = new Dollar(5);
  assartEquals(new Dollar(10), five.times(2));
  assartEquals(new Dollar(15), five.times(3));
}
```

- 이제 Dollar의 amount 인스턴스 변수를 사용하는 코드는 Dollar 자신밖에 없게 됐다.
- 따라서 변수를 private으로 변경할 수 있다.

```java
class Dollar {
  private int amount;
  ...
}
```

---

To-Do List

- [ ] $5 + 10CHF = $10
- [x] ~~$5 x 2 = $10~~
- [x] ~~amount를 private으로 만들기~~
- [x] ~~Dollar 의 side effect~~
- [ ] Money 반올림 ?
- [x] ~~equals()~~
- [ ] hashCode()
- [ ] Equal null
- [ ] Equal object

---

만약 동치성 테스트가 동치성에 대한 코드가 정확히 작동한다는 것을 검증하는 데 실패한다면, \
곱하기 테스트 역시 곱하기에 대한 코드가 정확하게 작동한다는 것을 검증하는 데 실패하게 된다.

#### 4-1. 지금까지 한 작업들

- 오직 테스트를 향상시키기 위해서만 개발된 기능을 사용했다.
- 두 테스트가 동시에 실패하면 망한다는 점을 인식했다.
- 위험 요소가 있음에도 계속 진행했다.
- 테스트와 코드 사이의 결합도를 낮추기 위해, 테스트하는 객체의 새 기능을 사용했다.

## 5. 솔직히 말하자면

---

To-Do List

- [ ] $5 + 10CHF = $10
- [x] ~~$5 x 2 = $10~~
- [x] ~~amount를 private으로 만들기~~
- [x] ~~Dollar 의 side effect~~
- [ ] Money 반올림 ?
- [x] ~~equals()~~
- [ ] hashCode()
- [ ] Equal null
- [ ] Equal object
- [ ] 5CHF x 2 = 10CHF \*

---

### 5-1. 테스트 작성하기

- Dollar 객체와 비슷하지만 달러 대신 Franc을 표현할 수 있는 객체가 필요 할 것 같다.

```java
public void testFrancMultiplicatioin() {
  Franc five = new Franc(5);
  assartEquals(new Franc(10), five.times(2));
  assartEquals(new Franc(15), five.times(3));
}
```

- Dollar 코드를 복사해서 Dollar를 Franc으로 바꾸면 어떨까.
- 중복코드를 사용하는 것이 문제되지만 일단 테스트가 통과 되게 만드는 것이 더 중요하다.
- 그렇다고 중복 제거가 중요하지 않다는 뜻은 아니다.
- 적절한 시기에 적절한 설계를. 돌아가게 만들고 올바르게 만들어라.

### 5-2. 테스트 통과하기

```java
class Franc {
  private int amount;

  Franc (int amount) {
    this.amount = amount;
  }

  Franc times (int multiplier) {
    return new Franc(amount * multiplier);
  }

  public boolean equals(Object object) {
    Franc franc = (Franc) object;
    return amount == franc.amount;
  }
}
```

---

To-Do List

- [ ] $5 + 10CHF = $10
- [x] ~~$5 x 2 = $10~~
- [x] ~~amount를 private으로 만들기~~
- [x] ~~Dollar 의 side effect~~
- [ ] Money 반올림 ?
- [x] ~~equals()~~
- [ ] hashCode()
- [ ] Equal null
- [ ] Equal object
- [x] ~~5CHF x 2 = 10CHF~~
- [ ] Dollar/Franc 중복
- [ ] 공용 equals
- [ ] 공용 times

---

#### 5-1. 지금까지 한 작업들

- 큰 테스트를 공략할 수 없다. 그래서 진전을 나타낼 수 있는 자그마한 테스트를 만들었다.
- 뻔뻔스럽게도 중복을 만들고 조금 고쳐서 테스트를 작성했다.
- 설상가상으로 모델 코드까지 도매금으로 복사하고 수정해서 테스트를 통과했다.
- 중복이 사라지기 전에는 집에 가지 않겠다고 약속했다.

## 6. 돌아온 '모두를 위한 평등'

---

To-Do List

- [ ] $5 + 10CHF = $10
- [x] ~~$5 x 2 = $10~~
- [x] ~~amount를 private으로 만들기~~
- [x] ~~Dollar 의 side effect~~
- [ ] Money 반올림 ?
- [x] ~~equals()~~
- [ ] hashCode()
- [ ] Equal null
- [ ] Equal object
- [x] ~~5CHF x 2 = 10CHF~~
- [ ] Dollar/Franc 중복
- [ ] 공용 equals \*
- [ ] 공용 times

---

### Dollar와 Franc의 공통 상위 클래스를 찾아내기

1. 공통의 상위 클래스인 Money 생성하기

```java
class Money
```

```java
class Dollar extends Money {
  private int amount;
  ...
}
```

2. amount 인스턴스 변수를 Money로 옮기기

```java
class Money {
  protected int amount;
}
```

```java
class Dollar extends Money {
  ...
}
```

3. 이제 equals() 코드를 위로 올리는 일을 할 수 있게 됐다. 우선 임시변수를 선언하는 부분을 변경

```java
// Dollar

public boolean equals(Object object) {
  Money money = (Money) object;
  return amount == money.amount;
}
```

4. 이 메서드를 Dollar에서 Money로 옮길 수 있다.

```java
// Money

public boolean equals(Object object) {
  Money money = (Money) object;
  return amount == money.amount;
}
```

5. Franc.equals() 제거

- 현재 동치성 테스트가 Franc끼리의 비교에 대해서는 다루지 않는다. => 이를 추가하자.

```java
public void testEquality() {
  assertTrue(new Dollar(5).equals(new Dollar(5)));
  assertFalse(new Dollar(5).equals(new Dollar(6)));
  assertTrue(new Franc(5).equals(new Franc(5)));
  assertFalse(new Franc(5).equals(new Franc(6)));
}
```

- Franc의 equals를 상위 클래스 Money에 맞게 고쳐보고, Money의 equals와 동일하다면 제거한다.

```java
// Franc
...
@deprecated
public boolean equals(Object object) { // Money의 equals와 동일하므로 제거
  Money money = (Money) object;
  return amount == Money.amount;
}
```

---

To-Do List

- [ ] $5 + 10CHF = $10
- [x] ~~$5 x 2 = $10~~
- [x] ~~amount를 private으로 만들기~~
- [x] ~~Dollar 의 side effect~~
- [ ] Money 반올림 ?
- [x] ~~equals()~~
- [ ] hashCode()
- [ ] Equal null
- [ ] Equal object
- [x] ~~5CHF x 2 = 10CHF~~
- [ ] Dollar/Franc 중복
- [x] ~~공용 equals~~ \*
- [ ] 공용 times
- [ ] Franc과 Dollar 비교하기

---

- 테스트는 잘돌아간다.
- 하지만 Franc과 Dollar를 비교하면 어떻게 될까?

#### 6-1. 지금까지 한 작업들

- 공통된 코드를 첫 번째 클래스(Dollar)에서 상위 클래스(Money)로 단계적으로 옮겼다.
- 두번째 클래서(Franc)도 Money의 하위 클래스로 만들었다.
- 불필요한 구현을 제거하기 전에 두 equals()구현을 일치 시켰다.

## 7. 사과와 오렌지

---

To-Do List

- [ ] $5 + 10CHF = $10
- [x] ~~$5 x 2 = $10~~
- [x] ~~amount를 private으로 만들기~~
- [x] ~~Dollar 의 side effect~~
- [ ] Money 반올림 ?
- [x] ~~equals()~~
- [ ] hashCode()
- [ ] Equal null
- [ ] Equal object
- [x] ~~5CHF x 2 = 10CHF~~
- [ ] Dollar/Franc 중복
- [x] ~~공용 equals~~
- [ ] 공용 times
- [ ] **Franc과 Dollar 비교하기** \*

---

### 7-1. 테스트 추가

- Franc과 Dollar를 비교하면 어떻게 될까?

```java
public void testEquality() {
  assertTrue(new Dollar(5).equals(new Dollar(5)));
  assertFalse(new Dollar(5).equals(new Dollar(6)));
  assertTrue(new Franc(5).equals(new Franc(5)));
  assertFalse(new Franc(5).equals(new Franc(6)));
  assertFalse(new Franc(5).equals(new Dollar(5)));
}
```

- 마지막 테스트를 통과시키기 위해 오직 금액과 클래스가 서로 동일할 때만 두 Money가 서로 같은 것으로 코드를 수정하자.

```java
// Money
public boolean equals(Object object) {
  Money money = (Money) object;
  return amount == money.amount
    && getClass().equals(money.getClass());
}
```

- 자바 객체의 용어를 사용하는 것보다 재정 분야에 맞는 용어를 사용하고 싶다.
- 하지만 현재는 통화 개념 같은게 없고, 통화 개념을 도입할 충분한 이유가 없어 보이므로 잠시 동안은 이대로 두자.

### 7-1. 지금까지 한 일

---

To-Do List

- [ ] $5 + 10CHF = $10
- [x] ~~$5 x 2 = $10~~
- [x] ~~amount를 private으로 만들기~~
- [x] ~~Dollar 의 side effect~~
- [ ] Money 반올림 ?
- [x] ~~equals()~~
- [ ] hashCode()
- [ ] Equal null
- [ ] Equal object
- [x] ~~5CHF x 2 = 10CHF~~
- [ ] Dollar/Franc 중복
- [x] ~~공용 equals~~
- [ ] 공용 times \*
- [x] ~~Franc과 Dollar 비교하기~~

---

- 우릴 괴롭히던 결함을 끄집어내서 테스트에 넣었다.
- 완벽하진 않지만 그럭저럭 봐줄 만한 방법 ( getClass() )으로 테스트를 통과하게 만들었다.
- 더 많은 동기가 있기 전에는 더 많은 설계를 도입하지 않기로 했다.

## 8. 객체 만들기

---

To-Do List

- [ ] $5 + 10CHF = $10
- [x] ~~$5 x 2 = $10~~
- [x] ~~amount를 private으로 만들기~~
- [x] ~~Dollar 의 side effect~~
- [ ] Money 반올림 ?
- [x] ~~equals()~~
- [ ] hashCode()
- [ ] Equal null
- [ ] Equal object
- [x] ~~5CHF x 2 = 10CHF~~
- [ ] Dollar/Franc 중복 \*
- [x] ~~공용 equals~~
- [ ] 공용 times
- [x] ~~Franc과 Dollar 비교하기~~

---

### Dollar/Franc 중복

두 times의 구현코드가 거의 똑같다.

```java
// Franc
Franc times(int multiplier) {
  return new Franc(amount * multiplier);
}
```

```java
// Dollar
Franc times(int multiplier) {
  return new Dollar(amount * multiplier);
}
```

양쪽 모두 Money를 반환하게 만들면 더 비슷하게 만들 수 있다.

```java
// Franc
Money times(int multiplier) {
  return new Franc(amount * multiplier);
}
```

```java
// Dollar
Money times(int multiplier) {
  return new Dollar(amount * multiplier);
}
```

- Money의 두 하위 클래스는 그다지 많은 일을 하는 것 같지 않으므로 아에 제거해버리고 싶다.
- 하위 클래스에 대한 직접적인 참조가 적어진다면 하위 클래스를 제거하기 위해 한 발짝 더 다가 섰다고 할 수 있겠다.
- Money에 Dollar를 반환하는 팩토리 메서드를 도입할 수 있다.

```java
public void testMultiplicatioin() {
  Dollar five = Money.dollar(5);
  assartEquals(new Dollar(10), five.times(2));
  assartEquals(new Dollar(15), five.times(3));
}
```

```java
// Money
static Dollar dollar(int amount) {
  return new Dollar(amount);
}
```

- Dollar에 대한 참조가 사라지길 바라므로 테스트의 선언부를 다음과 같이 바꿔야 한다.

```java
public void testMultiplicatioin() {
  Dollar five = Money.dollar(5);
  assartEquals(Money.dollar(10), five.times(2));
  assartEquals(Money.dollar(15), five.times(3));
}
```

- 컴파일러가 Money에는 times()가 정의되지 않았다는 사실을 알려준다.
- 아직 times를 정의할 준비가 되지 않았기 때문에, Money를 추상 클래스로 변경한 후 Money.times()를 선언하자.

```java
// Money
abstract class Money {
  ...
  abstract Money times(int multiplier);
  static Money dollar(int amount) {
    return new Dollar(amount);
  }
}
```

- 모든 테스트가 실행되므로 최소한 뭔가를 깨트리진 않았다.
- 이제 팩토리 메서드를 테스트 코드의 나머지 모든 곳에서 사용할 수 있다.

```java
public void testMultiplicatioin() {
  Dollar five = Money.dollar(5);
  assartEquals(Money.dollar(10), five.times(2));
  assartEquals(Money.dollar(15), five.times(3));
}
```

```java
public void testEquality() {
  assertTrue(Money.dollar(5).equals(Money.dollar(5)));
  assertFalse(Money.dollar(5).equals(nMoney.dollar(6)));
  assertTrue(new Franc(5).equals(new Franc(5)));
  assertFalse(new Franc(5).equals(new Franc(6)));
  assertFalse(new Franc(5).equals(Money.dollar(5)));
}
```

- 어떤 클라이언트 코드도 Dollar라는 이름의 클래스가 있다는 사실을 알지 못한다.
- Decoupling함으로써 어떤 모델코드에도 영향을 주지 않고 상속 구조를 마음대로 변경할 수 있게 됐다.

- Franc에도 적용하기

```java
public void testMultiplicatioin() {
  Franc five = Money.franc(5);
  assartEquals(Money.franc(10), five.times(2));
  assartEquals(Money.franc(15), five.times(3));
}
```

```java
public void testEquality() {
  assertTrue(Money.dollar(5).equals(Money.dollar(5)));
  assertFalse(Money.dollar(5).equals(nMoney.dollar(6)));
  assertTrue(Money.franc(5).equals(Money.franc(5)));
  assertFalse(Money.franc(5).equals(Money.franc(6)));
  assertFalse(Money.franc(5).equals(Money.dollar(5)));
}
```

```java
// Money
static Money franc(int amount) {
  return new Franc(amount);
}
```

---

To-Do List

- [ ] $5 + 10CHF = $10
- [x] ~~$5 x 2 = $10~~
- [x] ~~amount를 private으로 만들기~~
- [x] ~~Dollar 의 side effect~~
- [ ] Money 반올림 ?
- [x] ~~equals()~~
- [ ] hashCode()
- [ ] Equal null
- [ ] Equal object
- [x] ~~5CHF x 2 = 10CHF~~
- [ ] Dollar/Franc 중복 \*
- [x] ~~공용 equals~~
- [ ] 공용 times
- [x] ~~Franc과 Dollar 비교하기~~
- [ ] 통화?
- [ ] testFrancMuliplication을 지워야 할까?

---

### 8. 지금까지 한 일

- 동일한 메서드(times)의 두 변이형 메서드 서명부를 통일시킴으로써 중복 제거를 향해 한 단계 더 전진했다.
- 최소한 메서드 선언부만이라도 공통 상위 클래스(superclass)로 옮겼다.
- 팩토리 메서드를 도입하여 테스트 코드에서 콘크리트 하위 클래스의 존재 사실을 분래해냈다.
- 하위 클래스가 사라지면 몇몇 테스트는 불필요한 여분의 것이 된다는 것을 인식했다. 하지만 일단 그냥 뒀다.

## 9. 우리가 사는 시간

---

To-Do List

- [ ] $5 + 10CHF = $10
- [x] ~~$5 x 2 = $10~~
- [x] ~~amount를 private으로 만들기~~
- [x] ~~Dollar 의 side effect~~
- [ ] Money 반올림 ?
- [x] ~~equals()~~
- [ ] hashCode()
- [ ] Equal null
- [ ] Equal object
- [x] ~~5CHF x 2 = 10CHF~~
- [ ] Dollar/Franc 중복
- [x] ~~공용 equals~~
- [ ] 공용 times
- [x] ~~Franc과 Dollar 비교하기~~
- [ ] 통화? \*
- [ ] testFrancMuliplication을 지워야 할까?

---

### 통화개념에 대한 테스트 추가하기

- 하위클래스를 제거하기 위해 통화개념을 도입해보면 어떨까?
- 통화개념을 어떻게 테스트하길 원하는가?
- 경량 팩토리(flyweight factories) 패턴을 사용해 볼 수 있다.

```java
public void testCurrency() {
  assertEquals("USD", Money.dollar(1).currency());
  assertEquals("CHF", Money.franc(1).currency());
}
```

### 통화개념 구현

- Money에 currency() 메서드 추가

```java
// Money
abstract String currency();
```

- 두 하위 클래스에서 이를 구현하자

```java
// Franc
String currency() {
  return "CHF";
}

// Dollar
String currency() {
  return "USD";
}
```

- 우선 두 클래스를 모두 포함할 수 있는 동일한 구현을 원한다.
- 통화를 인스턴스 변수에 저장하고, 메서드에서는 그냥 그걸 반환하게 만들 수 있을 것 같다.

```java
// Franc
private String curreny;

Frnac(int amount) {
  this.amount = amount;
  currency = "CHF";
}

String curreny() {
  return currency;
}
```

```java
// Dollar
private String curreny;

Dollar(int amount) {
  this.amount = amount;
  currency = "USD";
}

String curreny() {
  return currency;
}
```

- 이제 두 currency()가 동일하므로 변수 선언과 currency() 구현을 둘 다 위로 올릴(push up) 수 있게 됐다.

```java
// Money
protected String currency;
String currency() {
  return currency;
}
```

- 문자열 'USD'와 'CHF'를 정적 팩토리 메서드로 옮긴다면 두 생성자가 동일해질 것이고, 그렇다면 공통 구현을 만들 수 있을 것이다.
- 우선 생성자에 인자를 추가하자

```java
// Franc
Franc(int amount, String currency) {
  this.amount = amount;
  this.currency = "CHF";
}
```

- 생성자를 호출하는 코드 두 곳이 깨진다.

```java
// Money
static Money franc(int amount) {
  return new Franc(amount, null);
}
```

```java
// Franc
Money times(int multiplier) {
  return new Franc(amount * multiplier, null);
}
```

- 잠깐! 왜 Franc.times()가 팩토리 메서드를 호출하지 않고 생성자를 호출하는 거지?
- 진행하기 전에 times()를 정리하자

```java
// Franc
Money times(int multiplier) {
  return Money.franc(amount * multiplier);
}
```

- 이젠 팩토리 메서드가 'CHF'를 전달할 수 있다.

```java
// Money
static Money franc(int amount) {
  return new Franc(amount, "CHF");
}
```

- 그리고 마지막으로 인자를 인스턴스 변수에 할당할 수 있다.

```java
// Franc
Franc(int amount, String currency) {
  this.amount = amount;
  this.currency = currency;
}
```

- 단번에 Dollar도 유사하게 수정가능하다.

```java
// Money
static Money dollar(int amount) {
  return new Dollar(amount, "USD");
}
```

```java
// Dollar
Dollar(int amount, String currency) {
  this.amount = amount;
  this.currency = currency;
}

Money times(int multiplier) {
  return Money.dollar(amount * multiplier);
}
```

- 두 생성자가 이제 동일해졌다. 구현을 상위 클래스에 올리자.

```java
// Money
Money(int amount, String currency) {
  this.amount = amount;
  this.currency = currency;
}
```

```java
// Franc
Franc(int amount, String currency) {
  super(amount, currency);
}
```

```java
// Dollar
Dollar(int amount, String currency) {
  super(amount, currency);
}
```

---

To-Do List

- [ ] $5 + 10CHF = $10
- [x] ~~$5 x 2 = $10~~
- [x] ~~amount를 private으로 만들기~~
- [x] ~~Dollar 의 side effect~~
- [ ] Money 반올림 ?
- [x] ~~equals()~~
- [ ] hashCode()
- [ ] Equal null
- [ ] Equal object
- [x] ~~5CHF x 2 = 10CHF~~
- [ ] Dollar/Franc 중복
- [x] ~~공용 equals~~
- [ ] 공용 times
- [x] ~~Franc과 Dollar 비교하기~~
- [x] ~~통화?~~
- [ ] testFrancMuliplication을 지워야 할까?

---

### 9. 지금까지 한 일

- 큰 설계 아이디어를 다루다가 조금 곤경에 빠졌다. 그래서 좀 전에 주목했던 더 작은 작업을 수행했다.
- 다른 부분들을 호출자(팩토리 메서드)로 옮김으로써 두 생성자를 일치시켰다.
- times()가 팩토리 메서드를 사용하도록 만들기 위해 리팩토링을 잠시 중단했다.
- 비슷한 리팰토링(Franc에 했던 일을 Dollar에도 적용)을 한번의 큰 단계로 처리했다.
- 동일한 생성자들을 상위 클래스로 올렸다.
