#include <jni.h>
#include <stdio.h>
#include "ArrayJNI.h"
 
// Implementation of native method sayHello() of HelloJNI class
JNIEXPORT void JNICALL Java_ArrayJNI_multi03(JNIEnv *env, jobject thisObj) 
{
   printf("Hello World!\n");
   return;
}