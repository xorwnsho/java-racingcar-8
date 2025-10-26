# java-racingcar-precourse

## 기능 구현
1. 자동차 이름 입력받고 쉼표(,)로 분리
2. 시도할 횟수 입력받기
3. 자동차 이름 5자 초과 시 `IllegalArgumentException`
4. 시도 횟수가 숫자가 아닐 시 `IllegalArgumentException`
5. 0~9 사이 무작위 값 생성 후, 4 이상이면 전진
6. 매 라운드마다 자동차별 전진 상태 출력
7. 최종 우승자 판별 및 출력  

## 디렉터리 구조 및 MVC 구조 적용
src/main/java/racingcar/  
├── `Application.java`  
├── controller/  
│   └── `GameController.java`  
├── domain/  
│   ├── `Car.java`  
│   └── `RacingGame.java`  
└── view/  
├── `InputView.java`  
└── `OutputView.java`      

1. **`Model (Domain) - domain` 패키지** - 핵심 비즈니스 로직과 데이터를 담당. (규칙)  
`Car.java`: 자동차 한 대의 상태(이름, 위치)와 행위(전진/멈춤)를 책임. 생성 시 이름 유효성 검사(5자 이하)도 스스로 수행.  
`RacingGame.java`: `Car` 객체 목록을 관리하며, `playRound()`(라운드 실행)와 `getWinners()`(우승자 판별) 등 게임의 핵심 규칙을 전담.


2. `View - view` 패키지 - 모든 콘솔 입/출력을 전담합니다.  
`InputView.java`: `Console.readLine()`을 사용하여 "자동차 이름 입력", "시도 횟수 입력" 등 모든 사용자 입력을 받음.  
`OutputView.java`: `System.out.println()`을 사용하여 "실행 결과", 라운드별 상태(`pobi : --`), "최종 우승자" 등 모든 출력을 담당.


3. `Controller - controller` 패키지 - `View`와 `Model(Domain)`을 연결. `GameController.java`: `run()` 메서드를 통해 전체 게임 흐름을 관리. 
`InputView`에서 입력을 받음. 입력값을 검증하고 `Car`, `RacingGame` 등 도메인 객체를 생성.
`RacingGame`에 라운드 실행을 명령. `OutputView`에 라운드 결과 및 최종 우승자 출력을 요청.