package com.example.demo.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Represents an outsourced part in the inventory.
 */
@Entity
@DiscriminatorValue("2")
public class OutsourcedPart extends Part {

    private String companyName;

    public OutsourcedPart() {
    }

    public OutsourcedPart(String name, double price, int inv, String companyName) {
        super(name, price, inv);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
