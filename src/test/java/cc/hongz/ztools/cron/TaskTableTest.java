package cc.hongz.ztools.cron;

import cc.hongz.ztools.core.lang.Console;
import cc.hongz.ztools.core.util.IdUtil;
import cc.hongz.ztools.cron.pattern.CronPattern;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("任务表测试")
public class TaskTableTest {

    @DisplayName("任务表转字符串")
    @Test
    @Disabled
    public void toStringTest() {
        final TaskTable taskTable = new TaskTable();
        taskTable.add(IdUtil.fastUUID(), new CronPattern("*/10 * * * * *"), () -> Console.log("Task 1"));
        taskTable.add(IdUtil.fastUUID(), new CronPattern("*/20 * * * * *"), () -> Console.log("Task 2"));
        taskTable.add(IdUtil.fastUUID(), new CronPattern("*/30 * * * * *"), () -> Console.log("Task 3"));

        Console.log(taskTable);
    }
}
