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
* frequency: How often?
* server check: host, application or http?  
* results: (if http) detailed error messages needed? 
* server list: can I use own server example list?
* Console Output: free choice
* Code sharing: via git possible?

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
* Conecpt and Planning/Research time: 2h
* Estimation for needed implementation time: 3h 
* if needed additional Testing time: 1h 

#### 
04.02.2019 

Question catalogue: 
* frequency: 
    1.1 okay-solution: fixed value (own choice)
    1.2 best solution: free value (user input)  
* server check: http-check 
* results: short message enough (“client error”, “server error”, but at least 3 checks)
* server list: 
    4.1 okay-solution: console input 
    4.2 best solution: free choice (user input: read .csv || console input) 
* Code sharing: via gitHub

Time after project finished:
* Conecpt and Planning/Research time: 2+1h
* Estimation for needed implementation time: 3+1h 
* if needed additional Testing time: 1h
RESULT: I needed 2h more than planned 

Reason (some of the unespected pain points): 
* git issues 
* for-loop issue
* debugging research
