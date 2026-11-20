public class MissionStep {
    private int command;
    private int energy;
    private String result;

    public MissionStep(int command, int energy, String result) {
        this.command = command;
        this.energy = energy;
        this.result = result;
    }

    public int getCommand() {
        return this.command;
    }

    public int getEnergy() {
        return this.energy;
    }

    public String getResult() {
        return this.result;
    }

    public boolean isSuccessful() {
        return "成功".equals(this.result);
    }
}