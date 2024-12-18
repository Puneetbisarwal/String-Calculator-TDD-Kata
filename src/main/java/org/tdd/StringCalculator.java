package org.tdd;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers == null ) {
            throw new IllegalArgumentException("String is null");
        }

        if (numbers.isEmpty() || numbers.trim().isEmpty()) {
            return 0;
        }

        String[] nums = numbers.split(",");
        int sum = 0;
        for (String num : nums) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}
