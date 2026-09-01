package cc.hongz.ztools.cron.demo;

import cc.hongz.ztools.core.lang.Console;
import cc.hongz.ztools.core.thread.ThreadUtil;
import cc.hongz.ztools.cron.CronUtil;
import org.junit.jupiter.api.DisplayName;

@DisplayName("定时任务增删示例")
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class AddAndRemoveMainTest {
    
    public static void main(final String[] args) {
        CronUtil.setMatchSecond(true);
        CronUtil.start(false);
        CronUtil.getScheduler().clear();
        String id = CronUtil.schedule("*/2 * * * * *", (Runnable) () -> Console.log("task running : 2s"));
        ThreadUtil.sleep(3000);
        CronUtil.remove(id);
        Console.log("Task Removed");

        CronUtil.schedule("*/3 * * * * *", (Runnable) () -> Console.log("New task add running : 3s"));
        Console.log("New Task added.");
    }
}
