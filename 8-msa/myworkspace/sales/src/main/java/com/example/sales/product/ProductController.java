package com.example.sales.product;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	private ProductService service;

	public ProductController(ProductService service) {
		this.service = service;
	}

	@PostMapping(value = "/products")
	public Product addProduct(@RequestBody Product product) {

		// 데이터 검증
		// db에 저장 repo.save(product)
		Product product = Product.builder().id(1).name(productRequest.getName()).code(procuctRequest)

		// event 외부 시스템에 추가된 데이터 보내기
		service.sendProduct(product);
		return product;
	}
}
