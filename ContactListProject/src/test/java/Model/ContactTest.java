/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author URSULA
 */
public class ContactTest {
    
    public ContactTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

     private Contact createTestContact() {
        return new Contact(
            "Chiara", "Rossi", 
            "123456789", "987654321", "1122334455", 
            "c.rossi@studenti.unisa.it", "chiararossi2@gmail.com", "rossiconstruction@gmail.com", 
            "Rossi Construction.", "IT123456789987654321", 
            "Via Roma 89, Salerno(Sa)", "www.rossiconstruction.com", 
            "Chiama il contatto venerdì 20 dicembre per avere info sul progetto.", false
        );
    }
   

    /**
     * Test of getName method, of class Contact.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Contact instance = createTestContact();
        String expResult = "Chiara";
        assertEquals(expResult, instance.getName(), "Il nome non è stato restituito correttamente.");
    }

    /**
     * Test of getSurname method, of class Contact.
     */
    @Test
    public void testGetSurname() {
        System.out.println("getSurname");
        Contact instance = createTestContact();
        String expResult = "Rossi";
        String result = instance.getSurname();
        assertEquals(expResult, result, "Il cognome non è stato restituito correttamente.");
    }

    /**
     * Test of getPhoneNumber1 method, of class Contact.
     */
    @Test
    public void testGetPhoneNumber1() {
        System.out.println("getPhoneNumber1");
        Contact instance = createTestContact();
        String expResult = "123456789";
        String result = instance.getPhoneNumber1();
        assertEquals(expResult, result, "The first phone number was not returned correctly.");
    }

    /**
     * Test of getPhoneNumber2 method, of class Contact.
     */
    @Test
    public void testGetPhoneNumber2() {
        System.out.println("getPhoneNumber2");
         Contact instance = createTestContact();
        String expResult = "987654321";
        String result = instance.getPhoneNumber2();
        assertEquals(expResult, result, "The second phone number was not returned correctly.");
    }

    /**
     * Test of getPhoneNumber3 method, of class Contact.
     */
    @Test
    public void testGetPhoneNumber3() {
        System.out.println("getPhoneNumber3");
        Contact instance = createTestContact();
        String expResult = "1122334455";
        String result = instance.getPhoneNumber3();
        assertEquals(expResult, result, "The third phone number was not returned correctly.");
    }

    /**
     * Test of getEmail1 method, of class Contact.
     */
    @Test
    public void testGetEmail1() {
        System.out.println("getEmail1");
        Contact instance = createTestContact();
        String expResult = "c.rossi@studenti.unisa.it";
        String result = instance.getEmail1();
        assertEquals(expResult, result, "The first email was not returned correctly.");
    }

    /**
     * Test of getEmail2 method, of class Contact.
     */
    @Test
    public void testGetEmail2() {
          System.out.println("getEmail2");
        Contact instance = createTestContact();
        String expResult = "chiararossi2@gmail.com";
        String result = instance.getEmail2();
        assertEquals(expResult, result, "The second email was not returned correctly.");
    }

    /**
     * Test of getEmail3 method, of class Contact.
     */
    @Test
    public void testGetEmail3() {
         System.out.println("getEmail3");
        Contact instance = createTestContact();
        String expResult = "rossiconstruction@gmail.com";
        String result = instance.getEmail3();
        assertEquals(expResult, result, "The third email was not returned correctly.");
    }

    /**
     * Test of getCompany method, of class Contact.
     */
    @Test
    public void testGetCompany() {
         System.out.println("getCompany");
        Contact instance = createTestContact();
        String expResult = "Rossi Construction.";
        String result = instance.getCompany();
        assertEquals(expResult, result, "The company name was not returned correctly.");
    }

    /**
     * Test of getIBAN method, of class Contact.
     */
    @Test
    public void testGetIBAN() {
         System.out.println("getIBAN");
        Contact instance = createTestContact();
        String expResult = "IT123456789987654321";
        String result = instance.getIBAN();
        assertEquals(expResult, result, "The IBAN was not returned correctly.");
    }

