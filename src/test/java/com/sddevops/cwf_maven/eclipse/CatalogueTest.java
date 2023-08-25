package com.sddevops.cwf_maven.eclipse;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CatalogueTest {
	private Catalogue cat1;
	private Catalogue cat2;
	private Catalogue cat3;
	private final int CAT_COLLECTION_SIZE = 3;
	private final int capacity = 20;

	@BeforeEach
	void setUp() throws Exception {

		cat1 = new Catalogue("Fruit", "Pear", 1.00, 10, "image1");
		cat2 = new Catalogue("Fruit", "Banana", 3.00, 12, "image2");
		cat3 = new Catalogue("Vegetable", "Carrot", 1.00, 8, "image3");
		
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
    /**
     * Rigorous Test :-)
     */
	/*
    @Test
    public void testGetPrice()
    {
        double price = cat1.getPrice();
        assertEquals(price, 1.00);
    }
    */
    @Test
    public void testSetPrice() {
    	double set = cat1.getPrice();
    	double newPrice = 1.20;
    	cat1.setPrice(newPrice);
    	assertEquals(cat1.getPrice(), newPrice);
    }

}
