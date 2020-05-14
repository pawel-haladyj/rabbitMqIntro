package pl.haladyj.RabbitMQ_intro.model;

import java.math.BigDecimal;
import java.util.Objects;

public class JobRequest {

    private String job;
    private BigDecimal salary;

    public JobRequest(String job, BigDecimal salary) {
        this.job = job;
        this.salary = salary;
    }

    public JobRequest() {
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobRequest that = (JobRequest) o;
        return Objects.equals(job, that.job) &&
                Objects.equals(salary, that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, salary);
    }
}
