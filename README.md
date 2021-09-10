# RiotGameAPISampleApp

이 프로젝트는 Riot Champions API를 이용하여  `Compose`를 사용한 샘플 앱 입니다.

### 느낀점

Riot Champions API의 각 챔피언 JSON은 동적 키로 구성되어 있어 이 부분을 파싱하는 부분이 어려웠습니다.. `Kotlin-serialization`를 사용해보려고 했지만 해결방법은 찾을 수 없었고 `gson`의 `@Expose`를 사용하여 해결했습니다!

### Screen

<img src = "./images/lol.gif" width = "20%">
