package com.example.commerce.product.event;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalesProduct {
	private int id;
	private String code;
	private String name;
	private int unitPrice;
}
