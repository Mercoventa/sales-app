package com.mercoventa.sales.controller

import com.mercoventa.sales.domain.Client
import grails.converters.JSON

class ClientController {

	def clientService

    def get() {
    	def clients = clientService.getAllClients()

    	render(contentType: "application/json") {
    		[count:clients.size(), clients:clients]
	    }
    }
}
