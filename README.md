# Camping SNS APP Admin 

성향에 맞는 캠핑장을 찾고, 캠핑장 경험을 공유할 수 있는 앱을 만들자. 

이런 앱을 관리하는 관리자 페이지를 만들자.

# 앱 개발 목표 
- 1차 목표 : 캠핑장 정보를 제공한다.
- 2차 목표 : 개인의 성향을 분석한다.
- 3차 목표 : 캠핑장 경험을 공유한다.
- 4차 목표 : 예약 시스템을 갖춘다.

# 개인 개발 목표
- CI/CD 등 자동화를 이용하자. 
- TDD를 생각하며 개발하자. 
- API Docs 역시 자동화를 이용하자.
- 평소에 탐내던 기술들을 활용하자.  
- 꾸준히 하자.

# 개발 스펙

### 개발(local)
- Spring boot 2.3.1
- OpenJDK 14
- Spring data jpa
- h2 database
- thymeleaf
- JUnit 5
- lombok

### 관리
1. Issue 발행
2. branch 생성 후, 이슈 작업
3. 작업 수행 후, update, commit, push
4. (코드리뷰) Pull Request 생성 (resolved #이슈번호)
5. Github Action 확인
6. Merge, 해당 issue의 branch 삭제


# 관리자 페이지 구성
- [대시보드](#dashboard)
- [캠핑장 목록](#캠핑장-목록)
- 사전 조사
- 이벤트
- 옵션(편의시설 등) 관리
- 공지사항 관리
- 사용자 관리

# Dashboard
기본 화면을 보여준다. 


# 캠핑장 목록

캠핑장 목록을 보여준다. 

1. 캠핑장명, 간단 위치, 등록일, 수정일, 데이터 기준일 (데이터기준일, 수정일 비교해서 표시)
2. 한 페이지에 20개씩 노출
3. 페이징
4. 검색 : 캠핑장명, 위치, 데이터 기준일이 수정일보다 더 최신인 데이터 

[캠핑 목록 URI](https://www.notion.so/03e2cce96f3a4ab38d45e8200b802004)

|메소드|이름|query|설명|
|---|---|---|---|
|GET|/camps|page|캠핑장 목록 화면|
|GET|/camps/form| |빈 캠핑장 입력 화면|
|GET|/camps/{id}/form| |id의 캠핑장 수정 페이지|
|GET|/camps/{id}| |id의 캠핑장 상세 페이지|		
|PUT|/camps{id}| |캠핑장 내용을 수정|		
|POST|/camps{id}| |캠핑장 내용을 저장|		
|DELETE|/camps{id}| |캠핑장 삭제(flag 변화)|

## 캠핑장 상세

캠핑장 상세 화면을 보여준다. 

1. 캠핑장 전체 정보 
2. 위도와 경도를 기반으로 지도 표시 
3. 목록, 수정, 삭제 버튼 만들기
4. 이전글, 다음글 버튼 만들기

