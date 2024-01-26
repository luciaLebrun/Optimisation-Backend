import datetime

def brute_force(numbers):
    start_time = datetime.datetime.now()
    result = 0
    for number1 in numbers:
        for number2 in numbers:
            if (number1 + number2 == 2020):
                result += number1 * number2
                numbers.remove(number1)
                numbers.remove(number2)
                break
    end_time = datetime.datetime.now()
    print("Time: ", end_time - start_time)

    return result

def complementary(numbers):
    start_time = datetime.datetime.now()
    result = 0

    for number in numbers:
        if (2020 - number) in numbers:
            result += number * (2020 - number)
            break

    end_time = datetime.datetime.now()
    print("Time: ", end_time - start_time)

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

print(complementary(numbers1))
print(complementary(numbers2))
print(brute_force(numbers1))
print(brute_force(numbers2))
