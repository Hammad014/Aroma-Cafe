# Project Modifications Documentation

This README outlines the specific changes made to the inventory management system to customize it according to a specific customer's needs, from updating UI elements to backend logic modifications. Each section corresponds to a requirement from the assessment criteria (C to J).

## Table of Contents

- [Part C: UI Customization](#part-c-ui-customization)
- [Part D: About Page](#part-d-about-page)
- [Part E: Sample Inventory](#part-e-sample-inventory)
- [Part F: Buy Now Button](#part-f-buy-now-button)
- [Part G: Inventory Tracking](#part-g-inventory-tracking)
- [Part H: Inventory Validation](#part-h-inventory-validation)
- [Part I: Unit Tests](#part-i-unit-tests)
- [Part J: Code Cleanup](#part-j-code-cleanup)

---

### Part C: UI Customization
**Prompt**: Customize the HTML user interface for customer’s application.

- **File**: `[mainscreen.html]`
- **Line**: `[15, 20-37]`
- **Change**: Added dynamic elements to display the shop name, product names, and part names within the UI, enhancing the relevance and usability of the interface for the customer.

---

### Part D: About Page
**Prompt**: Add an “About” page to the application.

- **File**: `[mainscreen.html, about.us, MainScreenController.java]`
- **Line**: `[30-31 in mainscreen.html, 55-57 in MainScreenController.java]`
- **Change**: Created an "About" page with detailed information about the customer's company. Added navigation links between the "About" page, did mapping in MainScreenController and the main screen for seamless user experience.

---

### Part E: Sample Inventory
**Prompt**: Add a sample inventory appropriate for chosen store.

- **File**: `[BootStrapData.java, OutSourcedPart, ]`
- **Line**: `[29-72, 18-20]`
- **Change**: Implemented logic to check if part and product lists are empty before adding five new parts and products to prevent data overwrite.

---

### Part F: Buy Now Button
**Prompt**: Add a “Buy Now” button to product list.

- **File**: `[mainscreen.html, productForm.html, AddProductController.java]`
- **Line**: `[110-112, 68-76, 171-184]`
- **Change**: Integrated a "Buy Now" button next to each product's update and delete options. Configured the button to decrement product inventory by one upon each click without affecting associated parts.

---

### Part G: Inventory Tracking
**Prompt**: Modify the parts to track maximum and minimum inventory.

- **File**: `[Part.java, BootStrapData.java, InhousePartForm.html, OutsourcedPartForm.html, application.properties]`
- **Line**: `[29-100, 29-49, 15-21, 21-39, 06]`
- **Change**: Added `minInventory` and `maxInventory` fields to the part entity. Updated forms to include inputs for setting these values. Adjusted the database storage configurations accordingly.

---

### Part H: Inventory Validation
**Prompt**: Add validation for inventory fields.

- **File**: `[AddInhousePartController.java, AddOutsourcedPartController.java, InhousePartForm.html, OutsourcedPartForm.html]`
- **Line**: `[23-43, 30-53, 22, 39]`
- **Change**: Implemented validation in the service layer to ensure inventory levels are maintained within the specified minimum and maximum limits. Configured error messaging for out-of-bounds inventory conditions.

---

### Part I: Unit Tests
**Prompt**: Add unit tests for the maximum and minimum fields.

- **File**: `PartTest.java`
- **Line**: `[9-58]`
- **Change**: Added unit tests to verify that the inventory management adheres to the defined minimum and maximum thresholds.

---

### Part J: Code Cleanup
**Prompt**: Remove unused validator class files.

- **File**: `[DeletePartValidator]`
- **Line**: `[15-19]`
- **Change**: Identified and deleted unused validator classes to streamline the codebase and improve maintainability.

---

## Professional Communication

Throughout this project, efforts have been made to ensure all documentation is clear, concise, and structured to reflect professional standards. Each entry in this README aims to directly address the core requirements of the tasks with precise references to code modifications, adhering to professional software development standards.


