package cc.hongz.ztools.cron.pattern;

import cc.hongz.ztools.cron.CronException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Cron表达式构建器测试")
public class CronPatternBuilderTest {

    @DisplayName("构建全匹配表达式")
    @Test
    public void buildMatchAllTest() {
        String build = CronPatternBuilder.of().build();
        assertEquals("* * * * *", build);

        build = CronPatternBuilder.of()
                .set(Part.SECOND, "*")
                .build();
        assertEquals("* * * * * *", build);

        build = CronPatternBuilder.of()
                .set(Part.SECOND, "*")
                .set(Part.YEAR, "*")
                .build();
        assertEquals("* * * * * * *", build);
    }

    @DisplayName("构建区间表达式")
    @Test
    public void buildRangeTest() {
        String build = CronPatternBuilder.of()
                .set(Part.SECOND, "*")
                .setRange(Part.HOUR, 2, 9)
                .build();
        assertEquals("* * 2-9 * * *", build);
    }

    @DisplayName("构建非法区间表达式")
    @Test
    public void buildRangeErrorTest() {
        assertThrows(CronException.class, () -> {
            String build = CronPatternBuilder.of()
                .set(Part.SECOND, "*")
                // 55无效值
                .setRange(Part.HOUR, 2, 55)
                .build();
            assertEquals("* * 2-9 * * *", build);
        });
    }
}
