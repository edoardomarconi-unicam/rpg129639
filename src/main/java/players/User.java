package players;

public class User extends Player {
    private Parameters parameters;

    public User(String name, String role) {
        super(name, role);
        this.parameters = new Parameters();
    }

    public Parameters getParameters() {return parameters;}

}