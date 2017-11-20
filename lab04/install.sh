javac ArrayJNI.java

javah ArrayJNI

g++ -fPIC -c -I/usr/lib/jvm/java-1.8.0-openjdk-amd64/include \
  -I/usr/lib/jvm/java-1.8.0-openjdk-amd64/include/linux sort01.cpp

g++ -fPIC -c -I/usr/lib/jvm/java-1.8.0-openjdk-amd64/include \
  -I/usr/lib/jvm/java-1.8.0-openjdk-amd64/include/linux multi02.cpp

g++ -fPIC -c -I/usr/lib/jvm/java-1.8.0-openjdk-amd64/include \
  -I/usr/lib/jvm/java-1.8.0-openjdk-amd64/include/linux multi03.cpp

g++ -shared -o libsort01.so sort01.o
g++ -shared -o libmulti02.so multi02.o
g++ -shared -o libmulti03.so multi03.o

java -Djava.library.path=. ArrayJNI
