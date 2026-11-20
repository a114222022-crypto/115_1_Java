// 類別：Rover（探測車，第 7 週版本）
public class Rover {
    // energy：目前能源格數（0～20）。
    private int energy;
    // samples：目前已收集的樣本數，達到 5 份就算任務成功。
    private int samples;
    // actionCount：成功行動的次數；被拒絕的指令不算。
    private int actionCount;

    // 建構子：設定初始能源與樣本，行動次數從 0 開始。
    public Rover(int energy, int samples) {
        this.energy = energy;
        this.samples = samples;
        actionCount = 0;
    }

    // getEnergy：回傳目前能源。
    public int getEnergy() { return energy; }
    // getSamples：回傳目前樣本數。
    public int getSamples() { return samples; }
    // getActionCount：回傳成功行動次數。
    public int getActionCount() { return actionCount; }
    // isSuccess：樣本數是否已達 5 份（任務成功的條件）。
    public boolean isSuccess() { return samples >= 5; }
    // isExhausted：能源是否已經用完（等於 0）。
    public boolean isExhausted() { return energy == 0; }
    // isStopped：成功或耗盡任一成立就停止，之後不再接受行動。
    public boolean isStopped() { return isSuccess() || isExhausted(); }

    // execute：執行一個指令（1 探索、2 掃描、3 充電、0 返回），回傳結果字串。
    public String execute(int command) {
        if (isStopped()) { return "任務已停止"; }
        switch (command) {
            case 1: return explore();
            case 2: return scan();
            case 3: return charge();
            case 0: return "返回";
            default: return "無效指令";
        }
    }

    // spendEnergy：嘗試扣除 amount 格能源。
    protected boolean spendEnergy(int amount) {
        if (amount <= 0 || amount > energy) {
            return false;
        }
        energy -= amount;
        return true;
    }

    // addSamples：增加 amount 份樣本。
    protected void addSamples(int amount) {
        if (amount > 0) { samples += amount; }
    }

    // countAction：成功行動次數加 1。
    protected void countAction() {
        actionCount++;
    }

    // explore：探索。能源至少 6 格才執行：扣 6 格、加 2 份樣本、行動次數加 1；否則回「能源不足」。
    private String explore() {
        if (!spendEnergy(6)) { return "能源不足"; }
        addSamples(2);
        countAction();
        return "成功";
    }

    // scan：掃描。能源至少 2 格才執行：扣 2 格、加 1 份樣本、行動次數加 1；否則回「能源不足」。
    private String scan() {
        if (!spendEnergy(2)) { return "能源不足"; }
        addSamples(1);
        countAction();
        return "成功";
    }

    // charge：充電。能源未滿時加 5 格（最多 20）、行動次數加 1；已滿回「能源已滿」。
    private String charge() {
        if (energy == 20) { return "能源已滿"; }
        energy += 5;
        if (energy > 20) { energy = 20; }
        actionCount++;
        return "成功";
    }
}