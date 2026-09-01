package cc.hongz.ztools.cron;

import cc.hongz.ztools.core.util.StrUtil;

/**
 * 定时任务异常。
 *
 * @author xiaoleilu
 */
public class CronException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * 构造。
     *
     * @param e 异常
     */
    public CronException(final Throwable e) {
        super(e.getMessage(), e);
    }

    /**
     * 构造。
     *
     * @param message 错误信息
     */
    public CronException(final String message) {
        super(message);
    }

    /**
     * 构造。
     *
     * @param messageTemplate 消息模板
     * @param params          参数
     */
    public CronException(final String messageTemplate, final Object... params) {
        super(StrUtil.format(messageTemplate, params));
    }

    /**
     * 构造。
     *
     * @param message            错误信息
     * @param throwable          异常
     * @param enableSuppression  是否启用抑制
     * @param writableStackTrace 是否可写堆栈
     */
    public CronException(final String message, final Throwable throwable, final boolean enableSuppression,
                         final boolean writableStackTrace) {
        super(message, throwable, enableSuppression, writableStackTrace);
    }

    /**
     * 构造。
     *
     * @param throwable       异常
     * @param messageTemplate 消息模板
     * @param params          参数
     */
    public CronException(final Throwable throwable, final String messageTemplate, final Object... params) {
        super(StrUtil.format(messageTemplate, params), throwable);
    }
}
