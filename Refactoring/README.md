# REFECTORING - Martin Fowler

- [REFECTORING - Martin Fowler](#refectoring---martin-fowler)
  - [9. 데이터 조직화](#9-데이터-조직화)
    - [9-1. 변수 쪼개기](#9-1-변수-쪼개기)
      - [루프변수](#루프변수)
      - [수집변수](#수집변수)
    - [9-2. 필드 이름 바꾸기](#9-2-필드-이름-바꾸기)
    - [9-3. 파생 변수를 질의 함수로 바꾸기](#9-3-파생-변수를-질의-함수로-바꾸기)
      - [변형 연산 ( Transformation Operation )](#변형-연산--transformation-operation-)
    - [9-4. 참조를 값으로 바꾸기](#9-4-참조를-값으로-바꾸기)
      - [값 객체 (Value Object)](#값-객체-value-object)
      - [동치성 비교 매서드](#동치성-비교-매서드)
    - [9-5. 값을 참조로 바꾸기](#9-5-값을-참조로-바꾸기)
      - [저장소 객체 Repository Object](#저장소-객체-repository-object)
    - [9-6. 매직 리터럴 바꾸기](#9-6-매직-리터럴-바꾸기)
      - [매직 리터럴 Magic Literal](#매직-리터럴-magic-literal)
  - [10. 조건부 로직 간소화](#10-조건부-로직-간소화)
    - [10-1. 조건문 분해하기](#10-1-조건문-분해하기)
    - [10-2. 중복 조건식 통합하기](#10-2-중복-조건식-통합하기)
    - [10-3. 중첩 조건문을 보호 구문으로 바꾸기](#10-3-중첩-조건문을-보호-구문으로-바꾸기)
      - [보호구문이란?](#보호구문이란)
    - [10-4. 조건부 로직을 다형성으로 바꾸기](#10-4-조건부-로직을-다형성으로-바꾸기)
    - [10-5. 특이 케이스 추가하기 ( NULL 객체 추가하기 )](#10-5-특이-케이스-추가하기--null-객체-추가하기-)
      - [특이케이스 패턴 ( Special Case Pattern )](#특이케이스-패턴--special-case-pattern-)
      - [예시: 변환 함수 이용하기](#예시-변환-함수-이용하기)
    - [10-6. 어서션 추가하기](#10-6-어서션-추가하기)
      - [좋은 Assertion](#좋은-assertion)
    - [10-7. 제어 플래그를 탈출문으로 바꾸기](#10-7-제어-플래그를-탈출문으로-바꾸기)
      - [제어 플래그](#제어-플래그)

## 9. 데이터 조직화

### 9-1. 변수 쪼개기

루프변수나 수집변수가 아닌 변수의 대입은 한번만 이뤄져야한다.

#### 루프변수

- 반복문 for(int i = 0 ; i < 10; i++) 에서 변수 i와 같은 변수

#### 수집변수

- 총합계산, 문자열 연결, 스트림에 쓰기, 컬렉션에 추가하기 등의 용도로 흔히 쓰인다.
- i = i + <무언가> 형태인 변수

```java
int temp = 2 * (height + width);
System.out.println(temp);

temp = height + width;
System.out.println(temp);
```

```java
final int perimeter = 2 * (height * width);
System.out.println(perimeter);

final int area = height * width;
System.out.println(area);
```

1. 변수를 선언한 곳과 값을 처음 대입하는 곳에서 변수 이름을 바꾼다.
2. 가능하면 이때 불변으로 선언한다.
3. 이 변수에 두 번째로 값을 대입하는 곳 앞까지의 모든 참조(이 변수가 쓰인 곳)를 새로운 변수 이름으로 바꾼다.
4. 두 번째 대입 시 변수를 원래 이름으로 다시 선언한다.
5. 테스트한다.
6. 반복한다. 매 반복에서 변수를 새로운 이름으로 선언하고 다음번 대입 때까지의 모든 참조를 새 변수명으로 바꾼다. 이 과정을 마지막 대입까지 반복한다.

### 9-2. 필드 이름 바꾸기

데이터 구조가 중요한 만큼 반드시 깔끔하게 관리해야한다.  
개발을 진행할수록 깊어진 이해를 프로그램에 반드시 반영해야 한다.

```javascript
class Organization {
  get name() {...}
}
```

```javascript
class Organization {
  get title() {...}
}
```

1. 레코드의 유효 범위가 제한적이라면 필드에 접근하는 모든 코드를 수정한 후 테스트한다. 이후 단계는 필요 없다.
2. 레코드가 캡슐화되지 않았다면 우선 레코드를 캡슐화한다.
3. 캡슐화된 객체 안의 private 필드명을 변경하고, 그에 맞게 내부 메서드들을 수정한다.
4. 테스트한다.
5. 생성자의 매개변수 중 필드와 이름이 겹치는 게 있다면 함수 선언 바꾸기로 변경한다.
6. 접근자들의 이름도 바꿔준다.

### 9-3. 파생 변수를 질의 함수로 바꾸기

가변 데이터를 없애기 위해 값을 쉽게 계산할 수 있는 변수들은 모두 제거해 볼 수 있다. ( 단, 변형 연산은 제외한다. )

#### 변형 연산 ( Transformation Operation )

1. 데이터 구조를 감싸며 그 데이터에 기초하여 계산한 결과를 속성으로 제공하는 객체.
2. 데이터 구조를 받아 다른 데이터 구조로 변환해 반환하는 함수.

```java
class ProductionPlan {
  private Integer production;
  private List<Adjustment> adjustments;

  ProductionPlan(Integer production) {
    this.production = production;
    this.adjustments = new HashList<>();
  }

  public Integer getProduction() {
    return this.production;
  }

  public void applyAdjustment(anAdjustment) {
    this.adjustments.push(anAdjustment);
    this.production += anAjdustment.amount();
  }
}
```

```java
class ProductionPlan {
  private Integer initialProduction;
  private Integer productAccumulator;
  private List<Adjustment> adjustments;

  ProductionPlan(Integer production) {
    this.initialProduction = production;
    this.productAccumulator = 0;
    this.adjustments = new HashList<>();
  }

  public Integer getProduction() {
    return this.initialProduction + calculatedProductionAccumulator();
  }

  public void applyAdjustment(anAdjustment) {
    this.adjustments.push(anAdjustment);
  }

  public Integer calculatedProductionAccumulator() {
    return this.adjustments.stream().reduce(0, Integer::sum);
  }
}
```

1. 변수 값이 갱신되는 지점을 모두 찾는다. 필요하면 변수 쪼개기를 활용해 각 갱신 지점에서 변수를 분리한다.
2. 해당 변수의 값을 계산해주는 함수를 만든다.
3. 해당 변수가 사용되는 모든 곳에 어서션을 추가하여 함수의 계산 결과가 변수의 값과 같은지 확인한다.
   - 필요하면 변수 캡슐화하기를 적용하여 어서션이 들어갈 장소를 마련해준다.
4. 테스트
5. 변수를 읽는 코드를 모두 함수 호출로 대체한다.
6. 테스트
7. 변수를 선언하고 갱신하는 코드를 죽은 코드 제거하기로 없앤다.

### 9-4. 참조를 값으로 바꾸기

필드를 내부 객체의 클래스를 수정하여 값 객체로 만들 수 있다.  
값 객체는 불변 데이터가 되면 프로그램 외부로 건내줘도 나중에 그 값이 나 몰래 바뀌어서 내부에 영향을 줄까 염려하지 않아도 된다.

> 객체를 다른 객체에 중첩하면 내부객체를 참조 혹은 값으로 취급할 수 있다.
>
> - 참조 - 내부 객체는 그대로 둔 채 그 객체의 속성만 갱신하는 때
> - 값 - 새로운 속성을 담은 객체로 기존 객체를 통채로 대체할 때

```java
class Product {
  private Money price;

  public void applyDiscount(int arg) {
    price.setAmount(price.getAmount() - arg);
  }
}
```

```java
class Product {
  private Money price;

  public void applyDiscount(int arg) {
    price = new Money(price.getAmount() - arg, price.getCurrency());
  }
}
```

1. 후보 클래스가 불변인지, 혹은 불변이 될 수 있는지 확인한다.
2. **각각의 세터를 하나씩 제거한다.**
3. 이 값의 객체의 필드들을 사용하는 동치성 비교 매서드를 만든다.

#### 값 객체 (Value Object)

- <https://martinfowler.com/bliki/ValueObject.html>

#### 동치성 비교 매서드

- 대부분의 언어는 이런 상황에 사용할 수 있는 오버라이딩 가능한 동치성 비교 메서드를 제공한다. 보통은 해쉬코드 생성 매서드도 함께 오버라이드 해야한다.

```java
 public class Person {

      private Integer age;
      private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

}
```

### 9-5. 값을 참조로 바꾸기

논리적으로 같은 데이터를 물리적으로 복제해 사용할 때 가장 크게 문제되는 상황은 그 데이터를 갱신해야 할 때이다. 모든 복제본을 찾아서 빠짐없이 갱신해야 하며, 하나라도 놓치면 데이터 일관성이 깨져버린다.  
이런 상황이라면 복제된 데이터를 모두 참조로 바꿔주는 것이 좋다. 이렇게 값을 참조로 바꾸면 엔티티 하나당 객체도 단 하나만 존재하게 된다.  
이 때는 **객체들을 한데 모아놓고 클라이언트들의 접근을 관리해주는 일종의 저장소**가 필요해진다.

```java
Customer customer = new Customer(customerData);
```

```java
Customer customer = customerRepository.get(customerData.id);
```

1. 같은 부류에 속하는 객체들을 보관할 저장소를 만든다.
2. 생성자에서 이 부류의 객체들 중 특정 객체를 정확히 찾아내는 방법이 있는지 확인한다.
3. 호스트 객체의 생성자들을 수정하여 필요한 객체를 이저장소에서 찾도록 한다. 하나 수정할 때 마다 테스트한다.

#### 저장소 객체 Repository Object

- 객체를 어디다 저장해야 할지는 애플리케이션에 따라 다르겠지만, 간단한 상황이라면 저장소 객체를 사용한다.

```javascript
let _repositoryData;

export function initialize() {
  _repositoryData = {};
  _repositoryData.customers = new Map();
}

export function registerCustomer(id) {
  if (!_repositoryData.customers.has(id))
    _repositoryData.customers.set(id, new Customer(id));
  return findCustomer(id);
}

export function findCustomer(id) {
  return _repositoryData.customers.get(id);
}
```

### 9-6. 매직 리터럴 바꾸기

#### 매직 리터럴 Magic Literal

- 소스 코드에 등장하는 일반적인 리터럴 값을 말한다.
- 아래 코드에서 9.81이 의미를 모른다면 숫자 자체로 의미를 명확히 알려주지 못하므로 매직 리터럴이라고 할 수 있다.
- 상수롤 비교할 경우가 많다면 상수보단 함수를 사용하자.
- 과유불급

```java
Double potentialEnergy(Double mass, Double height) {
  return mass * 9.81 * height;
}
```

```java
private final Double STANDARD_GRAVITY = 9.81;

Double potentialEnergy(Double mass, Double height) {
  return mass * STANDARD_GRAVITY * height;
}
```

1. 상수를 선언하고 매직 리터럴을 대입힌다.
2. 해당 리터럴이 사용되는 곳을 모두 찾는다.
3. 찾은 곳 각각에서 리터럴이 새 상수와 똑같은 의미로 쓰였는지 확인하여, 같은 의미라면 상수로 대체한 후 테스트한다.

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
if (aCustomer == "UnknownCustomer")
  customerName = "Resident"
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

- 특수한 경우의 공통동작을 요소 하나에 모아서 사용하는 특이 케이스 패턴 이라는 것이 있는데, 바로 이럴 때 적용하면 좋은 매커니즘이다.

#### 예시: 변환 함수 이용하기

- Site의 Json 데이터

```json
{
  "name": "Acme Boston",
  "location": "Malden MA",
  "customer": {
    "name": "Acme Industry",
    "billingPlan": "plan-451",
    "paymentHistory": {
      "weeksDelinquentInLastYear": 7
    }
  }
}

{
  "name": "Warehouse 15",
  "location": "Malden MA",
  "customer": "Unknown Customer"
}
```

- Before Refactoring

```javascript
const site = acquireSiteData();
const aCustomer = site.customer;

// Client 1
let customerName;
if (aCustomer === "Unknown Customer") customerName = "Resident";
else customerName = aCustomer.name;

// Client 2
const plan =
  aCustomer === "Unknown Customer"
    ? registry.billingPlans.basic
    : aCustomer.billingPlan;

// Client 3
const weeksDelinquent =
  aCustomer === "Unknown Customer"
    ? 0
    : aCustomer.paymentHistory.weeksDelinquentInLastYear;
```

- After Refactoring

```javascript
// enrichSite - 변환 함수
// 본질은 같고 부가 정보만 덧붙이는 변환 함수의 이름을 enrich라 하고, 형태가 변할 때만 transform이라는 이름을 쓴다.
// 특별한 작업 없이 Deep Copy만 수행한다.

function enrichSite(aSite) {
  const result = _.cloneDeep(aSite);
  const unknownCustomer = {
    isUnknown: true,
    name: "Resident",
    billingPlan: registry.billingPlans.basic,
    paymentHistory: {
      weeksDelinquentInLastYear: 0
    }
  };

  if (isUnknown(result.customer)) return.customer = unknownCustomer;
  else result.customer.isUnknown = false;
  return result;
}
```

```javascript
const site = enrichSite(acquireSiteData());
const aCustomer = site.customer;

// Client 1
const customerName = aCustomer.name;

// Client 2
const plan = aCustomer.billingPlan;

// Client 3
const weeksDelinquent = aCustomer.paymentHistory.weeksDelinquentInLastYear;
```

### 10-6. 어서션 추가하기

- 특정 조건이 참일 때만 제대로 동작하는 코드 영역이 있을 수 있다. 이런 가정이 명시적으로 코드에 기술되어 있지는 않아서 알고리즘을 보고 연역해서 알아내야 할 때도 있다. 이럴때 Assertion을 삽입하는 것이다.

```java
if (this.discountRate) {
  base = base - (this.discountRate() * base);
}
```

```java
assert this.discountRate() >= 0
if (this.discountRate) {
  base = base - (this.discountRate() * base);
}
```

1. 참이라고 가정하는 조건이 보이면 그 조건을 명시하는 어서션을 추가한다

> Assertion은 시스템 운영에 영향을 주면 안 되므로 어서션을 추가한다고 해서 동작이 달라지지는 않는다.

#### 좋은 Assertion

1. 반드시 참인 것이멘 검사하는 것이 좋다.
2. 외부에서 가져온 데이터를 검사하는 것이라면 예외처리를 이용하자.
3. Assertion의 조건이 자주 바뀌기 때문에 중복은 치명적이다. 중복된 Assertion이 있다면 중복은 함수 추출로 제거하자.

- [Using Java Assertions](https://www.baeldung.com/java-assert)

### 10-7. 제어 플래그를 탈출문으로 바꾸기

- 제어 플래그의 주 서식지는 반복문 안이다. break나 continue에 익숙하지 않은 사람이나 함수의 return을 하나로 유지하고자 하는 사람이 심기도 한다. 함수에서 할 일을 마쳤다면 그 사실을 return 문으로 명확히 알리는 편이 낫다.

```java
for (Person p : people) {
  if (!found) {
    if (p instanceof Joker) {
      sendAlert();
      found = true;
    }
  }
}
```

```java
for (Person p : people) {
  if (p instanceof Joker) {
    sendAlert();
    break;
  }
}
```

1. 제어 플래그를 사용하는 코드를 함수로 추출 할지 고려한다.
2. 제어 플래그를 갱신하는 코드를 각각을 적절한 제어문으로 바꾼다. 하나 바꿀 때마다 테스트한다.
   - return, break, countinue
3. 모두 수정했다면 제어 플래그를 제거한다.

#### 제어 플래그

- 코드의 동작을 변경하는 데 사용되는 변수
