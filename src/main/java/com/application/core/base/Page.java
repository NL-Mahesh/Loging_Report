package com.application.core.base;

import org.openqa.selenium.support.ui.ExpectedCondition;

public interface Page<T> {
	
	public abstract T getDriver();
	
	public abstract <T> T waitFor(ExpectedCondition<T> waitCondition, long timeOut);
	
	public abstract <T> T waitFor(ExpectedCondition<T> waitCondition);

}
