package com.mercoventa.sales.controller

import com.mercoventa.sales.domain.Product
import grails.converters.JSON

class ProductController {

	def productService

    def get() {
    	def products = productService.getAllProducts()

    	render(contentType: "application/json") {
    		[count:products.size(), results:products]
	    }
    }

    def getByName() {

    	def products = productService.findByNameLike(params.productName)

    	render(contentType: "application/json") {
    		[count:products?.size(), results:products]
    	}
    }
}
