# serverAvailability
####
Draft Plan: 
* 1. Define requirments
* 2. clear open questions
* 3. estimate needed time

####
Goal: Monitor Application

Content Requirements:
* list of server
* frequently check server availability >> Schedule a task to run in an interval
* Output: two columns (SERVER NAME | RESULT)

Implementation requirements
* Frontend: free choice
* server part: java
* code quality: follow own requirments
* class & library: free choice
* source code and application: .jar 
* time tracking

####
first implementation Idea:
* Class Main (ServerList, Methode call) 
* Class ServerDetails (name, result, constructor, Getter/Setter)
* Class PingCheck (Research Functions: Inet, Socket or HttpConnection)
* Output: Console 

Create a question catalog to ensure to get all important informations: 
Goal: Try to make yes/no question to get clear answers
* frequence: How often?
* server check: host, application or http?  
* results: (if http) detailed error messages needed? 
* server list: can I use own server example list?
* Console Output: free choice

####
Aslong you wait for Email/Phone answer, research technology: 
* InetAddress: http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_21_005.htm#mj8ba2862796503ab879fa49a1124af188
* Socket: https://docs.oracle.com/javase/7/docs/api/java/net/Socket.html
* HTTP: https://docs.oracle.com/javase/7/docs/api/java/net/HttpURLConnection.html
* List vs. ArrayList (contains List of Objects): https://techdifferences.com/difference-between-list-and-arraylist-in-java.html
* Console Output in tabular form: https://c4code.wordpress.com/2014/03/17/how-to-print-the-results-to-console-in-a-tabular-format-using-java/ 
* Printf, Console Outout: https://alvinalexander.com/programming/printf-format-cheat-sheet
* Ping Code: http://techdive.in/java/java-ping-host-or-ip-address
* Enum: https://www.geeksforgeeks.org/enummap-class-java-example/
Usage of Breakpoints/Debugging

####
Time:
* Planning/Research time: 2h
* Estimation for needed implementation time: 3h 
* additional Testing time: 1h 
