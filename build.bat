@echo off

rem -------------------------------------------------------------------------
rem AntIfs
rem Custom Ant Task
rem 
rem Version:    v1.0
rem Developer:  Cris del Rosario
rem Git         https://github.com/Amiagin/antifs.git
rem -------------------------------------------------------------------------

pushd

javac -classpath .;%ANT_HOME%\lib\ant.jar com\wolf\ant\*.java
mkdir bin\com\wolf\ant
move /Y com\wolf\ant\*.class bin\com\wolf\ant
copy /Y antifs.properties bin
cd bin

del /Q  *.jar
jar cvf antifs.jar .
del antifs.properties
rmdir /S/Q  com
cd ..

popd
