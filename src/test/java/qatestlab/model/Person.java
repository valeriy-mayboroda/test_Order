package qatestlab.model;

public class Person {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String postAddress;
    private String city;

    public Person() {
    }

    public Person(String firstName, String lastName, String email, String address, String postAddress, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.postAddress = postAddress;
        this.city = city;
    }

    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getFirstName() {return firstName;}

    public void setLastName(String lastName) {this.lastName = lastName;}
    public String getLastName() {return lastName;}

    public void setEmail(String email) {this.email = email;}
    public String getEmail() {return email;}

    public void setAddress(String address) {this.address = address;}
    public String getAddress() {return address;}

    public void setPostAddress(String postAddress) {this.postAddress = postAddress;}
    public String getPostAddress() {return postAddress;}

    public void setCity(String city) {this.city = city;}
    public String getCity() {return city;}

    public static Person initPerson() {
        String firstName = "MyFirstName";
        String lastName = "MyLastName";
        String email = "";
        char[] array = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for (int i = 0; i < 10 + (int)(Math.random()*10); i ++)
            email += array[(int)(Math.random()*array.length)];
        email += "@gmail.com";
        String address = "MyAvenue 1 Myhouse 1";
        String postAddress = "50050";
        String city = "MyCity";
        return new Person(firstName, lastName, email, address, postAddress, city);
    }
}
