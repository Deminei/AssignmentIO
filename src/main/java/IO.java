import java.io.*;
import java.util.*;

public class IO {
    public static void main(String[] args) {

        List<Integer> list1 = readFile("C:\\Users\\wowin\\IdeaProjects\\AssignmentIO\\src\\main\\java\\resources\\input1.txt");
        List<Integer> list2 = readFile("C:\\Users\\wowin\\IdeaProjects\\AssignmentIO\\src\\main\\java\\resources\\input2.txt");

        System.out.println("Contents of input1.txt: " + list1);
        System.out.println("Contents of input2.txt: " + list2);
        System.out.println();

        if (list1 != null && list2 != null) {
            writeToFile("C:\\Users\\wowin\\IdeaProjects\\AssignmentIO\\src\\main\\java\\resources\\merged.txt", list1, list2);

            list1.retainAll(list2);  // list1 now contains only elements that are in both lists
            writeToFile("C:\\Users\\wowin\\IdeaProjects\\AssignmentIO\\src\\main\\java\\resources\\common.txt", list1);
        }
        List<Integer> mergedlist = readFile("C:\\Users\\wowin\\IdeaProjects\\AssignmentIO\\src\\main\\java\\resources\\merged.txt");
        List<Integer> commonlist = readFile("C:\\Users\\wowin\\IdeaProjects\\AssignmentIO\\src\\main\\java\\resources\\common.txt");
        System.out.println("Input files merged and written to new file merged.txt: " + mergedlist);
        System.out.println("Integers that are present in both input files written to new file common.txt: " + commonlist);
    }

    //Method to read files using BufferedReader
    private static List<Integer> readFile(String filename) {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("The specified file does not exist.");
            e.printStackTrace();
        } catch (IOException | NumberFormatException e) {
            System.out.println("An error occurred while reading the file or parsing the numbers.");
            e.printStackTrace();
            return null;
        }
        return list;
    }

    //Method to write to files using BufferedWriter
    private static void writeToFile(String filename, List<Integer>... lists) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (List<Integer> list : lists) {
                for (Integer num : list) {
                    writer.write(num.toString());
                    writer.newLine();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The specified file does not exist.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
