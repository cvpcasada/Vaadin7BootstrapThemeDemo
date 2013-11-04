package com.digitallabs.demos.ui.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * There is a circular reference between View and Presenter. It is typical
 * for MVP, but Spring guys don't like it. Only singleton beans may have circular reference.
 * Then, one side of relation must be proxy. View cannot be proxy because Vaadin is really confused.
 * Simply, Presenter must be the proxy.
 *
 * Presenters in a MVP apps do not have UI framework dependencies so that it is Test Driven (TDD) ready
 *
 * User: cyrus
 * Date: 11/3/13
 * Time: 12:56 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MainPresenter {
    @Autowired
    private MainView mainView;

    public void buttonClicked() {

        String message = "This is a message, typically this will came from a DAO / or Model in a MVP type architecture";

        mainView.showMessage(message);
    }


}
