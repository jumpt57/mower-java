# Java Mower

The goal of this program is to take as input a file to place and move mowers around the
grid and at the end print the position of the mowers.

To package :
```
mvn clean package
```

To run :
```
java -jar mower-java-1.0-SNAPSHOT.jar -file data.txt
```

The file should be formatted like so :

```
55
12N
LFLFLFLFF
33E
FFRFFRFRRF
```

The first line represents the length of the grid.
The second line the position of the mowers at startup with is 
orientation.
The third one the list of instruction.

Ouput for this file is :
```
INFOS: 1 3 N
INFOS: 5 1 E
```

Orientation possible :
* N = north
* S = south
* E = east
* W = west

Instruction possible :
* L = left
* R = right
* F = forward

