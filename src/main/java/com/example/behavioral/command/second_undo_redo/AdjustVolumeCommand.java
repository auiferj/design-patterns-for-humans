package com.example.behavioral.command.second_undo_redo;

class AdjustVolumeCommand implements TVCommand {
    private Television tv;
    private int newVolume;
    private int previousVolume;
    private boolean executed = false;

    public AdjustVolumeCommand(Television tv, int volume) {
        this.tv = tv;
        this.newVolume = volume;
        this.previousVolume = tv.getCurrentVolume();
    }

    public void execute() {
        tv.adjustVolume(newVolume);
        executed = true;
    }

    public void undo() {
        if (executed) {
            tv.adjustVolume(previousVolume);
            executed = false;
        }
    }
}
