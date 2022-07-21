package uk.co.paidsoftware.util.argument.parser;

import uk.co.paidsoftware.util.argument.ProgramArgument;

import java.util.ArrayList;
import java.util.List;

public class ArgumentParser {
    private ArgumentPaserCreateArgumentEvent createArgumentEvent;

    public ArgumentParser(ArgumentPaserCreateArgumentEvent createArgumentEvent) {
        this.createArgumentEvent = createArgumentEvent;
    }

    public List<ProgramArgument> handleArgs(String[] args){
        List<ProgramArgument> argsData = new ArrayList<>();

        int itr = 0;
        String currentName = null;
        for (String data : args) {
            if (++itr % 2 == 1){
                currentName = data;
                continue;
            }

            ProgramArgument res = createArgumentEvent.create(currentName, data);
            argsData.add(res);
        }

        return argsData;
    }
}
