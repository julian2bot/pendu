@REM javadoc -d ./doc2 --module-path C:\Julian\lib_java\javafx-sdk-22\lib --add-modules javafx.controls ./src/*.java

@REM javac -d ./bin --module-path C:\Julian\lib_java\javafx-sdk-22\lib --add-modules javafx.controls ./src/*.java

@REM java -cp "bin;img" --module-path C:\Julian\lib_java\javafx-sdk-22\lib --add-modules javafx.controls Pendu


@REM javadoc -d ./doc2 --module-path  --add-modules javafx.controls ./src/*.java

javac -d ./bin --module-path <chemin vers lib javafx> --add-modules javafx.controls ./src/*.java

java -cp "bin;img" --module-path <chemin vers lib javafx> --add-modules javafx.controls Pendu
