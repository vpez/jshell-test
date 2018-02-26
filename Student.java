class Student extends Person {
  private List<String> courses;

  public Student(String name, String gender, int age, String... courses) {
    super(name, gender, age);
    this.courses = new ArrayList<>();
    this.courses.addAll(Arrays.asList(courses));
  }

  public List<String> getCourses() {
    return courses;
  }
}
