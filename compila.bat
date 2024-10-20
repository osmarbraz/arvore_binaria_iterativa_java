@echo off

if not exist target (
	echo  *** Criando Diretorio target ***
	mkdir target	
	mkdir target\classes
)

echo  *** Compilando projeto ***
javac -encoding UTF-8 -sourcepath src\main\java -d target\classes src\main\java\*.java