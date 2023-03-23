import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import kryo.KryoObjectSerializer;
import kryo.Wizard;
import org.hyperskill.hstest.dynamic.DynamicTest;
import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;


public class Tests extends StageTest {
    @DynamicTest
    CheckResult testDarkWizard() {
        Wizard wizard = new Wizard("Lord Voldemort", 71, true);
        return test(wizard);
    }

    @DynamicTest
    CheckResult testWizard() {
        Wizard wizard = new Wizard("Harry Potter", 13, false);
        return test(wizard);
    }

    private CheckResult test(Wizard wizard) {
        KryoObjectSerializer kryoObjectSerializer = new KryoObjectSerializer();
        byte[] actual = kryoObjectSerializer.doSerialization(wizard);
        byte[] expected = runExpected(wizard);
        return new CheckResult(
                Arrays.equals(actual, expected),
                "Byte array should be: " + Arrays.toString(expected) + ", " +
                        "but your program returned: " + Arrays.toString(actual)
        );
    }

    private byte[] runExpected(Wizard wizard) {
        Kryo kryo = new Kryo();
        kryo.register(Wizard.class);
        Output output = new Output(new ByteArrayOutputStream());
        kryo.writeObject(output, wizard);

        byte[] buffer = output.getBuffer();
        int size = output.position();
        byte[] trimmed = new byte[size];
        if (size >= 0) System.arraycopy(buffer, 0, trimmed, 0, size);

        return trimmed;
    }
}
