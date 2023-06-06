package utilities.logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileContactLogger extends ContactLogger {

  public FileContactLogger(LogLevel level) {
    this.level = level;
  }

  @Override
  protected void writeMessage(String message) throws IOException {
    String filename = "log.txt";

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
      writer.write(message);
      writer.newLine();
      System.out.println("Message logged successfully.");
    } catch (IOException e) {
      System.err.println("Error writing to the log file: " + e.getMessage());
    }
  }
}