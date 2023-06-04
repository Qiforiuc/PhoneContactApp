public class ConsoleContactLogger extends ContactLogger {
  public ConsoleContactLogger(LogLevel level) {
    this.level = level;
  }

  @Override
  protected void writeMessage(String message) {
    System.out.println("Console Logger: " + message);
  }
}