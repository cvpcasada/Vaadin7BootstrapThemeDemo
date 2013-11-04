package com.digitallabs.demos.ui.main;

import com.digitallabs.demos.theme.Bootstrap;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.xpoft.vaadin.VaadinView;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA.
 * User: cyrus
 * Date: 11/2/13
 * Time: 10:57 AM
 * To change this template use File | Settings | File Templates.
 *
 * Prototype scopes create new instance for each new page
 * Session scope ( similar to @PreserveOnRefresh ) stores UI to session
 */

@Component
@VaadinView(value = MainView.NAME)
@Scope("prototype")
public class MainView extends CustomComponent implements View {
    public static final String NAME = "main";

    @Autowired
    private MainPresenter presenter;


    @PostConstruct
    public void PostConstruct() {
        CssLayout container = new CssLayout();
        // Needed in order for contained components to size properly
        container.setWidth("100%");
        container.addStyleName("container");

        typography(container);
        tables(container);
        forms(container);

        tabs(container);
        subWindow();

        buttons(container);



        setSizeFull();
        setCompositionRoot(container);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }

    private void typography(CssLayout container) {
        for (int i = 1; i <= 6; i++) {
            Label header = new Label("Bootstrap heading <h" + i + ">");
            header.addStyleName(Bootstrap.Typography.valueOf("H" + i)
                    .styleName());
            container.addComponent(header);
        }

        Label text = new Label(
                "Nullam quis risus eget urna mollis ornare vel eu leo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam id dolor id nibh ultricies vehicula.");
        text.addStyleName(Bootstrap.Typography.BODYCOPY.styleName());
        container.addComponent(text);

        text = new Label(
                "Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec ullamcorper nulla non metus auctor fringilla. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Donec ullamcorper nulla non metus auctor fringilla.");
        text.addStyleName(Bootstrap.Typography.BODYCOPY.styleName());
        container.addComponent(text);

        text = new Label(
                "Maecenas sed diam eget risus varius blandit sit amet non magna. Donec id elit non mi porta gravida at eget metus. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit.");
        text.addStyleName(Bootstrap.Typography.BODYCOPY.styleName());
        container.addComponent(text);

        text = new Label(
                "Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Duis mollis, est non commodo luctus.");
        text.addStyleName(Bootstrap.Typography.LEAD.styleName());
        container.addComponent(text);

        text = new Label(
                "Maecenas sed diam eget risus varius blandit sit amet non magna. Donec id elit non mi porta gravida at eget metus. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit.");
        text.addStyleName(Bootstrap.Typography.SMALL.styleName());
        container.addComponent(text);

        text = new Label("Left aligned text");
        text.addStyleName(Bootstrap.Typography.TEXT_LEFT.styleName());
        container.addComponent(text);

        text = new Label("Center aligned text");
        text.addStyleName(Bootstrap.Typography.TEXT_CENTER.styleName());
        container.addComponent(text);

        text = new Label("Right aligned text");
        text.addStyleName(Bootstrap.Typography.TEXT_RIGHT.styleName());
        container.addComponent(text);

        // Colors

        text = new Label(
                "Muted. Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.");
        text.addStyleName(Bootstrap.Typography.TEXT_MUTED.styleName());
        container.addComponent(text);

        text = new Label(
                "Primary. Nullam id dolor id nibh ultricies vehicula ut id elit.");
        text.addStyleName(Bootstrap.Typography.TEXT_PRIMARY.styleName());
        container.addComponent(text);

        text = new Label(
                "Warning. Nullam id dolor id nibh ultricies vehicula ut id elit.");
        text.addStyleName(Bootstrap.Typography.TEXT_WARNING.styleName());
        container.addComponent(text);

        text = new Label(
                "Danger. Nullam id dolor id nibh ultricies vehicula ut id elit.");
        text.addStyleName(Bootstrap.Typography.TEXT_DANGER.styleName());
        container.addComponent(text);

        text = new Label(
                "Success. Nullam id dolor id nibh ultricies vehicula ut id elit.");
        text.addStyleName(Bootstrap.Typography.TEXT_SUCCESS.styleName());
        container.addComponent(text);

        text = new Label(
                "Info. Nullam id dolor id nibh ultricies vehicula ut id elit.");
        text.addStyleName(Bootstrap.Typography.TEXT_INFO.styleName());
        container.addComponent(text);
    }

