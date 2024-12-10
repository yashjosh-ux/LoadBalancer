# Load Balancer Application

This guide provides step-by-step instructions to clone, set up, and test the Load Balancer Application. Follow the steps below to implement and verify the functionality of the application.

---

## Steps to Implement the Load Balancer Application

### Step 1: Clone the Repository
1. Open a terminal.
2. Clone the repository using the HTTP or SSH URL:
   ```bash
   git clone <repository_URL>
   ```
3. Navigate to the project directory:
   ```bash
   cd <repository_name>
   ```

### Step 2: Open the Project in IntelliJ IDEA
1. Launch IntelliJ IDEA Ultimate.
2. Open the cloned project by navigating to `File > Open` and selecting the project folder.
3. Wait for the dependencies to load and the project to index.

### Step 3: Configure the Backend Servers
1. Open the `BackendServers` file located in the `src/main/java` directory.
2. Add your list of servers in the following format:
   ```java
   servers.add("<server_address:port>");
   ```
   Example:
   ```java
   servers.add("localhost:8081");
   servers.add("localhost:8082");
   servers.add("localhost:8083");
   ```

### Step 4: Run the Load Balancer Application
1. Ensure your backend servers are running and healthy.
2. Run the `LoadBalancer` file by right-clicking on it and selecting `Run 'LoadBalancer.main()'` in IntelliJ IDEA.

### Step 5: Test the Load Balancer
1. Open Command Prompt or a terminal.
2. Hit the API using the following command:
   ```bash
   curl "http://localhost:8080/<your_endpoint>"
   ```
   Example:
   ```bash
   curl "http://localhost:8080/hello"
   ```

### Step 6: Verify the Load Balancing
1. Re-run the `curl` command multiple times to see the load balancer distributing the requests to different servers.
2. Example:
   ```bash
   curl "http://localhost:8080/hello"
   ```
   Expected Output:
   - Response from Server 1
   - Response from Server 2
   - Response from Server 3

---

## Notes
- Ensure the backend servers are configured correctly and are operational before running the application.
- Modify the server list in `BackendServers` to match your setup.
- Use the IntelliJ IDEA Ultimate version for seamless Java project management and debugging.

---
