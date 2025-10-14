package com.example.behavioral.command.second_undo_redo;

class ChangeChannelCommand implements TVCommand {
    private Television tv;
    private int newChannel;
    private int previousChannel;
    private boolean executed = false;

    public ChangeChannelCommand(Television tv, int channel) {
        this.tv = tv;
        this.newChannel = channel;
        this.previousChannel = tv.getCurrentChannel();
    }

    public void execute() {
        tv.changeChannel(newChannel);
        executed = true;
    }

    public void undo() {
        if (executed) {
            tv.changeChannel(previousChannel);
            executed = false;
        }
    }
}
