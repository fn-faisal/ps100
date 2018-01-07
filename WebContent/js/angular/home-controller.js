/**
 * 
 */

var app = angular.module("homeApp",[]);

app.controller("homeController", function($scope, $interval){
	$scope.current = 1;
	$scope.galleryLength = $(".gallery-container img").length;
	$scope.hideButIndex = function(index){
		for ( var i = 0 ; i < $scope.galleryLength ; i++ ){
			if( $scope.current == i ){
				$(".gallery-container img").eq($scope.current).show();
			}else{
				$(".gallery-container img").eq(i).hide();
			}
		}
	};
	$scope.nextImage = $interval(function(){
		if ( $scope.current == $scope.galleryLength-1 )
			$scope.current = -1;
		$scope.current++;
		$scope.hideButIndex($scope.current);
	}, 2000);
	
	
});