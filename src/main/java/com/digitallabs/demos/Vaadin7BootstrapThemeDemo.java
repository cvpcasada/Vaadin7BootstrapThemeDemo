package com.digitallabs.demos;

import com.digitallabs.demos.ui.main.MainView;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.xpoft.vaadin.DiscoveryNavigator;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
@Theme("bootstrap")
@Component
@Scope("prototype")
public class Vaadin7BootstrapThemeDemo extends UI
{
    @Autowired
    private transient ApplicationContext applicationContext;


    @Override
    protected void init(final VaadinRequest request) {

        setSizeFull();

        DiscoveryNavigator navigator = new DiscoveryNavigator(this, this);
        navigator.navigateTo(MainView.NAME);


    }



}
