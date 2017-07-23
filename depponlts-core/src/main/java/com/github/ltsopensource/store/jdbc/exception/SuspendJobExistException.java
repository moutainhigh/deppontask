package com.github.ltsopensource.store.jdbc.exception;
/**
 * 暂停任务队异常
 * @author chenhaitao 333930
 */
@SuppressWarnings("serial")
public class SuspendJobExistException extends JdbcException{

	public SuspendJobExistException() {
		super();
	}

	public SuspendJobExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public SuspendJobExistException(String message) {
		super(message);
	}

	public SuspendJobExistException(Throwable cause) {
		super(cause);
	}

}
