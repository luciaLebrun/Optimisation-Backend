# Optimisation Backend

## Contributeurs
| Nom | Prénom |
| --- | ------ |
| LEBRUN | Lucia |
| SAINT-ALME | Raphaël |


## Contexte
C'est un projet qui permet de résoudre le premier exercice de l'advent of code de l'année 2020. (https://adventofcode.com/2020/day/1)
Le but est de trouver les deux chiffres qui permettent d'obtenir l'année 2020 en les additionnant. Puis de les multiplier entre eux. 

Exemple : 

```Bash
Liste des nombres : 1721, 979, 366, 299, 675, 1456	
```

```Bash
1721 + 299 = 2020
```

```Bash
1721 * 299 = 514579 (Solution)
```


## Objectif du cours d'optimisation backend

L'objectif est d'analyser les performances de trois méthodes de résolution différentes avec les trois langages différents (Python, Java et Go).
Le tout en faisant un benchmark, c'est à dire en mesurant le temps d'exécution de chaque méthode de résolution.
Mais aussi en analysant le temps d'exécution de chaque méthode de résolution en fonction de la taille de la liste de nombres.

## Langages de programmation
| Langage | Version |
| ------- | ------- |
| Python  | 3.x.x   |
| Java    | 21.x.x  |
| Go      | 1.21.6  |


## Méthodes de résolution

### Méthode 1 : Force brute

La première méthode de résolution est la force brute. C'est à dire que l'on va tester toutes les combinaisons possibles pour trouver la solution.

### Méthode 2 : Complémentaire

La deuxième méthode de résolution est la complémentaire. C'est à dire que l'on va tester toutes les combinaisons possibles pour trouver la solution. Mais cette fois-ci, on va utiliser le complémentaire de chaque nombre pour trouver la solution.

En effet, si on a deux nombres a et b, on sait que a + b = 2020. Donc a = 2020 - b. On peut donc calculer le complémentaire de chaque nombre et tester si le complémentaire est dans la liste des nombres. Si c'est le cas, on a trouvé la solution.

Exemple:
```Bash
Liste des nombres : 1721, 979, 366, 299, 675, 1456	
```

```Bash
Complémentaire de 1721 : 2020 - 1721 = 299

Dans ce cas, le complémentaire de 1721 est dans la liste des nombres.
```

```Bash
Complémentaire de 979 : 2020 - 979 = 1041

Dans ce cas, le complémentaire de 979 n'est pas dans la liste des nombres.
```


### Méthode 3 : Récursive

La troisième méthode de résolution est la récursive. C'est à dire que l'on va tester toutes les combinaisons possibles pour trouver la solution. Mais cette fois-ci, on va utiliser la récursivité pour trouver la solution.




