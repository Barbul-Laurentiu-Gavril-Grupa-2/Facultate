package isp.lab10.exercise1;

public class AtcMessage {
    private AtcCommand command;

    public AtcMessage(AtcCommand command) {
        this.command = command;
    }

    public AtcCommand getCommand() {
        return command;
    }

    public void setCommand(AtcCommand command) {
        this.command = command;
    }
}
