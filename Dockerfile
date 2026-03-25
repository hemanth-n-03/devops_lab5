FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY  . /app
RUN javac app.java
CMD ["java","app"]
