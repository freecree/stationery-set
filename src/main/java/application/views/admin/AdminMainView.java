package application.views.admin;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import application.views.MainLayout;
import config.SpringConfig;
import controllers.ProductController;
import models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import services.ProductService;
import services.ProductServiceImpl;

@Component
@Route(value = "admin", layout = MainLayout.class)
@PageTitle("admin")
public class AdminMainView extends Div {
    //@Autowired
    private ProductService productService;

    private Grid<Product> productsGrid = new Grid<>(Product.class);

    public AdminMainView( @Autowired ProductService productService) {
        addClassName("about-view");
        //add(new Text("Content placeholder"));

//        productsGrid.setDataProvider(new ListDataProvider<>(productService.getProducts()));
        createGridColumns();
        add(productsGrid);
        System.out.println(productService);
        productsGrid.setItems(productService.getProducts());
        //productsGrid.setItems(productService.getProducts());
    }
    private void createGridColumns() {
        productsGrid.addColumn(Product::getId).setHeader("Id").setWidth("70px").setFlexGrow(0);
        productsGrid.addColumn(Product::getName).setHeader("Name").setWidth("120px").setAutoWidth(true);
    }

}