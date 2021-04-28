package ru.krista.uniyar;

import io.grpc.stub.StreamObserver;
import io.quarkus.calc.CalculatorProto;
import io.quarkus.calc.CalculatorServiceGrpc;

import javax.inject.Singleton;

@Singleton
public class CalculatorServiceImpl extends CalculatorServiceGrpc.CalculatorServiceImplBase {
    @Override
    public void calculate(CalculatorProto.CalculatorRequest request, StreamObserver<CalculatorProto.CalculatorResponse> responseObserver) {
        double number1 = request.getNumber1();
        double number2 = request.getNumber2();
        CalculatorProto.CalculatorRequest.OperationType operation = request.getOperation();
        double result = 0;
        CalculatorProto.CalculatorResponse.Builder builder = CalculatorProto.CalculatorResponse.newBuilder();

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
                if (number2 == 0) {
                    builder.setError("Error: division by zero.");
                } else {
                    result = number1 / number2;
                }
                break;
            default:
                builder.setError("Error: unsupported operation.");
        }
        builder.setResult(result);
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}