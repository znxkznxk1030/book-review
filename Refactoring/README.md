# REFECTORING - Martin Fowler

- [REFECTORING - Martin Fowler](#refectoring---martin-fowler)
  - [10. 조건부 로직 간소화](#10-조건부-로직-간소화)
    - [10-1. 조건문 분해하기](#10-1-조건문-분해하기)
    - [10-2. 중복 조건식 통합하기](#10-2-중복-조건식-통합하기)
    - [10-3. 중첩 조건문을 보호 구문으로 바꾸기](#10-3-중첩-조건문을-보호-구문으로-바꾸기)
      - [보호구문이란?](#보호구문이란)
    - [10-4. 조건부 로직을 다형성으로 바꾸기](#10-4-조건부-로직을-다형성으로-바꾸기)
    - [10-5. 특이 케이스 추가하기 ( NULL 객체 추가하기 )](#10-5-특이-케이스-추가하기--null-객체-추가하기-)
      - [특이케이스 패턴 ( Special Case Pattern )](#특이케이스-패턴--special-case-pattern-)
    - [10-6. 어서션 추가하기](#10-6-어서션-추가하기)

## 10. 조건부 로직 간소화

> 조건부 로직은 프로그램의 힘을 강화하는 데 크게 기여하지만, 프로그램을 복잡하게 만드는 주요 원흉이기도 하다.

### 10-1. 조건문 분해하기

- 해당 조건이 무엇이고, 그래서 무엇을 분기했는지 명백하게 만들어 보자.

```java
if (!aDate.isBefore(plan.summerStart) && !aDate.isAfter(plan.summerEnd)) {
  charge = quantity * plan.summerRate;
} else {
  charge = quantity * plan.regularRate + plan.regularServiceCharge;
}
```

```java
if (summer()) {
  charge = summerCharge();
} else {
  charge = regularCharge();
}
```

1. 조건식과 그 조건식에 딸린 조건절 각각을 함수로 추출

### 10-2. 중복 조건식 통합하기

- 여러조각으로 나뉜 조건들을 하나로 통합함으로써 내가 하려는 일이 명확해진다.
- 이 작업이 함수추출하기로 이어질 가능성이 높다.

```java
if (anEmployee.seniority < 2) return 0;
if (anEmployee.monthsDisabled > 12) return 0;
if (anEmployee.isPartTime) return 0;
```

```java
if (isNotEligibleForDisability()) return 0;

Boolean isNotEligibleForDisability() {
  return (
    (anEmployee.seniority < 2) ||
    (anEmployee.monthsDisabled > 12) ||
    (anEmployee.isPartTime));
}
```

1. 해당 조건식에 부수효과 있는지 확인하기.
   - 부수효과가 있다면 함수분리하기 적용
2. 조건문 두 개를 선택하여 두 조건문의 조건식들을 논리연산자로 결합
   - 레벨이 같으면 OR, 중첩되면 AND
3. 테스트
4. 2-3 과정 반복
5. 하나로 합쳐진 조건식을 함수로 추출할지 고려해본다.

### 10-3. 중첩 조건문을 보호 구문으로 바꾸기

```java
Integer getPayAmount() {
  Integer result;
  if (isDead()) {
    result = deadAmount();
  } else {
    if (isSeperated()) {
      result = separatedAmount();
    } else {
      if (isRetired()) {
        result = retiredAmount();
      } else {
        result = normalPayAmount();
      }
    }
  }
  return result;
}
```

```java
Integer getPayAmount() {
  if (isDead) return deadAmount();
  if (isSeperated) return separatedAmount();
  if (isRetired) return retiredAmount();
  return normalPayAmound();
}
```

1. 교체해야 할 조건 중 가장 바깥 것을 선택하여 보호 구문으로 바꾼다.
2. 테스트 한다.
3. 1-2과정을 필요한 만큼 반복한다.
4. 모든 보호 구문이 같은 결과를 반환한다면 보호 구문들의 조건식을 통합한다.

#### 보호구문이란?

"이건 이 함수의 핵심이 아니야. 이 일이 일어나면 무언가 조치를 취한 후 함수에서 빠져나와" 하는 것.

### 10-4. 조건부 로직을 다형성으로 바꾸기

> 다형성으로 해결가능한 복잡한 조건부 로직을 발견하면 다형성이 막강한 도구임을 깨닫게 된다.

```java
String plumage(BirdVo birdVo) {
  switch (bird.getType()) {
    case "European Swallow":
      return "보통이다";
    case "African Swallow":
      return (bird.getNumberOfCoconuts() > 2)? "지첫다":  "보통이다";
    case "Norwegian Blue Parrot":
      return (bird.getVoltage() > 100) ? "그을렸다": "예쁘다";
    default:
      return "알 수 없다";
  }
}
```

```java
// 팩토리 패턴
List<String> plumages(List<BirdVo> birds) {
  return birds.stream()
  .map(b -> {return b.createBird(b)})
  .map(bird -> {
    return bird.plumage();
  })
  .collect(Collectors.toList());
}

Bird createBird(BirdVo birdVo) {
    switch (birdVo.type) {
    case "European Swallow":
      return new EuropeanSwallow();
    case "African Swallow":
      return new AfricanSwallow();
    case "Norwegian Blue Parrot":
      return new NorwegianBlueParrot();
    default:
      return new Bird();
  }
}

// 추상화
class EuropeanSwallow extends Bird {
  @Override
  String plumage() {
    return "보통이다";
  }
}

class AfricanSwallow extends Bird {
  @Override
  String plumage() {
    return (bird.numberOfCoconuts > 2)? "지첫다": "보통이다";
  }
}

class NorwegianBlueParrot extends Bird {
  @Override
  String plumage() {
    return (bird.voltage > 100) ? "그을렸다": "예쁘다";
  }
}
```

1. 다형적 동작을 표현하는 클래스들과 **팩토리 함수**를 만든다.
2. 호출하는 코드에서 **팩토리 함수**를 사용하게 한다.
3. 조건부 로직 함수를 슈퍼클래스로 옮긴다.
   - 조건부 로직이 온전한 함수로 분리되어 있지 않다면 먼저 함수로 추출한다.
4. 서브클래스에서 슈퍼클래스의 조건부 로직 메서드를 Override한다.
   - 조건부 문장 중 선택된 서브클래스에 해당하는 조건절을 서브클래스 메서드로 복사한 다음 적절히 수정
5. 같은 방식으로 각 조건절을 해당 서브클래스에서 메서드로 구현한다.
6. 슈퍼클래스 메서드에서는 기본 동작 부분만 남긴다.
   - 혹은 슈퍼클래스가 추상 클래스여야 한다면, 이 메서드를 추상으로 선언하거나 서브클래스에서 처리해야 함을 알리는 에러를 던진다.

### 10-5. 특이 케이스 추가하기 ( NULL 객체 추가하기 )

```java
if (aCustomer == "UnknownCustomer") customerName = "Resident"
```

```java
class UnknownCustomer {
  public String name() {
    return "Resident";
  }
}
```

1. 컨테이너에 특이 케이스 검사 속성을 추가하고 false 반환.
2. 특이 케이스 객체 생성. 특이 케이스 특이 케이스 검사 속성만을 추가하고 true 반환.
3. 클라이언트에서 특이 케이스인지 검사하는 코드를 함수로 추출
   - 클라이언트들의 특이 케이스 검사 코드는 함수로 교체.
4. 새로운 특이케이스 대상 추가.
   - 함수의 반환값으로 받거나 변환함수를 적용하면 된다.
5. 특이 케이스를 검사하는 함수 본문을 수정하여 특이 케이스 객체의 속성을 사용하도록 한다.
6. 테스트
7. 여러 함수를 클래스로 묶기나 여러가지 함수를 변환 함수로 묶기를 적용하여 특이 케이스를 처리하는 공통 동작을 새로운 요소로 옮긴다.
   - 특이 케이스 클래스는 간단한 요청에는 항상 같은 값을 변환하는 게 보통이므로, 해당 특이 케이스의 리터럴 레코드를 만들어 활용할 수도 있다.
8. 아직도 특이 케이스 검사 함수를 이용하는 곳이 남아있다면 검사 함수를 인라인 한다.

#### 특이케이스 패턴 ( Special Case Pattern )

> 특수한 경우의 공통동작을 요소 하나에 모아서 사용하는 특이 케이스 패턴 이라는 것이 있는데, 바로 이럴 때 적용하면 좋은 매커니즘이다.

### 10-6. 어서션 추가하기
