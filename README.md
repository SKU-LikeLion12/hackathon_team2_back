# Simple Project Back

## 프로젝트 설명

이 프로젝트는 Spring Boot를 기반으로 한 백엔드 애플리케이션입니다. 데이터베이스 연동, 웹 보안, 데이터 검증, JWT 인증, Thymeleaf 템플릿 엔진 등의 기능을 포함하고 있습니다. Spring Boot 3.3.2와 Java 17을 사용하여 개발되었습니다.

## 주요 기술 스택

- **Spring Boot**: `3.3.2`
- **Java**: `17`
- **데이터베이스**: MySQL
- **JWT**: `0.9.1`
- **Lombok**: `1.18.24`
- **Thymeleaf**: `3.1.16.RELEASE`
- **SpringDoc OpenAPI**: `2.1.0`

## 설치 및 실행

**1. 클론**

먼저, 이 저장소를 클론합니다:

```bash
git clone https://github.com/your-repo/simple_project_back.git
cd simple_project_back
````


**2. Gradle을 사용하여 종속성을 설치합니다**

```bash
./gradlew build
````

데이터베이스 설정
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/yourdatabase
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
````

**3. 애플리케이션 실행**

Spring Boot 애플리케이션을 실행합니다
```bash
./gradlew bootRun
````
또는 JAR 파일로 빌드하여 실행할 수 있습니다:
```bash
./gradlew build
java -jar build/libs/simple_project_back-0.0.1-SNAPSHOT.jar
````


**4. 개발**
이 프로젝트는 Lombok을 사용하여 코드의 boilerplate를 줄이고 있습니다. Lombok의 어노테이션을 적절히 활용하여 코드의 간결함을 유지합니다.

JUnit을 사용하여 테스트를 작성합니다. 테스트는 Gradle을 통해 실행할 수 있습니다:
```bash
./gradlew test
````


**5. 문서화**
이 프로젝트는 SpringDoc OpenAPI를 사용하여 API 문서를 자동으로 생성합니다. /swagger-ui.html 엔드포인트에서 Swagger UI를 통해 문서를 확인할 수 있습니다.

