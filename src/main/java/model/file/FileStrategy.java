package main.java.model.file;

import java.util.Set;

public interface FileStrategy {
	
	/**
	 * Uses a buffer to read each line from file.
	 * @return return each line read as a Set of String
	 */
	Set<String> fileReader();
	
	/**
	 * Uses a buffer to write a new line on file.
	 * @param objectToString to write
	 * @return false is something went wrong
	 */
	boolean writeInFile(final String objectToString);
	
	/**
	 * Search a String target on the first data in each line of the file.
	 * @param target to look for
	 * @return the complete line who contains the target inside the first information.
	 */
	String searchInFile(String target);
	
	/**
	 * It deletes the line that contain as the first data the target setted as parameter.
	 * @param target to delete
	 * @return false if something went wrong
	 */
	boolean deleteLine(String target);
	
	/**
	 * It cleans the file.
	 * @return false if something went wrong
	 */
	boolean emptyFile();
	
	/**
	 * Calls fileReader() method and from its output it takes all the IDs.
	 * {@link fileReader()}
	 * @return a Set of String containing the IDs
	 */
	Set<String> getAllId();
}
