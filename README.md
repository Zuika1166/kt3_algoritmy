# КТ3 Алгоритмы

Проект содержит решения шести алгоритмических задач на Java 21.

## Требования

- JDK 21
- Maven 3.9+

## Тесты

Запуск всех тестов:

```bash
mvn test
```

## Сборка

```bash
mvn package
```

После сборки классы находятся в `target/classes`.

## Задача 1. Первая позиция для вставки

Класс:

```text
com.example.kt3.Task1LowerBound
```

В первой строке вводятся `n` и `target`. Во второй строке вводятся `n` чисел отсортированного массива.

Запуск:

```bash
java -cp target/classes com.example.kt3.Task1LowerBound
```

Пример:

```text
Ввод:
5 2
1 2 2 2 5

Вывод:
1
```

Используется бинарный поиск. Сложность: `O(log n)`.

## Задача 2. Суммы на отрезках

Класс:

```text
com.example.kt3.Task2RangeSum
```

В первой строке вводится `n`. Во второй строке вводятся элементы массива. В третьей строке вводится `q`. Далее идут `q` пар `L R`.

Запуск:

```bash
java -cp target/classes com.example.kt3.Task2RangeSum
```

Пример:

```text
Ввод:
4
5 -2 7 3
3
0 1
1 3
2 2

Вывод:
3
8
7
```

Используются префиксные суммы. Подготовка: `O(n)`, каждый запрос: `O(1)`.

## Задача 3. Объединение интервалов

Класс:

```text
com.example.kt3.Task3MergeIntervals
```

В первой строке вводится `n`. Далее вводятся `n` закрытых интервалов `start end`.

Запуск:

```bash
java -cp target/classes com.example.kt3.Task3MergeIntervals
```

Каждый итоговый интервал выводится в отдельной строке.

Пример:

```text
Ввод:
5
1 3
3 5
8 10
9 12
20 20

Вывод:
1 5
8 12
20 20
```

Интервалы с общей границей объединяются. Сложность: `O(n log n)`.

## Задача 4. Минимальная вместимость корабля

Класс:

```text
com.example.kt3.Task4ShipCapacity
```

В первой строке вводятся `n` и `days`. Во второй строке вводятся веса грузов.

Запуск:

```bash
java -cp target/classes com.example.kt3.Task4ShipCapacity
```

Пример:

```text
Ввод:
10 5
1 2 3 4 5 6 7 8 9 10

Вывод:
15
```

Используется бинарный поиск по ответу. Сложность: `O(n log S)`, где `S` — сумма весов.

## Задача 5. Количество подмассивов с суммой k

Класс:

```text
com.example.kt3.Task5SubarraySum
```

В первой строке вводятся `n` и `k`. Во второй строке вводятся элементы массива.

Запуск:

```bash
java -cp target/classes com.example.kt3.Task5SubarraySum
```

Пример:

```text
Ввод:
3 0
1 -1 0

Вывод:
3
```

Используются префиксные суммы и `HashMap`. Средняя сложность: `O(n)`.

## Задача 6. Минимальное количество переговорных комнат

Класс:

```text
com.example.kt3.Task6MeetingRooms
```

В первой строке вводится `n`. Далее вводятся `n` полуоткрытых интервалов `start end`.

Запуск:

```bash
java -cp target/classes com.example.kt3.Task6MeetingRooms
```

Пример:

```text
Ввод:
3
0 30
5 10
15 20

Вывод:
2
```

Момент окончания встречи уже свободен для следующей встречи. Используется очередь с приоритетом. Сложность: `O(n log n)`.

## Структура

```text
src/main/java/com/example/kt3
├── FastScanner.java
├── Task1LowerBound.java
├── Task2RangeSum.java
├── Task3MergeIntervals.java
├── Task4ShipCapacity.java
├── Task5SubarraySum.java
└── Task6MeetingRooms.java

src/test/java/com/example/kt3
└── AlgorithmsTest.java
```
