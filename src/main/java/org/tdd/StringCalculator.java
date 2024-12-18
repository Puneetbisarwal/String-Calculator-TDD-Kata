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
        if(nums.length == 1)
        {
            int result = Integer.parseInt(numbers);
            return result;
        }
        int sum = Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);

        return sum;
    }
}
