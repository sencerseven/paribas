package com.cardif.project.policytrackingsystem.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames ={"tckNumber"} )})
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tckNumber;

    private String firstName;

    private String lastName;

    private Date birthDate;

    private String address;

    private String phoneNumber;

    @ManyToMany(cascade =  {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,},fetch = FetchType.EAGER)
    @JoinTable(name = "customers_policies",joinColumns = @JoinColumn(name ="customer_id"),inverseJoinColumns = @JoinColumn(name = "policy_id"))
    Set<Policy> policies = new HashSet<>();


    public Customer() {
    }

    public Long getId() {
        return this.id;
    }

    public String getTckNumber() {
        return this.tckNumber;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public Set<Policy> getPolicies() {
        return this.policies;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTckNumber(String tckNumber) {
        this.tckNumber = tckNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPolicies(Set<Policy> policies) {
        this.policies = policies;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Customer)) return false;
        final Customer other = (Customer) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$tckNumber = this.getTckNumber();
        final Object other$tckNumber = other.getTckNumber();
        if (this$tckNumber == null ? other$tckNumber != null : !this$tckNumber.equals(other$tckNumber)) return false;
        final Object this$firstName = this.getFirstName();
        final Object other$firstName = other.getFirstName();
        if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName)) return false;
        final Object this$lastName = this.getLastName();
        final Object other$lastName = other.getLastName();
        if (this$lastName == null ? other$lastName != null : !this$lastName.equals(other$lastName)) return false;
        final Object this$birthDate = this.getBirthDate();
        final Object other$birthDate = other.getBirthDate();
        if (this$birthDate == null ? other$birthDate != null : !this$birthDate.equals(other$birthDate)) return false;
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) return false;
        final Object this$phoneNumber = this.getPhoneNumber();
        final Object other$phoneNumber = other.getPhoneNumber();
        if (this$phoneNumber == null ? other$phoneNumber != null : !this$phoneNumber.equals(other$phoneNumber))
            return false;
        final Object this$policies = this.getPolicies();
        final Object other$policies = other.getPolicies();
        if (this$policies == null ? other$policies != null : !this$policies.equals(other$policies)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Customer;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $tckNumber = this.getTckNumber();
        result = result * PRIME + ($tckNumber == null ? 43 : $tckNumber.hashCode());
        final Object $firstName = this.getFirstName();
        result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
        final Object $lastName = this.getLastName();
        result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
        final Object $birthDate = this.getBirthDate();
        result = result * PRIME + ($birthDate == null ? 43 : $birthDate.hashCode());
        final Object $address = this.getAddress();
        result = result * PRIME + ($address == null ? 43 : $address.hashCode());
        final Object $phoneNumber = this.getPhoneNumber();
        result = result * PRIME + ($phoneNumber == null ? 43 : $phoneNumber.hashCode());
        final Object $policies = this.getPolicies();
        result = result * PRIME + ($policies == null ? 43 : $policies.hashCode());
        return result;
    }

    public String toString() {
        return "Customer(id=" + this.getId() + ", tckNumber=" + this.getTckNumber() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", birthDate=" + this.getBirthDate() + ", address=" + this.getAddress() + ", phoneNumber=" + this.getPhoneNumber() + ", policies=" + this.getPolicies() + ")";
    }
}
