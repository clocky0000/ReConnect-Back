# Docker 사용

Spring Boot + PostgreSQL 
Docker Desktop 설치 후 사용
터미널 환경 설정 필욘

---

## Docker 이미지 및 컨테이너 생성

### 컨테이너 실행 및 이미지 빌드

```bash
docker-compose up --build

docker-compose up --build -d  # 백그라운드 실행
```

---

## 접속 정보

Backend
    * URL: http://localhost:8080

PostgreSQL
    * Host: `localhost`
    * Port: `15432`
    * DB: `ReConnect`
    * User: `reconnect`
    * Password: `1234`

---

## PostgreSQL 접속 방법

### 컨테이너 내부 접속

```bash
docker exec -it postgres-db bash
```

### PostgreSQL CLI 실행

```bash
psql -U reconnect -d ReConnect
```

### 자주 사용하는 PostgreSQL 명령어

```bash
\dt                     # 테이블 목록 보기
SELECT * FROM users;    # users 테이블 데이터 조회
\q                      # 종료
```

---

## 컨테이너 중지 및 초기화

### 컨테이너 중지

```bash
docker-compose down
```

### 컨테이너 + 볼륨(데이터) 초기화

```bash
docker-compose down -v
```

## 자주 사용하는 Docker 명령어

```bash
docker ps
# 실행 중인 컨테이너 목록 확인

docker logs reconnect-app
# Spring Boot 로그 출력

docker exec -it postgres-db bash
# PostgreSQL 컨테이너 접속

docker-compose up --build -d
# 백그라운드 실행 (빌드 포함)

docker-compose down
# 모든 컨테이너 종료
```