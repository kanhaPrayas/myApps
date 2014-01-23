myApps
======

This folder contains my appCodes for perfectEvent which is targeted for any kind events

eventCategories include

      College Fests
      Events in Clubs
      Any functions/events in societies etc.

Installation Guide

Import the project into eclipse or Rational Application Developer
* Right click on the project folder, export as war file.
* Put the perfectEvent.war in the webApp folder of your tomcat webSerer
* open perfectEvent/dbSchema in an editor
* ctrl+A, ctrl+c 
* Open mysql command line
* execute "create database perfectEvent; use perfectEvent;"//dbUser is root with no password. If any other credential
.Then change accordingly in perfectEvent/src/Model/config.properties
* ctrl+v



//Now Apis are ready to use
//As project contaians only api, Nodashboard, Use advancedRestClient(chrome) or similar.
//Request Json is in perfectEvent/request.json


