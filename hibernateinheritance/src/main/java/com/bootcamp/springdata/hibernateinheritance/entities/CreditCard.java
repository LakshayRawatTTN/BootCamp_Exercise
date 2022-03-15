package com.bootcamp.springdata.hibernateinheritance.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.print.attribute.standard.MediaSize;

@Entity
@Table(name = "card")
@PrimaryKeyJoinColumn(name = "id") //This annotation is used for joined strategy
//@DiscriminatorValue("cc") This is for single_table
public class CreditCard extends Payment {
    private String cardnumber;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }
}
