package cc.hongz.ztools.cron.demo;

import cc.hongz.ztools.core.lang.Console;
import cc.hongz.ztools.core.thread.ThreadUtil;
import cc.hongz.ztools.cron.CronUtil;
import cc.hongz.ztools.cron.Scheduler;
import cc.hongz.ztools.cron.TaskExecutor;
import cc.hongz.ztools.cron.listener.TaskListener;
import cc.hongz.ztools.cron.task.Task;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 定时任务样例。
 */
@DisplayName("定时任务样例测试")
public class CronTest {

    @DisplayName("空调度测试")
    @Test
    @Disabled
    void emptyScheduleTest() {
        final Scheduler scheduler = new Scheduler();
        // 支持秒级别定时任务
        scheduler.setMatchSecond(true);

        scheduler.start();

        ThreadUtil.waitForDie();
        Console.log("Exit.");
    }

    @DisplayName("自定义Cron测试")
    @Test
    @Disabled
    public void customCronTest() {
        CronUtil.schedule("*/2 * * * * *", (Task) () -> Console.log("Task executed."));

        // 支持秒级别定时任务
        CronUtil.setMatchSecond(true);
        CronUtil.start();

        ThreadUtil.waitForDie();
        Console.log("Exit.");
    }

    @DisplayName("Cron测试")
    @Test
    @Disabled
    public void cronTest() {
        // 支持秒级别定时任务
        CronUtil.setMatchSecond(true);
        CronUtil.getScheduler().setDaemon(false);
        CronUtil.start();

        ThreadUtil.waitForDie();
        CronUtil.stop();
    }

    @DisplayName("带监听器Cron测试")
    @Test
    @Disabled
    public void cronWithListenerTest() {
        CronUtil.getScheduler().addListener(new TaskListener() {
            @Override
            public void onStart(final TaskExecutor executor) {
                Console.log("Found task:[{}] start!", executor.getCronTask().getId());
            }

            @Override
            public void onSucceeded(final TaskExecutor executor) {
                Console.log("Found task:[{}] success!", executor.getCronTask().getId());
            }

            @Override
            public void onFailed(final TaskExecutor executor, final Throwable exception) {
                Console.error("Found task:[{}] failed!", executor.getCronTask().getId());
            }
        });

        // 支持秒级别定时任务
        CronUtil.setMatchSecond(true);
        CronUtil.start();

        ThreadUtil.waitForDie();
        Console.log("Exit.");
    }

    @DisplayName("增删任务测试")
    @Test
    @Disabled
    public void addAndRemoveTest() {
        String id = CronUtil.schedule("*/2 * * * * *", (Runnable) () -> Console.log("task running : 2s"));

        Console.log(id);
        CronUtil.remove(id);

        // 支持秒级别定时任务
        CronUtil.setMatchSecond(true);
        CronUtil.start();
    }
}
