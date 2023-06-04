// Chain of Responsibility (ContactLogger)
public abstract class ContactLogger {
  protected LogLevel level;
  protected ContactLogger nextLogger;

  public void setNextLogger(ContactLogger nextLogger) {
    this.nextLogger = nextLogger;
  }

  public void logMessage(LogLevel level, String message) {
    if (this.level.equals(level)) {
      writeMessage("[" + level + "] " + message);
    } else if (nextLogger != null) {
      nextLogger.logMessage(level, message);
    }
  }

  protected abstract void writeMessage(String message);
}