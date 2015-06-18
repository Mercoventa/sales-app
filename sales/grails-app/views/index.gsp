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

        <h4>Static arrays</h4>
        <pre>Model: {{selected | json}}</pre>
        <input type="text" ng-model="selected" typeahead="state for state in states | filter:$viewValue | limitTo:8" class="form-control">

        <h4>Asynchronous results</h4>
        <pre>Model: {{asyncSelected | json}}</pre>
        <input type="text" ng-model="asyncSelected" placeholder="Locations loaded via $http" typeahead="address for address in getLocation($viewValue)" typeahead-loading="loadingLocations" class="form-control">
        <i ng-show="loadingLocations" class="glyphicon glyphicon-refresh"></i>

        <h4>Custom templates for results</h4>
        <pre>Model: {{customSelected | json}}</pre>
        <input type="text" ng-model="customSelected" placeholder="Custom template" typeahead="state as state.name for state in statesWithFlags | filter:{name:$viewValue}" typeahead-template-url="customTemplate.html" class="form-control">
    </div>
  <r:layoutResources/>
  </body>
</html>
