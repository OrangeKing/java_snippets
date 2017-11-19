#include <jni.h>
#include <stdio.h>
#include "ArrayJNI.h"

JNIEXPORT jobjectArray JNICALL Java_ArrayJNI_sort01(JNIEnv *env, jobject thisObj, jobjectArray Array, jobject order)
{
   printf("Hello World!\n");
   return;
}
