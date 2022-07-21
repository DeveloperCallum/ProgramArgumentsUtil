package uk.co.paidsoftware.util.argument;

public class BasicProgramArgument implements ProgramArgument {
    private final String name;
    private String value;

    /**
     * Creates a new ProgramArgument
     *
     * @param name The name of the argument
     * @param val  The value of the argument
     */

    public BasicProgramArgument(String name, String val) {
        this.name = name.substring(1);
        this.value = val;
    }

    public String getName() {
        return name;
    }

    public String getNameRaw() {
        return "-" + name;
    }

    public String getValue() {
        return value;
    }
}
