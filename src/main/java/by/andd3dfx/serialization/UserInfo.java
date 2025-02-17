package by.andd3dfx.serialization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serial;
import java.util.Base64;

/**
 * Check for details this <a href="https://javarush.ru/groups/posts/2023-znakomstvo-s-interfeysom-externalizable">article</a>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo implements Externalizable {

    @Serial
    private static final long serialVersionUID = 2019L;

    private String firstName;
    private String lastName;
    private String email;
    private String url;
    private String superSecretInformation;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(firstName);
        out.writeObject(lastName);
        out.writeObject(email);
        out.writeObject(url);
        out.writeObject(encryptString(superSecretInformation));
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        firstName = (String) in.readObject();
        lastName = (String) in.readObject();
        email = (String) in.readObject();
        url = (String) in.readObject();
        superSecretInformation = decryptString((String) in.readObject());
    }

    private String encryptString(String data) {
        if (data == null) {
            return null;
        }
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    private String decryptString(String data) {
        if (data == null) {
            return null;
        }
        try {
            return new String(Base64.getDecoder().decode(data));
        } catch (IllegalArgumentException iae) {
            throw new RuntimeException("Error during decode of " + data);
        }
    }
}
