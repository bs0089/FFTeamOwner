package edu.uah.cs.cs321;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// THIS CLASS HAS NOT BEEN TESTED
public class CSVParser {

    private final char DEFAULT_SEPARATOR = ',';
    private final char DEFAULT_QUOTE = '\"';
    private Scanner scanner;

    public CSVParser(String filename) throws FileNotFoundException {
        scanner = new Scanner(new File(filename));
    }

    public  List<String> parseLine() {
        return parseLine(DEFAULT_SEPARATOR, DEFAULT_QUOTE);
    }

    public List<String> parseLine(char separators) {
        return parseLine(separators, DEFAULT_QUOTE);
    }

    public  List<String> parseLine(char separators, char customQuote) {
        String csvLine = scanner.nextLine();
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
                    if (ch == '\"') {
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

                    if (chars[0] != '\"' && customQuote == '\"') {
                        curVal.append('\"');
                    }

                    if (startCollectChar) {
                        curVal.append('\"');
                    }
                } else if (ch == separators) {
                    result.add(curVal.toString());

                    curVal = new StringBuffer();
                    startCollectChar = false;
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

    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }
}
