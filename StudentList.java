// File Name: StudentList.java
import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
        // Check arguments first
        if (args.length == 0) {
            System.out.println("No arguments provided.");
            return;
        } else if (args[0].equals("a")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("students.txt")
                    )
                );
                String st = reader.readLine();
                String[] splited = st.split(", ");
                for (String j : splited) {
                    System.out.println(j);
                }
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("An error occurred.");
            }
        } else if (args[0].equals("r")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("students.txt")
                    )
                );
                String st = reader.readLine();
                // System.out.println(r);
                String[] splitted = st.split(", ");
                Random random = new Random();
                int y = random.nextInt(splitted.length);
                System.out.println(splitted[y]);
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("An error occurred.");
            }
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter fileWriter = new BufferedWriter(
                    new FileWriter("students.txt", true)
                );
                String substring = args[0].substring(1);
                Date date = new Date();
                String dateFormatPattern = "dd/MM/yyyy hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);
                String formatDate = dateFormat.format(date);
                fileWriter.write(", " + substring + "\nList last updated on " + formatDate);
                fileWriter.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("An error occurred.");
            }
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("students.txt")
                    )
                );
                String read = reader.readLine();
                String[] splitted = read.split(",");
                boolean done = false;
                String substring = args[0].substring(1);
                int idx;
                for (idx = 0; idx < splitted.length && !done; idx++) {
                    if (splitted[idx].equals(substring.trim())) {
                        System.out.println("We found it!");
                        done = true;
                    }
                }
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("An error occurred.");
            }
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("students.txt")
                    )
                );
                String read = reader.readLine();
                char[] chArr = read.toCharArray();
                boolean in_word = false;
                int count = 0;
                for (char c : chArr) {
                    if (c == ' ') {
                        if (!in_word) {
                            count++;
                            in_word = true;
                        }
                    } else {
                        in_word = false;
                    }
                } count++;
                System.out.println(count + " word(s) found");
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("An error occurred.");
            }
        }else {
            System.out.println("Invalid argument.");
        }
    }
}