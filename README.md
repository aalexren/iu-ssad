## RFID Based Public Transport Ticketing System

![](https://img.shields.io/github/issues/aalexren/RFID-System) ![](https://img.shields.io/github/stars/aalexren/RFID-System) ![](https://img.shields.io/github/license/aalexren/RFID-System) [![build](https://github.com/aalexren/RFID-System/actions/workflows/build.yml/badge.svg)](https://github.com/aalexren/RFID-System/actions/workflows/build.yml)

### Report for SSAD Assignment 3


###  **Task description:**

This application aims at the development and implementation of a system for ticketing. The application can be used anytime, anywhere, and tickets will be available on the customer’s phone in the form of “RFID”. GPS module is used for providing validation of the ticket at the source and deletion at the destination. For security reasons, the information about every user is stored and encrypted on CLOUD. The cloud database makes the information easily accessible anytime it is needed. The system provides multiple ways of payment methods.

### **General idea**
We designed the following main abstract entities: Client, Gates, Firewall, Server, Database. The Client is just a personal device (i.e. mobile phone). Gates are physical devices that open/close the door in front of passengers after applying for a ticket. There are two types of gates on each station, physically separated in real life: InGate passes the passenger to transport, and OutGate lets a passenger out from transport. The Server accumulates requests, makes queries to Database, and produces responses. A Firewall is used for the sake of security.  

Clients have different modules for making requests to Server. You can read more about each of them in code comments. Each module has its type of Request and Response. All requests go through a special Transfer module, which formalizes them. There are two types of requests: which go directly to the Firewall (i.e. buying a ticket) and which go through gates. Hence, if the passenger uses a card on the gate, the Client requests GateManager - a special entity to handle open/close requests, encrypting, formalizing, and redirecting them further to Firewall. Also, GateManager receives responses from the Server, decrypts them, and passes them to the Client. Notice that GateManager is a physical device located next to the actual InGates and OutGates. Then it passes the Firewall. ServerManager decrypts requests, sorts them and passes them to special modules. For instance, there is the module for buying tickets and another module for validating if the user can enter or exit through a concrete gate. Such modules make queries to Database. Also, they form and send responses based on received data. After all, responses go through the way described above to the Client or Gate (depending on request/response kind). To understand this schema more deeply, you may glance at UML and simulation in Main.java class and check code commands.  

This application aims at the development and implementation of a system for ticketing. The application can be used anytime, anywhere, and tickets will be available on the customer’s phone in the form of “RFID”. GPS module is used for providing validation of the ticket at the source and deletion at the destination. For security reasons, the information about every user is stored and encrypted on CLOUD. The cloud database makes the information easily accessible anytime it is needed. The system provides multiple ways of payment methods.  

![UML can be found here](uml.pdf)

### **Design patterns, OOP, and SOLID principles (v3)**
We corrected the mistakes of Assignment 2, refactored UML, and added new functionality.  
We fixed typos in the code, renamed classes and some of their fields, for example, Updation changed to Updating and Crypter to Cipher. Besides, we fixed the same problems in the UML diagram, got rid of overwhelming intersections, and followed an orthogonality approach.  
Technically, in this assignment we have added the Chain of Responsibility pattern to decrease the load on the system, interrupting the processing of irrelevant requests as early as possible. Before, we used a direct connection between Firewall and Server Manager. For now, the system has mediator classes forming Middleware.  
Middleware is a group of abstractions such as Firewall, DDoS, Origin, Authentication. If any request is invalid for the system, the chain of responsibility will confirm or reject it. The stage of rejection depends on the type of request. For instance, if the system recognizes the DDoS request, DDoSPreventer will deny it first, to not pass it further. If there is no DDoS attack, DDoSPreventer will pass it to OriginValidator, which will handle the request, etc.  
The main classes we have added: AuthenticationValidator, BaseRequestHandler, DDoSPreventer, FinalHandler, OriginValidator, and interface IRequestHandler. Unlike other handlers, FinalHandler calls ServerManager.
We have tried to ensure that our system follows the SOLID principles to the maximum, especially after the corrections.  

### **Design patterns, OOP, and SOLID principles (v2)**
We have corrected some mistakes of Assignment 1, made code refactoring, and added new functionality.  
We followed OOP principles and unified requests to Server and Database (IServerRequest). Also, we have unified corresponding responses (IResponse).  
The second thing we did was refactor the Database to make it satisfy CRUD principles. We divided Database into Tables, and each Table is in charge of a concrete entity. Now we have two Tables: TransactionTable and TicketTable.  
Created Tables required a new type of request - TableRequest. They are constructed in Database modules and pass through the Database to a corresponding Table.  
We added new functionality - now, when a user buys a ticket, they receive notifications. Users can set up the Client with a notification stack to choose where they would send messages. Now we have three types of notifications: Telegram, E-mail, and SMS notifications. Of course, we have added new types of requests and responses connected with notifications.  
Adding such functionality requires a new design pattern - Decorator. We have added EmailDecorator, SMSDecorator, and TelegramDecorator. Each of the decorators extends the send() function of the base Notifier by sending the corresponding requests to the Server (i.e. NotificationRequest(NotifierType.Email) for EmailDecorator). Thanks to Decorators, users can choose any combination of provided notifications.  

### **Design patterns, OOP, and SOLID principles (v1)**
We have used the Singleton design pattern for the Database class. In real life in such projects, only one database for all clients is used, so the singleton design pattern allows us to create only one instance of the class and provide global access to it.  
As for OOP principles, we tried to follow the inheritance principle to build up hierarchical architecture and make code reusable.  
We’ve used interfaces for classes to create extendable architecture. For instance, this approach allows the creation of two different classes inherited from one interface and passing them into one method. It makes the integration of new modules much easier.  
We tried to follow all the SOLID principles: we used single responsibility and followed open-closed principles in all classes, tried to follow the Liskov substitution principle, followed the interface segregation principle, and followed the dependency inversion principle in all modules.  
We also tried to bring an interesting idea to life: a proxy of a proxy of a singleton. The Firewall is a proxy of ServerManager, and SeverManager is a proxy of the Database, which is Singleton.  

***Authors:*** *by Dmitry Beresnev B20-02, Alina Safina B20-02, Anatoliy Shvarts B20-02, Artem Murashko B20-02, Artem Chernitsa B20-02*