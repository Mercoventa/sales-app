<!doctype html>
<html ng-app="sales">
  <head>
    <r:require modules="salesApp"/>
    <r:layoutResources/>
  </head>
  <body>
    <script type="text/ng-template" id="customTemplate.html">
      <a>
          <img ng-src="http://upload.wikimedia.org/wikipedia/commons/thumb/{{match.model.flag}}" width="16">
          <span bind-html-unsafe="match.label | typeaheadHighlight:query"></span>
      </a>
    </script>
    <div class='container-fluid' ng-controller="MainCtrl">
        <h4>Asynchronous results</h4>
        <pre>Model: {{asyncSelected | json}}</pre>
        <input type="text" ng-model="asyncSelected" placeholder="Locations loaded via $http" typeahead="address for address in getProduct($viewValue)" typeahead-loading="loadingProducts" class="form-control">
        <i ng-show="loadingProducts" class="glyphicon glyphicon-refresh"></i>
    </div>
  <r:layoutResources/>
  </body>
</html>
