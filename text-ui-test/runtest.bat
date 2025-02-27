@ECHO OFF

REM create bin directory if it doesn't exist
if not exist ..\bin mkdir ..\bin

REM delete output and tasks from previous run
if exist ACTUAL.TXT del ACTUAL.TXT
if exist tasks.txt del tasks.txt

REM compile the code into the bin folder
javac -cp ..\src\main\java -Xlint:none -d ..\bin ..\src\main\java\chaewon\*.java ..\src\main\java\tasks\*.java ..\src\main\java\commands\*.java
IF ERRORLEVEL 1 (
    echo ********** BUILD FAILURE **********
    exit /b 1
)
REM no error here, errorlevel == 0

REM run the program, feed commands from input.txt file and redirect the output to the ACTUAL.TXT
java -classpath ..\bin chaewon.Chaewon < input.txt > ACTUAL.TXT

REM compare the output to the expected output
FC ACTUAL.TXT EXPECTED.TXT
IF ERRORLEVEL 1 (
    echo Test result: FAILED
    exit /b 1
) ELSE (
    echo Test result: PASSED
    exit /b 0
)