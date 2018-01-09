Date now = new Date()
String message = "Hello! This is a message from Java 9!\n" + "Time: " + now.toString()
System.out.println(message)

// A class for person info
class Person {
  private String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String toString() {
    return name + "\t" + age;
  }
}

// A list of persons
List<Person> people = new ArrayList<>();
people.add(new Person("Alice", 20))
people.add(new Person("Bob", 24))
people.add(new Person("John", 25))
people.add(new Person("Mike", 19))
people.add(new Person("Mark", 19))
people.add(new Person("Anna", 19))
people.add(new Person("Bob", 40))
System.out.println("\nAll people")
people.forEach(System.out::println)

// Remove all persons with age < 21
List<Person> list = people.stream().map(p -> p.getAge() < 21 ? null : p).filter(p -> p != null).collect(Collectors.toList())
System.out.println("\nRemoving all with age < 21")
list.forEach(System.out::println)

// Get sorted names of persons
Function<List<Person>, String> sortedNames = list -> list.stream().map(Person::getName).sorted().collect(Collectors.joining(","))

// Get a string presentation of age range
Function<Integer, String> ageRange = min -> "[" + (min * 10) + "," + ((min + 1) * 10 - 1) + "]"

Map<Integer, List<Person>> groupByRange = people.stream().collect(Collectors.groupingBy(person -> person.getAge() / 10))
System.out.println("\nGrouping by age range")
groupByRange.keySet().forEach(k -> System.out.println(ageRange.apply(k) + " : " + sortedNames.apply(groupByRange.get(k))))

Comparator<Person> byAge    = (p1, p2) -> p1.getAge() - p2.getAge()
Comparator<Person> byName   = (p1, p2) -> p1.getName().compareTo(p2.getName())
Consumer<Person> printMax   = p -> { System.out.println(p.getName() + " has maximum age: " + p.getAge()); }
Consumer<Person> printName  = p -> { System.out.println(p.getName()); }

people.stream().max(byAge).ifPresent(printMax)

System.out.println("\nSort using Comparator.comparing(...)")
Comparator<Person> byAndAndName = Comparator.comparing(Person::getAge).thenComparing(Person::getName)
people.sort(byAndAndName)
people.forEach(System.out::println)

System.out.println("\nSort using Comparator.comparing(...).reversed()")
people.sort(byAndAndName.reversed())
people.forEach(System.out::println)
/exit
