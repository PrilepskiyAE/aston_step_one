package homework_one;

public final class ImmutablePerson {
    private final Person person;

    public ImmutablePerson(Person person) {
        this.person = person;
    }

    public ImmutablePerson(String name, int age) {
        this.person = new Person(name, age);
    }

    public Person getPerson() {
        return new Person(this.person.getName(), this.person.getAge());
    }

    public String getPersonName() {
        return this.person.getName();
    }

    public int getPersonAge() {
        return this.person.getAge();
    }

    @Override
    public String toString() {
        return "ImmutablePerson{person=" + person + "}";
    }
}
