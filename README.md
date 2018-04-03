# autoextender
Allows to implements only selected methods of interface other will be stubbed automatically 

## Usage

Implement methods you need in abstract class and then let AutoExtender to stub remaining methods 

```java
Interface stubbed = AutoExtender.extend(AbstractClass.class).to(Interface.class);
```