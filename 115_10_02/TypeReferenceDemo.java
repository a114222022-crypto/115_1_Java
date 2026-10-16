/*
    作業名稱：Java 基本型別與字串參考實作題
    目的：熟悉 byte、short、int、long、float、double、char、boolean 等基本型別，
           以及 String 物件的參考與內容比較。
    任務要求：
      1. 宣告各種基本型別變數並輸出其值。
      2. 利用值複製觀察基本型別的行為。
      3. 觀察 String 變數重新指定後是否改變原始內容。
      4. 比較 == 與 equals() 的差異。
 */
public class TypeReferenceDemo {
    public static void main(String[] args) {
        System.out.println("==============================");
        System.out.println("      Java 型別與參考作業");
        System.out.println("==============================");

        // 第一部分：基本資料型別宣告
        System.out.println("\n[1] 基本資料型別");
        byte smallCount = 20;
        short storage = 300;
        int energy = 7;
        long distance = 3000000000L;
        float sensor = 3.5F;
        double percent = 35.0;
        char zone = 'A';
        boolean locked = false;

        System.out.println(smallCount + " " + storage + " " + energy + " " + distance);
        System.out.println(sensor + " " + percent + " " + zone + " " + locked);

        // 第二部分：值型別複製
        System.out.println("\n[2] 值型別複製");
        int backupEnergy = energy;
        energy = 6;
        System.out.println("energy=" + energy + ", backupEnergy=" + backupEnergy);

        // 第三部分：String 參考型別
        System.out.println("\n[3] String 參考型別");
        String consoleName = "赤砂號";
        String logName = consoleName;
        consoleName = "晨星號";
        System.out.println(consoleName + " / " + logName);

        // 第四部分：比較 == 與 equals()
        System.out.println("\n[4] 字串比較");
        String code = "MARS";
        String receivedCode = new String("MARS");
        System.out.println("參考比較：" + (code == receivedCode));
        System.out.println("內容比較：" + code.equals(receivedCode));

        // 結論
        System.out.println("\n[5] 結論");
        System.out.println("任務狀態=" + (energy > 0 && !locked));
    }
}
