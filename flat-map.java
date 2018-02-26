/open Person.java
/open Student.java

Student s1 = new Student("Bob", "M", 23, "Java", "C++", "OOP", "CS 101")
Student s2 = new Student("Alice", "F", 24, "Java", "OS", "C++")
Student s3 = new Student("John", "M", 25, "C++", "Algorithms")

long n = Stream.of(s1, s2, s3).flatMap(s -> s.getCourses().stream()).distinct().count()
System.out.println("Number of distinct courses = " + n)

Map<String, Long> group = Stream.of(s1, s2, s3).flatMap(s -> s.getCourses().stream()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
System.out.println("\nNumber of students in each course:")
group.forEach((course, num) -> { System.out.println(course + " - " + num); })

String maxCourse = group.entrySet().stream().max(Comparator.comparingLong(e -> e.getValue())).map(e -> e.getKey()).orElse("N/A")
System.out.println("\nThe course with maximum number of students: " + maxCourse)

/exit
