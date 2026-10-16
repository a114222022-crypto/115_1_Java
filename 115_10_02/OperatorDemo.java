/*
    作業名稱：Java 運算子與邏輯判斷實作題
    目的：熟悉算術運算子、指定運算子、關係運算子、邏輯運算子與短路求值。
    任務要求：
      1. 宣告並使用整數變數進行基本計算。
      2. 比較 int 與 double 之間的運算差異。
      3. 使用 +=、++、-- 等複合指定與遞增、遞減運算。
      4. 設計簡單的邏輯判斷，理解 && 與 || 的短路行為。
      5. 使用 % 運算子完成分配與餘數計算。
 */
public class OperatorDemo {
    public static void main(String[] args) {
        System.out.println("==============================");
        System.out.println("      Java 運算子與邏輯判斷作業");
        System.out.println("==============================");

        int capacity = 20;
        int energy = 7;

        // 第一部分：算術運算與型別轉換
        System.out.println("\n[1] 算術運算與型別轉換");
        System.out.println("- 直接除法：" + energy / 20 * 100.0);
        System.out.println("- 先整數相除再轉 double：" + (double) (energy / 20) * 100);
        System.out.println("- 先轉型再除：" + (double) energy / 20 * 100);
        System.out.println("- 其中一個是 double：" + energy / 20.0 * 100);
        System.out.println("- 轉成整數：" + (int) 7.9);

        // 第二部分：字串串接
        System.out.println("\n[2] 字串串接");
        System.out.println("合計=" + 2 + 3);
        System.out.println("合計=" + (2 + 3));

        // 第三部分：複合指定與遞增遞減
        System.out.println("\n[3] 複合指定與遞增遞減");
        int samples = 0;
        samples += 2;
        samples++;
        samples--;
        System.out.println("樣本數=" + samples);

        // 第四部分：關係運算子與邏輯運算子
        System.out.println("\n[4] 關係與邏輯判斷");
        boolean locked = false;
        System.out.println("能量在合理範圍內：" + (energy >= 0 && energy <= capacity));
        System.out.println("能源足夠且未鎖定：" + (energy >= 6 && !locked));
        System.out.println("能量異常：" + (energy < 0 || energy > capacity));

        // 第五部分：短路求值
        System.out.println("\n[5] 短路求值（short-circuit）");
        System.out.println("false && reportCheck() => " + (false && reportCheck()));
        System.out.println("true || reportCheck() => " + (true || reportCheck()));
        System.out.println("true && reportCheck() => " + (true && reportCheck()));

        // 第六部分：餘數運算
        System.out.println("\n[6] 餘數與分配");
        int pearls = 53;
        System.out.println("配料份數=" + pearls / 8 + "，剩餘=" + pearls % 8);

        // 總結
        System.out.println("\n[7] 任務結論");
        boolean ready = energy > 0 && !locked && samples >= 2;
        System.out.println("探測系統是否準備就緒？" + ready);
    }

    static boolean reportCheck() {
        System.out.println("右側檢查已執行");
        return true;
    }
}
