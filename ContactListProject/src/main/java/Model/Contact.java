package Model;

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
   * @brief Default constructor for the Contact class. Initializes a new
   * Contact object.
   * @param name The contact's name.
   * @param surname The contact's surname.
   * @param email1 The contact's primary email address.
   * @param email2 The contact's secondary email address.
   * @param email3 The contact's tertiary email address.
   * @param company The contact's company.
   * @param IBAN The contact's IBAN.
   * @param address The contact's address.
   * @param website The contact's website.
   * @param notes Additional notes for the contact.
   * @param favourite Indicates whether the contact is marked as a favorite.
   */
  public Contact(
    String name,
    String surname,
    String phoneNumber1,
    String phoneNumber2,
    String phoneNumber3,
    String email1,
    String email2,
    String email3,
    String company,
    String IBAN,
    String address,
    String website,
    String notes,
    boolean favourite
  ) {
    this.name = name;
    this.surname = surname;
    this.phoneNumber1 = phoneNumber1;
    this.phoneNumber2 = phoneNumber2;
    this.phoneNumber3 = phoneNumber3;
    this.email1 = email1;
    this.email2 = email2;
    this.email3 = email3;
    this.company = company;
    this.IBAN = IBAN;
    this.address = address;
    this.website = website;
    this.notes = notes;
    this.favourite = favourite;
    check();
  }

  /**
   * @brief Default constructor without parameters.
   * Initializes all the fields with their default values.
   */
  public Contact() {
    this.name = "";
    this.surname = "";
    this.phoneNumber1 = "";
    this.phoneNumber2 = "";
    this.phoneNumber3 = "";
    this.email1 = "";
    this.email2 = "";
    this.email3 = "";
    this.company = "";
    this.IBAN = "";
    this.address = "";
    this.website = "";
    this.notes = "";
    this.favourite = false;
  }

  /**
   * @brief Checks if the contact has a name or a surname.
   * @throws IllegalArgumentException if both name and surname are empty or
   * null.
   */
  private void check() {
    if (
      (name == null || name.isEmpty()) && (surname == null || surname.isEmpty())
    ) {
      throw new IllegalArgumentException("Please enter a name or a surname");
    }
  }

  /**
   * @brief Getter method to return the name of the contact.
   * @return The name of the contact.
   */
  public String getName() {
    return name;
  }

  /**
   * @brief Getter method to return the surname of the contact.
   * @return The surname of the contact.
   */
  public String getSurname() {
    return surname;
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
   * @brief Getter method to return the emails of the contact.
   * @return emails of the contact.
   */
  public String getEmail1() {
    return email1;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  /**
   * @brief Getter method to return the company of the contact.
   * @return The company of the contact.
   */
  public String getCompany() {
    return company;
  }

  /**
   * @brief Getter method to return the IBAN of the contact.
   * @return The IBAN of the contact.
   */
  public String getIBAN() {
    return IBAN;
  }

  /**
   * @brief Getter method to return the address of the contact.
   * @return The address of the contact.
   */
  public String getAddress() {
    return address;
  }

  /**
   * @brief Getter method to return the website of the contact.
   * @return The website of the contact.
   */
  public String getWebsite() {
    return website;
  }

  /**
   * @brief Getter method to return the notes of the contact.
   * @return The notes of the contact.
   */
  public String getNotes() {
    return notes;
  }

  /**
   * @brief Setter method to set the name of the contact.
   * @param name The name to be set for the contact.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @brief Setter method to set the surname of the contact.
   * @param surname The surname to be set for the contact.
   */
  public void setSurname(String surname) {
    this.surname = surname;
  }

  public void setPhoneNumber1(String phoneNumber1) {
    this.phoneNumber1 = phoneNumber1;
  }

  public void setPhoneNumber2(String phoneNumber2) {
    this.phoneNumber2 = phoneNumber2;
  }

  public void setPhoneNumber3(String phoneNumber3) {
    this.phoneNumber3 = phoneNumber3;
  }

  /**
   * @brief Setter method to set the emails of the contact.
   * @param email1 The emails to be set for the contact.
   * @param email2 The emails to be set for the contact.
   * @param email3 The emails to be set for the contact.
   */
  public void setEmail1(String email1) {
    this.email1 = email1;
  }

  public void setEmail2(String email2) {
    this.email2 = email2;
  }

  public void setEmail3(String email3) {
    this.email3 = email3;
  }

  /**
   * @brief Setter method to set the company of the contact.
   * @param company The company to be set for the contact.
   */
  public void setCompany(String company) {
    this.company = company;
  }

  /**
   * @brief Setter method to set the IBAN of the contact.
   * @param IBAN The IBAN to be set for the contact.
   */
  public void setIBAN(String IBAN) {
    this.IBAN = IBAN;
  }

  /**
   * @brief Setter method to set the address of the contact.
   * @param address The address to be set for the contact.
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * @brief Setter method to set the website of the contact.
   * @param website The website to be set for the contact.
   */
  public void setWebsite(String website) {
    this.website = website;
  }

  /**
   * @brief Setter method to set the notes of the contact.
   * @param notes The notes to be set for the contact.
   */
  public void setNotes(String notes) {
    this.notes = notes;
  }

  public void setFavorite(boolean favourite) {
    this.favourite = favourite;
  }

  /**
   * Returns whether the contact is marked as a favorite or not.
   *
   * @return true if the contact is marked as a favorite, false otherwise.
   */
  public boolean isFavourite() {
    return favourite;
  }

  @Override
  public String toString() {
    return (
      "Name: " +
      name +
      " Surname: " +
      surname +
      " Company: " +
      company +
      " IBAN: " +
      IBAN +
      " Address: " +
      address +
      " Website: " +
      website +
      " Notes: " +
      notes +
      " Favorite: " +
      favourite
    );
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Contact contact = (Contact) obj;
    return (
      name.equalsIgnoreCase(contact.name) &&
      surname.equalsIgnoreCase(contact.surname)
    );
  }

  //Metodo per l'export in csv (formatta in csv)
  public String toCsv() {
    return String.format(
      "%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s",
      name,
      surname,
      formatPhoneNumber(phoneNumber1),
      formatPhoneNumber(phoneNumber2),
      formatPhoneNumber(phoneNumber3),
      formatEmail(email1),
      formatEmail(email2),
      formatEmail(email3),
      company,
      IBAN,
      address,
      website,
      notes,
      favourite
    );
  }

  /**
   * Formats a phone number by adding spaces after the third and sixth digits.
   * If the phone number is null or does not match the expected format of a
   * ten-digit number, it returns the original phone number.
   * @param phoneNumber The phone number to format.
   * @return The formatted phone number, or the original phone number if it
   *         does not match the ten-digit pattern.
   */
  private String formatPhoneNumber(String phoneNumber) {
    return phoneNumber != null && phoneNumber.matches("\\d{10}")
      ? String.format(
        "%s %s %s",
        phoneNumber.substring(0, 3),
        phoneNumber.substring(3, 6),
        phoneNumber.substring(6)
      )
      : phoneNumber;
  }

  /**
   * Formats an email address by converting it to lower case.
   * If the email address is null, it returns the original email address.
   * @param email The email address to format.
   * @return The formatted email address, or the original email address if it
   *         is null.
   */
  private String formatEmail(String email) {
    return email != null ? email.toLowerCase() : email;
  }
}
