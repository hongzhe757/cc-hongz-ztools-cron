package cc.hongz.ztools.cron.pattern;

import cc.hongz.ztools.core.date.DateTime;
import cc.hongz.ztools.core.lang.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

@DisplayName("Issue4006测试")
public class Issue4006Test {
    @DisplayName("Cron匹配测试")
    @Test
    void testCron() {
//        String cron = "0 0 0 */1 * ?";
        String cron = "0 0 0 */1 * ? *";
        DateTime judgeTime = DateTime.of(new Date());
        CronPattern cronPattern = new CronPattern(cron);

        Console.log("cronPattern = " + cronPattern);
        Date nextDate = CronPatternUtil.nextDateAfter(cronPattern, judgeTime, true);
        Console.log("nextDate = " + nextDate);
    }
}
