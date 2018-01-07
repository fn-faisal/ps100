package controller.jsf;

import java.util.ArrayList;

public class Application {

	private final String APP_NAME = "Photo Booth";
	
	
	public Application(){}
	
	public String getAppName(){
		return APP_NAME;
	}
	
	public String getCommonLinks(){
		return "<link href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' type='text/css' rel='stylesheet' />"
			+ " <link href='css/page.css' type='text/css' rel='stylesheet' />"
			+ " <meta name='viewport' content=' width = device-width, initial-scale = 1.0 ' />"
			+ " <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script>"
			+ " <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script>"
			+ " <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>"
			+ " <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js'></script>";
	}
	
}
