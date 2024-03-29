# Algorithms To Live By - Brian Christian, Tom Griffiths( 영문 )

- [Algorithms To Live By - Brian Christian, Tom Griffiths( 영문 )](#algorithms-to-live-by---brian-christian-tom-griffiths-영문-)
  - [1. Optimal Stopping](#1-optimal-stopping)
    - [The Secretary Problem ( 비서 문제 )](#the-secretary-problem--비서-문제-)
    - [Whence 37%?](#whence-37)
      - [Look-Then-Leap-Rule](#look-then-leap-rule)
    - [Lover's Leap](#lovers-leap)
    - [Knowing a Good Thing When You See It: Full Information](#knowing-a-good-thing-when-you-see-it-full-information)
      - [Threshold Rule](#threshold-rule)
    - [When To Sell](#when-to-sell)
    - [When To Park](#when-to-park)
      - [How to optimally find parking](#how-to-optimally-find-parking)
    - [When To Quit](#when-to-quit)
    - [Always Be Stopping](#always-be-stopping)
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
운명적으로는 알 수 없지만 수학적으로는 정답이 존재한다. 만날수 있는 이성의 37%는 가볍게 만난다면 좋은 선택을 할 수 있다.  
즉, 평생 10명의 이성과 교제할 수 있는 사람이라면 3번의 연애까지는 가볍게 만나고 이후 부터 만난 이성이 지금까지 본 사람중에 최고라고 생각이 들 때 결혼을 결심하는 것이 유리하다는 것이다.

### The Secretary Problem ( 비서 문제 )

37% 라는 숫자는 **비서 문제** 라고 하는 Optimal Stopping에서 가장 유명한 퍼즐에서 유래되었다. 비서 문제는 아래와 같다.

> 당신의 비서가 될 지원자들을 인터뷰를 해야한다. 당신의 목표는 비서 지원자 그룹 안에서 가장 좋은 비서를 뽑는 것이다.
> 비서 후보들의 가치는 절대적 숫자로 판단 할수 없지만 누가 더 나은지 상대적으로는 쉽게 판단할 수 있다.
> 철저히 임의의 순서로 지원자를 인터뷰 하게된다. 한번 면접보고 떨어진 후보를 다시 인터뷰 할 수 없고
> 한번 선택하면 그 뒤에 대기하던 지원자들은 자동으로 탈락하게 된다. 그렇다면 당신은 언제 비서를 선택할때 가장 좋은 비서를 선택할 수 있을까?

### Whence 37%?

비서 지원자가 2명일때 비서를 선택하는 일은 앞사람 혹은 뒷사람 완벽히 50:50의 도박이다.  
하지만 3명이상 이라면 어떨까? 각 지원자의 차례가 되었을 때, 지금까지의 최고가 될 확률을 나열해보자.

1. 첫번째 지원자는 비교대상이 없으므로 누가 오던 지금까지는 최고의 비서 후보자이다.
2. 두번째 지원자는 1/2 확률로 앞사람 보다 더 나을수도 더 못날 수도 있다.
3. 세번째 지원자는 앞의 두 사람들보다 더 나을 확률은 세명중 한명이 되야 하므로 1/3 이 된다..
4. 4번째 지원자는 1/4, 5번째 지원자는 1/5...100번째 지원자는 1/100 확률로 최고의 비서일 수 있다.

앞서 나열한 것과 같이 뒷차례로 갈수록 최고의 후보가 될 확률은 적어지게 된다.  
다시말해 무의식적으로 지원자를 넘기다 보면 점점 만족스러운 지원자를 찾기는 더 힘들어 지게 된다.

#### Look-Then-Leap-Rule

무의적으로 더 나은 비서가 나타나길 기다리는 것 대신에,"Look-Then-Leap-Rule" 전략을 도입해 볼 수 있다.  
이 전략은 탐색하는 시간을 명확히 설정해주는 것이다. 어떤 매력적인 지원자가 온다고 하더라도 탐색하는 시간 ("Look")에는 절대 결정("Leap") 하지 않는 것이다. 그리고 탐색전이 끝난 후에는 지금까지 중에 최고인 ( "Best Yet" ) 지원자가 나타났을 때에는 주저없이 결정해버리는 전략이다. 아래 표에서 수학자들이 계산해 놓은 최고의 비서를 뽑을 확률들을 보자.

- How to optimally choose a secretary

| 비서 지원자의 수 | 탐색할 지원자의 수 | 최고의 비서를 뽑을 확률 |
| ---------------- | ------------------ | ----------------------- |
| 3                | 1                  | 50%                     |
| 4                | 1                  | 45.83%                  |
| 5                | 2                  | 43.33%                  |
| 6                | 2                  | 42.78%                  |
| 7                | 2                  | 41.43%                  |
| 8                | 3                  | 40.98%                  |
| 9                | 3                  | 40.59%                  |
| 10               | 3                  | 39.97%                  |
| 20               | 7                  | 38.42%                  |
| 30               | 11                 | 37.86%                  |
| 40               | 15                 | 37.57%                  |
| 50               | 18                 | 37.43%                  |
| 100              | 37                 | 37.10%                  |
| 1000             | 369                | 36.81%                  |

표에서 보듯이 수학자들이 계산한 최적의 탐색시간은 37%언저리라는 것을 알 수 있다. 하지만 Look-Then-Leap-Rule 방법이 수학적인 최선의 방법이긴 하지만, 위 표에서 보다싶이 최고의 비서를 뽑는데 실패할 확률은 무려 63% 나 된다.  
그럼에도 이 방법이 의미있는건 지원자의 숫자가 천명이든 만명이 이든 혹은 그이상이 되어도 언제나 37%의 확률로 최고의 후보를 뽑을 수 있다는 것이다.

### Lover's Leap

실망스럽게도 실패할 확률이 생각보단 높긴하지만 Look-Then-Leap-Rule 방법으로 최고의 배우자를 찾아보는 것은 여전히 수학적으로 좋은 방법이긴 하다. 그런데 비서문제를 결혼문제에 적용할 때에는 고려해야할 몇가지 변수들이 더 있다.

첫째는 우리는 면접관과 다르게 거절( Reject ) 당할 수 있다. 지원자가 비서 면접을 본 것과 다르게 연인과의 결혼은 나 혼자 결정 할 수 있는 것이 아니다. 최고의 배우자를 만났다 하더라도 상대가 날 거절 할 경우가 생길 수 있다.

두번째는 우리는 거절한 상대에게 재요청( Recall )을 할 수도 있다. 다시금 용기내 구애 해 볼 수 있고 그것이 결정으로 이어 질 수도 있다.

변화적 요소들이 추가 되어 복잡성은 훨씬 높아졌다. 하지만 거절 당할 확률과 재요청시에도 성사될 확률을 적용할 수 있고 여전히 "Look-Then-Leap-Rule" 전략으로 최선을 찾을 수 있다.

### Knowing a Good Thing When You See It: Full Information

앞선 방법에선 비서문제에 거절과 재요청 이라는 요소로 변화를 주어 봤다. 여전히 "Look-Then-Leap-Rule" 전략이 최선의 선택이다. 그렇다면 전형적인 비서문제에서 좀더 근본적인 요소를 바꾸어 보면 어떨까?  
각 비서가 객관적 지표를 가지고 있다고 가정해보자. ( 예를 들면, 학업 성취도 점수 혹은 타자속도 같은 절대적인 숫자로 나타낼수 있는 지표 ) 전형적인 비서문제에서는 상대적인 비교만 가능했고, A 지원자가 B 지원자 보다 얼마나 더 나은지 알 수 없었다. 이러한 객관적 정보가 없는 문제를 비정보게임 ( No Information Game )이라고 한다. 그리고 비정보문제에서는 탐색 후 결정하는 방법으로 해결 하였다. 반면에, 객관적 지표가 있다면 이를 완정정보게임 ( Full Information Game ) 이라고 한다. 이때는 탐색 후 결정하는 방법이 아닌 한계점( Threshold )을 정하여 해결할 수 있다.

#### Threshold Rule

지원자의 객관적 지표를 백분율로 치환해보자. 55%의 지원자는 평균보다 조금 나은 수준이다. 75%의 지원자는 4명중 3명보다 나은 수준이라는 것을 알 수있다. 완정정보게임에서는 더 이상 탐색의 시간이 필요없다. 즉, 만약 첫 지원자가 98%의 지표를 가지고 있다고 가정하면 굳이 그 뒤의 지원자를 볼 필요없이 바로 선택 할 수도 있다는 것이다. 탐색의 시간은 필요없지만 지원자를 하나씩 넘기다 보면 마지막 순간에는 그 지원자가 평균 이하의 지표를 가지고 있더라도 선택해야하는 불상사가 벌어 질 수 있다. 이런 불상사를 방지 하기 위해서 남아있는 지원자 수에 따른 한계점을 두어 선택하는 전략 ( Threshold Role )을 사용할 수 있다. 이 전략으로 세워진 공식에 따르면, 25명이 남았을 때는 97%이상의 지원자를 선택해야하고, 4명이 남았을때는 78%, 3명이 남았을때는 69%, 1명이 남았을 때는 50% 이상일때 선택하는 것이 가장 최선이다.

### When To Sell

Optimal Stopping를 이용하여 부동산 문제를 해결해보자. 대출받아 매매한 집을 파아야 한다면 언제 팔아야 가장 적절한 가격에 매매 할 수 있을까?

집값은 부동산 시장에 축적된 데이터로 절대적 가격의 범위를 알 수 있기 때문에 완정정보게임 ( Full Information Game ) 이라고 볼 수 있다. 그렇기 때문에 한계점 ( Threshold )규칙을 적용해 볼 수 있다. 하지만 이 문제는 앞선 문제와 다르게 탐색에도 댓가를 치뤄야한다. 그렇기에 오늘의 제안은 몇달 뒤 같은 제안보다 약간 더 낫은 제안이 된다.

완전정보의 비서문제에서의 한계점은 시간이 지나도 변하지 않았던 것에 비해, 이 문제에서는 시간이 지날수록 한계점을 낮게 설정된다. 처음에 100억을 한계점으로 잡는다고 하더라도 대출 이자가 원금을 넘기 직전의 순간에는 아주 헐값이라도 집을 처분해야만 한다. 이경우에 한계점은 0원이 된다.

> 현실에서 Optimal Stopping를 이용하여 집을 팔때 자주 생기는 문제가 있다. 처음에 정한 한계점을 변경한다는 점이다. 시장가격과 대출이자를 도대로 한계점을 설정하였지만, 팔지 못했을 경우 걸리는 불어나는 이자와 시간때문에 한계점에 못미치는 가격에 거래가 많이 된다. 드물게 오는 고객에 조급해하지 않고 수학을 믿고 거래해야 수학적으로 이점을 취할 수 있겠다.

### When To Park

Optimal Stopping를 이용하여 주차 문제를 해결해보자. 차가 붐비는 평일 오전 회사 주차장에서 우리는 어디에 주차하는 것이 가장 현명할까? 차를 사무실 바로 근처에 세우자니 사무실 주변에 자리가 있을지 확실치 않다. 만약 없다면 오랜시간 뱅뱅이를 돌아야한다. 그렇다고 주차자리가 남는 곳에 무턱대고 주차하자니 걸어가야 할 길이 너무 멀다. 회사 주차장 안, 언제 멈춰서 주차하는 것이 대기없이 최소한의 도보로 이동할 수 있을까?

이 문제는 주차장의 점유율을 알면 해결 할 수 있다. "주차장의 점유율"별 "비어있는 자리까지 지나쳐야 하는 자리 개수"는 아래 표와 같다.

#### How to optimally find parking

| 주차장의 점유율 ( % ) | 비어있는 자리까지 지나쳐야 하는 자리 개수 |
| --------------------- | ----------------------------------------- |
| 0                     | 0                                         |
| 50                    | 1                                         |
| 75                    | 3                                         |
| 80                    | 4                                         |
| 85                    | 5                                         |
| 90                    | 7                                         |
| 95                    | 14                                        |
| 96                    | 17                                        |
| 97                    | 23                                        |
| 98                    | 35                                        |
| 99                    | 69                                        |
| 99.9                  | 693                                       |

0%의 점유율의 주차장이라면 다 비어있기 때문에 자리를 찾기 위해 지나쳐야할 개수는 0개이다.
50%의 점유율이라면 반은 차가 있고 반은 없기 때문에 평균적으로 1개는 지나쳐야 한다. 70%에서 80%까지는 천천히 올라가다 점유율이 95%가 넘어가면 급격하게 지나쳐야할 개수가 늘어난다. 점유율의 99%가 되어있다면 평균적으로 69개나 지나쳐야하고 99.9%에 도달했다면 평균적으로 693개나 지나쳐야 주차공간을 발견할 수 있다.

> 도착했을때 주차 점유율이 95%이상이라면 더 둘러보지 않고 빈공간에 주차를 하는 것이 현명한 선택이 될수 있겠다.

### When To Quit

### Always Be Stopping

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
- go down : 퀄이 떨어지다
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
- variants: 변종
- alter : 변경하다
- noncommittally : 비약속적으로
- namely: 즉
- calibrate : 교정하다
- assumption : 사실이라고 생각함, factor
- call into question : 의문을 제기하다.
- far cry from: 거리가 먼
- rub : 장애
- weigh : 무게를달다
- likelihood : 있을 수 있는 일
- odds : 확률
- skew : 비스듬한
- dwindle : 여위다, 점차 감소하다.
- slim picking: 얼마 남지 않아서 무언거를 얻는데 거의 혹은 전혀 성공하지 못함.
- crucially: 결정적으로
- arbitrarily : 임의로
- bizarre : 기괴한
- criterion : 기준
- disposal: 처분
- nebulous: 모호한
- endeavors: 성취하기 위해 열심히 시도하다
- grappling with: ~와 씨름하다
- exploit: 활용하다
- savor: 풍미
- friggin': 존나
- whereas: 반면에
- sobering: 냉정한
- infer: 추론하다.
- dizzying: 현기증
- byword: 대명사 ( ~의 대명사 )
- intransigence: 비타협
- ponder: 숙고하다
