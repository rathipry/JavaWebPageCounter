# JavaWebPageCounter
Project should show on UI the number of time this web page has been visited

This is demo project to learn developing web based database application.
Server :  Apache Tomcat v8.5
Java :    13.0.2
Mysql :   8.0 and workbench
Eclipse : Java EE version 2020-06

When servlet initializing (Server loading the project), the page visited count will be retrieved from database.
When UI is loaded/refreshed/revisited and servlet doGet() method is called, this count will be incremented by 1 and send it to UI.
When servlet stopped (web server stopped), the total count will be saved to database.