    private void tables(CssLayout container) {
        Table table = getSampleTable("");
        container.addComponent(table);

        table = getSampleTable("Striped");
        table.addStyleName(Bootstrap.Tables.STRIPED.styleName());
        container.addComponent(table);

        table = getSampleTable("Bordered");
        table.addStyleName(Bootstrap.Tables.BORDERED.styleName());
        container.addComponent(table);

        table = getSampleTable("Hover rows");
        table.addStyleName(Bootstrap.Tables.HOVER.styleName());
        container.addComponent(table);

        table = getSampleTable("Condensed");
        table.addStyleName(Bootstrap.Tables.CONDENSED.styleName());
        container.addComponent(table);
    }

    private Table getSampleTable(String caption) {
        Table table = new Table(caption);
        table.setWidth("100%");
        table.setHeight(null);
        table.setPageLength(0);
        table.setRowHeaderMode(Table.RowHeaderMode.INDEX);

        table.addContainerProperty("First Name", String.class, null);
        table.addContainerProperty("Last Name", String.class, null);
        table.addContainerProperty("Username", String.class, null);

        table.addItem(new Object[] { "Mark", "Otto", "@mdo" }, "mark");
        table.addItem(new Object[] { "Jacob", "Thornton", "@fat" }, "jacob");
        table.addItem(new Object[] { "Larry", "the Bird", "@twitter" }, "larry");
        return table;
    }

    private void forms(CssLayout container) {
        VerticalLayout form = new VerticalLayout();
        form.addStyleName(Bootstrap.Forms.FORM.styleName());
        form.setSpacing(true);
        form.setCaption("Legend");

        TextField email = new TextField("Email address");
        email.setInputPrompt("Enter email");
        form.addComponent(email);

        PasswordField password = new PasswordField("Password");
        password.setInputPrompt("Password");
        form.addComponent(password);

        Upload upload = new Upload("File input", null);
        form.addComponent(upload);

        Label help = new Label("Example block-level help text here.");
        help.addStyleName("help-block");
        form.addComponent(help);

        CheckBox check = new CheckBox("Check me out");
        form.addComponent(check);

        ListSelect select = new ListSelect("Select");
        form.addComponent(select);

        ListSelect multiSelect = new ListSelect("Multi Select");
        multiSelect.setMultiSelect(true);
        form.addComponent(multiSelect);

        NativeSelect nativeSelect = new NativeSelect("Native select");
        form.addComponent(nativeSelect);

        for (int i = 0; i < 5; i++) {
            String s = "Select "  + i;

            select.addItem(s);
            multiSelect.addItem(s);
            nativeSelect.addItem(s);
        }




        DateField dateField = new DateField("Date Field");
        form.addComponent(dateField);


        Button submit = new Button("Submit");
        submit.addStyleName(Bootstrap.Buttons.DEFAULT.styleName());
        form.addComponent(submit);

        container.addComponent(form);
    }

    private void buttons(CssLayout container) {
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);
        buttons.setMargin(true);
        container.addComponent(buttons);

        Button normal = new Button("Default");
        normal.addStyleName(Bootstrap.Buttons.DEFAULT.styleName());

        Button primary = new Button("Primary");
        primary.addStyleName(Bootstrap.Buttons.PRIMARY.styleName());

        Button success = new Button("Success");
        success.addStyleName(Bootstrap.Buttons.SUCCESS.styleName());

        Button info = new Button("Info");
        info.addStyleName(Bootstrap.Buttons.INFO.styleName());

        Button warning = new Button("Warning");
        warning.addStyleName(Bootstrap.Buttons.WARNING.styleName());

        Button danger = new Button("Danger");
        danger.addStyleName(Bootstrap.Buttons.DANGER.styleName());

        Button link = new Button("Link");
        link.addStyleName(Bootstrap.Buttons.LINK.styleName());

        buttons.addComponents(normal, primary, info, success, warning, danger,
                link);


        Button[] buttonsArr = {normal,primary,info,success,warning,danger};

        for (Button button : buttonsArr) {
            button.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent clickEvent) {
                    presenter.buttonClicked();
                }
            });
        }
    }

    public void tabs(CssLayout container)  {
        TabSheet tabSheet =  new TabSheet();
        tabSheet.setCaption("Tabsheet");
        container.addComponent(tabSheet);

        for (int i = 0; i < 3; i++) {

            Panel p = new Panel("Tab " + (i + 1));

            p.setContent(new Label("Nullam quis risus eget urna mollis ornare vel eu leo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam id dolor id nibh ultricies vehicula."));

            tabSheet.addTab(p);
        }
    }

    public void subWindow() {
        Window window = new Window("Sub Window");
        window.setHeight("300px"); window.setWidth("300px");

        UI.getCurrent().addWindow(window);
    }

    public void showMessage(String message) {
         Notification.show(message);
    }
}
