package Model;

import java.util.List;
import java.util.LinkedList;

/**
 * @file Contact.java
 * @brief Represents an individual contact in the contact book.
 */
public class Contact {

  /// The name of the contact.
  private String name;

  /// The surname of the contact.
  private String surname;

  /// A list of phone numbers associated with the contact.
  //private LinkedList<String> phoneNumbers;


// the emails associated with the contact
  private String email1;
  private String email2;
  private String email3;

//the phone numbers associated with the contact
private String phoneNumber1;
private String phoneNumber2;
private String phoneNumber3;  

  /// A list of email addresses associated with the contact.
 // private LinkedList<String> emails;

  /// The company the contact works for.
  private String company;

  /// The IBAN (International Bank Account Number) of the contact.
  private String IBAN;

  /// The physical address of the contact.
  private String address;

  /// The website associated with the contact.
  private String website;

  /// Additional notes related to the contact.
  private String notes;

  /// A flag indicating whether the contact is marked as a favorite.
  private boolean favourite;

  /**
   * @brief Default constructor for the Contact class.
   * Initializes a new Contact object.
  * @param name The contact's name.
   * @param surname The contact's surname.
   * @param company The contact's company.
   * @param IBAN The contact's IBAN.
   * @param address The contact's address.
   * @param website The contact's website.
   * @param notes Additional notes for the contact.
   * @param favourite Indicates whether the contact is marked as a favorite.
   */
   
  public Contact(String name, String surname, String phoneNumber1, String phoneNumber2, String phoneNumber3, String email1, String email2, String email3,String company, String IBAN, String address, String website, String notes, boolean favourite) {
this.name=name;
this.surname=surname;
this.phoneNumber1=phoneNumber1;
this.phoneNumber2=phoneNumber2;
this.phoneNumber3=phoneNumber3;
this.email1=email1;
this.email2=email2;
this.email3=email3;
this.company=company;
this.IBAN=IBAN;
this.address=address;
this.website=website;
this.notes=notes;
this.favourite=favourite;
check();
}

/**
 * @brief Checks if the contact has a name or a surname.
 * @throws IllegalArgumentException if both name and surname are empty or null.
 */
public void check(){
if((name==null|| name.isEmpty()) && (surname== null|| surname.isEmpty())){
throw new IllegalArgumentException("Please enter a name and a surname");
}
}


/**
 * @brief Getter method to return the name of the contact.
 * @return The name of the contact.
 */
public String  getName(){
return name;
}

/**
 * @brief Getter method to return the surname of the contact.
 * @return The surname of the contact.
 */
public String getSurname(){
return surname;
}

/**
 * @brief Getter method to return the company of the contact.
 * @return The company of the contact.
 */
public String getCompany(){
return company;
}

/**
 * @brief Getter method to return the IBAN of the contact.
 * @return The IBAN of the contact.
 */
public String getIBAN(){
return IBAN;
}

/**
 * @brief Getter method to return the address of the contact.
 * @return The address of the contact.
 */
public String getAddress(){
return address;
}

/**
 * @brief Getter method to return the website of the contact.
 * @return The website of the contact.
 */
public String getWebsite(){
return website;
}

/**
 * @brief Getter method to return the notes of the contact.
 * @return The notes of the contact.
 */
public String getNotes(){
return notes;
}

 public String getPhoneNumber1() {
        return phoneNumber1;
    }

 public String getPhoneNumber2() {
        return phoneNumber2;
    }

 public String getPhoneNumber3() {
        return phoneNumber3;
    }

/**
 * @brief Setter method to set the name of the contact.
 * @param name The name to be set for the contact.
 */
public void setName(String name) {
this.name=name;
}

/**
 * @brief Setter method to set the surname of the contact.
 * @param surname The surname to be set for the contact.
 */
public void setSurname(String surname) {
this.surname=surname;
}
 
 /**
  * @brief Setter method to set the company of the contact.
  * @param company The company to be set for the contact.
  */
 public void setCompany(String company) {
this.company=company;
}

/** 
 * @brief Setter method to set the IBAN of the contact.
 * @param IBAN The IBAN to be set for the contact.
 */
public void setIBAN(String IBAN) {
this.IBAN=IBAN;
}

/**
 * @brief Setter method to set the address of the contact.
 * @param address The address to be set for the contact.
 */
public void setAddress(String address) {
this.address=address;
}

/**
 * @brief Setter method to set the website of the contact.
 * @param website The website to be set for the contact.
 */
public void setWebsite(String website) {
this.website=website;
}

/**
 * @brief Setter method to set the notes of the contact.
 * @param notes The notes to be set for the contact.
 */
public void setNotes(String notes) {
this.notes=notes;
}



public void setPhoneNumber1(String phoneNumber1) {
 this.phoneNumber1=phoneNumber1;
}

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }
    public void setPhoneNumber3(String phoneNumber3) {
        this.phoneNumber3 = phoneNumber3;
    }
    /**
     * @brief Adds a phone number to the contact's list of phone numbers.
     * @param phoneNumber The phone number to be added to the contact's list.
    public void addPhoneNumber(String phoneNumber) {
    if (phoneNumbers.size() >= 3) {
    throw new IllegalStateException("Error: A contact can have a maximum of 3 phone numbers.");
    }
    phoneNumbers.add(phoneNumber);
    }
    /**
     * @brief Adds an email address to the contact's list of email addresses.
     * @param email The email address to be added to the contact's list.
    public void addEmail(String email) {
    if (emails.size() >= 3) {
    throw new IllegalStateException("Error: A contact can have a maximum of 3 emails.");
    }
    emails.add(email);
    }
     * @brief Removes a phone number from the contact's list of phone numbers.
     * @param phoneNumber The phone number to be removed from the contact's list.
     *
    public void removePhoneNumber(String phoneNumber) {
    phoneNumbers.remove(phoneNumber);
    }
    /**
     * @brief Removes an email address from the contact's list of email addresses.
     * @param email The email address to be removed from the contact's list.
     *
    public void removeEmail(String email) {
    emails.remove(email);
    }
    /**
     * @brief Sets the favorite status of the contact.
     * @param favorite The favorite status to be set for the contact.
     */


    public void setFavorite(boolean favorite) {
        this.favourite=favorite;
    }

/**
   * Returns whether the contact is marked as a favorite or not.
   * @return true if the contact is marked as a favorite, false otherwise.
   */
  public boolean isFavourite() {
    return favourite;
}


/**
 * @brief Checks if two contacts are equal based on their phone numbers and email addresses.
 * @param o The object to compare with the contact.
 * @return true if the objects are equal, false otherwise.
 */
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Contact contact = (Contact) o;
    return phoneNumbers.equals(contact.phoneNumbers) && emails.equals(contact.emails);
  }

/**
 * @brief Computes the hash code for the contact based on its phone numbers and email addresses.
 * @return The hash code for the contact.
 */
  public int hashCode() {
    return phoneNumbers.hashCode() + emails.hashCode();}

/**
 * @brief Returns a string representation of the contact.
 * @return A string representation of the contact.
 */
public String toString() {
    return "Name: " + name + " Surname: " + surname + " Company: " + company + " IBAN: " + IBAN + " Address: " + address + " Website: " + website + " Notes: " + notes + " Favorite: " + favorite;
  }
}