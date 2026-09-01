package cc.hongz.ztools.cron.listener;

import cc.hongz.ztools.cron.TaskExecutor;
import cc.hongz.ztools.log.StaticLog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 监听调度器，统一管理监听。
 * @author Looly
 *
 */
public class TaskListenerManager implements Serializable {
    private static final long serialVersionUID = 1L;

    private final List<TaskListener> listeners = new ArrayList<>();

    /**
     * 增加监听器。
     * @param listener {@link TaskListener}
     * @return this
     */
    public TaskListenerManager addListener(final TaskListener listener) {
        synchronized (listeners) {
            this.listeners.add(listener);
        }
        return this;
    }

    /**
     * 移除监听器。
     * @param listener {@link TaskListener}
     * @return this
     */
    public TaskListenerManager removeListener(final TaskListener listener) {
        synchronized (listeners) {
            this.listeners.remove(listener);
        }
        return this;
    }

    /**
     * 通知所有监听任务启动器启动。
     * @param executor {@link TaskExecutor}
     */
    public void notifyTaskStart(final TaskExecutor executor) {
        synchronized (listeners) {
            TaskListener listener;
            for (TaskListener taskListener : listeners) {
                listener = taskListener;
                if (null != listener) {
                    listener.onStart(executor);
                }
            }
        }
    }

    /**
     * 通知所有监听任务启动器成功结束。
     * @param executor {@link TaskExecutor}
     */
    public void notifyTaskSucceeded(final TaskExecutor executor) {
        synchronized (listeners) {
            for (TaskListener listener : listeners) {
                listener.onSucceeded(executor);
            }
        }
    }

    /**
     * 通知所有监听任务启动器结束并失败。 <br>
     * 无监听将打印堆栈到命令行
     * @param executor {@link TaskExecutor}
     * @param exception 失败原因
     */
    public void notifyTaskFailed(final TaskExecutor executor, final Throwable exception) {
        synchronized (listeners) {
            int size = listeners.size();
            if (size > 0) {
                for (TaskListener listener : listeners) {
                    listener.onFailed(executor, exception);
                }
            } else {
                StaticLog.error(exception, exception.getMessage());
            }
        }
    }
}
