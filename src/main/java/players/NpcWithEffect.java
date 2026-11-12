package players;

import com.google.gson.Gson;

import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

public class NpcWithEffect extends Npc{
    private Parameters parameters;

    public NpcWithEffect(String name, String role) {
        super(name, role);
        parameters = new Parameters();
    }

    public Parameters getParameters() {
        return parameters;
    }



}
