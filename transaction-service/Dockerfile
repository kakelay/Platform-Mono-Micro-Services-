FROM maven:3.9.8-eclipse-temurin-17-alpine AS builder
WORKDIR /workspace
COPY . .
RUN mvn -B -pl transaction-service -am clean package -DskipTests -Dmaven.test.skip=true

FROM eclipse-temurin:17-jre-alpine
RUN addgroup -S spring && adduser -S spring -G spring spring
WORKDIR /app
COPY --from=builder /workspace/transaction-service/target/*.jar app.jar
RUN chown spring:spring /app/app.jar
USER spring
EXPOSE 8085
ENTRYPOINT ["java","-XX:+UseContainerSupport","-XX:MaxRAMPercentage=75.0","-jar","/app/app.jar"]
