# 命令模式

    思考到餐廳點餐這件事情：「女服務生」透過「訂單」吩咐「後場廚師」準備餐點

- 命令模式將請求封裝成對象，以便使用不同的請求、隊列或是日誌來參數化其他對象，並可支持撤銷命令
- 訂單(command)封裝「準備餐點的請求」:使用orderUp()讓廚師開始做料理(execute())
- 女服務生(invoker)透過不同的訂單類別，使用訂單共通的orderUp()讓廚師準備餐點
- 廚師(receiver)知道實際餐點的製作流程
- 顧客(client)

```java
public class Client {
    public Command createCommandObject() {
        Command command = new ConcreteComand();    
    }
}

public class Command {
    public void execute();
    public void undo();
    
}

public class ConcreteCommand implements Command {
    @Override
    public void execute() {
        receiver.action1();
    }
    @Override
    public void undo () {
        receiver.action2();
    }
}
public class Receiver {
    public void action1();
    public void action2();
}
public class Invoker {
    public void setCommnad();
}

```

- NoCommand對象是一個空對象(null object)
- 撤銷命令有時候需要紀錄狀態
- Party mode可以幫助同時執行指令

```java
public class MacroCommand implements Command {
    Command[] commands;
    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }
    public void execute() {
        for (Command command: commands) {
            command.execute();
        }
    }
    public void undo() {
        for (Command command: commands) {
            command.undo();
        }
    }
}

```

- 命令模式可以將運算邏輯打包為一個接收者和一組動作，在命令對象被創建許久後仍然可以被重複調用，甚至是「不同線程」
    - 可以使用在行程安排(scheduler)、線程池、工作佇列（從佇列中拿取命令對象送入線程中，調用完成後將這個命令對象丟棄）
    - 用在工作日誌記錄上，可以將execute()、undo()視為store()、load()，對於系統恢復時依次調用命令對象：transaction處理上的命令原子化

# 空對象

- 我們可以藉由空對象的產生，將處理`nulll`的責任從客戶轉移到空對象上
