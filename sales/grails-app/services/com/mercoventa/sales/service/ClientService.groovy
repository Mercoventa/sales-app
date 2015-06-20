package com.mercoventa.sales.service

import grails.transaction.Transactional
import com.mercoventa.sales.domain.Client

@Transactional
class ClientService {

    def getClient(clientId) {
    	Client.findByClientId(clientId)
    }

    def findByName(clientName) {
    	Client.findAllByName(clientName)
    }

    def findByTradeName(clientTradeName) {
    	Client.findAllByTradeName(clientTradeName)
    }

    def findByNameLike(clientName) {
        Client.findAllByNameIlike("%${clientName}%")
    }

    def findByTradeNameLike(clientTradeName) {
        Client.findAllByTradeNameIlike("%${clientTradeName}%")
    }

    def createClient(clientData) {
    	new Client(clientData).save(flush:true, failOnError:true)
    }

    def getAllClients() {
    	Client.list()
    }
}
