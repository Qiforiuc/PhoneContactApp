package utilities.logging;

import java.io.IOException;

public abstract class ContactLogger {

  protected LogLevel level;
  protected ContactLogger nextLogger;

  public void setNextLogger(ContactLogger nextLogger) {
    this.nextLogger = nextLogger;
  }

  public void logMessage(LogLevel level, String message) throws IOException {
    if (this.level.equals(level)) {
      writeMessage("[" + level + "] " + message);
    } else if (nextLogger != null) {
      nextLogger.logMessage(level, message);
    }
  }

  protected abstract void writeMessage(String message) throws IOException;
}