package kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//do not change code below
public class KryoObjectSerializer {
    public void serializeObject(Address address) {
        Kryo kryo = new Kryo();
        kryo.register(Address.class, new AddressSerializer());
        AddressSerializer addressSerializer = new AddressSerializer();
        try (Output output = new Output(new FileOutputStream("data1.bin"))) {
            addressSerializer.write(kryo, output, address);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public Address deserializeObject() {
        Kryo kryo = new Kryo();
        AddressSerializer addressSerializer = new AddressSerializer();
        try (Input input = new Input(new FileInputStream("data1.bin"))) {
            Address address = addressSerializer.read(kryo, input, Address.class);
            System.out.println("Object after deserialization: " + address);
            return address;
        } catch (IOException e) {
            System.err.println("An error occurred while reading from the file: " + e.getMessage());
        }
        return null;
    }
}
