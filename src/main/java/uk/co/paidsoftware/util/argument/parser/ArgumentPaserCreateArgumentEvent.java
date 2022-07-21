package uk.co.paidsoftware.util.argument.parser;

import uk.co.paidsoftware.util.argument.ProgramArgument;

public interface ArgumentPaserCreateArgumentEvent {
    /**
     * Create a new argument.
     * @param name The name of the argument.
     * @param val The value of the argument.
     * @return The instance of the created argument.
     */
    ProgramArgument create(String name, String val);
}
