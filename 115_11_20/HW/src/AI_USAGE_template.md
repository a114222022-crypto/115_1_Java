# 第七週AI使用紀錄

姓名／學號：陳奕璇／A114222022
工具及來源：Gemini（Google AI）

## 精簡紀錄

| 使用目的與Prompt摘要（註明來源） | 採納／拒絕與理由 | 本人驗證：預期、實際、證據位置 | 最終修改與commit |
|---|---|---|---|
| 詢問 IntelliJ IDEA 專案設定與重複類別編譯錯誤（`duplicate class: RoverDashboard`）的排除方式（來源：Gemini） | 採納：取消舊週次資料夾的 Sources Root 標記，僅保留 `115_11_20/HW`，成功解決編譯衝突 | 預期能正常編譯並執行 `HeavyRoverTry`；實際成功編譯並運行（`exit code 0`），證據見 `115_11_20/HW` 執行結果 | 調整 IDEA 目錄設定（未更動程式碼） |
| 詢問 `Rover` 類別重構（`spendEnergy` 提取共用扣能源邏輯）與 `HeavyRover` 繼承實作（`drill` 方法與 `drillCount` 狀態維護）（來源：Gemini） | 採納：透過父類別 `protected` 方法（`spendEnergy`、`addSamples`、`countAction`）更新狀態，避免子類別重複宣告欄位導致狀態不同步 | 預期 `HeavyRoverTry` 所有測試案例皆顯示「相符」（如鑽探後 `12/3/1/1`、能源不足維持 `7/0/0/0`、能源剛好足夠 `0/3/1/1`）；實際執行 `HeavyRoverTry.main` 全部案例均印出「相符」 | 完成 `Rover.java` 與 `HeavyRover.java` 修改並通過測試（待補 commit 編號） |

## 反思

- 哪個案例讓我發現「回成功卻沒更新正確狀態」：在尚未實作 `HeavyRover.drill()` 與 `Rover.spendEnergy()` 前，或若子類別不小心重複宣告與父類別同名的 `energy`、`samples` 欄位時，呼叫 `drill()` 雖可能回傳「成功」，但父類別的 `getEnergy()` 與 `getSamples()` 仍維持原始數值（例如 `8/0/0/0` 而非預期的 `0/3/1/1`），透過 `HeavyRoverTry` 的狀態比對即可立刻發現狀態未正確更新。
- 我保留或拒絕AI建議的理由：保留 AI 建議使用父類別 `protected` 輔助方法（`spendEnergy`、`addSamples`、`countAction`）來操作狀態，因為這符合物件導向封裝與繼承原則，能確保 `Rover` 與 `HeavyRover` 共用同一份狀態資料；在操作過程中曾誤將 `HeavyRover` 程式碼貼入 `HeavyRoverTry.java` 導致類別名稱不符報錯，發現後立即復原測試檔並重新貼至正確檔案。
- 我仍無法解釋或尚未完成的部分：目前 `HeavyRoverTry` 內建測試案例皆已全數通過，後續還需確認 `Mission.java`、`MissionLog.java` 與 `MissionStep.java` 是否需要配合本週重構進行調整與額外反例測試。
- ![](https://picgocloud.com/m/bpzj13ef/b12ee908-8fe4-47b9-af94-61822feec343.png)