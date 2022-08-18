## Spring Boot Reward Points Project



## steps to Run the project
```bash

 1. mvn clean install
 2. java -jar reward-points-0.0.1-SNAPSHOT.jar
```

we need to create the jar and the run the jar by using the above commands.

## Procedure

1. In this project we have a event listener which creates the transaction on the application startup.
2. it creates a transaction with customerId, price and caluclate the reward points and store them in the List.
3. we have a rest end point /rewardPoints. if we pass the customerId to the rewardpoints end point it clauclates all the reward points and return them.
4. used the exception handling streams and lombok and followed best practices to built this service.



