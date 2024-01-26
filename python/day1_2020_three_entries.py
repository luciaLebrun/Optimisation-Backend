import datetime

import cProfile

def brute_force(numbers):
    result = 0
    for number1 in numbers:
        for number2 in numbers:
            res = number1 + number2
            for number3 in numbers:
                if (res + number3 == 2020):
                    result += number1 * number2 * number3
                    numbers.remove(number1)
                    numbers.remove(number2)
                    numbers.remove(number3)
                    break

    return result

def complementary(numbers):
    result = 0 
    for number1 in numbers:
        for number2 in numbers:
            if (2020 - (number1 + number2)) in numbers:
                result += number1 * number2 * (2020 - (number1 + number2))
                numbers.remove(number1)
                numbers.remove(number2)
                break

    return result

input1 = open("../inputs/input1.txt", "r")
input2 = open("../inputs/input2.txt", "r")

## open the file and transform it into int array
numbers1 = []
numbers2 = []

for line in input1:
    numbers1.append(int(line))

for line in input2:
    numbers2.append(int(line))

numbers3 = numbers1.copy()
numbers4 = numbers2.copy()

def main():
    complementary(numbers4)

if __name__ == '__main__':
    cProfile.run('main()')




