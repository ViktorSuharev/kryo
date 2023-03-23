package kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.*;

//do not change code below
public class KryoObjectSerializer {
    private final Kryo kryo;
    private final AddressSerializer addressSerializer;

    public KryoObjectSerializer() {
        this.kryo = new Kryo();
        this.addressSerializer = new AddressSerializer();
    }

    public byte[] serializeObject(Address address) {
        kryo.register(Address.class, new AddressSerializer());
        Output output = new Output(new ByteArrayOutputStream());
        addressSerializer.write(kryo, output, address);
        return output.getBuffer();
    }

    public Address deserializeObject(byte[] arr) {
        Input input = new Input(new ByteArrayInputStream(arr));

        return addressSerializer.read(kryo, input, Address.class);
    }
}
