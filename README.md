# Board-Server
대용량 트래픽 게시판 프로젝트

---
# 목적
- 대용량 트래픽을 고려한 어플리케이션 개발 (초당 1000 tps 이상의 게시글 검색 API)
- 객체지향과 디자인 패턴을 적용 및 가독성을 고려한 코드 작성 방법 공유
- 현업 단계에서 코드리뷰를 어떻게 하는지 경험 공유 공유
- 모니터링 및 트러블 슈팅 전략 공유
- 젠킨스 툴로 배포 자동화를 통해 개발 생산성 높이기

---
# 사용기술
- JAVA 17, Spring Boot 2.3, MyBatis, MySQL, Redis

---
# 성능테스트 툴
- Python 3.9, Locust
- ****[성능테스트 툴](https://github.com/ccommit-dev/Board-Server-Locust)****

---
# 기획
- 커뮤니티 사이트의 게시판을 구현함으로써 자유롭게 소통하는 및 정보 공유 사이트를 목표로 구현

---
# 프로그램 주요 기능
- 회원
  - 가입, 탈퇴
  - 아이디 및 닉네임 중복체크
  - 비밀번호 암호화
  - 로그인, 로그아웃
- 게시판
  - 카테고리 관리
    - 추가, 삭제, 수정
  - 게시글 관리
    - 게시글 & 파일 추가, 삭제, 수정, 조회
    - 유저 정보, 게시글 제목, 게시글 내용 등
  - 게시글 검색 기능
    - 작성 유정 아이디
    - 게시글 제목, 게시글 내용 등을 통해 검색
    - 태크 작성 및 조회 기능
  - 댓글 작성 기능
- 어드민
  - 공지글 추가 기능

---
# 이슈별 실습 내용

![image](https://github.com/user-attachments/assets/e0586fe4-7ca7-4f7a-aa1d-68d687f25923)

---
# ERD(Entity Relationship Diagram)
![image](https://github.com/user-attachments/assets/32280041-c970-4146-9f55-81b890277fe8)


---
# 시퀀스
- 게시글 등록 시퀀스
![image](https://github.com/user-attachments/assets/aa8a7fcd-6f89-48e4-a70d-a1ebebbcacbc)


- 게시글 검색 시퀀스
![image](https://github.com/user-attachments/assets/47b1c9ec-0480-4d1d-a9b1-d7a139c30260)


---
# 아키텍처(요약)
![image](https://github.com/user-attachments/assets/3bb39e8f-d69e-4b50-8ed7-3afb154ea4f4)
