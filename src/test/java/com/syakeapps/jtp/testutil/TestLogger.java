package com.syakeapps.jtp.testutil;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;

@SuppressWarnings("serial")
public class TestLogger extends MarkerIgnoringBase {

    private List<String> events = new ArrayList<>();

    public List<String> getEvents() {
        return events;
    }

    @Override
    public boolean isTraceEnabled() {
        return true;
    }

    @Override
    public void trace(String msg) {
        addEvent(msg);
    }

    @Override
    public void trace(String format, Object arg) {
        FormattingTuple tuple = format(format, arg, null);
        trace(tuple.getMessage());
    }

    @Override
    public void trace(String format, Object arg1, Object arg2) {
        FormattingTuple tuple = format(format, arg1, arg2, null);
        trace(tuple.getMessage());
    }

    @Override
    public void trace(String format, Object... arguments) {
        FormattingTuple tuple = format(format, arguments, null);
        trace(tuple.getMessage());
    }

    @Override
    public void trace(String msg, Throwable t) {
        trace(String.format("%s: %s", msg, t.getClass().getName()));
    }

    @Override
    public boolean isDebugEnabled() {
        return true;
    }

    @Override
    public void debug(String msg) {
        trace(msg);
    }

    @Override
    public void debug(String format, Object arg) {
        FormattingTuple tuple = format(format, arg, null);
        debug(tuple.getMessage());
    }

    @Override
    public void debug(String format, Object arg1, Object arg2) {
        FormattingTuple tuple = format(format, arg1, arg2, null);
        debug(tuple.getMessage());
    }

    @Override
    public void debug(String format, Object... arguments) {
        FormattingTuple tuple = format(format, arguments, null);
        debug(tuple.getMessage());
    }

    @Override
    public void debug(String msg, Throwable t) {
        debug(String.format("%s: %s", msg, t.getClass().getName()));
    }

    @Override
    public boolean isInfoEnabled() {
        return true;
    }

    @Override
    public void info(String msg) {
        trace(msg);
    }

    @Override
    public void info(String format, Object arg) {
        trace(format, arg);
    }

    @Override
    public void info(String format, Object arg1, Object arg2) {
        trace(format, arg1, arg2);
    }

    @Override
    public void info(String format, Object... arguments) {
        trace(format, arguments);
    }

    @Override
    public void info(String msg, Throwable t) {
        info(String.format("%s: %s", msg, t.getClass().getName()));
    }

    @Override
    public boolean isWarnEnabled() {
        return true;
    }

    @Override
    public void warn(String msg) {
        trace(msg);
    }

    @Override
    public void warn(String format, Object arg) {
        FormattingTuple tuple = format(format, arg, null);
        warn(tuple.getMessage());
    }

    @Override
    public void warn(String format, Object arg1, Object arg2) {
        FormattingTuple tuple = format(format, arg1, arg2, null);
        warn(tuple.getMessage());
    }

    @Override
    public void warn(String format, Object... arguments) {
        FormattingTuple tuple = format(format, arguments, null);
        warn(tuple.getMessage());
    }

    @Override
    public void warn(String msg, Throwable t) {
        warn(String.format("%s: %s", msg, t.getClass().getName()));
    }

    @Override
    public boolean isErrorEnabled() {
        return true;
    }

    @Override
    public void error(String msg) {
        trace(msg);
    }

    @Override
    public void error(String format, Object arg) {
        FormattingTuple tuple = format(format, arg, null);
        error(tuple.getMessage());
    }

    @Override
    public void error(String format, Object arg1, Object arg2) {
        FormattingTuple tuple = format(format, arg1, arg2, null);
        error(tuple.getMessage());
    }

    @Override
    public void error(String format, Object... arguments) {
        FormattingTuple tuple = format(format, arguments, null);
        error(tuple.getMessage());
    }

    @Override
    public void error(String msg, Throwable t) {
        error(String.format("%s: %s", msg, t.getClass().getName()));
    }

    private FormattingTuple format(String format, Object... arguments) {
        return MessageFormatter.arrayFormat(format, arguments);
    }

    private void addEvent(String msg) {
        events.add(msg);
    }
}