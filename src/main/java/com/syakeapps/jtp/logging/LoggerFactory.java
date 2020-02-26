package com.syakeapps.jtp.logging;

import java.util.Locale;

import org.slf4j.cal10n.LocLogger;
import org.slf4j.cal10n.LocLoggerFactory;

import ch.qos.cal10n.IMessageConveyor;
import ch.qos.cal10n.MessageConveyor;

public class LoggerFactory {

    public static LocLogger getLogger(Class<?> clazz) {
        return getLogger(clazz, Locale.getDefault());
    }

    private static LocLogger getLogger(Class<?> clazz, Locale loc) {
        IMessageConveyor conveyor = new MessageConveyor(loc);
        return new LocLoggerFactory(conveyor).getLocLogger(clazz);
    }
}
