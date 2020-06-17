**Akka- grpc-project**

_Compile the project by entering:_
mvn compile

_Run the server:_

mvn compile dependency:properties exec:exec@server

Maven runs the com.example.helloworld.GreeterServer main class that starts the gRPC server. The exec:exec@server execution is defined in the Maven pom.xml build definition.
The output should include something like:

gRPC server bound to: /127.0.0.1:8080

_Run the client, open another console window and enter:_

mvn compile dependency:properties exec:exec@client

Maven runs the com.example.helloworld.GreeterClient main class that starts the gRPC client. The exec:exec@client execution is defined in the Maven pom.xml build definition.
The output should include something like:

Performing request: Alice
Performing request: Bob
HelloReply(Hello, Bob)
HelloReply(Hello, Alice)
