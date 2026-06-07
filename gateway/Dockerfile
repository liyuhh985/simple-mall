# 第一阶段：构建
FROM maven:3.8-openjdk-11 AS builder
WORKDIR /build
# 复制整个项目
COPY . .
# 在根目录构建
RUN mvn clean package -DskipTests -pl gateway -am

# 第二阶段：运行
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=builder /build/gateway/target/*.jar app.jar
EXPOSE 10010
ENTRYPOINT ["java", "-jar", "app.jar"]
