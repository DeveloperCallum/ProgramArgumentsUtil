package uk.co.paidsoftware.util.argument;

import uk.co.paidsoftware.util.argument.parser.ArgumentPaserCreateArgumentEvent;
import uk.co.paidsoftware.util.argument.parser.ArgumentParser;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ArgumentHandler {
    private final ArgumentParser argumentParser;
    private  final HashMap<String, ProgramArgument> argsData = new HashMap<>();

    public ArgumentHandler() {
        argumentParser = new ArgumentParser((name, val) -> {
            if (val.contains(":\\")){
                return  new FileProgramArgument(name, val);
            }

            return new BasicProgramArgument(name, val);
        });
    }

    public ArgumentHandler(ArgumentPaserCreateArgumentEvent e) {
        argumentParser = new ArgumentParser(e);
    }

    public ProgramArgument createArgument(String name, String val) {
        BasicProgramArgument programArgument = new BasicProgramArgument(name, val);
        argsData.put(name, programArgument);

        return programArgument;
    }

    public ProgramArgument createArgument(String name, String val, Class<? extends BasicProgramArgument> programArgument) {
        try {
            BasicProgramArgument argsInstance = programArgument.getDeclaredConstructor(String.class, String.class).newInstance(name, val);
            argsData.put(name, argsInstance);

            return argsInstance;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<ProgramArgument> getArgs(String name){
        ProgramArgument programArgument = argsData.get(name);
        return programArgument == null ? Optional.empty() : Optional.of(programArgument);
    }

    public void handleArgs(String[] args){
        List<ProgramArgument> data = argumentParser.handleArgs(args);

        data.forEach(programArgument -> {
            argsData.put(programArgument.getName(), programArgument);
        });
    }
}
