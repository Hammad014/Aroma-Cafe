package com.example.demo.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class PartTest {
    private InhousePart partIn;
    private OutsourcedPart partOut;

    @BeforeEach
    void setUp() {
        partIn = new InhousePart();
        partIn.setMinInventory(1);
        partIn.setMaxInventory(10);

        partOut = new OutsourcedPart();
        partOut.setMinInventory(1);
        partOut.setMaxInventory(10);
    }

    @Test
    void inventoryShouldNotBeBelowMinimumForInhousePart() {
        int belowMinimum = partIn.getMinInventory() - 1;
        partIn.setInv(belowMinimum);

        // Here we check that the inventory should not be below minimum
        assertTrue(partIn.getInv() >= partIn.getMinInventory(), "Inventory is incorrectly below minimum.");
    }

    @Test
    void inventoryShouldNotExceedMaximumForInhousePart() {
        int aboveMaximum = partIn.getMaxInventory() + 1;
        partIn.setInv(aboveMaximum);

        // Here we check that the inventory should not exceed maximum
        assertTrue(partIn.getInv() <= partIn.getMaxInventory(), "Inventory incorrectly exceeds maximum.");
    }

    @Test
    void inventoryShouldNotBeBelowMinimumForOutsourcedPart() {
        int belowMinimum = partOut.getMinInventory() - 1;
        partOut.setInv(belowMinimum);

        // Here we check that the inventory should not be below minimum
        assertTrue(partOut.getInv() >= partOut.getMinInventory(), "Inventory is incorrectly below minimum.");
    }

    @Test
    void inventoryShouldNotExceedMaximumForOutsourcedPart() {
        int aboveMaximum = partOut.getMaxInventory() + 1;
        partOut.setInv(aboveMaximum);

        // Here we check that the inventory should not exceed maximum
        assertTrue(partOut.getInv() <= partOut.getMaxInventory(), "Inventory incorrectly exceeds maximum.");
    }


    @Test
    void getId() {
        Long idValue=4L;
        partIn.setId(idValue);
        assertEquals(partIn.getId(), idValue);
        partOut.setId(idValue);
        assertEquals(partOut.getId(), idValue);
    }

    @Test
    void setId() {
        Long idValue=4L;
        partIn.setId(idValue);
        assertEquals(partIn.getId(), idValue);
        partOut.setId(idValue);
        assertEquals(partOut.getId(), idValue);
    }

    @Test
    void getName() {
        String name="test inhouse part";
        partIn.setName(name);
        assertEquals(name,partIn.getName());
        name="test outsourced part";
        partOut.setName(name);
        assertEquals(name,partOut.getName());
    }

    @Test
    void setName() {
        String name="test inhouse part";
        partIn.setName(name);
        assertEquals(name,partIn.getName());
        name="test outsourced part";
        partOut.setName(name);
        assertEquals(name,partOut.getName());
    }

    @Test
    void getPrice() {
        double price=1.0;
        partIn.setPrice(price);
        assertEquals(price,partIn.getPrice());
        partOut.setPrice(price);
        assertEquals(price,partOut.getPrice());
    }

    @Test
    void setPrice() {
        double price=1.0;
        partIn.setPrice(price);
        assertEquals(price,partIn.getPrice());
        partOut.setPrice(price);
        assertEquals(price,partOut.getPrice());
    }

    @Test
    void getInv() {
        int inv=5;
        partIn.setInv(inv);
        assertEquals(inv,partIn.getInv());
        partOut.setInv(inv);
        assertEquals(inv,partOut.getInv());
    }

    @Test
    void setInv() {
        int inv=5;
        partIn.setInv(inv);
        assertEquals(inv,partIn.getInv());
        partOut.setInv(inv);
        assertEquals(inv,partOut.getInv());
    }

    @Test
    void getProducts() {
        Product product1= new Product();
        Product product2= new Product();
        Set<Product> myProducts= new HashSet<>();
        myProducts.add(product1);
        myProducts.add(product2);
        partIn.setProducts(myProducts);
        assertEquals(myProducts,partIn.getProducts());
        partOut.setProducts(myProducts);
        assertEquals(myProducts,partOut.getProducts());
    }

    @Test
    void setProducts() {
        Product product1= new Product();
        Product product2= new Product();
        Set<Product> myProducts= new HashSet<>();
        myProducts.add(product1);
        myProducts.add(product2);
        partIn.setProducts(myProducts);
        assertEquals(myProducts,partIn.getProducts());
        partOut.setProducts(myProducts);
        assertEquals(myProducts,partOut.getProducts());
    }

    @Test
    void testToString() {
        String name="test inhouse part";
        partIn.setName(name);
        assertEquals(name,partIn.toString());
        name="test outsourced part";
        partOut.setName(name);
        assertEquals(name,partOut.toString());
    }

    @Test
    void testEquals() {
        partIn.setId(1l);
        Part newPartIn=new InhousePart();
        newPartIn.setId(1l);
        assertEquals(partIn,newPartIn);
        partOut.setId(1l);
        Part newPartOut=new OutsourcedPart();
        newPartOut.setId(1l);
        assertEquals(partOut,newPartOut);

    }

    @Test
    void testHashCode() {
        partIn.setId(1l);
        partOut.setId(1l);
        assertEquals(partIn.hashCode(),partOut.hashCode());
    }
}