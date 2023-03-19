
import kryo.KryoObjectSerializer;
import kryo.Vacation;
import org.hyperskill.hstest.dynamic.DynamicTest;
import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;

import java.time.LocalDate;
import java.util.Arrays;


public class Tests extends StageTest {
    @DynamicTest
    CheckResult testClassRegister() {
        Vacation vacation = new Vacation(LocalDate.of(2019,10,10), null, null);
        KryoObjectSerializer kryoObjectSerializer = new KryoObjectSerializer();
        byte[] actual = kryoObjectSerializer.serializeObject(vacation);
        byte[] expected = {0, 1, -29, 15, 10, 10, 0};
        return new CheckResult(Arrays.equals(actual, expected), "Byte array should be: [0, 1, -29, 15, 10, 10, 0], " +
                "but your program returned: " + Arrays.toString(actual));
    }

    @DynamicTest
    CheckResult testClassRegisterInFuture() {
        Vacation vacation = new Vacation(LocalDate.of(2079,12,30), null, null);
        KryoObjectSerializer kryoObjectSerializer = new KryoObjectSerializer();
        byte[] actual = kryoObjectSerializer.serializeObject(vacation);
        byte[] expected = {0, 1, -97, 16, 12, 30, 0};
        return new CheckResult(Arrays.equals(actual, expected), "Byte array should be: [0, 1, -97, 16, 12, 30, 0], " +
                "but your program returned: " + Arrays.toString(actual));
    }
}