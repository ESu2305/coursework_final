package com.sddevops.cwf_maven.eclipse;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsersTest {
	private User us;
	private User u1;
	private User u2;
	private User u3;
	private User u4;
	// private Song s5;
	// private Song s6;
	private final int USER_COLLECTION_SIZE = 4;
	private final int capacity = 20;

	@BeforeEach
	void setUp() throws Exception {

		u1 = new User("user1", "password", "user1@email.com", "English");
		u2 = new User("user2", "password6", "user2@email.com", "Chinese");
		u3 = new User("user3", "passworddf", "user3@email.com", "Malay");
		u4 = new User("user4", "password*", "user4@email.com", "Tamil");
		
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testGetName()
    {
        String name = u1.getName();
        assertEquals(name, "user1");
    }
    
    @Test
    public void testSetName() {
    	String set = u1.getName();
    	String newName = "user2s";
    	u1.setName(newName);
    	assertEquals(u1.getName(), newName);
    }

}
