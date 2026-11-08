
Managing a Wildlife Rescue Center
Problems:
Tracking Animals: Wildlife rescue centers often have a large number of animals, each with its own species, age, health status, and enclosure. It can be difficult to keep track of all this information.
Managing Rescuers: Each rescuer may be responsible for rescuing and caring for multiple animals. It can be challenging to manage, which animals are under the care of which rescuers.
Updating Animal Status: The health status of an animal can change over time due to treatment and care. It’s important to keep this information up-to-date.
How the System Solves These Problems:
Tracking Animals: The Animal class keeps track of each animal’s species, age, health status, and enclosure. The Rescue Center class maintains a list of all animals in the center.
Managing Rescuers: The Rescuer class keeps track of each rescuer’s name, ID, and list of rescued animals. The Rescue-center class maintains a list of all rescuers in the center.
Updating Animal Status: The Animal class has a method to update an animal’s health status. This method can be called when there is a change in the animal’s health.
This system makes it easier to manage a wildlife rescue center by keeping track of all animals and rescuers in an organized manner. It also allows for easy updates to an animal’s health status as needed. This can help improve the efficiency and effectiveness of the rescue center’s operations.
Classes:
Animal: This class will have attributes such as species, age, health status, and enclosure. It will have methods to get and set these attributes.
 
UML for the animal class
Rescuer: This class will have attributes such as name, ID, and list of rescued animals. It will have methods to get and set these attributes, and to rescue and release animals.
 
UML for the rescuer class

Rescue-center: This class will have a list of all animals and rescuers. It will have methods to add and remove animals and rescuers.
 
UML for the rescue-class
	




