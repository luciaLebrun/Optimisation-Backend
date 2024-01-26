package fr.sdv.adventofcode2020;

import org.openjdk.jmh.annotations.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static fr.sdv.adventofcode2020.Main.brute_force;
import static fr.sdv.adventofcode2020.Main.complementary;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.SingleShotTime)
@Measurement(iterations = 10)
@Fork(value = 10, warmups = 0)
public class BenchmarkPlan {

    @Benchmark
    //Le mode AverageTime calcule le temps moyen d'exécution d'une méthode
    //Le mode SampleTime calcule le temps d'exécution d'une méthode en prenant des échantillons
    //Le mode SingleShotTime calcule le temps d'exécution d'une méthode en prenant un seul échantillon
    //Le mode Throughput calcule le nombre d'opérations par unité de temps
    //Le mode All calcule tous les modes de mesure

    //Comment avoir 10 echantillons ?
    // @Measurement(iterations = 10)
    // @Warmup(iterations = 10)
    public void benchmark_with_test_input_in_brute_force() throws FileNotFoundException {
        File input = new File("src/test/resources/input_test.txt");
        Scanner sc = new Scanner(input);

        List<Integer> numbers1 = new ArrayList<>();

        while (sc.hasNextLine()) {
            numbers1.add(Integer.parseInt(sc.nextLine()));
        }

        System.out.println("---- Brute force ----");

        System.out.println(brute_force(numbers1));
    }

    @Benchmark
    public void benchmark_with_test_input_in_complementary() throws FileNotFoundException {
        File input = new File("src/test/resources/input_test.txt");
        Scanner sc = new Scanner(input);

        List<Integer> numbers1 = new ArrayList<>();

        while (sc.hasNextLine()) {
            numbers1.add(Integer.parseInt(sc.nextLine()));
        }

        System.out.println("---- Complementary ----");

        System.out.println(complementary(numbers1));
    }

    @Benchmark
    public void benchmark_with_test_input_in_recursive() throws FileNotFoundException {
        File input = new File("src/test/resources/input_test.txt");
        Scanner sc = new Scanner(input);

        List<Integer> numbers1 = new ArrayList<>();

        while (sc.hasNextLine()) {
            numbers1.add(Integer.parseInt(sc.nextLine()));
        }

        System.out.println("---- Recursive ----");

        System.out.println(Main.recursive(new HashSet<>(numbers1), 2020, 3));
    }

    @Benchmark
    public void benchmark_with_input_in_brute_force() throws FileNotFoundException {
        File input = new File("src/test/resources/input.txt");
        Scanner sc = new Scanner(input);

        List<Integer> numbers1 = new ArrayList<>();

        while (sc.hasNextLine()) {
            numbers1.add(Integer.parseInt(sc.nextLine()));
        }

        System.out.println("---- Brute force ----");

        System.out.println(brute_force(numbers1));
    }

    @Benchmark
    public void benchmark_with_input_in_complementary() throws FileNotFoundException {
        File input = new File("src/test/resources/input.txt");
        Scanner sc = new Scanner(input);

        List<Integer> numbers1 = new ArrayList<>();

        while (sc.hasNextLine()) {
            numbers1.add(Integer.parseInt(sc.nextLine()));
        }
        
        System.out.println("---- Complementary ----");

        System.out.println(complementary(numbers1));
    }

    @Benchmark
    public void benchmark_with_input_in_recursive() throws FileNotFoundException {
        File input = new File("src/test/resources/input.txt");
        Scanner sc = new Scanner(input);

        List<Integer> numbers1 = new ArrayList<>();

        while (sc.hasNextLine()) {
            numbers1.add(Integer.parseInt(sc.nextLine()));
        }

        System.out.println("---- Recursive ----");

        System.out.println(Main.recursive(new HashSet<>(numbers1), 2020, 3));
    }



    // résultat du score benchmark
    // Mode = Représente le mode de mesure utilisé (SingleShotTime = temps d'exécution d'une méthode en prenant un seul échantillon)
    // Score = Représente le score de performance de la méthode testée (plus le score est bas, plus la méthode est performante)
    // Error = Représente la marge d'erreur (plus le score est bas, plus la marge d'erreur est faible)
    // Units = Représente l'unité de mesure du score (ms/op = millisecondes par opération)

}
