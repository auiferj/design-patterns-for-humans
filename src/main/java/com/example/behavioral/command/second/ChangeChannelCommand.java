package com.example.behavioral.command.second;

class ChangeChannelCommand implements TVCommand {
    private Television tv;
    private int channel;

    public ChangeChannelCommand(Television tv, int channel) {
        this.tv = tv;
        this.channel = channel;
    }

    public void execute() {
        tv.changeChannel(channel);
    }
}
