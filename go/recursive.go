package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
	"time"
)

func sumOfK(numbers map[int]struct{}, d int, k int) []int {
	if k == 1 {
		if _, exists := numbers[d]; exists {
			return []int{d}
		}
		return nil
	}
	for n := range numbers {
		delete(numbers, n)
		nComp := sumOfK(numbers, d-n, k-1)
		if nComp != nil {
			return append(nComp, n)
		}
		numbers[n] = struct{}{}
	}
	return nil
}

func main() {
	file, err := os.Open("../inputs/input2.txt")
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
	result := sumOfK(numbers, 2020, 3)
	elapsedTime := time.Since(startTime)

	if result != nil {
		sort.Ints(result)
		fmt.Printf("Result: %v\n", result)
		fmt.Printf("Result (with *): %d * %d * %d = %d\n", result[0], result[1], result[2], result[0]*result[1]*result[2])
	} else {
		fmt.Println("No result found.")
	}

	fmt.Printf("Elapsed Time: %v\n", elapsedTime)
}
