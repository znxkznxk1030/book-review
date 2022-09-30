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

기능 리스트

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

기능 리스트

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

기능 리스트

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
기능 리스트
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
  assartEquals(15, procuet.amount);
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
  assartEquals(15, procuet.amount);
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

기능 리스트

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

기능 리스트

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

---

기능 리스트

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