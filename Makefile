all: doc jeu.jar


doc:
	javadoc -sourcepath src -d docs -subpackages maze

cls:
	# classes
	javac -sourcepath src -d classes src/maze/*.java

	# tests
	javac -classpath test4poo.jar test/maze/*.java
	javac -classpath test4poo.jar test/maze/items/*.java
	javac -classpath test4poo.jar test/maze/actions/*.java
	javac -classpath test4poo.jar test/maze/characters/immobile/*.java
	javac -classpath test4poo.jar test/maze/characters/mobile/*.java


jeu.jar: cls
	jar cvfm jeu.jar jar/manifest-jeu -C classes maze
	mv jeu.jar jar/

jeu-v2.jar: cls
	 jar cvfm jeu-v2.jar jar/manifest-v2 -C classes maze
	 mv jeu-v2.jar jar/

game:
	# execution du jeu
	java -jar jar/jeu-v2.jar

clean:
	rm -r docs classes jar/*.jar test/maze/*.class test/maze/characters/mobile/*.class test/maze/characters/immobile/*.class test/maze/items/*.class test/maze/actions/*.class

.PHONY : all clean docs
