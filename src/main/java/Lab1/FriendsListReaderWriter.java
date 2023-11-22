package Lab1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * This class provides methods for reading and writing friends' names to a file.
 *
 * <p>
 * The friends' names are stored in a file specified by the {@code FRIENDS_LIST_FILE} constant.
 * The class includes methods for adding a friend to the file and retrieving the list of friends.
 * </p>
 *
 * <p>
 * The class uses Java's built-in logging framework ({@code java.util.logging.Logger}) to log information
 * and errors to a file named "friends.log". Exception handling is implemented to capture IO exceptions
 * during file operations.
 * </p>
 *
 * <p>
 * The author of this class is Alazar Tilahun.
 * </p>
 */
public class FriendsListReaderWriter {
    private static final String FRIENDS_LIST_FILE = "/home/redu/IdeaProjects/Lab1/src/main/java/Lab1/friends.list";
    private static final Logger LOGGER = Logger.getLogger(FriendsListReaderWriter.class.getName());

    static {
        try {
            // Set up the file handler to log to a file named "friends.log"
            FileHandler fileHandler = new FileHandler("friends.log");
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            // If an exception occurs while setting up the logger, print the stack trace
            e.printStackTrace();
        }
    }

    /**
     * Adds a friend to the friends list file.
     *
     * @param friendName The name of the friend to be added.
     */
    public static void addFriend(String friendName) {
        try (FileWriter writer = new FileWriter(FRIENDS_LIST_FILE, true)) {
            writer.write(friendName + "\n");
            LOGGER.log(Level.INFO, "Added friend: {0}", friendName);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error adding friend: {0}", friendName);
            e.printStackTrace();
        }
    }

    /**
     * Gets the list of friends from the friends list file.
     *
     * @return The list of friends.
     * @throws RuntimeException If an IO exception occurs while reading the file.
     */
    public static List<String> getFriendsList() {
        List<String> friendsList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FRIENDS_LIST_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                friendsList.add(line);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading friends list file", e);
            throw new RuntimeException("Error reading friends list file", e);
        }
        return friendsList;
    }
}
