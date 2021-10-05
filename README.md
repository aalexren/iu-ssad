### RFID Based Public Transport Ticketing System

#### Assignment 1 SSAD Course



##### **Assignment requirements:**

Your team will be given the topic for a project with description, your task is to implement ONE of the design patterns:

- Factory method
- Abstract factory
- Prototype
- Singleton

You are not required to develop the project (for example, if the project is about to create an Android app, then it does not mean that you have to create an Android project. It means you should just take into account the aspects of mobile development when you are creating your classes). It is about implementing the design pattern within the context of the project. You may choose any feature (functionality) of your project, and if you think that the description does not contain a feature to implement the design pattern, you are free to add a feature to the project within the context of the topic.



#####  **Task description:**

This application aims at the development and implementation of a system for ticketing. The application can be used anytime, anywhere and tickets will be available on the customer’s phone in the form of “RFID”. GPS module is used for providing validation of the ticket at the source and deletion at the destination. For security reasons, the information about every user is stored and encrypted on CLOUD. The cloud Database makes the information easily accessible anytime it is needed. The system provides multiple ways of payment methods.

#### **General Idea:**
We designed the following main abstract entities: Client, Gates, Firewall, Server, Database. The Client is just a personal device (i.e. mobile phone). Gates are physical devices that open/close the door in front of passengers after applying for a ticket. There are two types of gates on each station, physically separated in real life: InGate passes the passenger to transport, and OutGate lets a passenger out from transport. Server accumulates requests to Database, makes queries to Database, and produces responses. A Firewall is used for the sake of security.
Clients have different modules for making requests to Server. You can read more about each of them in code comments. Each module has its own type of Request and Response. All requests go through a special Transfer module, which formalizes them. There are two types of requests: which go directly to the Firewall (i.e. buying a ticket) and which go through gates. Hence, if the passenger uses a card on the gate, the client just makes a request to GateManager - a special entity to handle open/close requests, encrypting, formalizing, and redirecting them further to Firewall. Also, GateManager receives responses from the Server, decrypting them, and passes them to the Client. Notice that GateManager is a physical device, located next to the actual InGates and OutGates. A Firewall is for the sake of security. ServerManager decrypts requests, sorts them and passes them to special modules. For instance, there is the module for buying tickets and another module for validating if the user can enter or exit through a concrete gate. Such modules make queries to Database. Also, they form and send responses based on received data. After all, responses go through all the way described above to the client or gate (it depends on request/response kind). If you want to understand this schema more deeply, you may take a glance at UML and simulation in Main.java class, and check code commands.
