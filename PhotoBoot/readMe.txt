PhotoBooth
--------------------------------------------------------------------------------
Problem:
	Build an application that allows users to post pictures and like other pictures on the platform.
	Users may also follow other users.

Functionalities required:
	A new user should be able to register
	A user should be able to post a picture of his/her choice. For simplicity, consider the picture as a string value
	A user should be able to Follow/UnFollow any number of other users of his/her choice
	A user should be able to Like/UnLike any number of pictures
	Any user should be able to see posted pictures on the app
	Pictures on the app should be sorted by created time. (Last created should come first)
	Show number of likes on picture at any point of time
	Show count and list of followers of a user at any point of time

Example:
	Sample Data:
		RegisterUser(User1,9999999999); - Register User1
		PostPicture(User1, Picture1); - User1 posts Picture1
		PostPicture(User1, Picture2); - User1 posts Picture2
		RegisterUser(User2,9999999991); - Register User2
		Interaction(User2,Picture1,Like); - User2 likes Picture1 
		Interaction(User2,User1,Follow); - User2 follows User1
		RegisterUser(User3,9999999999); - Register User3
		PostPicture(User3, Picture3); - User3 posts Picture3

Case 1:
	Input - showPictures();
	Output - Pictures - [Picture1,Picture2,Picture3] ;

Case 2:
	Input - getInteractions(Picture1, Like);
	Output - Like - 1 ;

Case 3:
	Input - getInteractions(User1, Follow);
	Output - Followers - [User2] ;



Bonus:
	Show list of users I follow
	Show pictures of only those users whom I follow. If I don’t follow any user, result should be empty

Case 1:
	Input - showPictures(User2);
	Output - Pictures - [Picture1,Picture2] ; - Picture3 won't appear because User2 follows User1 and not User3

Case 2:
	Input - getInteractions(User2, Followers);
	Output -  Follows - [User1] ;

Expectations:						
	Create the sample data yourself. You can put it into a file, test case or main driver program itself.
	The code should be demo-able. Either by using the main driver program or test cases. 	
	The code should be modular. The code should have the basic OO design. Please do not jam in
	the responsibilities of one class into another.					
	The code should be extensible. Wherever applicable, use interfaces and contracts between different methods. It should be easy to add/remove functionality without rewriting the entire codebase. 							
	The code should handle edge cases properly and fail gracefully. 
	The code should be legible, readable and DRY.
	Database integration is not required. 

Guidelines:		 	 	 		
	Please do not access the internet for anything EXCEPT syntax.
	You are free to use the language and IDE of your choice.
	The entire code should be your own. 



Drivers -->

	user = username, uid , ArrayList<Post> posts, ArrayList<uid > followers
	Post = pictureName, date , ArrayList<userid> like


Storage -- >
	UserMap<userid, User>
	PostMap<pctureName, post> 