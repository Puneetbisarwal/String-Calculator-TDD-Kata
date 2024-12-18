package org.tdd;

import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers == null ) {
            throw new IllegalArgumentException("String is null");
        }

        if (numbers.isEmpty() || numbers.trim().isEmpty()) {
            return 0;
        }

        // Default Delimiter
        String delimiter = ",|\n";
        String numberPart = numbers;

        if (numbers.startsWith("//")) {
            int delimiterEnd = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterEnd);
            numberPart = numbers.substring(delimiterEnd + 1);
        }

        String escapedDelimiter = "[" + delimiter + "]";
        String[] nums = numberPart.split(escapedDelimiter);
        int sum = 0;
        StringBuilder negatives = new StringBuilder();

        for (String num : nums) {
            int n = Integer.parseInt(num);
            if (n < 0) {
                if (negatives.length() > 0)
                    negatives.append(",");
                negatives.append(n);
            }
            sum += n;
        }

        if (negatives.length() > 0) {
            throw new IllegalArgumentException("negative numbers not allowed " + negatives);
        }

        return sum;
    }
}
