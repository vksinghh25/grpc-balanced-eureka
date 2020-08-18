package com.example.helloserviceclient;

import com.example.helloservice.gen.proto.HelloRequest;
import com.example.helloservice.gen.proto.HelloResponse;
import com.example.helloservice.gen.proto.HelloServiceGrpc;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HelloServiceClientApplication implements CommandLineRunner {

    @Autowired
    EurekaClient eurekaClient;

    public static void main(String[] args) {
        SpringApplication.run(HelloServiceClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i < 100; i++) {
            InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("hello-service", false);
            ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort())
                    .usePlaintext()
                    .build();

            HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);
            HelloResponse response = stub.hello(HelloRequest.newBuilder()
                    .setName("VkSinghh!")
                    .build());

            System.out.println(response.getMessage());

            Thread.sleep(200);
        }
    }
}
