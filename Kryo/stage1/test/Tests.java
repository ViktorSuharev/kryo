import kryo.KryoObjectSerializer;
import kryo.Wizard;
import org.hyperskill.hstest.dynamic.DynamicTest;
import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;

import java.util.Arrays;


public class Tests extends StageTest {
    @DynamicTest
    CheckResult testDarkWizard() {
        Wizard wizard = new Wizard("Lord Voldemort", 71, true);
        KryoObjectSerializer kryoObjectSerializer = new KryoObjectSerializer();
        byte[] actual = kryoObjectSerializer.doSerialization(wizard);
        System.out.println(Arrays.toString(actual));
        byte[] expected = {1, -114, 1, 1, 1, 76, 111, 114, 100, 32, 86, 111, 108, 100, 101, 109, 111, 114, -12};
        return new CheckResult(Arrays.equals(actual, expected), "Byte array should be: [1, -114, 1, 1, 1, 76, 111, 114, 100, 32, 86, 111, 108, 100, 101, 109, 111, 114, -12], " +
                "but your program returned: " + Arrays.toString(actual));
    }

    @DynamicTest
    CheckResult testWizard() {
        Wizard wizard = new Wizard("Harry Potter", 13, false);
        KryoObjectSerializer kryoObjectSerializer = new KryoObjectSerializer();
        byte[] actual = kryoObjectSerializer.doSerialization(wizard);
        System.out.println(Arrays.toString(actual));
        byte[] expected = {1, 26, 1, 0, 72, 97, 114, 114, 121, 32, 80, 111, 116, 116, 101, -14};
        return new CheckResult(Arrays.equals(actual, expected), "Byte array should be: [1, 26, 1, 0, 72, 97, 114, 114, 121, 32, 80, 111, 116, 116, 101, -14], " +
                "but your program returned: " + Arrays.toString(actual));
    }
}