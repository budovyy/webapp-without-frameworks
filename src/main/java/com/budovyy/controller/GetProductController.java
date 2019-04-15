package com.budovyy.controller;

import com.budovyy.web.Request;
import com.budovyy.web.ViewModel;
import com.budovyy.service.ProductService;

import static java.util.Collections.emptyList;


public class  GetProductController implements Controller {

    private ProductService productService;

    public GetProductController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ViewModel process(Request req) {
        String param = req.getParam("p_id")[0];
        Long id = Long.parseLong(param);

        return productService.getProduct(id)
                .map(p -> ViewModel.of("product").withAttribute("product", p))
                .orElseGet(() -> ViewModel.of("404"));  // () -> ViewModel.of("product").withAttribute("product", emptyList())
    }
}
