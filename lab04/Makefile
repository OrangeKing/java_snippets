cc -fPIC -c -I/usr/lib/jvm/java-1.8.0-openjdk-amd64/include \
  -I/usr/lib/jvm/java-1.8.0-openjdk-amd64/include/linux HelloJNI.c
cc -shared -o libHelloWorld.so HelloJNI.o
java -Djava.library.path=. HelloJNI
