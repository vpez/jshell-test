Date now = new Date();
String message = "Hello! This is a message from Java 9!\n" + "Time: " + now.toString();
System.out.println(message);

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
}

// A list containing a few Person objects
List<Person> people = Arrays.asList(
  new Person("Bob", 22), new Person("Alice", 27), new Person("John", 25), new Person("Vahe", 29),
  new Person("Zaz", 31), new Person("Mark", 16), new Person("Mike", 19), new Person("Bob", 40)
);

// Get sorted names of persons
Function<List<Person>, String> sortedNames = list -> list.stream().map(Person::getName).sorted().collect(Collectors.joining(","));

// Get a string presentation of age range
Function<Integer, String> ageRange = min -> "[" + (min * 10) + "," + ((min + 1) * 10 - 1) + "]";

Map<Integer, List<Person>> groupByRange = people.stream().collect(Collectors.groupingBy(person -> person.getAge() / 10));
groupByRange.keySet().forEach(k -> System.out.println(ageRange.apply(k) + " : " + sortedNames.apply(groupByRange.get(k))));

Comparator<Person> byAge    = (p1, p2) -> p1.getAge() - p2.getAge();
Comparator<Person> byName   = (p1, p2) -> p1.getName().compareTo(p2.getName());
Consumer<Person> printMax   = p -> { System.out.println(p.getName() + " has maximum age: " + p.getAge()); };
Consumer<Person> printName  = p -> { System.out.println(p.getName()); };

people.stream().max(byAge).ifPresent(printMax);


// people.stream().mapToInt(p -> p.getAge()).max().ifPresent(System.out::println);

/exit
