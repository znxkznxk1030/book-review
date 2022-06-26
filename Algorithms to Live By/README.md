# Algorithms To Live By - Brian Christian, Tom Griffiths( 영문 )

- [Algorithms To Live By - Brian Christian, Tom Griffiths( 영문 )](#algorithms-to-live-by---brian-christian-tom-griffiths-영문-)
  - [1. Optimal Stopping](#1-optimal-stopping)
    - [The Secretary Problem ( 비서 문제 )](#the-secretary-problem--비서-문제-)
    - [Whence 37%?](#whence-37)
      - [Look-Then-Leap-Rule](#look-then-leap-rule)
        - [How to optimally choose a secretary](#how-to-optimally-choose-a-secretary)
    - [Lover's Leap](#lovers-leap)
  - [2. Explore/Exploit](#2-exploreexploit)
  - [3. Sorting](#3-sorting)
  - [4. Caching](#4-caching)
  - [5. Scheduling](#5-scheduling)
  - [6. Bayes's Rule](#6-bayess-rule)
  - [7. Overfitting](#7-overfitting)
  - [8. Relaxation](#8-relaxation)
  - [9. Randomness](#9-randomness)
  - [10. Networking](#10-networking)
  - [11. Game Theory](#11-game-theory)
  - [읽으면서 몰랐던 단어들](#읽으면서-몰랐던-단어들)

## 1. Optimal Stopping

지금 만나는 연인과 결혼을 해도 되는지 알기 위해선 몇명의 이성을 사귀어 봐야 알 수 있을까?  
운명적으로는 알 수 없지만 수학적으로는 정답이 존재한다. 그것은 최대로 만날수 있는 이성의 37% 까지이다.  
즉, 평생 10명의 이성과 교제할 수 있는 사람이라면 3번의 연애까지는 가볍게 만나고  
이 이후 부터 만난 이성이 지금까지 본 사람중에 최고라고 생각이 들 때 결혼을 결심해야 한다는 것이다.

### The Secretary Problem ( 비서 문제 )

- 37% 라는 숫자는 **비서 문제** 라고 하는 Optimal Stopping에서 가장 유명한 퍼즐에서 도출되었다.  

>당신이 비서 후보자 그룹을 인터뷰를 해야한다고 하자.  
>당신의 목표는 비서 후보자 그룹 안에서 가장 좋은 비서를 뽑는 것이다.  
>비서 후보들의 가치는 절대적 숫자로 판단 할수 없지만 상대적으로는 쉽게 판단할 수 있다.  
>철저히 랜덤한 순서로 후보자를 인터뷰 하게된다.  
>하지만 한번 면접보고 떨어진 후보를 다시 인터뷰 할 수 없다.

### Whence 37%?

비서 후보자가 2명일때 비서를 선택하는 일은 앞사람 혹은 뒷사람 완벽히 50:50의 도박이다.  
하지만 3명이상 이라면 어떨까? 각 후보자의 차례가 되었을 때, 지금까지의 최고가 될 확률을 나열해보자.  

두번째 후보자는 1/2 확률로 앞사람 보다 더 나을수도 더 못날 수도 있다.  
세번째 후보자는 앞사람들보다 더 나을 확률이 1/3이다.  
... 7번째 후보자는 1/7 확률로 지금까지의 최고의 비서후보자가 된다.  

뒷차례 후보자가 될 수록 앞사람들을 넘은 최고의 후보가 될 확률은 적어지게 된다.  
즉, 의식에 따라 후보자를 넘기다 보면 점점 만족스러운 후보자를 찾기는 더 힘들어 지게 된다는 이야기이다.  

#### Look-Then-Leap-Rule

무의적으로 더 나은 비서가 나타나길 기다리는 것 대신에, 최적의 해결법인 "Look-Then-Leap-Rule" 전략을 도입해 볼 수 있다.  
다시말해, 탐색하는 시간을 명확히 설정해주는 것이다. 어떤 매력적인 후보자가 온다고 하더라도 탐색하는 시간 ("Look")에는 절대 결정("Leap") 하지 않는 것이다. 그리고 탐색전이 끝나면 "Best Yet" 후보자가 나타났을 때에는 주저없이 결정해버리는 전략이다. 그리고 여기서 탐색시간은 전체시간의 37%로 지정하는 것이 최선의 방법이다.

##### How to optimally choose a secretary

비서 후보자의 수 | 탐색할 후보자의 수 | 최고의 비서를 뽑을 확률
---------|----------|---------
  3 | 1 | 50%
  4 | 1 | 45.83%
  5 | 2 | 43.33%
  6 | 2 | 42.78%
  7 | 2 | 41.43%
  8 | 3 | 40.98%
  9 | 3 | 40.59%
  10 | 3 | 39.97%
  20 | 7 | 38.42%
  30 | 11 | 37.86%
  40 | 15 | 37.57%
  50 | 18 | 37.43%
  100 | 37 | 37.10%
  1000 | 369 | 36.81%

Look-Then-Leap-Rule 방법의 최선의 방법이라고 대단하듯이 포장했지만, 
위 표에서 보다싶이 최고의 비서를 뽑는데 실패할 확률은 무려 63%나 된다.  
하지만 이 방법이 의미있는건 후보자의 숫자가 천명이든 만명이 이든 혹은 그이상이 되어도 언제나 37%의 확률로 최고의 후보를 뽑을 수 있다는 것이다.

### Lover's Leap




## 2. Explore/Exploit

## 3. Sorting

## 4. Caching

## 5. Scheduling

## 6. Bayes's Rule

## 7. Overfitting

## 8. Relaxation

## 9. Randomness

## 10. Networking

## 11. Game Theory

## 읽으면서 몰랐던 단어들

- solemnly : 침통하게
- turkey drop : 급작스럽게 떨어지는것 ( 대학을 가거나 할때 )
- nonchalant : 차분한, 맥없는
- monogamy : 일부일처제
- writ : 영장
- angstry : 분노 + 불안 ( angry + angst )
- Catch-22 : 동명의 소설, "경력있는 신입만 뽑는다면 경력은 어디서 쌓아야 할까" 딜레마를 뜻함
- implications : 예상되는 결과
- cardinal : 카디날, 양으로 나타낼 수 있는
- speculation : 추측
- haul : 끌다
- correspondence : 서신, 관련성
- eavesdropping : 도청
- suffice : 충분하다
- subfield: 하위분야
- anthropological : 인류학적
- imagery :형상
- incarnations : 화신
- predominating : 지배적인
- hasty : 급한
- encounter : 예기치 못한 상황을 마주하다
- go down  : 퀄이 떨어지다
- proceed : 진행하다
- rash : 두드러기
- intuitively : 의식적인 이유없이
- trump : 낫다
- streak : 긴 줄
- emerges : 드러나다
- whence : 어떻게
- halfheartedly : 열정이나 에너지 없이
- decry : 공적으로 잘못되었음을 알리다
- copernican : 니콜라스 코페니우스, Copenican Revolution: 천동설 => 지동설
- terrestrial : 거주지역에서의
- bemoan : 깊이 슬퍼짐
- confidante : 비밀을 지킬만클 신뢰할만한 사람
- consolation : 위로
- degeneracy : 타락한 상태나 재산.