# S.C.H.A.D Akka Producer

Author G. Gordon	

## Overview

This project is a part of a larger project SCHAD created by GGordon.

It's aim is to retrieve clickstream data using the Akka framework, tranform this data into a pipe delimited string and publish to Apache Kafka

It will provide the following on each data event received

- Customer Id
- Product Viewed Id
- Customer Zip Code
- ScrollXPosition (X position in window)
- ScrollYPosition (Y position in window)
- Date Time

A sample line would look like (using `text` output format)
```
9515|965|57146|704.628|666.230|2020/05/20 01:35:50
```

It expects a json stream source - see https://github.com/gggordon/schad-clicksteam-generator

A sample line would look like (using `json` output format)
```
{"customerId":7869,"browser_y_position":1097.1743,"zipCode":28804,"browser_x_position":774.58954,"productId":1274,"date_time":"2020/05/18 15:31:05"}
```

## Acquiring a release

You may either build a release or use one of the pre-existing releases

### Pre-existing releases

Pre-existing releases are available in the `releases` folder and in another folder indicating their version. For eg. version `1.0.0` is available in `./releases/1.0.0`

### Building a release

This is an eclipse project managed by maven. 

1. You may either export the project from eclipse as a runnable jar
2. You may build a version using `mvn package`

## Running the application

You may either run the application directly or as a Docker Container.

### Running the application directly

```
java -jar schad-akka-producer-1.0.0.jar --clickStreamServerAddress "0.0.0.0" --clickStreamServerPort "3005" --kafkaTopic schad --kafkaBootstrapServers "192.168.1.1:9092"
```

Where 
  - `schad-akka-producer-1.0.0.jar` is the application name
  - `--clickStreamServerAddress` server address of clickstream data emitter source
  - `--clickStreamServerPort`  port used by clickstream data emitter
  - `--kafkaTopic`  kafka topics to publish to
  - `--kafkaBootstrapServers`  comma separated list of kafka bootstrap servers


### Running the application using docker

Dockerfiles are available for each release . Eg to run release 1.0.0
```
cd releases/1.0.0 # Change director to release folder
docker build -t schad-akka-producer .
docker run --name my-schad-akka-producer schad-akka-producer
```
#### Build Arguments Available
- clickstream_server_address=0.0.0.0 - click stream server address
- clickstream_server_port=3005 - click stream server port
- kafka_topic=schad - kafka topic to publish to
- kafka_boostrap_servers=192.168.1.1:9092 - kafka bootstrap servers, comma separated list

#### Environment Arguments Available
- CLICKSTREAM_SERVER_ADDRESS=0.0.0.0 - click stream server address
- CLICKSTREAM_SERVER_PORT=3005 - click stream server port
- KAFKA_TOPIC=schad - kafka topic to publish to
- KAFKA_BOOTSTRAP_SERVERS=192.168.1.1:9092 - kafka bootstrap servers, comma separated list

Eg. Running with an interval of 500 milliseconds
```
docker run --name my-schad-akka-producer -e KAFKA_BOOTSTRAP_SERVERS="192.168.1.3:9092" schad-akka-producer
```

## Change Log


#### 1.0.0 - Initial Release
- Akka Kafka Producer

## LICENSE

[Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)


