Kyro
Kyro is a chatbot designed to assist you in your daily life. Its name is inspired by the Greek word Kyros, meaning "master". Given below are instructions on how to use it.

Setting up in Intellij
Prerequisites: JDK 17, update Intellij to the most recent version.

Open Intellij (if you are not in the welcome screen, click File > Close Project to close the existing project first)
Open the project into Intellij as follows:
Click Open.
Select the project directory, and click OK.
If there are any further prompts, accept the defaults.
Configure the project to use JDK 17 (not other versions) as explained in here.
In the same dialog, set the Project language level field to the SDK default option.
After that, locate the src/main/java/Kyro.java file, right-click it, and choose Run Kyro.main() (if the code editor is showing compile errors, try restarting the IDE). If the setup is correct, you should see something like the below as the output:
Hello from
____  __.                      
|    |/ _|___.__._______  ____  
|      < <   |  |\_  __ \/  _ \
|    |  \ \___  | |  | \(  <_> )
|____|__ \/ ____| |__|   \____/
\/\/                    
Warning: Keep the src\main\java folder as the root folder for Java files (i.e., don't rename those folders or move Java files to another folder outside of this folder path), as this is the default location some tools (e.g., Gradle) expect to find Java files.