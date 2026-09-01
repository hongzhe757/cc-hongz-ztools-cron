package cc.hongz.ztools.cron.listener;

import cc.hongz.ztools.cron.TaskExecutor;

/**
 * 简单监听实现，不做任何操作。 <br>
 * 继承此监听后实现需要的方法即可
 * @author Looly
 *
 */
public class SimpleTaskListener implements TaskListener {

    @Override
    public void onStart(final TaskExecutor executor) {
    }

    @Override
    public void onSucceeded(final TaskExecutor executor) {
    }

    @Override
    public void onFailed(final TaskExecutor executor, final Throwable exception) {
    }

}
