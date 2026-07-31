package _04_ECommerce.exception;

public class ProductNotNullException extends RuntimeException {
  public ProductNotNullException(String message) {
    super(message);
  }
}