    /**
     * Test of getAddress method, of class Contact.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        Contact instance = createTestContact();
        String expResult = "Via Roma 89, Salerno(Sa)";
        String result = instance.getAddress();
        assertEquals(expResult, result, "The address was not returned correctly.");
    }

    /**
     * Test of getWebsite method, of class Contact.
     */
    @Test
    public void testGetWebsite() {
         System.out.println("getWebsite");
        Contact instance = createTestContact();
        String expResult = "www.rossiconstruction.com";
        String result = instance.getWebsite();
        assertEquals(expResult, result, "The website URL was not returned correctly.");
    }

    /**
     * Test of getNotes method, of class Contact.
     */
    @Test
    public void testGetNotes() {
        System.out.println("getNotes");
        Contact instance = createTestContact();
        String expResult = "Chiama il contatto venerdì 20 dicembre per avere info sul progetto.";
        String result = instance.getNotes();
        assertEquals(expResult, result, "The notes were not returned correctly.");
    }

  /**
     * Test of setName method, of class Contact.
     */
     @Test
    public void testSetName() {
        Contact instance = createTestContact();
        String expectedName = "Maria";
        instance.setName(expectedName);
        assertEquals(expectedName, instance.getName(), "The name was not set correctly.");
    }

    /**
     * Test of setSurname method, of class Contact.
     */
   @Test
    public void testSetSurname() {
        Contact instance = createTestContact();
        String expectedSurname = "Verdi";
        instance.setSurname(expectedSurname);
        assertEquals(expectedSurname, instance.getSurname(), "The surname was not set correctly.");
    }

    /**
     * Test of setPhoneNumber1 method, of class Contact.
     */
     @Test
    public void testSetPhoneNumber1() {
        Contact instance = createTestContact();
        String expectedPN1 = "147258369";
        instance.setPhoneNumber1(expectedPN1);
        assertEquals(expectedPN1, instance.getPhoneNumber1(), "Il numero di telefono primario non è stato impostato correttamente.");
    }

    /**
     * Test of setPhoneNumber2 method, of class Contact.
     */
    @Test
public void testSetPhoneNumber2() {
    Contact instance = createTestContact();
    String expectedPN2 = "258147369";
    instance.setPhoneNumber2(expectedPN2);
    assertEquals(expectedPN2, instance.getPhoneNumber2(), "The secondary phone number was not set correctly.");
}


    /**
     * Test of setPhoneNumber3 method, of class Contact.
     */
   @Test
public void testSetPhoneNumber3() {
    Contact instance = createTestContact();
    String expectedPN3 = "369258147";
    instance.setPhoneNumber3(expectedPN3);
    assertEquals(expectedPN3, instance.getPhoneNumber3(), "The tertiary phone number was not set correctly.");
}

    /**
     * Test of setEmail1 method, of class Contact.
     */
    @Test
public void testSetEmail1() {
    Contact instance = createTestContact();
    String expectedEmail1 = "c.rossi1@studenti.unisa.it";
    instance.setEmail1(expectedEmail1);
    assertEquals(expectedEmail1, instance.getEmail1(), "The first email was not set correctly.");
}

    /**
     * Test of setEmail2 method, of class Contact.
     */
   @Test
public void testSetEmail2() {
    Contact instance = createTestContact();
    String expectedEmail2 = "c.rossi1@studenti.unisa.it";
    instance.setEmail2(expectedEmail2);
    assertEquals(expectedEmail2, instance.getEmail2(), "The second email was not set correctly.");
}


    /**
     * Test of setEmail3 method, of class Contact.
     */
  @Test
public void testSetEmail3() {
    Contact instance = createTestContact();
    String expectedEmail3 = "c.rossi3@studenti.unisa.it";
    instance.setEmail3(expectedEmail3);
    assertEquals(expectedEmail3, instance.getEmail3(), "The third email was not set correctly.");
}

