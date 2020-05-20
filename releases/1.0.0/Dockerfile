# Author GGordon
# This is apart of a larger project SCHAD
# Image to run SCHAD Akka Producer
# See https://github.com/gggordon/schad-clicksteam-generator

FROM openjdk:latest

# clickstream server address
ARG clickstream_server_address="0.0.0.0"
ENV CLICKSTREAM_SERVER_ADDRESS=$clickstream_server_address

# clickstream server port
ARG clickstream_server_port="3005"
ENV CLICKSTREAM_SERVER_PORT=$clickstream_server_port

#  kafka topic
ARG kafka_topic="3005"
ENV KAFKA_TOPIC=$kafka_topic

# kafka boostrap server
ARG kafka_boostrap_servers="192.168.1.1:9092"
ENV KAFKA_BOOTSTRAP_SERVERS=$kafka_boostrap_servers

WORKDIR /app

COPY schad-akka-producer-1.0.0.jar ./

CMD ["sh","-c","java -jar schad-akka-producer-1.0.0.jar --clickStreamServerAddress '${CLICKSTREAM_SERVER_ADDRESS}' --clickStreamServerPort '${CLICKSTREAM_SERVER_PORT}' --kafkaTopic ${KAFKA_TOPIC} --kafkaBootstrapServers '${KAFKA_BOOTSTRAP_SERVERS}'"]
