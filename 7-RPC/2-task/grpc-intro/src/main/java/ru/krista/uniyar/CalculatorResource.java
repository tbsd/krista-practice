package ru.krista.uniyar;

import io.quarkus.calc.CalculatorProto;
import io.quarkus.calc.CalculatorProto.CalculatorRequest.OperationType;
import io.quarkus.grpc.runtime.annotations.GrpcService;
import io.quarkus.calc.CalculatorServiceGrpc.CalculatorServiceBlockingStub;

import javax.inject.Inject;
import javax.management.openmbean.OpenDataException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;

@Path("/calc")
public class CalculatorResource {

    @Inject
    @GrpcService("calculator")
    CalculatorServiceBlockingStub client;

//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String hello() {
//        return "hello";
//    }

    @GET
    @Path("/")
    public String hello(@QueryParam("n1") Double number1, @QueryParam("n2") Double number2, @QueryParam("op") Integer operation) {
        if (number1 == null || number2 == null || operation == null)
            return "Error: some parameters are undefined.";
        Double result = client.calculate(CalculatorProto.CalculatorRequest.newBuilder().setNumber1(number1).setNumber2(number2)
                .setOperationValue(operation).build()).getResult();
        if (result.isNaN())
            return "Error: unsupported operation.";
        return "result: " + result;
    }
}