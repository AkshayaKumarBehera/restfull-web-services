package com.akki.rest.webservices.restfullwebservices.services;

import com.akki.rest.webservices.restfullwebservices.dao.ProductDaoImpl;
import com.akki.rest.webservices.restfullwebservices.model.PriceModel;
import com.akki.rest.webservices.restfullwebservices.model.ProductModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    ProductDaoImpl productDaoImplMock;

    @InjectMocks
    ProductServiceImpl productServiceImplMock;

    @Test
    public void findAllTest() {
        List<ProductModel> productList = new ArrayList<>();
        productList.add(new ProductModel(100, "Prod1", "Seller1","manufacturer1",new PriceModel(100,"2-3",new Double(2.00),new Double(3.00))));
        productList.add(new ProductModel(200, "Prod2", "Seller2","manufacturer2",new PriceModel(200,"3-4",new Double(3.00),new Double(4.00))));
        productList.add(new ProductModel(300, "Prod3", "Seller3","manufacturer3", new PriceModel(300,"4-5",new Double(4.00),new Double(5.00))));
        Mockito.when(productDaoImplMock.findAll()).thenReturn(productList);
        assertEquals(productList, productServiceImplMock.findAll());

        assertEquals(3, productDaoImplMock.findAll().toArray().length);
        List<ProductModel>  productModels = productServiceImplMock.findAll();
        assertThat(productModels.size()).isEqualTo(3);

        //For all Products
        assertAll("productList",
                () -> assertEquals(productModels.get(0).getProduct_id(),100),
                () -> assertEquals(productModels.get(0).getTitle(), "Prod1"),
                () -> assertEquals(productModels.get(0).getManufacturer(), "manufacturer1"),
                () -> assertEquals(productModels.get(0).getSeller_Id(),"Seller1"),
                () -> assertEquals(productModels.get(0).getPriceModel().getMaxPrice(), 3),
                () -> assertEquals(productModels.get(0).getPriceModel().getMinPrice(), 2),
                () -> assertEquals(productModels.get(0).getPriceModel().getRange(), "2-3"),

                () -> assertEquals(productModels.get(1).getProduct_id(),200)
        );
    }

    @Test
    public void saveTest(){
        ProductModel productModel = new ProductModel();
        productModel.setProduct_id(100);
        productModel.setTitle("Prod1");
        productModel.setSeller_Id("Seller1");
        productModel.setManufacturer("manufacturer1");

        PriceModel newPriceModel = new PriceModel(100, "2-3",new Double(2) ,new Double(3));
        productModel.setPriceModel(newPriceModel);

        Mockito.when(productDaoImplMock.save(productModel)).thenReturn(productModel);
        assertEquals(productModel, productServiceImplMock.save(productModel));

        ProductModel newProduct = productServiceImplMock.save(productModel);

        assertAll("new product",
                () -> assertEquals(newProduct.getProduct_id(),100),
                () -> assertEquals(newProduct.getTitle(), "Prod1"),
                () -> assertEquals(newProduct.getManufacturer(), "manufacturer1"),
                () -> assertEquals(newProduct.getSeller_Id(),"Seller1"),
                () -> assertEquals(newProduct.getPriceModel().getMaxPrice(), 3),
                () -> assertEquals(newProduct.getPriceModel().getMinPrice(), 2),
                () -> assertEquals(newProduct.getPriceModel().getRange(), "2-3")
        );
    }

    @Test
    public void updateProductTest(){
        Integer id = 100;

        ProductModel productModel = new ProductModel();
        productModel.setProduct_id(100);
        productModel.setTitle("Prod1");
        productModel.setSeller_Id("Seller1");
        productModel.setManufacturer("manufacturer1");

        PriceModel newPriceModel = new PriceModel(100, "2-3",new Double(2) ,new Double(3));
        productModel.setPriceModel(newPriceModel);

        Mockito.when(productDaoImplMock.updateProduct(id, productModel)).thenReturn(productModel);
        assertEquals(productModel, productServiceImplMock.updateProduct(id, productModel));
    }

    @Test
    public void deleteByIdTest(){
        Integer id = 100;
        ProductModel productModel = new ProductModel();
        productModel.setProduct_id(100);
        productModel.setTitle("Prod1");
        productModel.setSeller_Id("Seller1");
        productModel.setManufacturer("manufacturer1");

        Mockito.when(productDaoImplMock.deleteById(id)).thenReturn(productModel);
        assertEquals(productModel, productServiceImplMock.deleteById(id));
    }

    @Test
    public void findOneTest(){
        Integer id = 100;
        ProductModel productModel = new ProductModel();
        productModel.setProduct_id(100);
        productModel.setTitle("Prod1");
        productModel.setSeller_Id("Seller1");
        productModel.setManufacturer("manufacturer1");

        PriceModel newPriceModel = new PriceModel(100, "2-3",new Double(2) ,new Double(3));
        productModel.setPriceModel(newPriceModel);

        Mockito.when(productDaoImplMock.findOne(id)).thenReturn(productModel);
        assertEquals(productModel, productServiceImplMock.findOne(id));
    }

}
