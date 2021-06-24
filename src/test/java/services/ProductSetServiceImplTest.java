package services;

import config.SpringConfig;
import models.ProductSet;
//import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ProductSetServiceImplTest {
    private static AnnotationConfigApplicationContext context;
    private static ProductSetService productSetService;
    final private static ProductSet productSet1 = new ProductSet();

    @BeforeAll
    static void setUp() {
        context = new AnnotationConfigApplicationContext(SpringConfig.class);
        productSetService = context.getBean("productSetServiceImpl", ProductSetService.class);
        productSet1.setName("set1");
    }

    @Test
    @DisplayName("testing for creating and getting productSet by id")
    public void getProductById() {
        //GIVEN
        ProductSet expectedProductSet = productSetService.createSet(productSet1);
        //WHEN
        ProductSet actualProductSet = productSetService.getSetById(expectedProductSet.getId());
        //THEN
        Assertions.assertEquals(expectedProductSet, actualProductSet);
        productSetService.deleteSet(expectedProductSet);
    }

    @Test
    @DisplayName("testing for adding product to productSet")
    public void addProductToSet() {
//        //GIVEN
//        Product product = new Product();
//        product.setName("product");
//        ProductSet expectedProductSet = productSetService.createSet(productSet1);
//        JSONObject expectedJson = new JSONObject();
//        expectedJson.put("id", product.getId());
//        expectedJson.put("amount", 5);
//
//        //WHEN
//        productSetService.addProductToSet(expectedProductSet.getId(), product, 5);
//        ProductSet actualProductSet = productSetService.getSetById(expectedProductSet.getId());
//        //ProductSet actualProductSet = productSetService.getSetById(expectedProductSet.getId());
//        //THEN
//        Assertions.assertEquals(expectedJson.toJSONString(), actualProductSet.getProducts());
//        //productSetService.deleteSet(expectedProductSet);
    }

}