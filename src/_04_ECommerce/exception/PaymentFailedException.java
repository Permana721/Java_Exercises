package _04_ECommerce.exception;

public class PaymentFailedException extends RuntimeException {
  public PaymentFailedException(String message) {
    super(message);
  }
}
