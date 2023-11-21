Final Feedback!

Although there are other ways to design the classes , this is what I expect you when you design your classes:

1.
Create Interface or Abstract class ---Chat
Add abstract methods: public void write(String message,String url)
                    : public List<String> read(String url)
					: public void display(List messages)
					: Add any other methods if you have more
2.					
Extend or implement Chat ---> create PublicChat	class		

3.
Extend PublicChat or implement Chat       --->  create PrivateChat class
 
4. Add Class Friend.
   Add method: addFriend()
             : updateFriend()
			 : deleteFriend()
			 
5. You normally have two classes for SystemExceptionHandler and CustomExceptionHandler. I expect these classes to inherit one of Exception exption classes.  So , you shouldnt extend one of these
in your Class but create instances of them and write your logs. No collaboration!


6. You can use function like ".split()" to extract names from the list of friends. 
   You could have made the private chat flexible If you change the file name based on the username. 


Check this link for a good example of how to design classes, OO Design
https://www.pearsonenespanol.com/docs/librariesprovider5/deitel-adicionales-9e/como-programar-en-c-14/material-complementario/cap26.pdf?sfvrsn=3ee3d2b2_2
 

Work on "Class Design"
