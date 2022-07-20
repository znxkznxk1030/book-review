# REFECTORING - Martin Fowler

- [REFECTORING - Martin Fowler](#refectoring---martin-fowler)
  - [10. 조건부 로직 간소화](#10-조건부-로직-간소화)
    - [10-1. 조건문 분해하기](#10-1-조건문-분해하기)
    - [10-2. 중복 조건식 통합하기](#10-2-중복-조건식-통합하기)
    - [10-3. 중첩 조건문을 보호 구문으로 바꾸기](#10-3-중첩-조건문을-보호-구문으로-바꾸기)
    - [10-4. 조건부 로직을 다형성으로 바꾸기](#10-4-조건부-로직을-다형성으로-바꾸기)
    - [10-5. 특이 케이스 추가하기 ( 널 객체 추가하기 )](#10-5-특이-케이스-추가하기--널-객체-추가하기-)
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

### 10-4. 조건부 로직을 다형성으로 바꾸기

### 10-5. 특이 케이스 추가하기 ( 널 객체 추가하기 )

### 10-6. 어서션 추가하기
