package ru.krista.uniyar;

import io.grpc.stub.StreamObserver;
import io.quarkus.calc.CalculatorProto;
import io.quarkus.calc.CalculatorServiceGrpc;

import javax.inject.Singleton;

@Singleton
public class CalculatorServiceImpl extends CalculatorServiceGrpc.CalculatorServiceImplBase {
    @Override
    public void calculate(CalculatorProto.CalculatorRequest request, StreamObserver<CalculatorProto.CalculatorResponse> responseObserver) {
        Double number1 = request.getNumber1();
        Double number2 = request.getNumber2();
        CalculatorProto.CalculatorRequest.OperationType operation = request.getOperation();
        Double result = Double.NaN;

        switch (operation) {
            case ADD:
                result = number1 + number2;
                break;
            case SUBTRACT:
                result = number1 - number2;
                break;
            case MULTIPLY:
                result = number1 * number2;
                break;
            case DIVIDE:
                result = number1 / number2;
                break;
        }
        responseObserver.onNext(CalculatorProto.CalculatorResponse.newBuilder().setResult(result).build());
        responseObserver.onCompleted();
    }
}