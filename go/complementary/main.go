package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
	"time"
)

func findTripletsWithSum(numbers map[int]struct{}, targetSum int) [][]int {
	var triplets [][]int

	for n1 := range numbers {
		for n2 := range numbers {
			if n1 != n2 {
				complement := targetSum - n1 - n2
				if _, exists := numbers[complement]; exists {
					triplets = append(triplets, []int{n1, n2, complement})
				}
			}
		}
	}

	return triplets
}

func main() {
	file, err := os.Open("../../inputs/input2.txt")
	if err != nil {
		fmt.Println("Error opening file:", err)
		return
	}
	defer file.Close()

	numbers := make(map[int]struct{})
	scanner := bufio.NewScanner(file)
	for scanner.Scan() {
		line := strings.TrimSpace(scanner.Text())
		if num, err := strconv.Atoi(line); err == nil {
			numbers[num] = struct{}{}
		}
	}

	startTime := time.Now()
	triplets := findTripletsWithSum(numbers, 2020)
	elapsedTime := time.Since(startTime)

	if len(triplets) > 0 {
		for _, triplet := range triplets {
			fmt.Printf("Result: %d * %d * %d = %d\n", triplet[0], triplet[1], triplet[2], triplet[0]*triplet[1]*triplet[2])
		}
	} else {
		fmt.Println("No result found.")
	}

	fmt.Printf("Elapsed Time: %v\n", elapsedTime)
}
