
// Generated by Akka gRPC. DO NOT EDIT.
package com.example.helloworld;

import akka.grpc.internal.*;
import akka.grpc.GrpcClientSettings;
import akka.grpc.javadsl.AkkaGrpcClient;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;

import io.grpc.ManagedChannel;
import io.grpc.MethodDescriptor;

import static com.example.helloworld.GreeterService.Serializers.*;

import scala.concurrent.ExecutionContext;


import akka.grpc.javadsl.SingleResponseRequestBuilder;
import akka.grpc.javadsl.StreamResponseRequestBuilder;


public abstract class GreeterServiceClient extends GreeterServiceClientPowerApi implements GreeterService, AkkaGrpcClient {
  public static final GreeterServiceClient create(GrpcClientSettings settings, Materializer mat, ExecutionContext ec) {
    return new DefaultGreeterServiceClient(settings, mat, ec);
  }

  protected final static class DefaultGreeterServiceClient extends GreeterServiceClient {

      private final ClientState clientState;
      private final GrpcClientSettings settings;
      private final io.grpc.CallOptions options;
      private final Materializer mat;
      private final ExecutionContext ec;

      private DefaultGreeterServiceClient(GrpcClientSettings settings, Materializer mat, ExecutionContext ec) {
        this.settings = settings;
        this.mat = mat;
        this.ec = ec;
        this.clientState = new ClientState(
          settings,
          // TODO #733 remove cast once we update Akka
          akka.event.Logging$.MODULE$.apply(((ActorMaterializer)mat).system(), DefaultGreeterServiceClient.class, akka.event.LogSource$.MODULE$.<DefaultGreeterServiceClient>fromAnyClass()),
          mat,
          ec);
        this.options = NettyClientUtils.callOptions(settings);

        if (mat instanceof ActorMaterializer) {
          ((ActorMaterializer) mat).system().getWhenTerminated().whenComplete((v, e) -> close());
        }
      }

  
    
      private final SingleResponseRequestBuilder<com.example.helloworld.HelloRequest, com.example.helloworld.HelloReply> sayHelloRequestBuilder(scala.concurrent.Future<ManagedChannel> channel){
        return new JavaUnaryRequestBuilder<>(sayHelloDescriptor, channel, options, settings, ec);
      }
    
  
    
      
        
          private final StreamResponseRequestBuilder<akka.stream.javadsl.Source<com.example.helloworld.HelloRequest, akka.NotUsed>, com.example.helloworld.HelloReply> sayHelloToAllRequestBuilder(scala.concurrent.Future<ManagedChannel> channel){
            return new JavaBidirectionalStreamingRequestBuilder<>(
                                 sayHelloToAllDescriptor, "GreeterService.SayHelloToAll", channel, options, settings, ec);
          }
        
      
    
  

      

        /**
         * For access to method metadata use the parameterless version of sayHello
         */
        public java.util.concurrent.CompletionStage<com.example.helloworld.HelloReply> sayHello(com.example.helloworld.HelloRequest request) {
          return sayHello().invoke(request);
        }

        /**
         * Lower level "lifted" version of the method, giving access to request metadata etc.
         * prefer sayHello(com.example.helloworld.HelloRequest) if possible.
         */
        
          public SingleResponseRequestBuilder<com.example.helloworld.HelloRequest, com.example.helloworld.HelloReply> sayHello()
        
        {
          return clientState.withChannel( this::sayHelloRequestBuilder);
        }
      

        /**
         * For access to method metadata use the parameterless version of sayHelloToAll
         */
        public akka.stream.javadsl.Source<com.example.helloworld.HelloReply, akka.NotUsed> sayHelloToAll(akka.stream.javadsl.Source<com.example.helloworld.HelloRequest, akka.NotUsed> request) {
          return sayHelloToAll().invoke(request);
        }

        /**
         * Lower level "lifted" version of the method, giving access to request metadata etc.
         * prefer sayHelloToAll(com.example.helloworld.HelloRequest) if possible.
         */
        
          public StreamResponseRequestBuilder<akka.stream.javadsl.Source<com.example.helloworld.HelloRequest, akka.NotUsed>, com.example.helloworld.HelloReply> sayHelloToAll()
        
        {
          return clientState.withChannel( this::sayHelloToAllRequestBuilder);
        }
      

      
        private static MethodDescriptor<com.example.helloworld.HelloRequest, com.example.helloworld.HelloReply> sayHelloDescriptor =
          MethodDescriptor.<com.example.helloworld.HelloRequest, com.example.helloworld.HelloReply>newBuilder()
            .setType(
   MethodDescriptor.MethodType.UNARY 
  
  
  
)
            .setFullMethodName(MethodDescriptor.generateFullMethodName("GreeterService", "SayHello"))
            .setRequestMarshaller(new ProtoMarshaller<com.example.helloworld.HelloRequest>(HelloRequestSerializer))
            .setResponseMarshaller(new ProtoMarshaller<com.example.helloworld.HelloReply>(HelloReplySerializer))
            .setSampledToLocalTracing(true)
            .build();
        
        private static MethodDescriptor<com.example.helloworld.HelloRequest, com.example.helloworld.HelloReply> sayHelloToAllDescriptor =
          MethodDescriptor.<com.example.helloworld.HelloRequest, com.example.helloworld.HelloReply>newBuilder()
            .setType(
  
  
  
  MethodDescriptor.MethodType.BIDI_STREAMING 
)
            .setFullMethodName(MethodDescriptor.generateFullMethodName("GreeterService", "SayHelloToAll"))
            .setRequestMarshaller(new ProtoMarshaller<com.example.helloworld.HelloRequest>(HelloRequestSerializer))
            .setResponseMarshaller(new ProtoMarshaller<com.example.helloworld.HelloReply>(HelloReplySerializer))
            .setSampledToLocalTracing(true)
            .build();
        

      /**
       * Initiates a shutdown in which preexisting and new calls are cancelled.
       */
      public java.util.concurrent.CompletionStage<akka.Done> close() {
        return clientState.closeCS() ;
      }

     /**
      * Returns a CompletionState that completes successfully when shutdown via close()
      * or exceptionally if a connection can not be established after maxConnectionAttempts.
      */
      public java.util.concurrent.CompletionStage<akka.Done> closed() {
        return clientState.closedCS();
      }
  }

}



