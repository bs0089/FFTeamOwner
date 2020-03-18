package edu.uah.cs.cs321;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// THIS CLASS HAS NOT BEEN TESTED
public class CSVParser {

    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DEFAULT_QUOTE = '"';
    private String csvFile;

    public CSVParser(String filename) {
        Scanner scanner;

        csvFile = filename;

        try {
            scanner = new Scanner(new File(csvFile));
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open " + csvFile);
            return;
        }

        while (scanner.hasNext()) {
            List<String> line = parseLine(scanner.nextLine());
            // do stuff here to add data to Players
        }
        scanner.close();
    }

    public static List<String> parseLine(String csvLine) {
        return parseLine(csvLine, DEFAULT_SEPARATOR, DEFAULT_QUOTE);
    }

    public static List<String> parseLine(String csvLine, char  separators) {
        return parseLine(csvLine, separators, DEFAULT_QUOTE);
    }

    public static List<String> parseLine(String csvLine, char separators, char customQuote) {
        List<String> result = new ArrayList<>();
        StringBuffer curVal = new StringBuffer();
        boolean inQuotes = false;
        boolean startCollectChar = false;
        boolean doubleQuotesInColumn = false;
        char[] chars;

        if (csvLine == null) { // return if empty
            return result;
        }

        if (customQuote == ' ') {
            customQuote = DEFAULT_QUOTE;
        }

        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        chars = csvLine.toCharArray();

        for (char ch: chars) {
            if (inQuotes) {
                startCollectChar = true;

                if (ch == customQuote) {
                    inQuotes = false;
                    doubleQuotesInColumn = false;
                } else {
                    if (ch == '"') {
                        if (!doubleQuotesInColumn) {
                            curVal.append(ch);
                            doubleQuotesInColumn = true;
                        } else {
                            curVal.append(ch);
                        }
                    }
                }
            } else {
                if (ch == customQuote) {
                    inQuotes = true;

                    if (chars[0] != '"' && customQuote == '"') {
                        curVal.append('"');
                    }

                    if (startCollectChar) {
                        curVal.append('"');
                    }
                } else if (ch == separators) {
                    curVal = new StringBuffer();
                    startCollectChar = false;

                    result.add(curVal.toString());
                } else if (ch == '\r') { // ignore LF characters
                    continue;
                } else if (ch == '\n') {
                    break;
                } else {
                    curVal.append(ch);
                }
            }
        }
        result.add(curVal.toString());

        return result;
    }
}
