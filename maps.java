/open Person.java

void announce(String line) {
  System.out.println("\n" + line);
}

// A list of persons
List<Person> people = new ArrayList<>();
people.add(new Person("Alice", "F", 20))
people.add(new Person("Bob", "M", 20))
people.add(new Person("John", "M", 25))
people.add(new Person("Mike", "M", 19))
people.add(new Person("Mark", "M", 19))
people.add(new Person("Anna", "F", 19))
people.add(new Person("Bob", "M", 40))
people.add(new Person("Jane", "F", 40))
people.add(new Person("Amy", "F", 25))
people.add(new Person("Sheldon", "M", 25))

announce("All people:")
people.forEach(System.out::println)

// Grouping by gender
announce("Grouping the list by gender:")
Map<String, List<Person>> byGender = people.stream().collect(Collectors.groupingBy(Person::getGender))
byGender.keySet().forEach(gender -> System.out.println(gender + " -> " + byGender.get(gender)))

announce("Counting persons in each group:")
Map<String, Long> count = people.stream().collect(Collectors.groupingBy(Person::getGender, Collectors.counting()))
count.keySet().forEach(gender -> System.out.println(gender + " -> " + count.get(gender)))

// Grouping by age and gender
Map<Integer, Map<String, List<Person>>> bimap = new HashMap<>()
Consumer<Person> mapper = p -> bimap.computeIfAbsent(p.getAge(), HashMap::new).merge(p.getGender(), new ArrayList<>(Arrays.asList(p)), (a, b) -> {a.addAll(b); return a;})
people.forEach(mapper)

announce("Grouping by age and gender:")
bimap.forEach((k, v) -> System.out.println(k + " -> " + v))

announce("bimap.get(25).get(\"M\") = " + bimap.get(25).get("M"))
/exit
