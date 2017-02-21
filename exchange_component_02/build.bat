"%JAVA%\bin\javac" -Xlint:all -g:none -classpath build -d build src\IWheel.java
"%JAVA%\bin\javac" -Xlint:all -g:none -classpath build -d build src\Wheel.java

cd build
"%JAVA%\bin\jar" -cvf Wheel.jar IWheel.class
"%JAVA%\bin\jar" -uvf Wheel.jar Wheel.class
"%JAVA%\bin\jar" -uvf Wheel.jar Wheel$Port.class

move Wheel.jar ..\Wheel.jar

pause