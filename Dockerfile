FROM amazoncorretto:21

WORKDIR /app

COPY build.gradle /app
COPY gradlew /app
COPY gradle /app/gradle
COPY settings.gradle /app

# gradlewに実行権限を追加
RUN chmod +x ./gradlew

# イメージからコンテナを作成・起動する際に実行されるコマンド
CMD [ "/bin/bash", "-c", "./gradlew bootRun" ]
