
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import kryo.*;
import org.hyperskill.hstest.dynamic.DynamicTest;
import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;

public class Tests extends StageTest {
    private final KryoConfigurator kryoConfigurator = new KryoConfigurator();

    @DynamicTest
    CheckResult testClassRegister() {
        Vacation vacation = new Vacation(
                LocalDate.of(2019,10,10),
                new City("NY"),
                new Ticket(123, TicketType.AIRLINE)
        );

        return test(vacation);
    }

    @DynamicTest
    CheckResult testClassRegisterInFuture() {
        Vacation vacation = new Vacation(
                LocalDate.of(2079,12,30),
                new City("Porto"),
                new Ticket(321, TicketType.CRUISE)
        );
        return test(vacation);
    }

    private CheckResult test(Vacation vacation) {
        Kryo kryo = new Kryo();
        kryoConfigurator.configure(kryo);
        kryo.writeObject(new Output(new ByteArrayOutputStream()), vacation);

        boolean isCorrect = kryo.isRegistrationRequired()
                && kryo.getRegistration(Vacation.class).getId() != -1
                && kryo.getRegistration(LocalDate.class).getId() != -1
                && kryo.getRegistration(City.class).getId() != -1
                && kryo.getRegistration(Ticket.class).getId() != -1
                && kryo.getRegistration(TicketType.class).getId() != -1;

        return new CheckResult(isCorrect, "Some classes are not registered");
    }
}
