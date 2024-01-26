from typing import Optional, Tuple, Set

import cProfile

def sum_of_k(numbers: Set[int], d: int, k: int) -> Optional[Tuple[int]]:
    if k == 1:
        return (d,) if d in numbers else None
    
    for n in numbers:
        n_comp  = sum_of_k(numbers, d - n, k - 1) 
        if n_comp:
            return n_comp + (n,)


numbers = {int(l) for l in open("../inputs/input2.txt", "r").readlines()}

def main():
    sum_of_k(numbers, 2020, 3)

if __name__ == '__main__':
    cProfile.run('main()')