package com.mercoventa.sales.domain

class OrderItem {

	int quantity
	Product product

    static constraints = {
    	product(blank:false, nullable:false)
    	quantity(blank:false, nullable:false)
    }

    String toString () {
        "OrderItem: {product:${product}, quantity:${quantity}}"
    }
}
