package hu.flowacademy.FlowRatr.exception;

public class ValidationErrorException extends RuntimeException {
    public ValidationErrorException() {
        super("Validation Error...");
    }
}
