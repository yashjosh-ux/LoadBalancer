Step 1: Clone the repository from GitHub by using the HTTP/SSH URL.
Step 2: Open the LoadBalancer file in IntelliJ IDEA Ultimate.
Step 3: Add your own list of servers in the BackendServers file. 
Step 4: Run the LoadBalancer file and make sure your servers are up and healthy.
Step 5: Open Command Prompt and hit the API using the command "curl <your_LoadBalancer_URL/your_endpoint>". (For example: curl "http://localhost:8080/hello").
Step 6: Rewrite this command to see that a different server will process the request. (This is the expected output)

These are the complete instructions to implement the Load Balancer Application.
