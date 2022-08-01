public abstract class Person {
    protected double salary;

    protected Person(double salary){
        this.salary = salary;
    }

    public Person() {
        setSalary(salary);
    }

    public abstract void setSalary(double salary);

    public double getSalary() {
        return salary;
    }
}
