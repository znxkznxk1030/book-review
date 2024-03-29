# REFECTORING - Martin Fowler

- [REFECTORING - Martin Fowler](#refectoring---martin-fowler)
  - [7. 캡슐화](#7-캡슐화)
    - [7-1. 레코드 캡슐화하기](#7-1-레코드-캡슐화하기)
    - [7-2. 컬렉션 캡슐화하기](#7-2-컬렉션-캡슐화하기)
      - [내부 컬렉션을 직접 수정못하게 하는 방법](#내부-컬렉션을-직접-수정못하게-하는-방법)
    - [7-3. 기본형을 객체로 바꾸기](#7-3-기본형을-객체로-바꾸기)
    - [7-4. 임시 변수를 질의 함수로 바꾸기](#7-4-임시-변수를-질의-함수로-바꾸기)
    - [7-5. 클래스 추출하기](#7-5-클래스-추출하기)
    - [7-6. 클래스 인라인하기](#7-6-클래스-인라인하기)
    - [7-7. 위임 숨기기](#7-7-위임-숨기기)
    - [7-8. 중재자 제거하기](#7-8-중재자-제거하기)
    - [7-9. 알고리즘 교체하기](#7-9-알고리즘-교체하기)
  - [8. 기능 이동](#8-기능-이동)
    - [8-1. 함수 옮기기](#8-1-함수-옮기기)
      - [모듈성](#모듈성)
    - [8-2. 필드 옮기기](#8-2-필드-옮기기)
    - [8-3. 문장을 함수로 옮기기](#8-3-문장을-함수로-옮기기)
    - [8-4. 문장을 호출한 곳으로 옮기기](#8-4-문장을-호출한-곳으로-옮기기)
    - [8-5. 인라인 코드를 함수 호출로 바꾸기](#8-5-인라인-코드를-함수-호출로-바꾸기)
      - [함수의 장점](#함수의-장점)
    - [8-6. 문장 슬라이드하기](#8-6-문장-슬라이드하기)
      - [문장 슬라이드가 안되는 상황](#문장-슬라이드가-안되는-상황)
    - [8-7. 반복문 쪼개기](#8-7-반복문-쪼개기)
    - [8-8. 반복문을 파이프라인으로 바꾸기](#8-8-반복문을-파이프라인으로-바꾸기)
    - [8-9. 죽은 코드 제거하기](#8-9-죽은-코드-제거하기)
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
  - [11. API 리팩터링](#11-api-리팩터링)
    - [11-1. 질의 함수와 변경 함수 분리하기](#11-1-질의-함수와-변경-함수-분리하기)
      - [명령-질의 분리 ( command-query seperation )](#명령-질의-분리--command-query-seperation-)
    - [11-2. 함수 매개변수화하기](#11-2-함수-매개변수화하기)
    - [11-3. 플래그 인수 제거하기](#11-3-플래그-인수-제거하기)
      - [플래그 인수 ( flag argument )](#플래그-인수--flag-argument-)
    - [11-4. 객체 통째로 넘기기](#11-4-객체-통째로-넘기기)
    - [11-5. 매개변수를 질의 함수로 바꾸기](#11-5-매개변수를-질의-함수로-바꾸기)
      - [수용 객체](#수용-객체)
    - [11-6. 질의 함수를 매개변수로 바꾸기](#11-6-질의-함수를-매개변수로-바꾸기)
      - [참조 투명성](#참조-투명성)
    - [11-7. 세터 제거하기](#11-7-세터-제거하기)
      - [생성 스크립트](#생성-스크립트)
    - [11-8. 생성자를 팩터리 함수로 바꾸기](#11-8-생성자를-팩터리-함수로-바꾸기)
      - [생성자의 제약](#생성자의-제약)
    - [11-9. 함수를 명령으로 바꾸기](#11-9-함수를-명령으로-바꾸기)
      - [명령 ( 또는 명령 객체 )](#명령--또는-명령-객체-)
    - [11-10. 명령을 함수로 바꾸기](#11-10-명령을-함수로-바꾸기)
    - [11-11. 수정된 값 반환하기](#11-11-수정된-값-반환하기)
    - [11-12. 오류 코드를 예외로 바꾸기](#11-12-오류-코드를-예외로-바꾸기)
    - [11-13. 예외를 사전 확인으로 바꾸기](#11-13-예외를-사전-확인으로-바꾸기)
  - [12. 상속다루기](#12-상속다루기)
    - [12-1. 메서드 올리기](#12-1-메서드-올리기)
      - [템플릿 메서드 만들기 Form Template Method](#템플릿-메서드-만들기-form-template-method)
    - [12-2. 필드 올리기](#12-2-필드-올리기)
    - [12-3. 생성자 본문 올리기](#12-3-생성자-본문-올리기)
    - [12-4. 메서드 내리기](#12-4-메서드-내리기)
    - [12-5. 필드 내리기](#12-5-필드-내리기)
    - [12-6. 타입 코드를 서브클래스로 바꾸기](#12-6-타입-코드를-서브클래스로-바꾸기)
    - [12-7. 서브클래스 제거하기](#12-7-서브클래스-제거하기)
    - [12-8. 슈퍼클래스 추출하기](#12-8-슈퍼클래스-추출하기)
    - [12-9. 계층 합치기](#12-9-계층-합치기)
    - [12-10. 서브클래스를 위임으로 바꾸기](#12-10-서브클래스를-위임으로-바꾸기)
      - [상속의 단점](#상속의-단점)
    - [12-11. 슈퍼클래스를 위임으로 바꾸기](#12-11-슈퍼클래스를-위임으로-바꾸기)

## 7. 캡슐화

### 7-1. 레코드 캡슐화하기

- '가변' 데이터일 때 레코드보다 객체를 선호한다.
- 사용자는 무엇이 저장된 값이고 무엇이 계산된 값인지 알 필요가 없다.
- 이름을 변경할 때에도 좋다.

```javascript

class Organization {
  public String name = "애크미 구스베리";
  public String country = "GB";
}
```

```java
class Organization {
  private String name;
  private String country;

  Organization(String name, String country) {
    this.name = name;
    this.country = country;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry() {
    this.country = country;
  }

}
```

1. 레코드를 감은 변수를 캡슐화 한다.
2. 레코드를 감싼 단순한 클래스로 해당 변수의 내용을 교체한다. 이 클래스에 원본 레코드를 반환하는 접근자도 정의하고, 변수를 캡슐화 하는 함수들이 이 접근자를 사용하도록 수정한다.
3. 테스트한다.
4. 원본 레코드 대신 새로 정의한 클래스 타입의 객체를 반환하는 함수들을 새로 만든다.
5. 레코드를 반환하는 예전 함수를 사용하는 코드를 4에서 만든 새 함수를 사용하도록 바꾼다. 필드에 접근할 때에는 객체의 접근자를 사용한다. 적절한 접근자가 없다면 추가한다. 한 부분을 바꿀 때마다 테스트한다.

### 7-2. 컬렉션 캡슐화하기

- 컬렉션 변수로의 접근을 캡슐화하면서 게터가 컬렉션 자체를 반환하도록 한다면, 그 컬렉션을 감싼 클래스가 눈치채지 못하는 상태에서 컬렉션의 원소들이 바뀌어버릴 수 있다.
- 컬렉션 게터가 원본 컬렉션을 반환하지 않게 만들어서 클라이언트가 실수로 컬렉션을 바꿀 가능성을 차단하는 게 낫다.

#### 내부 컬렉션을 직접 수정못하게 하는 방법

1. 컬렉션 값 자체를 반환하지 않도록 하기
2. 컬렉션을 읽기전용으로 반환하기
3. 내부 컬렉션의 복제본을 반환하기

```java
class Person {
  private List<Course> courses;

  public List<Course> getCourse() {
    return this.courses;
  }

  public void setCourse(List<Course> courses) {
    this.courses = courses;
  }
}
```

```java
class Person {
  private List<Course> courses;

  public List<Course> getCourse() {
    List<Course> _courses;
    return this.courses.clone();
    // return Collections.unmodifiableList(this.courses); - 읽기전용으로 반환하기
  }

  public void addCourse(Course c) { ... }

  public void removeCourse(Course c) { ... }
}
```

1. 아직 컬렉션을 캡슐화하지 않았다면 변수 캡슐화하기부터 한다.
2. 컬렉션에 원소를 추가/제거하는 함수를 추가한다.
3. 정적 검사를 수행한다.
4. 컬렉션을 참조하는 부분을 모두 찾는다. 컬렉션의 변경자를 호출하는 코드가 모두 앞에서 추가한 추가/제거 함수를 호출하도록 수정한다. 하나씩 수정할 때마다 테스트한다.
5. 컬렉션 게터를 수정해서 원본 내용을 수정할 수 없는 읽기전용 프록시나 복제본을 반환하게 한다.
6. 테스트한다.

### 7-3. 기본형을 객체로 바꾸기

- 단순한 출력 이상의 기능이 필요해지는 순간 그 데이터를 표현하는 전용 클래스를 정의
- 나중에 특별한 동작이 필요해지면 이 클래스에 추가하면 되니 프로그램이 커질수록 점점 유용한 도구가 된다.

```java
orders.filter( o -> { return "high".equals(o.priority) || "rush".equals(o.priority); } )
```

```java
orders.filger(o -> {
  return o.priority.higherThan(new Priority("normal"));
})
```

1. 아직 변수를 캡슐화하지 않았다면 캡슐화 한다.
2. 단순한 값 클래스를 만든다. 생성자는 기존 값을 인수로 받아서 지정하고, 이 값을 반환하는 게터를 추가한다.
3. 정적 검사를 수행한다.
4. 값 클래스의 인스턴스를 새로 만들어서 필드에 저장하도록 세터를 수정한다. 이미 있다면 필드의 타입을 적절히 변경된다.
5. 새로 만든 클래스의 게터를 호출한 결과를 반환하도록 게터를 수정한다.
6. 테스트한다.
7. 함수 이름을 바꾸면 원본 접근자의 동작을 더 잘 드러낼 수 있는지 검토한다.

### 7-4. 임시 변수를 질의 함수로 바꾸기

- 변수 대신 함수로 만들어두면 비슷한 계산을 수행하는 다른 함수에서도 사용할 수 있어 코드 중복이 줄어든다.
- 클래스 안에서 적용할 때 효과가 가장 크다. 클래스틑 추출할 메서들에 공유 컨텍스트를 제공하기 때문이다.
- 읽기만 하는 변수에 사용하여야 한다.

```java
double basePrice = this.quantity * this.itemPrice;

if ( basePrice > 1000 ) {
  return basePrice * 0.95;
} else {
  return basePrice * 0.98;
}
```

```java
double getBasePrice() {
  return this.quantity * this.itemPrice;
}
...
if ( getBasePrice() > 1000 ) {
  return basePrice * 0.95;
} else {
  return basePrice * 0.98;
}
```

1. 변수가 사용되기 전에 값이 확실히 결정되는지, 변수를 사용할 때마다 계산 로직이 매번 다른 결과를 내지는 않는지 확인한다.
2. 읽기전용으로 만들 수 있는 변수는 읽기전용으로 만든다.
3. 테스트한다.
4. 변수 대입문을 함수로 추출한다.
5. 테스트한다.
6. 변수 인라인하기로 임시 변수를 제거한다.

### 7-5. 클래스 추출하기

### 7-6. 클래스 인라인하기

### 7-7. 위임 숨기기

### 7-8. 중재자 제거하기

### 7-9. 알고리즘 교체하기

## 8. 기능 이동

### 8-1. 함수 옮기기

- 모듈성을 높이기 위해, 서로 연관된 요소들을 함께 묶고, 요소 사이의 연결 관계를 쉽게 찾고 이해할 수 있도록 해야 한다.
- 높아진 이해를 반영하기 위해 요소를 이리저리 옮겨야 할 수 있다.

#### 모듈성

- 프로그램의 어딘가를 수정하려 할 때 해당 기능과 깊이 관련된 작은 일부만 이해해도 가능하게 해주는 능력

```java
class Account {
  Double overdraftCharge() { ... }
}
```

```java
class AccountType {
  Double overdraftCharge() { ... }
}
```

1. 선택한 함수가 현재 컨텍스트에서 사용 중인 모든 프로그램 요소를 살펴본다. 이 요소들 중에도 함께 옮겨야 할 게 있는지 고민해본다.
2. 선택한 함수가 다형 메서드인지 확인한다. ( 슈퍼클래스나 서브클래스에도 선언되어 있는지 확인 )
3. 선택한 함수를 타깃 컨텍스트로 복사한다. 타깃 함수가 새로운 터전에 잘 자리 잡도록 다듬는다.
4. 정적 분석을 수행한다.
5. 소스 컨텍스트에서 타깃 함수를 참조할 방법을 찾아 반영한다.
6. 소스 함수를 타깃 함수의 위임 함수가 되도록 수정한다.
7. 테스트한다.
8. 소스 함수를 인라인할지 고민해본다.

### 8-2. 필드 옮기기

- 주어진 문제에 적합한 데이터 구조를 활용하면 동작 코드는 자연스럽게 단순하고 직관적으로 짜여진다.
- 현재 데이터 구조가 적절치 않음을 깨닫게 되면 곧바로 수정해야 한다.
- 한 레코드를 넘길 때마다 다른 레코드의 필드를 함께 넘기고 있다면 데이터의 위치를 옮겨야 할 것이다.
- 한 레코드를 변경할 때 다른 레코드의 필드까지 변경해야 한다면 필드의 위치가 잘못 된 것.
- 구조체 여러 개의 정의된 똑같은 필드들을 갱신해야 한다면 한 번만 갱신해도 되는 다른위치로 옮길수 있다.

```java
class Customer {
  String getPlan() { return this.plan; }
  Double discountRate() { return this.discountRate; }
}
```

```java
class Customer {
  String getPlan() { return this.plan; }
  Double discountRate() { return this.plan.discountRate();}
}
```

1. 소스 필드가 캡슐화되어 있지 않다면 캡슐화한다.
2. 테스트한다.
3. 타깃 객체의 필드를 생성한다.
4. 정적 검사를 수행한다.
5. 소스 객체에서 타깃 객체를 참조할 수 있는지 확인한다.
6. 접근자들이 타깃 필드를 사용하도록 수정한다.
7. 테스트한다.
8. 소스 필드를 제거한다.
9. 테스트한다.

### 8-3. 문장을 함수로 옮기기

- 특정 함수를 호출하는 코드가 나올 때마다 그 앞이나 뒤에서 똑같은 코드가 추가로 실행되는 모습을 보면 반복되는 부분을 피호출 함수로 합치는 방법을 궁리해보자

```javascript
result.push(`<p>제목: ${person.photo.title}</p>`);
result.concat(photoData(person.photo));

function photoData(aPhoto) {
  return [
    `<p>위치: ${aPhoto.location}`,
    `<p>날짜: ${aPhoto.date.toDateString()}`,
    ``,
  ];
}
```

```javascript
result.concat(photoData(person.photo));

function photoData(aPhoto) {
  return [
    `<p>제목: ${person.photo.title}</p>`,
    `<p>위치: ${aPhoto.location}`,
    `<p>날짜: ${aPhoto.date.toDateString()}`,
    ``,
  ];
}
```

1. 반복 코드가 함수 호출 부분과 멀리 떨어져 있다면 문장 슬라이드하기를 적용해 근처로 옮긴다.
2. 타깃 함수를 호출하는 곳이 한 곳뿐이면, 단순히 소스 위치에서 해당 코드를 잘라내어 피호출 함수로 복사하고 테스트한다. 이 경우라면 나머지 단계는 무시한다.
3. 호출자가 둘 이상이면 호출자 중 하나에서 '타깃 함수 호출 부분과 그 함수로 옮기려는 문장들을 함께' 다른 함수로 추출한다. 추출한 함수에 기억하기 쉬운 임시 이름을 지어준다.
4. 다른 호출자 모두가 방금 추출한 함수를 사용하도록 수정한다. 하나씩 수정할 때마다 테스트한다.
5. 모든 호출자가 새로운 함수를 사용하게 되면 원래 함수를 새로운 함수 안으로 인라인 한 후 원래 함수를 제거한다.
6. 새로운 함수의 이름을 원래 함수의 이름으로 바꿔준다.

### 8-4. 문장을 호출한 곳으로 옮기기

```javascript
emitPhotoCata(outStream, person.photo);

function emitPhotoData(outStream, photo) {
  outStream.write(`<p>제목: ${photo.title}</p>\n`);
  outStream.write(`<p>위치: ${photo.location}</p>\n`);
}
```

```javascript
emitPhotoCata(outStream, person.photo);
outStream.write(`<p>제목: ${photo.title}</p>\n`);

function emitPhotoData(outStream, photo) {
  outStream.write(`<p>위치: ${photo.location}</p>\n`);
}
```

1. 간단한 상황이라면 피호출 함수를 잘라내어 호출 함수에 복사해 넣는다.
2. 복잡한 상황이라면 이동을 원치 않는 부분을 잘라내어 함수로 추출한다.
3. 원래 함수를 인라인 한다.
4. 추출된 함수의 이름을 원래 함수의 이름으로 변경한다.

### 8-5. 인라인 코드를 함수 호출로 바꾸기

- 함수로 바꾸었을때 말이되지 않는다면 함수의 이름이 적절치 않거나 함수의 목적이 인라인 코드의 목적과 부합하지 않는 것이다.

#### 함수의 장점

- 함수의 이름이 코드의 동작 방식보다는 목적을 말해준다.
- 중복을 없애는 데 효과적이다.

```java
boolean appliesToMass = false;

for (String s: states) {
  if (s.equals("MA")) appliesToMass = true;
}
```

```java
boolean appliesToMass = states.contains("MA");
```

1. 인라인 코드를 함수 호출로 대체한다.
2. 테스트한다.

### 8-6. 문장 슬라이드하기

- 관련된 코드들이 가까이 모여 있다면 이해하기가 더 쉽다.

#### 문장 슬라이드가 안되는 상황

1. 코드에서 참조하는 요소를 선언하는 문장 앞으로는 이동할 수 없다.
2. 코드를 참조하는 요소 뒤로 이동 할 수 없다.
3. 코드에서 참조하는 요소를 수정하는 문장을 건너 뛸 수 없다.
4. 코드가 수정하는 요소를 참조하는 요소를 건너 뛸 수 없다.

```java
Plan pricingPlan = retrievePricingPlan();
Order order = retrieveOrder();
Double charge;
Unit chargePerUnit = pricingPlan.getUnit();
```

```java
Plan pricingPlan = retrievePricingPlan();
Unit chargePerUnit = pricingPlan.getUnit();
Order order = retrieveOrder();
Double charge;
```

1. 코드 조각을 이동할 위치를 찾는다.
2. 코드 조각을 잘라내어 목표 위치에 붙여 넣는다.
3. 테스트한다.

### 8-7. 반복문 쪼개기

- 리펙터링과 최적화를 구분하자. 최적화는 코드를 깔끔히 정리한 이후에 수행하자.

```java
double averageAge = 0;
double totalSalary = 0;

for (Person p : people) {
  averageAge += p.getAge();
  totalSalary += p.getSalary();
}

averageAge = averageAge / people.size();
```

```java
double totalSalary = 0;

for (Person p : people) {
  totalSalary += p.getSalary();
}

double averageAge = 0;
for (Person p : people) {
  averageAge += p.getAge();
}

averageAge = averageAge / people.size();
```

1. 반복문을 복제해 두 개로 만든다.
2. 반복문이 중복되어 생기는 부수효과를 파악해서 제거한다.
3. 테스트한다.
4. 완료됐으면, 각 반복문을 함수로 추출할지 고민해본다.

### 8-8. 반복문을 파이프라인으로 바꾸기

[더 자세히 알아보기](https://martinfowler.com/articles/refactoring-pipelines.html)

```java
List<String> names = new ArrayList<>();

for ( Person p : people ) {
  if ( p.getJob().equals("programmer") )
    names.add(p.getName())
}
```

```java
List<String> names = people.stream()
                      .filter(p -> { return p.getJob().equals("programmer") })
                      .map(i -> { return i.getName() })
                      .collect(Collectors.toList())
```

1. 반복문에서 사용하는 컬렉션을 가리키는 변수를 하나 만든다.
2. 반복문의 첫 줄부터 시작해서, 각각의 단위 행위를 절절한 컬렉션 파이프라인 연산으로 대체한다.
3. 반복문의 모든 동작을 대체했다면 반복문 자체를 지운다.

### 8-9. 죽은 코드 제거하기

- 맘껏지우자. 우리에겐 버전 관리 시스템이 있다.
  > 하지만 솔직히, 마지막으로 이렇게 했던게 언제인지 기억나지 않으며, 이렇게 하지않아서 후회한적은 없다. - 마틴 파울러

```java
if (false) {
  doSomethingThatUsedToMatter();
}
```

```java

```

1. 죽은 코드를 외부에서 참조할 수 있는 경우라면 혹시라도 호출하는 곳이 있는지 확인한다.
2. 없다면 죽은 코드를 제거한다.
3. 테스트한다.

## 9. 데이터 조직화

### 9-1. 변수 쪼개기

- 변수의 대입은 한번만 이뤄져야한다. ( 단, 루프변수와 수집변수 제외 )

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

- 데이터 구조가 중요한 만큼 반드시 깔끔하게 관리해야한다.
- 개발을 진행할수록 깊어진 이해를 프로그램에 반드시 반영해야 한다.

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

- 가변 데이터를 없애기 위해 값을 쉽게 계산할 수 있는 변수들은 모두 제거해 볼 수 있다. ( 단, 변형 연산은 제외한다. )

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

- 필드를 내부 객체의 클래스를 수정하여 값 객체로 만들 수 있다.
- 값 객체는 불변 데이터가 되면 프로그램 외부로 건내줘도 나중에 그 값이 나 몰래 바뀌어서 내부에 영향을 줄까 염려하지 않아도 된다.

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

- 논리적으로 같은 데이터를 물리적으로 복제해 사용할 때 가장 크게 문제되는 상황은 그 데이터를 갱신해야 할 때이다. 모든 복제본을 찾아서 빠짐없이 갱신해야 하며, 하나라도 놓치면 데이터 일관성이 깨져버린다.  
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

1. 반드시 참인 것에만 검사하는 것이 좋다.
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

## 11. API 리팩터링

### 11-1. 질의 함수와 변경 함수 분리하기

#### 명령-질의 분리 ( command-query seperation )

- 겉보기 부수효과가 있는 함수와 없는 함수는 명확히 구분하는 것이 좋다.
- 질의 함수는 모두 부수효과가 없어야한다.
- <https://martinfowler.com/bliki/CommandQuerySeparation.html>

```java
Integer getTotalOutStandingAndSendBill() {
  Integer result = customer.getInvoices.stream().reduce(0, (total, each) -> each.amount + total);
  sendBill();
  return result;
}
```

```java
Integer getTotalOutStandingAndSendBill() {
  return customer.getInvoices.stream().reduce(0, (total, each) -> each.amount + total);
}

void SendBill() {
  sendBill();
}
```

1. 대상 함수를 복제하고 질의 목적에 충실한 이름을 짓는다.
   - 함수 내부를 살펴 무엇을 반환하는지 찾는다. 어떤 변수의 값을 반환한다면 그 변수 이름이 훌륭한 단초가 될 것이다.
2. 새 질의 함수에서 부수효과를 모두 제거한다.
3. 정적 검사를 수행한다.
4. 원래 함수 ( 변경함수 )를 호출하는 곳을 모두 찾아낸다. 호출 하는 곳에서 반환 값을 사용한다면 질의 함수를 호출하도록 바꾸고, 원래 함수를 호출하는 코드를 바로 아래 줄에 새로 추가한다. 하나 수정할때마다 테스트한다.
5. 원래 함수에서 질의 관련 코드를 제거한다.
6. 테스트한다.

### 11-2. 함수 매개변수화하기

- 두 함수의 로직이 아주 비슷하고 단지 리터럴 값만 다르다면, 그 다른 값만 매개변수로 받아 처리하는 함수 하나로 합쳐서 중복을 없앨 수 있다.

```java
void tenPercentRaise(Person aPerson) {
  aPerson.setSalary(aPerson.getSalary().muliply(1.1));
}

void fivePercentRaise(Person aPerson) {
  aPerson.setSalary(aPerson.getSalary().muliply(1.05));
}
```

```java
void raise(Person aPerson, Double factor) {
  aPerson.setSalary(aPerson.getSalary().muliply(factor));
}
```

1. 비슷한 함수 중 하나를 선택한다.
2. 함수 선언 바꾸기 로 리터럴들을 매개변수로 추가한다.
3. 이 함수를 호출하는 곳 모두에 적절한 리터럴 값을 추가한다.
4. 테스트한다.
5. 매개변수로 받은 값을 사용하도록 함수 본문을 수정한다. 하나 수정할 때마다 테스트한다.
6. 비슷한 다른 함수를 호출하는 코드를 찾아 매개변수화된 함수를 호출하도록 하나씩 수정한다. 하나 수정할 때 마다 테스트한다.

### 11-3. 플래그 인수 제거하기

#### 플래그 인수 ( flag argument )

- 호출되는 함수가 실행할 로직을 호출하는 쪽에서 선택하기 위해 전달하는 인수

```java
void setDimension(String name, Integer value) {
  if (name.equals("height")) {
    this.height = value;
  }

  if (name.equals("width")) {
    this.width = value;
  }
}
```

```java
void setHeight(Integer value) { this.height = value; }
void setWidth(Integer value) { this.width = value; }
```

1. 매개변수로 주어질 수 있는 값 각각에 대응하는 명시적 함수들을 생성한다.
   - 추가되는 함수에 깔끔한 분배 조건문이 포함되어 있다면 조건문 분해하기 로 명시적 함수들을 생성하자. 그렇지 않다면 래핑 함수 형태로 만든다.
2. 원래 함수를 호출하는 코드들을 모두 찾아서 각 리터럴 값에 대응되는 명시적 함수를 호출하도록 수정한다.

### 11-4. 객체 통째로 넘기기

- 하나의 레코드에서 두 개이상의 값을 인수로 넘기는 코드는 레코드 자체를 통째로 넘기도록 리펙토링 해볼 수 있다.
- 레코드 통째로 넘기면 변화에 대응하기 쉽다.
- 단, 함수가 레코드 자체에 의존하기를 윈치 않을 경우엔 제외한다. ( \* 레코드와 함수가 다른 모듈의 있을경우 )

```java
Double low = aRoom.daysTempRange.low;
Double high = aRoom.daysTempRange.high;
if (aPlan.withinRange(low, high))
```

```java
if (aPlan.withinRange(aRoom.daysTempRange))
```

1. 매개변수들을 원하는 형태로 받는 빈 함수를 만든다.
   - 마지막 단계에서 이 함수의 이름을 변경해야 하나 검색하기 휘운 이름으로 지어준다.
2. 새 함수의 본문에서는 원래 함수를 호출하도록 하며, 새 매개변수와 원래 함수의 매개변수를 매핑한다.
3. 정적 검사를 수행한다.
4. 모든 호출자가 새 함수를 사용하게 수정한다. 하나씩 수정하면서 테스트
   - 수정 후에는 원래의 매개변수를 만들어내는 코드 일부가 필요 없어질 수 있다. 따라서 죽은 코드 제거하기 로 없앨 수 있을 것이다.
5. 호출자를 모두 수정했다면 원래 함수를 인라인 한다.
6. 새 함수의 이름을 적절히 수정하고 모든 호출자에 반영한다.

### 11-5. 매개변수를 질의 함수로 바꾸기

- 매개변수는 함수의 변동요인을 모아 놓은 곳으로 중복은 파하고 짧을수록 좋음
- 피호출 함수가 '쉽게' 결정할 수 있는 값 역시 중복이므로 피하는 것이 좋다
- 단, 매개변수를 제거하면 피호출 함수에 원치 않는 의존성이 생길때는 바꾸지 않는다. ( 외부 함수를 호출하거나 수용 객체에 담긴 데이터를 사용해야하는 경우. )

#### 수용 객체

```java
availableVacation(anEmployee, anEmployee.grade)

void availableVacation(Employee anEmployee, Integer grade) { }
```

```java
availableVacation(anEmployee)

void availableVacation(Employee anEmployee) {
  Integer grade = anEmployee.getGrade();
}
```

1. 필요하다면 대상 매개변수의 값을 계산하는 코드를 별도 함수로 추출 해놓는다.
2. 함수 본문에서 대상 매개변수로의 참조를 모두 찾아서 그 매개변수의 값을 만들어주는 표현식을 참조하도록 바꾼다. 하나 수정할 때마다 테스트한다.
3. 함수 선언 바꾸기 로 대상 매개변수를 없앤다.

### 11-6. 질의 함수를 매개변수로 바꾸기

- 전역 변수를 참조하거나 제거하길 바라는 원소를 참조할 경우 참조를 배개변수로 변경한다.
- 길고 반복적인 매개변수 목록과 함수끼리 수많은 결합을 만들어 내는 것 사이의 균형을 찾아야한다.
- 참조 투명성을 해치는 원소는 매개변수로 바꾸어서 해결할 수 있다.

#### 참조 투명성

- 똑같은 값을 건네면 매번 똑같은 결과를 내는 함수

```java
targetTemperature(aPlan);

Double targetTemperature(Plan aPlan) {
  Double currentTemperature = thermostat.currentTemperature;
}
```

```java
targetTemperature(aPlan, thermostat.currentTemperature);

Double targetTemperature(Plan aPlan, Double currentTemperature) { }
```

1. 변수 추출하기로 질의 코드를 함수 본문의 나머지 코드와 분리한다.
2. 함수 본문 중 해당 질의를 호출하지 않는 코드들을 별도 함수로 추출한다.
   - 이 함수의 이름은 나중에 수정해야하니 검색하기 쉬운 이름으로 짓는다.
3. 방금 만든 변수를 인라인 한다.
4. 원래 함수도 인라인 한다.
5. 새 함수의 이름을 원래 함수의 이름을 고쳐준다.

### 11-7. 세터 제거하기

- 객체 생성 후에 수정되지 않길 원하는 필드라면 새터를 제공하지 않는다. ( 필드를 불변으로 만든다 )
- 생성스크립트를 사용할 때에도 세터를 제거하여 스크립트 이후엔 객체를 변경하지 않는다는 의도를 분명히 한다.

#### 생성 스크립트

- 생성자를 호출한 수 일련의 세터를 호출하여 객체를 완성하는 형태의 코드

```java
class Person {
  private String name;

  public String getName () {
    return this.name;
  }

  public void setName (String name) {
    this.name = name;
  }
}
```

```java
class Person {
  private String name;

  public String getName () {
    return this.name;
  }
}
```

1. 설정해야 할 값을 생성자에서 받지 않는다면 그 값을 받을 매개변수를 생성자에 추가한다. ( 함수 선언 바꾸기 ), 그런 다음 생성자 안에서 적절한 세터를 호출한다.
   - 세터 여러 개를 제거하려면 해당 값 모두를 한꺼번에 생성자에 추가한다. 그러면 이후 과정이 간소해진다.
2. 생성자 밖에서 세터를 호출하는 곳을 찾아 제거하고, 대신 새로운 생성자를 사용하도록 한다. 하나 수정할 때마다 테스트한다.
   - ( 갱신하려는 대상이 공유 참조 객체라서 ) 새로운 객체를 생성하는 방식으로는 새터 호울을 대체할 수 없다면 이 리펙터링을 취소한다.
3. 세터 메서드를 함수 인라인 한다. 가능하다면 해당 필드를 불변으로 만든다.
4. 테스트한다.

### 11-8. 생성자를 팩터리 함수로 바꾸기

팩터 함수는 생성자와 다르게 제약이 없다. 팩터리 함수를 구현하는 과정에서 생성자를 호출할 수는 있지만, 원한다면 다른 무언가로 대체할 수 있다.

#### 생성자의 제약

1. 반드시 그 생성자를 정의한 클래스의 인스턴스를 반환해야한다. 서브클래스의 인스턴스나 프록시를 반환 할 수 없다.
2. 생성자의 이름은 고정되어, 기존 이름보다 적절한 이름이 있어도 사용할 수 없다.
3. 생성자를 호출하기 위해 특별한 연산자 ( new )를 사용해야 해서 일반 함수가 오길 기대하는 자리에는 쓰기 어렵다.

```java
Engineer leadEngineer = new Employee(document.getLeadEngineer(), "E");
```

```java
Engineer leadEngineer = createEngineer(document.getLeadEngineer());
```

1. 팩터리 함수를 만든다. 팩터리 함수의 본문에서는 원래의 생성자를 호출한다.
2. 생성잘르 호출하던 코드를 팩터리 함수 호출로 바꾼다.
3. 하나씩 수정할 때마다 테스트한다.
4. 생성자의 가시범위가 최소가 되도록 제한한다.

### 11-9. 함수를 명령으로 바꾸기

- Undo 같은 보조연산 제공 가능.
- 수명주기를 더 정밀하게 제어하는데 필요한 매개변수를 만들어주는 메서드를 제공 가능.
- 일급 함수를 흉내낼 수 있다.
- 단, 복잡성은 커지게 된다.

#### 명령 ( 또는 명령 객체 )

- 함수를 그 함수만을 위한 객체 안으로 캡슐화하면 더 유용해지는 상황이 있다. 이런 객체를 가르켜 '명령 객체' 또는 '명령'이라고 한다.
- 명령 패턴

```java
Integer score(Candidate candidate, Exam medicalExam, Guide scoringGuide) {
  Integer result = 0;
  Integer healthLevel = 0;
  // omit
}
```

```java
class Scorer {
  private Candidate candidate;
  private Exam medicalExam;
  private Guide scoringGuide;

  private Integer result;
  private healthLevel = 0;

  constructor (Candidate candidate, Exam medicalExam, Guide scoringGuide) {
    this.candidate = candidate;
    this.medicalExam = medicalExam;
    this.scoringGuide = scoringGuide;
  }

  execute() {
    this.result = 0;
    this.healthLevel = 0;
    // omit;
  }
}
```

1. 대상 함수의 기능을 옮길 빈 클래스를 만든다. 클래스 이름은 함수이름에 기초해 짓는다.
2. 방금 생성한 빈 클래스로 함수를 옮긴다.
   - 리팩터링이 끝날 때까지는 원래 함수를 전달하는 함수 역할로 남긴다.
   - 명령 관련 이름은 사용하는 프로그래밍 언어의 명명규칙을 따른다. ( 규칙이 없다면 'execute' 혹은 'call' )
3. 함수의 인수들 각각은 명령의 필드로 만들어 생성자를 통해 설정할지 고민해본다.

### 11-10. 명령을 함수로 바꾸기

- 명령 객체는 큰연산을 작은 여러개의 메서드로 쪼개고 필드를 이용하는 것에 효율적이다.
- 로직이 크게 복잡하지 않다면 명령은 장점보다 단점이 더 크니 평범한 함수로 바꿔주는 것이 낫다.

```java
class ChargeCalculator {
  private Customer customer;
  private Integer usage;

  public ChargeCalculator(Customer customer, Integer usage) {
    this.customer = customer;
    this.usage = usage;
  }

  Integer execute() {
    return customer.getRate() * usage;
  }
}
```

```java
Integer execute(Customer customer, Usage usage) {
  return customer.getRate();
}
```

1. 명령을 생성하는 코드와 명령의 실행 메서드를 호출하는 코드를 함께 함수로 추출 한다.
   - 이 함수가 바로 명령을 대체할 함수이다.
2. 명령의 실행 함수가 호출하는 보조 메서드를 각각을 인라인 한다.
   - 보조 메서드가 값을 반환한다면 함수 인라인에 앞서 변수 추출하기를 적용한다.
3. 함수 선언 바꾸기를 적용하여 생성자의 매개변수 모두를 명령의 실행 메서드로 옮긴다.
4. 명령의 실행 메서드에서 참조하는 필드를 대신 대응하는 매개변수를 사용하게끔 바꾼다. 하나씩 수정 할 때마다 테스트한다.
5. 생성자 호출과 명령의 실행 메서드 호출을 호출자 안으로 인라인 한다.
6. 테스트한다.
7. 죽은 코드 제거하기로 명령 클래스를 없앤다.

### 11-11. 수정된 값 반환하기

- 데이터가 어떻게 수정되는지를 추적하는 일은 코드에서 이해하기 가장 어려운 부분 중 하나다.
- 변수를 갱신하는 함수라면 수정된 값을 반환하여 호출자가 그 값을 변수에 담아두도록 하는 것이 좋다.
- 값 하나를 계산하는 함수에 효과적이고, 값 여러개를 갱신하는 함수에는 효과적이지 않다.

```java
private int totalAscent = 0;

void calculateAscent() {
  for (int i = 0; i < points.length; i++) {
    int verticalChange = points[i].elevation - points[i - 1].elevation;
    totalAscent += (verticalChange > 0) ? valticalChange : 0;
  }
}
```

```java
private int totalAscent = calculateAscent();

int calculateAscent() {
  int result = 0;
  for (int i = 0; i < points.length; i++) {
    int verticalChange = points[i].elevation - points[i - 1].elevation;
    result += (verticalChange > 0) ? valticalChange : 0;
  }
  return result;
}
```

1. 함수가 수정된 값을 반환하게 하여 호출자가 그 값을 자신의 변수에 저장하게 한다.
2. 테스트한다.
3. 피호출 함수 안에 반환할 값을 가리키는 새로운 변수를 선언한다.
   - 이 작업이 의도대로 이뤄졌는지 검사하고 싶다면 호출자에서 초깃값을 수정해보자. 제대로 처리했다면 수정된 값이 무시된다.
4. 테스트한다.
5. 계산이 선언과 동시에 이뤄지도록 통합한다. ( 즉, 선언 시점에 계산 로직을 바로 실행해 대입한다. )
   - 프로그래밍 언어에서 지원한다면 이 변수를 불변으로 지정하자.
6. 테스트한다.
7. 피호출 함수의 변수 이름을 새 역할에 어울리도록 바꿔준다.
8. 테스트한다.

### 11-12. 오류 코드를 예외로 바꾸기

- 예외는 프로그래밍 언어에서 제공하는 독립적인 오류 처리 메커니즘이다.
- 오류코드를 일일이 검사하거나 오류를 식별해 콜스택 위로 던지는 일을 신경 쓰지 않아도 된다.
- 예외는 정확히 예상 밖의 동작일때만 쓰여야한다.
- 예외를 던지는 코드를 프로그램 종료 코드로 바꿔도 프로그램이 여전히 정상동작하는지 따져보자.

```java
if (data) {
  return new ShippingRules(data);
} else {
  return -23;
}
```

```java
if (data) {
  return new ShippingRules(data);
} else {
  throw new OrderProcessingError(-23);
}
```

1. 콜스택 상위에 해당 예외를 처리할 예외 핸들러를 작성한다.
   - 이 핸들러는 처음에는 모든 예외를 다시 던지게 해둔다.
   - 적절한 처리를 해주는 핸들러가 이미 있따면 지금의 콜스택도 처리할 수 있도록 확장한다.
2. 테스트한다.
3. 해당 오류 코드를 대체할 예외와 그 밖의 예외를 구분할 식별 방법을 찾는다.
   - 사용하는 프로그래밍 언어에 맞게 선택하면 된다. 대부분 언어에서는 서브클래스를 사용하면 될 것이다.
4. 정적 검사를 수행한다.
5. cath절을 수정하여 직겁 처리할 수 있는 예외는 적절히 대처하고 그렇지 않은 예외는 다시 던진다.
6. 테스트한다.
7. 오류 코드를 반환하는 곳 모두에서 예외를 던지도록 수정한다. 하나씩 수정할 때마다 테스트한다.
8. 모두 수정했다면 그 오류 코드를 콜스택 위로 전달하는 코드를 모두 제거한다. 하나씩 수정할 때마다 테스트한다.
   - 먼저 오류 코드를 검사하는 부분을 함정으로 바꾼 다음, 함정에 걸려들지 않는지 테스트한 후 제거하는 전략을 권한다. 함정에 걸려드는 곳이 있다면 오류 코드를 검사하는 코드가 아직 남아 있다는 뜻이다. 함정을 무사히 피했다면 안심하고 본문을 정리하자 ( 죽은 코드 제거하기 )

### 11-13. 예외를 사전 확인으로 바꾸기

- 함수 수행 시 문제가 될 수 있는 조건을 함수 호출 전에 검사할 수 있다면, 예외를 던지는 대신 호출하는 곳에서 조건을 검사하도록 해야 한다.

```java
double getValueForPeriod(int periodNumber) {
  try {
    return values[periodNumber];
  } catch (ArrayIndexOutOfBoundsException e) {
    return 0;
  }
}
```

```java
double getValueForPeriod(int periodNumber) {
  return (periodNumber >= values.length) ? 0 : values[periodNumber];
}
```

1. 예외를 유발하는 상황을 검사할 수 있는 조건문을 추가한다. catch 블록의 코드를 조건문의 조건절 중 하나로 옮기고, 남은 try 블록의 코드를 다른 조건절로 옮긴다.
2. catch 블록에 어서션을 추가하고 테스트한다.
3. try 문과 catch 블록을 제거한다.
4. 테스트한다.

## 12. 상속다루기

### 12-1. 메서드 올리기

- 무언가 중복되었다는 것은 한쪽의 변경이 다른쪽에는 반영되지 않을 수 있다는 위험을 항상 수반한다.
- 메서드들의 본문 코드가 같다면 그냥 복사해서 메서드 올리기가 가능하다. ( 난이도 ★☆☆ )
- 서로 다른 두 클래스의 메서드가 매개변수화 하면 같은 메서드가 되어서 메서드 올리기가 가능 할 수 있다. ( 난이도 ★★☆ )
- 해당 메서드의 본문에서 참조하는 필드들이 서브클래스에만 있는 경우라면 먼저 필드를 슈퍼클래스로 올린 후에 메서드를 올린다. ( 난이도 ★★★ )
- 두 메서드의 전체 흐름은 비슷하지만 세부 내용이 다르다면 템플릿 메서드 만들기를 고려해보자

#### 템플릿 메서드 만들기 Form Template Method

- <https://refactoring.com/catalog/formTemplateMethod.html>

```java
class Employee { ... }

class Salesperson extends Employee {
  public String getName() { ... }
}

class Engineer extends Employee {
  public String getName() { ... }
}
```

```java
class Employee {
  public String getName() { ... }
}

class Salesperson extends Employee { ... }
class Engineer extends Employee { ... }
```

1. 똑같이 동작하는 메서드인지 면밀히 살펴본다.
   - 실질적으로 하는 일은 같지만 코드가 다르다면 본문 코드가 똑같아질 때까지 리팩터링 한다.
2. 메서드 안에서 호출하는 다른 메서드와 참조하는 필드들을 슈퍼클래스에서도 호출하고 참조할 수 있는지 확인한다.
3. 메서드 시그니처가 다르다면 함수 선언 바꾸기 로 슈퍼클래스에서 사용하고 싶은 형태로 통일한다.
4. 슈퍼클래스에 새로운 메서드를 생성하고 대상 메서드의 코드를 복사해 넣는다.
5. 정적 검사를 수행한다.
6. 서브클래스 중 하나의 메서드를 제거한다.
7. 테스트한다.
8. 모든 서브클래스의 메서드가 없어질 때까지 다른 서브클래스의 메서드를 하나씩 제거한다.

### 12-2. 필드 올리기

- 필드들이 비슷한 방식으로 쓰인다고 판단되면 슈퍼클래스로 끌어올리자.
- 데이터 중복선언을 없앨 수 있다.
- 해당 필드를 사용하는 동작을 서브클래스에서 슈퍼클래스로 옮길 수 있다.

```java
class Employee { ... }

class Salesperson extends Employee {
  private String name;
}

class Engineer extends Employee {
  private String name;
}
```

```java
class Employee {
  protected String name;
}

class Salesperson extends Employee { ... }
class Engineer extends Employee { ... }
```

1. 후보 필드들을 사용하는 곳 모두가 그 필드들을 똑같은 방식으로 사용하는지 면밀히 살핀다.
2. 필드들의 이름이 각기 다르다면 똑같은 이름으로 바꾼다. ( 필드 이름 바꾸기 )
3. 슈퍼클래스에 새로운 필드를 생성한다.
   - 서브클래스에서 이 필드에 접근 가능해야한다. ( protected 로 선언 )
4. 서브클래스의 필드들을 제거한다.
5. 테스트한다.

### 12-3. 생성자 본문 올리기

- 생성자는 메서드와 달리 다루기 까다롭기에 하는 일에 제약을 두는 편이다.
- 생성자를 팩터리 함수로 바꾸기 를 고려해본다.

```java
class Party { ... }

class Employee extends Party {
  public Employee(String name, String id, int monthlyCost) {
    super();
    this.id = id;
    this.name = name;
    this.monthlyCost = monthlyCost;
  }
}
```

```java
class Party {
  public Party(String name) {
    this.name = name;
  }
}

class Employee extends Party {
  public Employee(String name, String id, int monthlyCost) {
    super(name);
    this.id = id;
    this.monthlyCost = monthlyCost;
  }
}
```

1. 슈퍼클래스에 생성자가 없다면 하나 정의한다. 서브클래스의 생성자들에서 이 생성자가 호출되는지 확인한다.
2. 문장 슬라이드하기 로 공통 문장 모두 super() 호출 직후로 옮긴다.
3. 공통 코드를 슈퍼클래스에 추가하고 서브클래스들에서는 제거한다. 생성자 매개변수 중 공통 코드에서 참조하는 값들을 모두 super()로 건낸다.
4. 테스트한다.
5. 생성자 시작 부분으로 옮길 수 없는 공통 코드에는 함수 추출하기 외 메서드 올리기 를 차례로 적용한다.

### 12-4. 메서드 내리기

- 특정 서브클래스에서만 사용되는 메서드는 슈퍼클래스에서 제거하는 것이 깔끔하다.
- 단, 해당 메소드를 제공할 서브클래스가 호출자가 무엇인지 알고있을때만 가능하다.
- 아니라면 서브클래스마다 다르게 동작하는 조건부 로직을 다형성으로 바꿔야 한다.

```java
class Employee {
  public String quota() {
    return "...";
  }
}

class Engineer extends Employee { ... }
class Salesperson extends Employee { ... }
```

```java
class Employee { ... }

class Engineer extends Employee { ... }
class Salesperson extends Employee {
  public String quota() {
    return "...";
  }
 }
```

1. 대상 메서드를 모든 서브클래스에 복사한다.
2. 슈퍼클래스에서 그 메서드를 제거한다.
3. 테스트한다.
4. 이 메서드를 사용하지 않는 모든 서브 클래스에서 제거한다.
5. 테스트한다.

### 12-5. 필드 내리기

```java
class Employee {
  protected String quota();
}

class Engineer extends Employee { ... }
class Salesperson extends Employee { ... }
```

```java
class Employee { ... }

class Engineer extends Employee { ... }
class Salesperson extends Employee {
  private String quota();
 }
```

1. 대상 필드를 모든 서브클래스에 정의한다.
2. 슈퍼클래스에서 그 필드를 제거한다.
3. 테스트한다.
4. 이 필드를 사용하지 않는 모든 서브클래스에서 제거한다.
5. 테스트한다.

### 12-6. 타입 코드를 서브클래스로 바꾸기

- 타입 코드만으로 특별히 불편한 상황은 없지만 그 이상이 필요할때가 있다. ( 서브클래스가 그 이상이다. )
- 조건에 따라 다르게 동작하도록 해주는 다형성을 제공한다.
- 특정 타입만 필요한 필드가 생길시, 서브클래스를 이용하면 해당 서브클래스만 필드를 가지도록 할 수 있다. ( ISP )

```java
Employee createEmployee(String name, String type) {
  return new Employee(name, type);
}
```

```java
Employee createEmployee(String name, String type) {
  switch ( type ) {
    case "engineer" :
      return new Engineer(name);
    case "salesperson" :
      return new Salesperson(name)
    case "manager" :
      return new Manager(name);
  }
}
```

1. 타입 코드 필드를 자가 캡슐화한다.
2. 타입 코드 값 하나를 선택하여 그 값에 해당하는 서브클래스를 만든다. 타입 코드 게터 메서드를 오버라이드하여 해당 타입 코드의 리터럴 값을 반환하게 한다.
3. 매개 변수로 받은 타입 코드와 방금 만든 서브클래스를 맵핑하는 선택 로직을 만든다.
   - 직접 상속일 때는 생성자를 팩터리 함수로 바꾸기를 적용하고 선택 로직을 팩터리에 넣는다. 간접 상혹일 때는 선택 로직을 생성자에 두면 될 것이다.
4. 테스트한다.
5. 타입 코드 값 각각에 대해 서브클래스 생성과 선택 로직 추가를 반복한다. 클래스 하나가 완성될 때마다 테스트한다.
6. 타입 코드 필드를 제거한다.
7. 테스트 한다.
8. 타입 코드 접근자를 이용하는 메서드 모두에 메서드 내리기와 조건부 로직을 다형성으로 바꾸기를 적용한다.

### 12-7. 서브클래스 제거하기

```java
class Person {
  public String genderCode() {
    return "X";
  }
}

class Male extends Person {
  @Override
  public String genderCode() {
    return "M";
  }
}

class Femail extends Person {
  @Override
  public String genderCode() {
    return "F";
  }
}
```

```java
class Person {
  private genderCode;

  public String genderCode() {
    return this.genderCode;
  }
}
```

1. 서브클래스의 생성자를 팩토리 함수로 바꾼다.
   - 생성자를 사용하는 측에서 데이터 필드를 이용해 어떤 서브클래스를 생성할지 결정한다면 그 결정로직을 슈퍼클래스의 팩터리 메서드에 넣는다.
2. 서브클래스의 타입을 검사하는 코드가 있다면 그 검사 코드에 함수 추출하기와 함수 옮기기를 차례로 적용하여 슈퍼클래스로 옮긴다. 하나 변경할 때마다 테스트한다.
3. 서브클래스의 타입을 나타내는 필드를 슈퍼클래스에 만든다.
4. 서브클래스를 참조하믄 메서드가 방금 만든 타입 필드를 이용하도록 수정한다.
5. 서브클래스를 지운다.
6. 테스트한다.

### 12-8. 슈퍼클래스 추출하기

- 상속은 프로그램이 성장하면서 깨어쳐가게 되며, 슈퍼클래스로 끌어올리고 싶은 공통 요소를 찾았을 때 수행하는 사례가 잦았다.
- 슈퍼클래스 추출하기 대안으로는 클래스 추출하기가 있다. ( 상속 vs 위임 )
- 슈퍼클래스를 위임으로 바꾸기는 쉬우니, 슈퍼클래스 추출하기를 먼저 적용하는 것을 권장한다.

```java
class Department {
  public Integer totalAnnualCost() { ... }
  public String getName() { ... }
  public Integer headCount() { ... }
}

class Employee {
  public Integer annualCost() { ... }
  public String getName() { ... }
  public Integer getId() { ... }
}
```

```java
class Party {
  public Integer annualCost() { ... }
  public String getName() { ... }
}

class Department extends Party {
  @Override
  public Integer annualCost() { ... }
  public Integer headCount() { ... }
}

class Employee {
  @Override
  public Integer annualCost() { ... }
  public Integer getId() { ... }
}
```

1. 빈 슈퍼클래스를 만든다. 원래의 클래스들이 새 클래스를 상속하도록 한다.
   - 필요하다면 생성자에 함수 선언 바꾸기를 적용한다.
2. 테스트한다.
3. 생성자 본문 올리기, 메서드 올리기, 필드 올리기를 차례로 적용하여 공통 원소를 슈퍼클래스로 옮긴다.
4. 서브클래스에 남은 메서드들을 검토한다. 공통되는 부분이 있다면 함수로 추출한 다음 메서드 올리기를 적용한다.
5. 원래 클래스들을 사용하는 코드를 검토하여 슈퍼클래스의 인터페이스를 사용하게 할지 고민해본다.

### 12-9. 계층 합치기

- 계층구조도 진화하면서 어떤 클래스와 그 부모가 너무 비슷해져서 더는 독립적으로 존재해야 할 이유가 사라지는 경우가 사라지기도 한다.

```java
class Employee { ... }
class SalePerson extends Employee { ... }
```

```java
class Employee { ... }
```

1. 두 클래스 중 제거할 것을 고른다.
   - 미래를 생각하여 더 적합한 이름의 클래스를 남기자. 둘 다 적절치 않다면 임의로 하나를 고른다.
2. 필드 올리기와 메서드 올리기 혹은 필드 내리기 와 메서드 내리기 를 적용하여 모든 요소를 하나의 클래스로 옮긴다.
3. 제거할 클래스를 참조하던 모든 코드가 남겨질 클래스를 참조하도록 한다.
4. 빈 클래스를 제거한다.
5. 테스트한다.

### 12-10. 서브클래스를 위임으로 바꾸기

- 위임을 사용하면 상속의 두가지 단점을 극복할 수 있다.
- '**상속보다는 컴포지션을 사용하라!**' 원칙이 있지만, 언제든지 서브클래스를 위임을 바꿀 수 있다는 사실은 안다면 상속도 유연하게 사용할 수 있다.
- 서브클래스를 '[상태 패턴](https://victorydntmd.tistory.com/294?category=719467)'이나 '[전략 패턴](https://victorydntmd.tistory.com/292?category=719467)'으로 대체한다고 생각하면 도움이 된다.

#### 상속의 단점

1. 한번만 쓸 수 있는 카드.
   - 예컨대 사람 객체의 동작을 "나잇대"와 "소득 수준" 에 따라 달리하고 싶다면
   - 서브클래스는 젊은이와 어르신이 되거나 부자와 거지가 되어야한다.
   - 둘 다는 안된다.
2. 클래스간 아주 긴밀한 결합.
   - 부모를 수정하면 이미 존재하는 자식들의 기능을 해치기가 쉽기 때문에 각별히 주의해야 한다.

```java
class Order {
  public Integer daysToShip() {
    return this.warehouse.daysToShip;
  }
}

class PriorityOrder extends Order {
  public Integer daysToShip() {
    return this.priorityPlan.daysToShip;
  }
}
```

```java
class Order {
  public Integer daysToShip() {
    return (this.priorityDelegate)
      ? this.priorityDelegate.daysToShip;
      : this.warehouse.daysToShip;
  }
}

class PriorityOrderDelegate {
  public Integer daysToShip() {
    return this.priorityPlan.daysToShip;
  }
}
```

1. 생성자를 호출하는 곳이 많다면 생성자를 팩터리 함수로 바꾼다.
2. 위임으로 활용할 빈 클래스를 만든다. 이 클래스의 생성자는 서브클래스에 특화된 데이터를 전부 받아야 하며, 보통은 슈퍼 클래스를 가리키는 역참조도 필요하다.
3. 위임을 저장할 필드를 슈퍼클래스에 추가한다.
4. 서브클래스 생성 코드를 수정하여 위임 인스턴스를 생성하고 위임 필으데 대입해 초기화한다.
   - 이 작업은 팩터리 함수가 수행한다. 혹은 생성자가 정확한 위임 인스턴스를 생성할 수 있는게 확실하다면 생성자에서 수행할 수도 있다.
5. 서브클래스의 메서드 중 위임 클래스로 이동할 것을 고른다.
6. 함수 옮기기를 적용해 위임 클래스로 옮긴다. 원래 메서드에서 위임하는 코드는 지우지 않는다.
   - 이 메서드가 사용하는 원소 중 위임으로 옮겨야 하는 게 있다면 함께 옮긴다. 슈퍼클래스에 유지해야 할 원소를 참조한다면 슈퍼클래스를 참조하는 필드를 위임에 추가한다.
7. 서브클래스 외부에도 원래 메서드를 호출하는 코드가 있다면 서브클래스의 위임 코드를 슈퍼클래스로 옮긴다. 이때 위임이 존재하는지 검사하는 보호 코드로 감싸야 한다. 호출하는 외부 코드가 없다면 원래 메서드는 죽은 코드가 되므로 제거한다.
   - 서브클래스가 둘 이상이고 서브클래스들에서 중복이 생겨나기 시작했다면 슈퍼클래스를 추출한다. 이렇게 하여 기본 동작이 위임 슈퍼클래스로 옮겨졌다면 슈퍼클래스의 위임 메서드들에는 보호 코드가 필요없다.
8. 테스트한다.
9. 서브클래스의 모든 메서드가 옮겨질 때까지 5.~8. 과정을 반복한다.
10. 서브클래스들의 생성자를 호출하는 코드를 찾아서 슈퍼클래스의 생성자를 사용하도록 수정한다.
11. 테스트한다.
12. 서브클래스를 삭제한다. ( 죽은 코드 제거하기 )

### 12-11. 슈퍼클래스를 위임으로 바꾸기

- 슈퍼 클래스의 기능들이 서브클래스에는 어울리지 않는다면 그 기능들을 상속을 통해 이용하면 안된다는 신호
- 위임을 이용하면 기능 일부만 빌려올 뿐인, 서로 별개인 개념임이 명확해진다.

```java
class List { ... }

class Stack extends List { ... }
```

```java
class List { ... }

class Stack {
  public Stack() {
    this.storage = new List();
  }
 }
```

1. 슈퍼클래스 객체를 잠조하는 필드를 서브클래스에 만든다. 위임 참조를 새로운 슈퍼클래스 인스턴스로 초기화한다.
2. 슈퍼클래스 동작 각각에 대응하는 전달 함수를 서브클래스에 만든다. 서로 관련된 함수끼리 그룹으로 묶어 진행하며, 그룹을 하나씩 만들 때마다 테스트한다.
   - 대부분은 전달 함수 각각을 테스트할 수 있을 것이다. 하지만 게터와 세터같은 것은 둘다 옮긴 후에나 테스트 가능하다.
3. 슈퍼클래스의 동작 모두가 전달 함수로 오버라이드되었다면 상속 관계를 끊는다.
