package kryo;

import com.esotericsoftware.kryo.*;
import com.esotericsoftware.kryo.io.*;

import java.io.*;
import java.time.*;
import java.util.*;

public class KryoObjectSerializer {
    public byte[] serializeObject(Vacation vacation) {
        Kryo kryo = new Kryo();
        //write you code here

        // do not change code below
        try (Output output = new Output(new FileOutputStream("data.bin"))) {
            kryo.writeObject(output, vacation);
            byte[] bytes = output.toBytes();
            System.out.println("Byte array: " + Arrays.toString(bytes));
            return bytes;
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
        return new byte[0];
    }
}
