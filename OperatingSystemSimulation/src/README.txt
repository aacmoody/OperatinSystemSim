Operating System Simulation

Project can be run from main class Kernel
    Three base processes will be started
    And prompt for user input



Commands:  All commands are not case sensitive

    proc                will show the processes running

    log                 will show the processing logs, times and switches

    start 'MyProcess'   will start a new process with the name MyProcess

    web 'site'          will make a web call

        example web https://www.google.com/

    show                will show each process and their addressSpace data

    save 'fileName'     will save the process data to long term storage
         example save myNewFile -> information will be saved into myNewFile.txt

    read 'fileName'     will read the contents of a given file in storage
        example read myNewFile.txt -> information from myNewFile.txt will be printed

    quit                shuts down the operating system