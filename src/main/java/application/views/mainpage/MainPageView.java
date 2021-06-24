package application.views.mainpage;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import application.views.MainLayout;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "hello", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@PageTitle("Stationary set")
public class MainPageView extends HorizontalLayout {

    private TextField name;
    private Button sayHello;

    public MainPageView() {
        addClassName("hello-world-view");
        name = new TextField("Your name print!!");
        sayHello = new Button("Say bye");
        add(name, sayHello);
        setVerticalComponentAlignment(Alignment.END, name, sayHello);
        sayHello.addClickListener(e -> {
            Notification.show("Hello " + name.getValue());
        });
    }

}
