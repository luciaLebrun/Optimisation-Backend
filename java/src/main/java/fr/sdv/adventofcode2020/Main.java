package fr.sdv.adventofcode2020;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;


public class Main {
    static void printTimeElapsed(LocalDateTime startTime, LocalDateTime endTime) {
        Duration duration = Duration.between(startTime, endTime);
        System.out.println("Time elapsed: " + duration.getNano() / 1000000 + "ms");

    }

//    public static int brute_force(List<Integer> numbers) {
//        LocalDateTime startTime = java.time.LocalDateTime.now();
//        int result = 0;
//        for(int i = 0; i < numbers.size(); i++) {
//            for(int j = 0; j < numbers.size(); j++) {
//                if(numbers.get(i) + numbers.get(j) == 2020) {
//                    result += numbers.get(i) * numbers.get(j);
//                    numbers.remove(i);
//                    numbers.remove(j);
//                    break;
//                }
//            }
//        }
//        LocalDateTime endTime = java.time.LocalDateTime.now();
//        printTimeElapsed(startTime, endTime);
//        return result;
//    }


    public static int brute_force(List<Integer> numbers) {
        LocalDateTime startTime = java.time.LocalDateTime.now();
        int result = 0;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size() - 1; j++) {
                Integer res = numbers.get(i) + numbers.get(j);
                for (int k = 0; k < numbers.size() - 2; k++) {
                    if (res + numbers.get(k) == 2020) {
                        result += numbers.get(i) * numbers.get(j) * numbers.get(k);
                        numbers.remove(i);
                        numbers.remove(j);
                        numbers.remove(k);
                        break;
                    }
                }
            }
        }
        LocalDateTime endTime = java.time.LocalDateTime.now();
        printTimeElapsed(startTime, endTime);
        return result;
    }


    public static int complementary(List<Integer> numbers) {
        LocalDateTime startTime = java.time.LocalDateTime.now();
        int result = 0;

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                if (numbers.contains(2020 - (numbers.get(i) + numbers.get(j)))) {
                    result += numbers.get(i) * numbers.get(j) * (2020 - (numbers.get(i) + numbers.get(j)));
                    numbers.remove(i);
                    numbers.remove(j);
                    break;
                }
            }
        }

        LocalDateTime endTime = java.time.LocalDateTime.now();
        printTimeElapsed(startTime, endTime);
        return result;
    }

    public static Optional<Integer> recursive(Set<Integer> numbers, int d, int k) {
        if (k == 1) {
            return numbers.contains(d) ? Optional.of(d) : Optional.empty();
        }

        for (int n : numbers) {
            Set<Integer> remainingNumbers = new HashSet<>(numbers);
            remainingNumbers.remove(n);

            Optional<Integer> nComp = recursive(remainingNumbers, d - n, k - 1);
            if (nComp.isPresent()) {
                return Optional.of(n * nComp.get());
            }
        }

        return Optional.empty();
    }

    public static void main(String[] args) throws IOException {
        File input = new File("src/main/resources/input.txt");
        File inputTest = new File("src/main/resources/input_test.txt");

        Scanner sc = new Scanner(inputTest);
        Scanner sc2 = new Scanner(input);


        List<Integer> numbers1 = new ArrayList<>();
        List<Integer> numbers2 = new ArrayList<>();

        while (sc.hasNextLine()) {
            numbers1.add(Integer.parseInt(sc.nextLine()));
        }

        while (sc2.hasNextLine()) {
            numbers2.add(Integer.parseInt(sc2.nextLine()));
        }

        List<Integer> numbers3 = new ArrayList<>(numbers1);
        List<Integer> numbers4 = new ArrayList<>(numbers2);

        List<Integer> numbers5 = new ArrayList<>(numbers1);
        List<Integer> numbers6 = new ArrayList<>(numbers2);

        System.out.println(numbers1);
        System.out.println(numbers2);

        System.out.println("---- Brute force ----");

        System.out.println(brute_force(numbers1));
        System.out.println(brute_force(numbers2));

        System.out.println("---- Complementary ----");

        System.out.println(complementary(numbers3));
        System.out.println(complementary(numbers4));

        System.out.println("---- Recursive ----");
        LocalDateTime startTime = java.time.LocalDateTime.now();
        System.out.println(recursive(new HashSet<>(numbers5), 2020, 3));
        LocalDateTime endTime = java.time.LocalDateTime.now();
        printTimeElapsed(startTime, endTime);

        LocalDateTime startTime2 = java.time.LocalDateTime.now();
        System.out.println(recursive(new HashSet<>(numbers6), 2020, 3));
        LocalDateTime endTime2 = java.time.LocalDateTime.now();
        printTimeElapsed(startTime2, endTime2);
    }
}