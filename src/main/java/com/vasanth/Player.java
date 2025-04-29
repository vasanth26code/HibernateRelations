package com.vasanth;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.List;

// used to change table name, colname, and donot create a column in DB but use the variable to perform operation
//@Table(name = "footballer")
//@Transient
//@Column(name = "player_name")
@Entity
public class Player {

    @Id
    private int pid;
    private String pname;
    private String position;

    //for manytomany
    @ManyToMany
    private List<Address> addresses;

    //for one to many
//    @OneToMany(mappedBy = "player")
//    private List<Address> addresses;

//    @OneToOne     for one to one relationships table creation
//    private Address address;


    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    //for one to many relationship

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Player{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", position='" + position + '\'' +
                ", addresses=" + addresses +
                '}';
    }

    // for one to one realtionship
//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

// for one to one realtionship
//
//    @Override
//    public String toString() {
//        return "Player{" +
//                "pid=" + pid +
//                ", pname='" + pname + '\'' +
//                ", position='" + position + '\'' +
//                ", address=" + address +
//                '}';
//    }
}
