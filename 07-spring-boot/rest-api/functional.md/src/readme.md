# Java Stream API Notes

## What is Stream API?

Stream API was introduced in Java 8.

It is used to process collections (List, Set, etc.) in a functional and readable way.

Benefits:

* Less code
* Better readability
* Easy filtering and transformation
* Supports functional programming

---

## Creating a List

```java
List<Integer> list1 = new ArrayList<>();

list1.add(1);
list1.add(2);
list1.add(3);
list1.add(5);
list1.add(4);

System.out.println(list1);
```

Output:

```text
[1, 2, 3, 5, 4]
```

---

## Immutable List using List.of()

```java
List<Integer> list2 = List.of(2, 4, 6);

System.out.println(list2);
```

Output:

```text
[2, 4, 6]
```

Note:

* List.of() creates an immutable list.
* add(), remove(), set() are not allowed.

---

## Creating a Stream

```java
list1.stream()
```

Converts the List into a Stream so that operations can be performed on it.

---

## Filter Operation

```java
List<Integer> even = list1.stream()
        .filter(integer -> integer % 2 == 0)
        .toList();
```

### How it works

Input List:

```text
[1, 2, 3, 5, 4]
```

Condition:

```java
integer -> integer % 2 == 0
```

Check each element:

```text
1 -> false
2 -> true
3 -> false
5 -> false
4 -> true
```

Result:

```text
[2, 4]
```

Output:

```java
System.out.println(even);
```

```text
[2, 4]
```

---

## Lambda Expression

```java
integer -> integer % 2 == 0
```

Equivalent to:

```java
public boolean check(Integer integer) {
    return integer % 2 == 0;
}
```

Lambda provides a shorter way to write functions.

---

## Stream Pipeline

```java
list1.stream()
     .filter(integer -> integer % 2 == 0)
     .toList();
```

Steps:

```text
List
 ↓
Stream
 ↓
Filter
 ↓
Collect to List
 ↓
Result
```

---

## Stream.of()

Directly creates a Stream.

```java
Stream.of(1, 2, 3, 4, 5)
      .forEach(System.out::println);
```

Output:

```text
1
2
3
4
5
```

---

## names.stream() vs Stream.of()

### names.stream()

Used when a Collection already exists.

```java
List<String> names = List.of("Durgesh", "Sourav", "Ankit");

names.stream()
     .forEach(System.out::println);
```

### Stream.of()

Used when creating a Stream directly.

```java
Stream.of("Durgesh", "Sourav", "Ankit")
      .forEach(System.out::println);
```

---

## String Array Example

```java
String[] names = {
    "Durgesh",
    "Sourav",
    "Ankit"
};
```

Convert array to Stream:

```java
Arrays.stream(names)
      .forEach(System.out::println);
```

Output:

```text
Durgesh
Sourav
Ankit
```

---

## Important Stream Methods

### filter()

Select elements based on condition.

```java
.filter(x -> x % 2 == 0)
```

---

### map()

Transform elements.

```java
list1.stream()
     .map(x -> x * x)
     .toList();
```

Output:

```text
[1, 4, 9, 25, 16]
```

---

### sorted()

Sort elements.

```java
list1.stream()
     .sorted()
     .toList();
```

Output:

```text
[1, 2, 3, 4, 5]
```

---

### distinct()

Remove duplicates.

```java
List.of(1,1,2,2,3,3)
    .stream()
    .distinct()
    .toList();
```

Output:

```text
[1, 2, 3]
```

---

### count()

Count elements.

```java
long count = list1.stream().count();
```

Output:

```text
5
```

---

### forEach()

Perform action on each element.

```java
list1.stream()
     .forEach(System.out::println);
```

---

## Interview Questions

### Q1. What is Stream API?

Stream API is used to process collections in a functional way.

### Q2. Is Stream a data structure?

No. It processes data from collections.

### Q3. Can a Stream be reused?

No. Once consumed, it cannot be reused.

### Q4. Difference between map() and filter()?

* filter() removes elements.
* map() transforms elements.

### Q5. Which Java version introduced Stream API?

Java 8.
