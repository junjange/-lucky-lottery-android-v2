<h1 align="center">🍀행운복권🍀</h1>

"행운복권v2"는 개발자의 꿈을 갖고 처음으로 개발부터 배포까지 진행한 프로젝트인 ["행운복권"](https://github.com/junjange/lucky-lottery-android) 을 Jetpack Compose로 마이그레이션하고 클린 아키텍처를 적용하여 리팩토링한 결과물입니다. 이 프로젝트에서는 로또 6/45 및 연금복권의 각 회차별 당첨번호를 확인할 수 있으며, 로또 6/45와 연금복권 +720의 당첨 여부를 QR코드 스캔을 통해 쉽게 확인할 수 있습니다.

Jetpack Compose를 사용하여 UI를 구성함으로써 사용자 경험을 향상시켰으며, 클린 아키텍처를 도입하여 코드의 가독성과 유지보수성을 향상시켰습니다. 또한, QR코드 스캔을 통해 간편하게 로또와 연금복권의 당첨 여부를 확인할 수 있어 사용자에게 편의성을 제공하고 있습니다.
<br>

# Architectures
- MVVM + Clean Architecture
- Multi Modules
  - app
  - domain
  - data
  - presentation
  - local
  - remote
  - core-feature
  - kakao
  - firebase
  - buildSrc
    <br>

# Stacks
- Language
  - Kotlin
- Gradle
  - Kotlin DSL
  - Version Catalog
- Asynchronous
  - Coroutines Flow
- UI
  - Jetpack Compose
  - Material Design 3
- DI
  - Dagger Hilt
- Local
  - DataStore
- Remote
  - Okhttp
  - Retrofit2
  - Gson
- Third party
  - Firebase Messaging
  - Kakao Login
  - Google Login
  - Tesseract4Android
  - Zxing qr scanner

<br>