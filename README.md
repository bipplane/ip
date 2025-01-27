<h1 align="center">CS2103T Individual Project 😺</h1>

This is my very own individual software project, featuring a chatbot named after the talented and beloved Kim Chaewon! I will be dedicating my efforts towards this project throughout AY24/25 Semester 2 to develop the essential skills needed in the expansive field of software engineering. WIZ*ONE FOREVER!!

<h2 align="center"> Setting up in IntelliJ </h2>

**Prerequisites:** JDK 17, update IntelliJ to the most recent version.

1. Open IntelliJ (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project first)
1. Open the project into IntelliJ as follows:
   1. Click `Open`.
   1. Select the project directory, and click `OK`.
   1. If there are any further prompts, accept the defaults.
1. Configure the project to use **JDK 17** (not other versions) as explained in [here](https://www.jetbrains.com/help/idea/sdk.html#set-up-jdk).<br>
   In the same dialog, set the **Project language level** field to the `SDK default` option.
1. After that, locate the `src/main/java/Chaewon.java` file, right-click it, and choose `Run Chaewon.main()` (if the code editor is showing compile errors, try restarting the IDE). If the setup is correct, you should see something like the below as the output:

   ```
   ____________________________________________________________
    ___   _____          ___    _   _   _____ 
   |_ _| |__  / __/\__  / _ \  | \ | | | ____|
    | |    / /  \    / | | | | |  \| | |  _|  
    | |   / /_  /_  _\ | |_| | | |\  | | |___ 
   |___| /____|   \/    \___/  |_| \_| |_____|
   
   Hello! I'm Kim Chaewon!
   What can I do for you?
   ____________________________________________________________
   ```

**Warning:** Keep the `src\main\java` folder as the root folder for Java files (i.e., don't rename those folders or move Java files to another folder outside of this folder path), as this is the default location some tools (e.g., Gradle) expect to find Java files.
