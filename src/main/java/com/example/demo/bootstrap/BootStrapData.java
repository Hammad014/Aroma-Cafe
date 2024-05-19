package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final OutsourcedPartRepository outsourcedPartRepository;
    private final ProductRepository productRepository;

    public BootStrapData(OutsourcedPartRepository outsourcedPartRepository, ProductRepository productRepository) {
        this.outsourcedPartRepository = outsourcedPartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Check if the databases are empty before adding sample inventory
        if (outsourcedPartRepository.count() == 0 && productRepository.count() == 0) {
            addSampleInventory();
        }
    }

    private void addSampleInventory() {
        // Add sample parts with min and max inventory levels
        OutsourcedPart part1 = new OutsourcedPart("Coffee Beans", 10.0, 20, "Coffee Suppliers Inc.");
        part1.setMinInventory(10);
        part1.setMaxInventory(100);

        OutsourcedPart part2 = new OutsourcedPart("Milk", 15.0, 15, "Dairy Farms Ltd.");
        part2.setMinInventory(5);
        part2.setMaxInventory(50);

        OutsourcedPart part3 = new OutsourcedPart("Sugar Packets", 12.5, 25, "Sweeteners Co.");
        part3.setMinInventory(15);
        part3.setMaxInventory(75);

        OutsourcedPart part4 = new OutsourcedPart("Cups", 8.0, 30, "Packaging Solutions Corp.");
        part4.setMinInventory(20);
        part4.setMaxInventory(200);

        OutsourcedPart part5 = new OutsourcedPart("Lids", 9.5, 18, "Packaging Solutions Corp.");
        part5.setMinInventory(10);
        part5.setMaxInventory(150);

        // Save parts to the repository
        outsourcedPartRepository.save(part1);
        outsourcedPartRepository.save(part2);
        outsourcedPartRepository.save(part3);
        outsourcedPartRepository.save(part4);
        outsourcedPartRepository.save(part5);

        // Add sample products
        Product product1 = new Product("Espresso", 50.0, 10);
        Product product2 = new Product("Latte", 65.0, 8);
        Product product3 = new Product("Cappuccino", 40.0, 12);
        Product product4 = new Product("Mocha", 55.0, 15);
        Product product5 = new Product("Americano", 70.0, 7);

        // Save products to the repository
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);

        System.out.println("Sample inventory added successfully!");
    }
}
