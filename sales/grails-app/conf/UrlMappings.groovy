class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')

        "/clients"(controller: "client"){
            action = [GET: "get"]
        }

        "/clients/byname"(controller: "client"){
            action = [GET: "getByName"]
        }

        "/products"(controller: "product"){
            action = [GET: "get"]
        }

        "/products/byname"(controller: "product"){
            action = [GET: "getByName"]
        }
	}
}
