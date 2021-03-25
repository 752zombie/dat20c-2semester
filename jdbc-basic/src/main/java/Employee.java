public class Employee {
    int empNo;
    String name;
    String job;

    public Employee(int empNo, String name, String job) {
        this.empNo = empNo;
        this.name = name;
        this.job = job;
    }

    @Override
    public String toString() {
        return String.format("empno: %d name: %s job: %s", empNo, name, job);
    }

}
