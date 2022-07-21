package uk.co.paidsoftware.util.argument;

import java.io.File;

public class FileProgramArgument extends BasicProgramArgument {
    private File file;

    /**
     * Creates a new ProgramArgument
     *
     * @param name The name of the argument
     * @param val  The value of the argument
     */
    public FileProgramArgument(String name, String val) {
        super(name, val);
        this.file = new File(val);
    }

    public File getFile() {
        return file;
    }
}
