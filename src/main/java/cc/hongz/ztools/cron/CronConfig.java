package cc.hongz.ztools.cron;

import java.util.TimeZone;

/**
 * 定时任务配置类。
 *
 * @author looly
 * @since 5.4.7
 */
public class CronConfig {

    /**
     * 时区。
     */
    protected TimeZone timezone = TimeZone.getDefault();
    /**
     * 是否支持秒匹配。
     */
    protected boolean matchSecond;

    /**
     * 构造。
     */
    public CronConfig() {
    }

    /**
     * 设置时区。
     *
     * @param newTimeZone 时区
     * @return this
     */
    public CronConfig setTimeZone(final TimeZone newTimeZone) {
        this.timezone = newTimeZone;
        return this;
    }

    /**
     * 获得时区，默认为 {@link TimeZone#getDefault()}。
     *
     * @return 时区
     */
    public TimeZone getTimeZone() {
        return this.timezone;
    }

    /**
     * 是否支持秒匹配。
     *
     * @return {@code true}使用，{@code false}不使用
     */
    public boolean isMatchSecond() {
        return this.matchSecond;
    }

    /**
     * 设置是否支持秒匹配，默认不使用。
     *
     * @param isMatchSecond {@code true}支持，{@code false}不支持
     * @return this
     */
    public CronConfig setMatchSecond(final boolean isMatchSecond) {
        this.matchSecond = isMatchSecond;
        return this;
    }
}
