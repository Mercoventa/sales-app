package com.mercoventa.sales.service

import grails.transaction.Transactional
import com.mercoventa.sales.domain.Client

@Transactional
class ClientService {

    def getClient(clientId) {
    	Client.findByClientId(clientId)
    }

    def findByName(clientName) {
    	Client.findByName(clientName)
    }

    def findByTradeName(clientTradeName) {
    	Client.findByTradeName(clientTradeName)
    }

    def createClient(clientData) {
    	new Client(clientData).save(flush:true, failOnError:true)
    }

    def getAllClients() {
    	Client.list()
    }
}
