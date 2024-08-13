package test.clients;

import java.util.Arrays;
import java.util.List;

/**
 * Yields all the client info
 *
 */
public class ClientInfo {
    String id, firstName, lastName, address, email;
    int zipCode;

    public ClientInfo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Method to test the main functionality
     *
     * @return
     */
    public static List<ClientInfo> getTestClients() {
        ClientInfo info1 = new ClientInfo();
        info1.setId("1001");
        info1.setFirstName("Darwis Miguel");
        info1.setLastName("Narvaez Patino");
        info1.setAddress("John doe street, 2828");
        info1.setEmail("darwisnarvaezdev@gmail.com");
        info1.setZipCode(1426);

        ClientInfo info2 = new ClientInfo();
        info2.setId("1002");
        info2.setFirstName("Darwis");
        info2.setLastName("Narvaez");
        info2.setAddress("John doe street, 2828");
        info2.setEmail("darwisnarvaezdev@gmail.com");
        info2.setZipCode(1426);

        ClientInfo info3 = new ClientInfo();
        info3.setId("1003");
        info3.setFirstName("Miguel");
        info3.setLastName("Narvaez");
        info3.setAddress("John doe street, 2828");
        info3.setEmail("darwisnarvaezdev@gmail.com");
        info3.setZipCode(1426);

        ClientInfo info4 = new ClientInfo();
        info4.setId("1004");
        info4.setFirstName("John");
        info4.setLastName("Doe");
        info4.setAddress("John doe street, 2828");
        info4.setEmail("j_doe@gmail.com");
        info4.setZipCode(1426);

        ClientInfo info5 = new ClientInfo();
        info5.setId("1005");
        info5.setFirstName("John");
        info5.setLastName("Doe");
        info5.setAddress("John doe street, 2828");
        info5.setEmail("j_doe@gmail.com");
        info5.setZipCode(1426);

        ClientInfo info6 = new ClientInfo();
        info6.setId("1006");
        info6.setFirstName("Miguel Darwis");
        info6.setLastName("Narvaez Patino");
        info6.setAddress("John doe street, 2828");
        info6.setEmail("darwisnarvaezdev@gmail.com");
        info6.setZipCode(1426);

        ClientInfo info7 = new ClientInfo();
        info7.setId("1007");
        info7.setFirstName("Miguel Darwis");
        info7.setLastName("Patino Narvaez");
        info7.setAddress("John doe street, 2828");
        info7.setEmail("darwisnarvaezdev@gmail.com");
        info7.setZipCode(1426);

        return Arrays.asList(
                info1,
                info2,
                info3,
                info4,
                info5,
                info6,
                info7
        );
    }

    @Override
    public String toString() {
        return "ClientInfo{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
