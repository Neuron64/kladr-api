package org.neuron64.kladr.api;

/**
 * Created by neuron on 21.05.17.
 */
public abstract class Action<T> {

    public abstract void handle(Exception exception);

    public abstract void perform(T responseData);
}