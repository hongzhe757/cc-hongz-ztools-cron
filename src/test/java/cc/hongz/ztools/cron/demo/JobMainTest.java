package cc.hongz.ztools.cron.demo;

import cc.hongz.ztools.cron.CronUtil;
import org.junit.jupiter.api.DisplayName;

/**
 * 定时任务样例。
 */
@DisplayName("定时任务启动示例")
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class JobMainTest {

    public static void main(final String[] args) {
        CronUtil.setMatchSecond(true);
        CronUtil.start(false);
    }
}
