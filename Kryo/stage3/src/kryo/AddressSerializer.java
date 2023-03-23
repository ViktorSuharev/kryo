package kryo;

import com.esotericsoftware.kryo.*;
import com.esotericsoftware.kryo.io.*;

public class AddressSerializer extends Serializer<Address> {
    @Override
    public void write(Kryo kryo, Output output, Address address) {
        // write your code here
    }

    @Override
    public Address read(Kryo kryo, Input input, Class<? extends Address> type) {
        // write your code here
        return null;
    }
}
