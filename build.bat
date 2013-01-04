@echo off

rem -------------------------------------------------------------------------
rem AntIfs
rem Custom Ant Task
rem 
rem Version:    v1.0
rem Developer:  Cris del Rosario
rem Git         https://github.com/Amiagin/antifs.git
rem -------------------------------------------------------------------------

javac -classpath .;%ANT_HOME%\lib\ant.jar src\com\wolf\ant\*.java -d bin
copy /Y antifs.properties bin
jar -cvf antifs.jar -C bin\ .
