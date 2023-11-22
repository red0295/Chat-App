package Lab1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * This class provides methods for reading and writing private chat messages to a file.
 *
 * <p>
 * The private chat messages are stored in a file specified by the {@code PRIVATE_CHAT_FILE} constant.
 * The class includes methods for writing a message to the file and reading messages from the file.
 * </p>
 *
 * <p>
 * The class uses Java's built-in logging framework ({@code java.util.logging.Logger}) to log information
 * and errors to a file named "private_chat.log". Exception handling is implemented to capture IO exceptions
 * during file operations.
 * </p>
 *
 * <p>
 * The author of this class is Alazar Tilahun.
 * </p>
 */
public class PrivateChatReaderWriter {
    private static final String PRIVATE_CHAT_FILE = "/home/redu/IdeaProjects/Lab1/src/main/java/Lab1/Donut[AFK].log";
    private static final Logger LOGGER = Logger.getLogger(PrivateChatReaderWriter.class.getName());

    static {
        try {
            // Set up the file handler to log to a file named "private_chat.log"
            FileHandler fileHandler = new FileHandler("private_chat.log");
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            // If an exception occurs while setting up the logger, print the stack trace
            e.printStackTrace();
        }
    }

    /**
     * Writes a private chat message to the private chat file.
     *
     * @param message The message to be written.
     */
    public static void writeMessage(String message) {
        try (FileWriter writer = new FileWriter(PRIVATE_CHAT_FILE, true)) {
            writer.write(message + "\n");
            LOGGER.log(Level.INFO, "Wrote private chat message: {0}", message);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error writing private chat message", e);
            e.printStackTrace();
        }
    }

    /**
     * Reads and prints all private chat messages from the private chat file.
     */
    public static void readMessage() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PRIVATE_CHAT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading private chat file", e);
            e.printStackTrace();
        }
    }
}
