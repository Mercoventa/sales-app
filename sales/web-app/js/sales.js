angular.module('sales', ['ui.bootstrap']);
angular.module('sales').controller('MainCtrl', function($scope, $http) {

  $scope.selected = undefined;
  // Any function returning a promise object can be used to load values asynchronously
  $scope.getProduct = function(val) {
    return $http.get('http://localhost:8080/sales/products/byname', {
      params: {
        productName: val,
      }
    }).then(function(response){
      return response.data.results.map(function(product){
        return product.name;
      });
    });
  };
});