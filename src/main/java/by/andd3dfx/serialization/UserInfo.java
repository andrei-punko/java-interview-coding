package by.andd3dfx.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Base64;

public class UserInfo implements Externalizable {

    private String firstName;
    private String lastName;
    private String superSecretInformation;

    private static final long serialVersionUID = 1L;

    public UserInfo() {
    }

    public UserInfo(String firstName, String lastName, String superSecretInformation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.superSecretInformation = superSecretInformation;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getFirstName());
        out.writeObject(this.getLastName());
        out.writeObject(this.encryptString(this.getSuperSecretInformation()));
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        firstName = (String) in.readObject();
        lastName = (String) in.readObject();
        superSecretInformation = this.decryptString((String) in.readObject());
    }

    private String encryptString(String data) {
        String encryptedData = Base64.getEncoder().encodeToString(data.getBytes());
        System.out.println(encryptedData);
        return encryptedData;
    }

    private String decryptString(String data) {
        String decrypted = new String(Base64.getDecoder().decode(data));
        System.out.println(decrypted);
        return decrypted;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSuperSecretInformation() {
        return superSecretInformation;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", superSecretInformation='" + superSecretInformation + '\'' +
            '}';
    }
}
