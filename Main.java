import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class Main {
    public static void main(String[] args) {

        User user1 = new User("Andrey", "Deshankov", 23);

        try {
            FileOutputStream fos = new FileOutputStream("user.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(user1);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileInputStream fis = new FileInputStream("user.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            User user = (User) ois.readObject();
            System.out.println(user);

        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
}