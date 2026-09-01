package cc.hongz.ztools.cron.pattern;

import cc.hongz.ztools.core.date.DateUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;

@DisplayName("IssueI9FQUA测试")
public class IssueI9FQUATest {
    @DisplayName("下一匹配日期")
    @Test
    public void nextDateAfterTest() {
        final String cron = "0/5 * * * * ?";
        final Calendar calendar = CronPattern.of(cron).nextMatchAfter(
            DateUtil.parse("2024-01-01 00:00:00").toCalendar());

        //Console.log(DateUtil.date(calendar));
        assertEquals("2024-01-01 00:00:05", DateUtil.date(calendar).toString());
    }
}