    /**
     * Test of setCompany method, of class Contact.
     */
    @Test
public void testSetCompany() {
    Contact instance = createTestContact();
    String expectedCompany = "Rossi S.P.A.";
    instance.setCompany(expectedCompany);
    assertEquals(expectedCompany, instance.getCompany(), "The company name was not set correctly.");
}

    /**
     * Test of setIBAN method, of class Contact.
     */
   @Test
public void testSetIBAN() {
    Contact instance = createTestContact();
    String expectedIBAN = "IT987654321234567890";
    instance.setIBAN(expectedIBAN);
    assertEquals(expectedIBAN, instance.getIBAN(), "The IBAN was not set correctly.");
}


    /**
     * Test of setAddress method, of class Contact.
     */
    @Test
    public void testSetAddress() {
        Contact instance = createTestContact();
        String expectedAddress = "Via Napoli 10, Napoli(Na)";
        instance.setAddress(expectedAddress);
        assertEquals(expectedAddress, instance.getAddress(), "The address was not set correctly.");
    }

    /**
     * Test of setWebsite method, of class Contact.
     */
   @Test
    public void testSetWebsite() {
        Contact instance = createTestContact();
        String expectedWebsite = "www.rossigroup.com";
        instance.setWebsite(expectedWebsite);
        assertEquals(expectedWebsite, instance.getWebsite(), "The website was not set correctly.");
    }

    /**
     * Test of setNotes method, of class Contact.
     */
  @Test
    public void testSetNotes() {
        Contact instance = createTestContact();
        String expectedNotes = "Chiama il contatto il 21 dicembre alle 10.";
        instance.setNotes(expectedNotes);
        assertEquals(expectedNotes, instance.getNotes(), "The notes were not set correctly.");
}

    /**
     * Test of setFavorite method, of class Contact.
     */
    @Test
    public void testSetFavorite() {
        System.out.println("setFavorite");
        Contact instance = createTestContact();
        boolean favorite = true;
        instance.setFavorite(favorite);
         assertEquals(favorite, instance.isFavourite(), "The favorite status was not set correctly.");

    }

    /**
     * Test of isFavourite method, of class Contact.
     */
    @Test
    public void testIsFavourite() {
        System.out.println("isFavourite");
         Contact instance = createTestContact();
        
        boolean expResult = false;
        boolean result = instance.isFavourite();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Contact.
     */
    
    @Test
    public void testToString() {
        System.out.println("toString");
        Contact instance = createTestContact();
        String expResult = "Name: Chiara Surname: Rossi Company: Rossi Construction. IBAN: IT123456789987654321 Address: Via Roma 89, Salerno(Sa) Website: www.rossiconstruction.com Notes: Chiama il contatto venerdì 20 dicembre per avere info sul progetto. Favorite: false";
        String result = instance.toString();
        assertEquals(expResult, result, "The toString method did not return the expected string.");
    }


    /**
     * Test of equals method, of class Contact.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Contact c1 = createTestContact();
        Contact c2 = createTestContact();
        assertTrue(c1.equals(c2), "Objects with identical attributes should not be equal.");
        
        assertFalse(c1.equals(null), "Comparing with null should return false.");
        
        c2.setName("Elena");
        assertFalse(c1.equals(c2), "Objects with different attributes should not be equal.");
        
        assertFalse(c1.equals("A string"), "Comparing with an object of a different class should return false.");

        
    }

    /**
     * Test of toCsv method, of class Contact.
     */
    @Test
    public void testToCsv() {
        System.out.println("toCsv");
       
        Contact instance = createTestContact();
        
        String expResult = "Chiara;Rossi;123456789;987654321;112 233 4455;" +
            "c.rossi@studenti.unisa.it;chiararossi2@gmail.com;rossiconstruction@gmail.com;" +
            "Rossi Construction.;IT123456789987654321;Via Roma 89, Salerno(Sa);" +
            "www.rossiconstruction.com;Chiama il contatto venerdì 20 dicembre per avere info sul progetto.;false";
        
        String result = instance.toCsv();
        assertEquals(expResult, result, "The CSV representation is not correct.");
        
    }
    
}
