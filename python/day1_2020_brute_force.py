import itertools
import cProfile

input1 = open("../inputs/input1.txt", "r")
input2 = open("../inputs/input2.txt", "r")

## open the file and transform it into int array
numbers1 = []
numbers2 = []

for line in input1:
    numbers1.append(int(line))

for line in input2:
    numbers2.append(int(line))

def sums_to_2020(values):
    return sum(values) == 2020

def main():
   list(itertools.combinations(numbers1, 3))

if __name__ == '__main__':
    cProfile.run('main()')

