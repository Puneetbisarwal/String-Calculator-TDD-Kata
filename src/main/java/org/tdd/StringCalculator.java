package org.tdd;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers == null ) {
            throw new IllegalArgumentException("String is null");
        }

        if (numbers.isEmpty() || numbers.trim().isEmpty()) {
            return 0;
        }

        // eg: numbers: "-5"
        // Default Delimiter
        String delimiter = ",|\n";
        String[] nums = numbers.split(delimiter); // eg: numbers: "-5"  delimiter: ",|\n"  nums: ["-5"]
        int sum = 0;

        for (String num : nums) {    // nums: ["-5"]   num: "-5"
            int n = Integer.parseInt(num); // num: "-5"  n: -5
            if (n < 0) {  // n: -5
                throw new IllegalArgumentException("negative numbers not allowed " + n);
            }
            sum += n;
        }

        return sum;
    }
}
