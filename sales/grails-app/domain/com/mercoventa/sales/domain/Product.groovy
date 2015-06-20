package com.mercoventa.sales.domain

class Product {

	String productId
	String name

    static constraints = {
    	productId(blank:false, nullable:false)
    	name(blank:false, nullable:false)
    }

    static mapping = {
        id name:'productId', generator:'assigned'
    }

    String toString () {
        "Product: {product_id:${productId}, name:${name}}"
    }

    boolean equals (other) {
        other && other in Product && other.productId == productId
    }

    int hashCode () {
        productId.hashCode()
    }
}
