package com.mercoventa.sales.domain

class Client {

	String clientId
	String name
	String tradeName // Razon social

    static constraints = {
    	clientId(blank:false, nullable:false, unique:true)
    	name(blank:false, nullable:false)
    	tradeName(blank:false, nullable:false)
    }

    static mapping = {

    }
}
