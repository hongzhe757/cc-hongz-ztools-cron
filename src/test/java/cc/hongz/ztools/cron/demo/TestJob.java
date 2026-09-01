package cc.hongz.ztools.cron.demo;

import cc.hongz.ztools.core.date.DateUtil;
import cc.hongz.ztools.core.lang.Console;
import cc.hongz.ztools.core.thread.ThreadUtil;
import cc.hongz.ztools.core.util.IdUtil;
import org.junit.jupiter.api.DisplayName;

/**
 * 测试定时任务，当触发到定时的时间点时，执行doTest方法。
 *
 * @author looly
 *
 */
@DisplayName("测试任务")
public class TestJob {
    
    private final String jobId = IdUtil.simpleUUID();

    /**
     * 执行定时任务内容。
     */
    public void doTest() {
//        String name = Thread.currentThread().getName();
        Console.log("Test Job {} running... at {}", jobId, DateUtil.now());
    }

    /**
     * 执行循环定时任务，测试在定时任务结束时作为daemon线程是否能正常结束。
     */
    @SuppressWarnings("InfiniteLoopStatement")
    public void doWhileTest() {
        String name = Thread.currentThread().getName();
        while (true) {
            Console.log("Job {} while running...", name);
            ThreadUtil.sleep(2000);
        }
    }
}
