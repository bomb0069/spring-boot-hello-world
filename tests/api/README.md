# API Test with NEWMAN JSON Script

## Start Stubby External Service

>java -jar ./external-service/stubby4j-6.0.2.jar -d ./external-service/world-client.yaml -s 9090 > ./external-service/world-client.log 2>&1 &

## Start API Server

>cd ../..
>cd backend
>./mvnw spring-boot:run &

## Run Newman Script 

>cd ../
>cd tests/api
>newman run hello_world.json 
