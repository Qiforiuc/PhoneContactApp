public class FileContactLogger extends ContactLogger {
  public FileContactLogger(LogLevel level) {
    this.level = level;
  }

  @Override
  protected void writeMessage(String message) {
    // Write message to a file
  }
}