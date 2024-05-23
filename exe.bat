@REM javac -d ./bin ./src/*.java

@REM java -cp ./bin ExecutablePendu



javac -d ./bin --module-path C:\Julian\lib_java\javafx-sdk-22 --add-modules javafx.controls ./src/*.java

java -cp "bin;img" --module-path C:\Julian\lib_java\javafx-sdk-22 --add-modules javafx.controls Pendu
