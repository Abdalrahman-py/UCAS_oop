JAVAC=javac
SRC=src
BIN=bin
LIB=lib
JARS=$(LIB)/junit-platform-console-standalone-1.10.2.jar:$(LIB)/junit-jupiter-api-5.10.2.jar

all:
	$(JAVAC) -d $(BIN) -cp $(JARS) $(SRC)/*.java

test:
	java -jar $(LIB)/junit-platform-console-standalone-1.10.2.jar --class-path $(BIN) --scan-class-path

run:
	java -cp $(BIN) Main 