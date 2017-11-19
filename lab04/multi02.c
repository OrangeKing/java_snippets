#include <jni.h>
#include <stdio.h>
#include "ArrayJNI.h"

JNIEXPORT jobjectArray JNICALL Java_ArrayJNI_multi02(JNIEnv *env, jobject thisObj, jobjectArray Array)
{
   printf("Hello World!\n");
   return;
}