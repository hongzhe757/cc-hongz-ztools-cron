package cc.hongz.ztools.cron.pattern.matcher;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * 年匹配。 <br>
 * 考虑年数字太大，不适合boolean数组，单独使用{@link LinkedHashSet}匹配
 *
 * @author Looly
 */
public class YearValueMatcher implements PartMatcher {

    private final LinkedHashSet<Integer> valueList;

    /**
     * 构造。
     *
     * @param intValueList 年份值列表
     */
    public YearValueMatcher(final Collection<Integer> intValueList) {
        this.valueList = new LinkedHashSet<>(intValueList);
    }

    @Override
    public boolean match(final Integer t) {
        return valueList.contains(t);
    }

    @Override
    public int nextAfter(final int value) {
        for (Integer year : valueList) {
            if (year >= value) {
                return year;
            }
        }

        // 年无效，此表达式整体无效
        return -1;
    }
}
