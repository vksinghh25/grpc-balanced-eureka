package com.example.helloservice.services;

import com.example.helloservice.gen.proto.HelloRequest;
import com.example.helloservice.gen.proto.HelloResponse;
import com.example.helloservice.gen.proto.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GRpcService
public class HelloService extends HelloServiceGrpc.HelloServiceImplBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloService.class);

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String name = request.getName();
        LOGGER.info("Got Request for Name : " + name);

        HelloResponse helloResponse = HelloResponse.newBuilder().setMessage("Hello " + name + "!!").build();
        responseObserver.onNext(helloResponse);
        responseObserver.onCompleted();
    }
}
