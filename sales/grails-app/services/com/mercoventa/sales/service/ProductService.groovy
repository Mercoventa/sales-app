package com.mercoventa.sales.service

import grails.transaction.Transactional
import com.mercoventa.sales.domain.Product

@Transactional
class ProductService {

    def getClient(productId) {
    	Product.findByProductId(clientId)
    }

    def findByName(productName) {
    	Product.findAllByName(productName)
    }

    def findByNameLike(productName) {
        def split = productName.split(' ').join('%')
        Product.findAllByNameIlike("%${split}%", [max:10])
    }

    def createProduct(productData) {
    	new Product(productData).save(flush:true, failOnError:true)
    }

    def getAllProducts() {
    	Product.list()
    }
}
