import kryo.Address;
import kryo.KryoObjectSerializer;
import org.hyperskill.hstest.dynamic.DynamicTest;
import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;

public class Tests extends StageTest {

    @DynamicTest
    CheckResult test1() {
        Address address = new Address("Main str.", "Washington", "USA");

        return test(address);
    }

    @DynamicTest
    CheckResult test2() {
        Address address = new Address("Main Boulevard.", "Chicago", "USA");

        return test(address);
    }

    private CheckResult test(Address address) {
        KryoObjectSerializer kryoObjectSerializer = new KryoObjectSerializer();
        byte[] serialized = kryoObjectSerializer.serializeObject(address);
        Address actual = kryoObjectSerializer.deserializeObject(serialized);

        return new CheckResult(
                address.equals(actual),
                "Address after serialization should be:" + address
                        + "but your program returned: " + actual.toString());
    }
}
