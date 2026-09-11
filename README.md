# ☕ CafeKiosk

> **Practical Testing: 실용적인 테스트 가이드** (박우빈) 강의를 수강하며 진행하는 학습 프로젝트입니다.

🔗 **강의 링크** — [Practical Testing: 실용적인 테스트 가이드](https://www.inflearn.com/course/practical-testing-%EC%8B%A4%EC%9A%A9%EC%A0%81%EC%9D%B8-%ED%85%8C%EC%8A%A4%ED%8A%B8-%EA%B0%80%EC%9D%B4%EB%93%9C?cid=329295)

<br/>

## 📌 강의 수강 이유

팀 프로젝트를 진행하면서 테스트 코드를 작성해야 한다는 것은 알고 있었지만, **무엇을 어떻게 테스트해야 하는지는 몰랐습니다.**
결국 AI에게 맡겨 테스트 코드를 채워 넣었고, 커버리지 숫자는 올라갔지만 남은 건 찜찜함이었습니다.

- 테스트가 통과해도 이 코드가 정말 동작한다는 확신이 들지 않았습니다.
- 무엇을 검증하려는 테스트인지, 나중에 읽는 사람이 이해할 수 없는 테스트가 쌓여갔습니다.

그래서 품질 좋은 소프트웨어를 위해 테스트 코드를 왜 , 어떻게 작성해야 하는지 학습하기 위해 해당 강의를 수강 합니다. 


<br/>

## 📚 이 강의를 통해 배운 것

챕터별 학습 내용은 PR 단위로 기록합니다. 자세한 내용은 각 PR을 참고해주세요.

| 챕터 | PR |
| --- | --- |
| 1 ~ 3. 테스트는 왜 필요한가 · 단위 테스트 · TDD | [#1](https://github.com/woo-in/cafekiosk/pull/1) |
| 4. 테스트는 [ ]다 | [#2](https://github.com/woo-in/cafekiosk/pull/2) |
| 5. Spring & JPA 기반 테스트 | 진행 중 |
| 6. Mock을 마주하는 자세 | - |
| 7. 더 나은 테스트를 작성하기 위한 구체적 조언 | - |
| 8. Appendix | - |

<br/>

### 1. 테스트는 왜 필요한가

🔗 [#1 test: 카페 키오스크 단위 테스트 작성 및 TDD 실습 (01~03)](https://github.com/woo-in/cafekiosk/pull/1)

- 수동 테스트는 커버할 수 없는 영역이 계속 남고, 그 비용이 쌓인다.
- 테스트 코드는 가까이 보면 느리지만, 멀리 보면 가장 빠르다.

### 2. 단위 테스트

🔗 [#1 test: 카페 키오스크 단위 테스트 작성 및 TDD 실습 (01~03)](https://github.com/woo-in/cafekiosk/pull/1)

- 테스트 케이스를 **해피 케이스 / 예외 케이스**로 세분화하고, **경계값 테스트**를 반드시 챙긴다. (개장 시간 09:59 / 10:00)
- 현재 시각·랜덤 값처럼 **관측할 때마다 달라지는 값**, 콘솔 출력·DB 기록처럼 **외부 세계에 영향을 주는 코드**는 테스트하기 어려운 영역으로 구분해 분리한다.
- `createOrder()`가 내부에서 `LocalDateTime.now()`를 부르는 대신 파라미터로 받도록 바꿔 테스트 가능한 코드로 만들었다.

### 3. TDD

🔗 [#1 test: 카페 키오스크 단위 테스트 작성 및 TDD 실습 (01~03)](https://github.com/woo-in/cafekiosk/pull/1)

- 테스트 코드를 먼저 작성해, 테스트가 구현 과정을 주도하게 하는 방법론.
- **RED → GREEN → REFACTOR**
  - RED: 실패하는 테스트를 작성한다.
  - GREEN: 테스트를 통과하는 최소한의 코딩만 한다.
  - REFACTOR: 테스트 통과를 유지하면서 구현 코드를 개선한다.

### 4. 테스트는 [ ]다 — 문서로서의 테스트

🔗 [#2 test: @DisplayName과 BDD 스타일 적용 (04)](https://github.com/woo-in/cafekiosk/pull/2)

- 테스트는 프로덕션 코드의 **요구사항과 히스토리를 담은 문서**이고, 한 사람의 고민이 팀의 자산으로 남는다.
- **BDD 스타일이 먼저다** — `Given` / `When` / `Then`으로 무엇을 준비하고, 수행하고, 검증하는지 먼저 정리한다.
- 그 위에서 **`@DisplayName`을 섬세하게** — "~테스트" 대신 도메인 용어로 행위와 결과를 문장으로 서술한다.

### 5. Spring & JPA 기반 테스트 — 레이어별 전략

- [ ] **Layered Architecture**와 통합 테스트의 필요성
- [ ] **Persistence Layer** — `@DataJpaTest`로 데이터 접근 로직만 빠르게 검증하기
- [ ] **Business Layer** — `@SpringBootTest`로 비즈니스 로직 + 트랜잭션 경계 검증하기
- [ ] **Presentation Layer** — `@WebMvcTest` + `MockMvc` + `@MockBean`으로 요청/응답과 **유효성 검증** 테스트하기
- [ ] `@Transactional(readOnly = true)`의 의미와 **CQRS** 관점의 읽기/쓰기 분리
- [ ] 통합 테스트와 단위 테스트의 경계를 어디에 둘 것인가

### 6. Mock을 마주하는 자세

- [ ] **Test Double**의 종류 — Dummy, Fake, Stub, Spy, Mock의 차이와 목적
- [ ] `@Mock`, `@Spy`, `@InjectMocks`, `@MockBean`을 상황에 맞게 골라 쓰기
- [ ] **BDDMockito**로 `given().willReturn()` 형태의 읽기 좋은 스텁 작성하기
- [ ] **Classicist vs Mockist** — 언제 진짜 객체를 쓰고, 언제 대역을 세울 것인가에 대한 나만의 기준

### 7. 더 나은 테스트를 작성하기 위한 구체적 조언

- [ ] **한 문단에 한 주제** — 하나의 테스트는 하나의 논리적 의미만 검증한다 (분기·반복이 들어가는 순간 신호)
- [ ] **완벽하게 제어하기** — 시간·랜덤 등을 파라미터로 주입해 테스트를 결정적으로 만들기
- [ ] **테스트 환경의 독립성 / 테스트 간 독립성** — 공유 자원 제거, `deleteAll()`과 `deleteAllInBatch()`의 차이
- [ ] **한 눈에 들어오는 Test Fixture** — `@BeforeEach`에 모든 것을 몰아넣지 않기, 빌더로 의미 있는 픽스처 만들기
- [ ] **`@ParameterizedTest`와 `@DynamicTest`** 로 케이스를 확장하고 시나리오를 표현하기
- [ ] **테스트 수행도 비용이다** — `@SpringBootTest` 남용 피하기, 테스트 환경 통합으로 컨텍스트 재사용하기
- [ ] private 메서드는 테스트하지 않는다 / 테스트만을 위한 코드는 어디까지 허용할 것인가

### 8. Appendix

- [ ] **학습 테스트** — 낯선 라이브러리를 테스트로 학습하고, 그 결과를 팀 자산으로 남기기
- [ ] **Spring REST Docs** — 테스트가 통과해야만 생성되는, 신뢰할 수 있는 API 문서 만들기 (vs Swagger)

