## RFID Based Public Transport Ticketing System

![](https://img.shields.io/github/issues/aalexren/RFID-System) ![](https://img.shields.io/github/stars/aalexren/RFID-System) ![](https://img.shields.io/github/license/aalexren/RFID-System) [![build](https://github.com/aalexren/RFID-System/actions/workflows/build.yml/badge.svg)](https://github.com/aalexren/RFID-System/actions/workflows/build.yml)

### Assignment 1 SSAD Course


####  **Task description:**

This application aims at the development and implementation of a system for ticketing. The application can be used anytime, anywhere and tickets will be available on the customer’s phone in the form of “RFID”. GPS module is used for providing validation of the ticket at the source and deletion at the destination. For security reasons, the information about every user is stored and encrypted on CLOUD. The cloud Database makes the information easily accessible anytime it is needed. The system provides multiple ways of payment methods.

#### **General idea**
We designed the following main abstract entities: Client, Gates, Firewall, Server, Database. The Client is just a personal device (i.e. mobile phone). Gates are physical devices that open/close the door in front of passengers after applying for a ticket. There are two types of gates on each station, physically separated in real life: InGate passes the passenger to transport, and OutGate lets a passenger out from transport. Server accumulates requests to Database, makes queries to Database, and produces responses. A Firewall is used for the sake of security.

Clients have different modules for making requests to Server. You can read more about each of them in code comments. Each module has its own type of Request and Response. All requests go through a special Transfer module, which formalizes them. There are two types of requests: which go directly to the Firewall (i.e. buying a ticket) and which go through gates. Hence, if the passenger uses a card on the gate, the client just makes a request to GateManager - a special entity to handle open/close requests, encrypting, formalizing, and redirecting them further to Firewall. Also, GateManager receives responses from the Server, decrypting them, and passes them to the Client. Notice that GateManager is a physical device, located next to the actual InGates and OutGates. A Firewall is for the sake of security. ServerManager decrypts requests, sorts them and passes them to special modules. For instance, there is the module for buying tickets and another module for validating if the user can enter or exit through a concrete gate. Such modules make queries to Database. Also, they form and send responses based on received data. After all, responses go through all the way described above to the client or gate (it depends on request/response kind). If you want to understand this schema more deeply, you may take a glance at UML and simulation in Main.java class, and check code commands.

*Design patterns, OOP, and SOLID principles*  
We have used the Singleton design pattern for the Database class. In real life in such projects, only one database for all clients is used, so the singleton design pattern allows us to create only one instance of the class and provide global access to it. 
As for OOP principles, we tried to follow the inheritance principle, in order to build up hierarchical architecture and make code reusable. 

We’ve used interfaces for classes in order to create extendable architecture. For instance, this approach allows to the creation of two different classes inherited from one interface and pass them into one method. This makes the integration of new modules much easier.
We tried to follow all the SOLID principles: we used single responsibility and followed open-closed principles in all classes, tried to follow the Liskov substitution principle, followed the interface segregation principle, and followed the dependency inversion principle in all modules.
We also tried to bring an interesting idea to life: a proxy of a proxy of a singleton. The Firewall is a proxy of ServerManager, and SeverManager is a proxy of the Database, which is Singleton.

#### *by Dmitry Beresnev B20-02, Alina Safina B20-02, Anatoliy Shvarts B20-02, Artem Murashko B20-02, Artem Chernitsa B20-02*