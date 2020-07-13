# pratice

서울시 공공데이터를 활용하여 각 자치구 별 인구현황을 표출하는 서비스 작성

1. 자치구 선택시 각 자치구가 보유한 인구수를 동적으로 페이지에 표현
2. 자치구 선택시 액션 적용


진행상황
1. API 호출 = JSON
2. Json 파싱하여 Model 객체로 맵핑
3. Service 구현 
   - Api를 호출하는 메서드 (httpClient)
   - 자치구별 List 반환메서드
   - 자치구 이름을 인자로 받아 단일 자치구 Model 반환 메서드 

* 각 자치구 클릭시 액티브 액션 스크립트 작성 필요
* 각 데이터 서칭기능 추가 필요
  - 각 자치구 별 기간 별 검색 기능 추가 필요
  
