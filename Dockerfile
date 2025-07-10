# Spring Boot 애플리케이션용 멀티스테이지 Dockerfile

# 1단계: 빌드 스테이지
FROM gradle:8.11-jdk21 AS builder

WORKDIR /app

# Gradle 래퍼와 의존성 파일들 복사
COPY gradle/ gradle/
COPY gradlew .
COPY gradle.properties* ./
COPY build.gradle.kts .
COPY settings.gradle.kts .

# 의존성 다운로드 (캐싱 최적화)
RUN ./gradlew dependencies --no-daemon

# 소스 코드 복사 및 빌드
COPY src/ src/
RUN ./gradlew clean build --no-daemon -x test

# 2단계: 실행 스테이지
FROM eclipse-temurin:21-jre-alpine

# 애플리케이션 실행용 사용자 생성
RUN addgroup -g 1001 spring && adduser -u 1001 -G spring -s /bin/sh -D spring

WORKDIR /app

# 빌드된 JAR 파일 복사
COPY --from=builder /app/build/libs/*.jar app.jar

# 권한 설정
RUN chown spring:spring /app/app.jar

USER spring

# 포트 노출
EXPOSE 8080

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "/app/app.jar"] 