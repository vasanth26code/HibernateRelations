package com.vasanth;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class Address {

    @Id
    private int aid;
    private int num;
    private String street;
    private String area;

    //for manytomany
    @ManyToMany(mappedBy = "addresses")
    private List<Player> players;

    //for onetomany and manytoone
//    @ManyToOne
//    private Player player;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    //for onetomany and manytoone
//    public Player getPlayer() {
//        return player;
//    }
//
//    public void setPlayer(Player player) {
//        this.player = player;
//    }

    @Override
    public String toString() {
        return "Address{" +
                "aid=" + aid +
                ", num=" + num +
                ", street='" + street + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
