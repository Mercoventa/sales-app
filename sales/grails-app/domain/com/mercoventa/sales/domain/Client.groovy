package com.mercoventa.sales.domain

class Client {

	String clientId
	String name
	String tradeName // Razon social

    static constraints = {
    	clientId(blank:false, nullable:false)
    	name(blank:false, nullable:false)
    	tradeName(blank:false, nullable:false)
    }

    static mapping = {
        id name:'clientId', generator:'assigned'
    }

    String toString () {
        "Client: {client_id:${clientId}, name:${name}, trade_name:${tradeName}}"
    }

    boolean equals (other) {
        other && other in Client && other.clientId == clientId
    }

    int hashCode () {
        clientId.hashCode()
    }
}
