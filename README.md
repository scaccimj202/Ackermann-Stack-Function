# Ackermann-Stack-Function
Ackermann Function done by simulating recursion with a stack. Final commit will include all lab report material.
Problem: Given the Ackermann function, and it's
recursive implementation[source: https://introcs.cs.princeton.edu/java/53universality/Ackermann.java]
The goal of Ackermann.java is to:
  A) Recreate the algorithm as a stack, simulating the recurive structure.
  B) Analyze the run time between our(mine) stack based implementation and the recursive solution provided.
  
 Testing Conditions: 
    For the program I ran testing within the Ackermann file provided. I created my experiment to load a
  set of pre selected values(based on the Assignment PDF) and fed them into an array. To test the two algorithms I then pop'd
  the values off the stack sequentially and fed them into their respective methods. The methods then took snapshots of the time
  before and after execution and recorded a total time based off this. The program wrote these to files and put them in a 
  sub directory within the assignment folder.

Execution Instructions:
    The Ackermann.java file has been modified to fit the experiment. I have included a boolean toggle 'assignemntTest' 
   wihtin the Ackermann.java file that is by default set to true. Whether or not this is toggled the original files for 
  each methods data WILL BE OVERWRITTEN. Copies of the data used for the purpose of the lab report are backed up in the
  'Experiment Data' folder already.
  
  - While true: This will rerun the experiment and allow the user to regenerate the test results given the assigned data set.

  - While false: This will now cause the program to function similarly to the original design:
      Type: Ackermann.java [m] [n] and the program will test those values and store the time results in the respective 
      files under the Experiment Data subdirectory. This will only record one set per program execution
      again overwritting the previous data, and assigning '1' to the set number field.
  
