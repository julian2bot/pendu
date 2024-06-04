#!/bin/bash

# Répertoire de la documentation
DOC_DIR="./doc2"

# Répertoire des fichiers sources et binaires
SRC_DIR="./src"
BIN_DIR="./bin"

# Lib JavaFX chemin
LIB_PATH="<chemin vers lib javafx>"

# Nom du module principal
MAIN_MODULE="Pendu"

# Génération de la documentation Javadoc
# javadoc -d "$DOC_DIR" --module-path "$LIB_PATH" --add-modules javafx.controls "$SRC_DIR"/*.java

# Compilation 
javac -d "$BIN_DIR" --module-path "$LIB_PATH" --add-modules javafx.controls "$SRC_DIR"/*.java

# exe du prog
java -cp "$BIN_DIR:img" --module-path "$LIB_PATH" --add-modules javafx.controls "$MAIN_MODULE"
