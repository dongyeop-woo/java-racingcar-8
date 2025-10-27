# java-racingcar-precourse

## 구현할 기능 목록

### 1. 자동차 이름 입력 및 검증
- 자동차 이름 입력 받기 (쉼표로 구분)
- 자동차 이름이 5자 이하인지 검증
- 자동차 이름이 비어있지 않은지 검증

### 2. 시도 횟수 입력 및 검증
- 시도 횟수 입력 받기
- 시도 횟수가 양수인지 검증

### 3. 자동차 경주 실행
- 각 자동차의 전진 여부 결정 (랜덤값 0-9, 4 이상 시 전진)
- 라운드별 결과 출력
- 최종 우승자 결정 및 출력

### 4. 테스트
- 기능 테스트
- 예외 테스트

## 패키지 구조

```
racingcar/
├── domain/          # 도메인 모델 (순수 비즈니스 로직)
│   ├── Car         # 자동차 엔티티
│   └── Cars        # 자동차 컬렉션
├── service/         # 비즈니스 로직
│   └── RacingGameService
├── controller/      # 흐름 제어
│   └── RacingController
├── view/            # 입출력 담당
│   ├── InputView    # 입력 담당
│   └── OutputView   # 출력 담당
├── parser/          # 입력 파싱
│   └── InputParser
├── exception/       # 예외 처리
│   ├── RacingCarException
│   └── Validator
└── constants/       # 상수
    ├── Message         # 메시지 상수
    └── RacingConstants # 경주 상수
```
