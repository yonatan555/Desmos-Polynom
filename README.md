# JavaProjectE

This Project has direct connection to the previous task(Polynom),

In our task we have 2 mainly classes which:
1)ComplexFunction-
2)Functions_GUI-

1)  ComplexFunction  implements the function interface , and can get all of sub's classes interface
like polynom , Monom,and itself(ComplexFunction).

It fileds are 2 function(Left-type of function,Right-type of function too),
and Operator-this filed will decide which operation to execute 
(plus,div,mul,comp,min,max functions) which implements Enum.

Our constructor who get Operator,function 1, function 2: can get only 2 functions and op,
(when if 1 of them is null then will throw execption,or error op is inserted ).
The onstructor who get Operator(String type),function 1, function 2 can get only 2 functions and op
(if S is empty it will drop execption)

This class contain many functions :
F(x): which return the Y value in X has inserted.
InitalFromString(intial an Object) to all forms of functions(if we get is empty it will drop execption).
and diffrent of opertions are executing(follow to the Enum opertions,when
None indicates -there is no op,and error op- will drop exception).
Equals:This function will compare 2 diffrents object by Y value in 10 diffrents X.
if the all Y values are equal then the both Objects are the same.

2)   Functions_GUI who implements functions interface who extended by the Collection functions
This class has 1 filed ,is arrayList (function type).
The purpose of class is to come togther all kinds of the functions and put them in 1 collection array,
and then draws a graph who illustrates the functions have got in the array field.
This class using in mainly 2 diffrent libs : dtdDraw and Gson, with these libs 
we can read/write functions to/from a file,and then print them on the monitor.

we have all the functions have heired from(Collection Class), and 4 other functions 
are implemting the functions interface.
saveToFile-create a file with functions are inserted as String(will get every char).
initFromFile- inital an function_gui Object from a file has read.(can contain many diffrenets of functions).
drawFunctions- draw to monitor all of functions with diffrentes inputs(width,height,rx,ry,resolution).
drawFunctions-draw to monitor all of functions  from json file.

we have Junit testers for these classes will check the executive level.
 

