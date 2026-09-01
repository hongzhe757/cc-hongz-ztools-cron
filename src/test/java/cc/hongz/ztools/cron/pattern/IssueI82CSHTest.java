package cc.hongz.ztools.cron.pattern;

import cc.hongz.ztools.core.date.DateTime;
import cc.hongz.ztools.core.date.DateUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

@DisplayName("IssueI82CSH测试")
public class IssueI82CSHTest {

    @DisplayName("区间表达式匹配日期")
    @Test
    public void test() {
        final DateTime begin = DateUtil.parse("2023-09-20");
        final DateTime end = DateUtil.parse("2025-09-20");
        final List<Date> dates = CronPatternUtil.matchedDates("0 0 1 3-3,9 *", begin, end, 20, false);
        //dates.forEach(Console::log);
        assertEquals(4,  dates.size());
    }
}
