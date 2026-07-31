package _04_ECommerce.exception;

public class UserNotNullException extends RuntimeException {
  public UserNotNullException(String message) {
    super(message);
  }
}
