package com.mercoventa.sales.domain

class Order {

	static hasMany = [items: OrderItem]
	Client client

    static constraints = {
    	client(blank:false, nullable:false)
    }

    static mapping = {
        table 'mv_order'
    }

    String toString () {
        "Order: {client_id:${client}, items:${items}}"
    }
}
