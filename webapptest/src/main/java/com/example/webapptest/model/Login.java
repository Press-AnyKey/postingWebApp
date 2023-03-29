package com.example.webapptest.model;

import jakarta.persistence.*;

@Entity
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String appAccountName;
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_title_id", nullable = false)
    private JobTitle jobTitle;

    public Login() {
    }

    public Login(String appAccountName, Boolean isActive, Application application, Department department, JobTitle jobTitle) {
        this.appAccountName = appAccountName;
        this.isActive = isActive;
        this.application = application;
        this.department = department;
        this.jobTitle = jobTitle;
    }

    public Login(Long id, String appAccountName, Boolean isActive, Application application, Department department, JobTitle jobTitle) {
        this.id = id;
        this.appAccountName = appAccountName;
        this.isActive = isActive;
        this.application = application;
        this.department = department;
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", appAccountName='" + appAccountName + '\'' +
                ", isActive=" + isActive +
                ", application=" + application +
                ", department=" + department +
                ", jobTitle=" + jobTitle +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppAccountName() {
        return appAccountName;
    }

    public void setAppAccountName(String appAccountName) {
        this.appAccountName = appAccountName;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
}
