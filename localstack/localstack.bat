@echo off

echo ### Criando Queue(Standard) no SQS do LocalStack...
aws --endpoint http://localhost:4566 --profile default sqs create-queue --queue-name sqsHelloWorld
aws --endpoint http://localhost:4566 --profile default sqs send-message --queue-url http://localhost:4566/000000000000/sqsHelloWorld --message-body "Hello World SQS!!!" --delay-seconds 1
aws --endpoint http://localhost:4566 --profile default sqs receive-message --queue-url http://localhost:4566/000000000000/sqsHelloWorld

@REM echo ###PURGE fila SQS
@REM aws --endpoint http://localhost:4566 --profile default sqs purge-queue --queue-url http://localhost:4566/000000000000/sqsHelloWorld
