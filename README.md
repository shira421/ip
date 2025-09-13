# Kyro

_Kyro_ is a scheduler and chatbot designed to assist you in your daily life.

Its name is inspired by the Greek word _Kyros_, meaning "master". Given below are instructions on how to use it.

## Setting up in Intellij

Prerequisites: JDK 17, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project
   first)
1. Open the project into Intellij as follows:
    1. Click `Open`.
    1. Select the project directory, and click `OK`.
    1. If there are any further prompts, accept the defaults.
1. Configure the project to use **JDK 17** (not other versions) as explained
   in [here](https://www.jetbrains.com/help/idea/sdk.html#set-up-jdk).<br>
   In the same dialog, set the **Project language level** field to the `SDK default` option.
1. After that, locate the `src/main/java/kyro/base/Kyro.java` file, right-click it, and choose `Run Kyro.main()` (if the
   code
   editor is showing compile errors, try restarting the IDE). If the setup is correct, you should see something like the
   below as the output:
   ```
   Hello from
    ____  __.                      
   |    |/ _|___.__._______  ____  
   |      < <   |  |\_  __ \/  _ \ 
   |    |  \ \___  | |  | \(  <_> )
   |____|__ \/ ____| |__|   \____/ 
        \/\/                    
   ```

**Warning:** Keep the `src\main\java` folder as the root folder for Java files (i.e., don't rename those folders or move
Java files to another folder outside of this folder path), as this is the default location some tools (e.g., Gradle)
expect to find Java files.

## Commands

User Commands

   ```
   todo <description>                                      --> Add a todo Task
   deadline <description> /by <yyyy-MM-dd>                 --> Add a deadline Task
   event <description> /from <yyyy-MM-dd> /to <yyyy-MM-dd> --> Add an event Task
   list                                                    --> List out all tasks
   mark <task number>                                      --> Mark task by number
   unmark <task number>                                    --> Unmark task by number
   delete <task number>                                    --> Delete task by number
   filter <yyyy-MM-dd>                                     --> Filter by date
   find <keyword>                                          --> Find by keyword
   bye                                                     --> End Session
   ```