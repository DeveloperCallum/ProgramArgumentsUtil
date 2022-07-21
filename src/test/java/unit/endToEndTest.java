package unit;

import org.junit.jupiter.api.Test;
import uk.co.paidsoftware.util.argument.ArgumentHandler;
import uk.co.paidsoftware.util.argument.ProgramArgument;

import java.util.Optional;


public class endToEndTest {
    @Test
    public void basicEndToEnd(){
        ArgumentHandler argumentHandler = new ArgumentHandler();
        argumentHandler.handleArgs(new String[]{"-current", "testing"});

        Optional<ProgramArgument> argument = argumentHandler.getArgs("current");

        argument.orElseThrow(() -> new IllegalStateException(("Argument was not found!")));
    }
}
