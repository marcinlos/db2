package pl.edu.agh.iisg.bd213lg.hellodb.domain2;

// Generated May 29, 2013 9:12:47 AM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Employees generated by hbm2java
 */
@Entity
@Table(name = "Employees", catalog = "northwind")
public class Employees implements java.io.Serializable {

    private Integer employeeId;
    private Employees employees;
    private String lastName;
    private String firstName;
    private String title;
    private String titleOfCourtesy;
    private Date birthDate;
    private Date hireDate;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String homePhone;
    private String extension;
    private byte[] photo;
    private String notes;
    private String photoPath;
    private Float salary;
    private Set<Orders> orderses = new HashSet<Orders>(0);
    private Set<Employees> employeeses = new HashSet<Employees>(0);

    public Employees() {
    }

    public Employees(String lastName, String firstName, String notes) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.notes = notes;
    }

    public Employees(Employees employees, String lastName, String firstName,
            String title, String titleOfCourtesy, Date birthDate,
            Date hireDate, String address, String city, String region,
            String postalCode, String country, String homePhone,
            String extension, byte[] photo, String notes, String photoPath,
            Float salary, Set<Orders> orderses, Set<Employees> employeeses) {
        this.employees = employees;
        this.lastName = lastName;
        this.firstName = firstName;
        this.title = title;
        this.titleOfCourtesy = titleOfCourtesy;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.address = address;
        this.city = city;
        this.region = region;
        this.postalCode = postalCode;
        this.country = country;
        this.homePhone = homePhone;
        this.extension = extension;
        this.photo = photo;
        this.notes = notes;
        this.photoPath = photoPath;
        this.salary = salary;
        this.orderses = orderses;
        this.employeeses = employeeses;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "EmployeeID", unique = true, nullable = false)
    public Integer getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ReportsTo")
    public Employees getEmployees() {
        return this.employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    @Column(name = "LastName", nullable = false, length = 20)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "FirstName", nullable = false, length = 10)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "Title", length = 30)
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "TitleOfCourtesy", length = 25)
    public String getTitleOfCourtesy() {
        return this.titleOfCourtesy;
    }

    public void setTitleOfCourtesy(String titleOfCourtesy) {
        this.titleOfCourtesy = titleOfCourtesy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BirthDate", length = 19)
    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "HireDate", length = 19)
    public Date getHireDate() {
        return this.hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Column(name = "Address", length = 60)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "City", length = 15)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "Region", length = 15)
    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Column(name = "PostalCode", length = 10)
    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Column(name = "Country", length = 15)
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "HomePhone", length = 24)
    public String getHomePhone() {
        return this.homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    @Column(name = "Extension", length = 4)
    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Column(name = "Photo")
    public byte[] getPhoto() {
        return this.photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Column(name = "Notes", nullable = false, length = 16777215)
    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Column(name = "PhotoPath")
    public String getPhotoPath() {
        return this.photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @Column(name = "Salary", precision = 12, scale = 0)
    public Float getSalary() {
        return this.salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employees")
    public Set<Orders> getOrderses() {
        return this.orderses;
    }

    public void setOrderses(Set<Orders> orderses) {
        this.orderses = orderses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employees")
    public Set<Employees> getEmployeeses() {
        return this.employeeses;
    }

    public void setEmployeeses(Set<Employees> employeeses) {
        this.employeeses = employeeses;
    }

}