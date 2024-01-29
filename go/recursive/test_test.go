package main

import "testing"

var numbers map[int]struct{}

func init() {
	numbers = make(map[int]struct{})
	for _, num := range []int{1721, 979, 366, 299, 675, 1456} {
		numbers[num] = struct{}{}
	}
}

func BenchmarkSumOfK(b *testing.B) {
	for i := 0; i < b.N; i++ {
		sumOfK(numbers, 2020, 3)
	}
}
