modules = {
	application {
		resource url:'js/application.js'
		resource url:'js/sales.js'
	}

    bootstrap {
    	resource url: [dir:'js', file:'bootstrap.min.js'], disposition: 'defer'
    	resource url: [dir:'css', file:'bootstrap.min.css'], disposition: 'head'
    }

    angular {
    	dependsOn 'bootstrap'
    	resource url: [dir:'js', file:'angular.min.js'], disposition: 'defer'
    }

    angularUi {
    	dependsOn 'angular'
    	resource url: [dir:'js', file:'ui-bootstrap-tpls-0.13.0.min.js'], disposition: 'defer'
    }

    salesApp {
    	dependsOn 'angularUi'
    }
}