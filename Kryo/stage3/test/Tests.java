import kryo.Address;
import kryo.KryoObjectSerializer;
import org.hyperskill.hstest.dynamic.DynamicTest;
import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;

public class Tests extends StageTest {
    @DynamicTest
    CheckResult testCustomSerializer() {
        String street = "Main str.";
        String city = "Washington";
        String country = "USA";
        Address address = new Address(street, city, country);
        KryoObjectSerializer kryoObjectSerializer = new KryoObjectSerializer();
        kryoObjectSerializer.serializeObject(address);
        Address actual = kryoObjectSerializer.deserializeObject();
        System.out.println("Are objects equal before and after serialization: "
                + address.equals(actual));
        return new CheckResult(address.equals(actual), "Address after serialization should be: Main str., Washington, USA, " +
                "but your program returned: " + actual.toString());
    }
}