// A class for person info
class Person {
  private String name;
  private int age;
  private String gender;

  public Person(String name, String gender, int age) {
    this.name = name;
    this.gender = gender;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public String getGender() {
    return gender;
  }

  public int getAge() {
    return age;
  }

  public String toString() {
    return name + "\t" + gender + "  " + age;
  }
}
