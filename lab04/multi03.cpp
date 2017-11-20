#include <iostream>
#include "ArrayJNI.h"
#include "function.h"

using namespace std;

JNIEXPORT void JNICALL Java_ArrayJNI_multi03
(JNIEnv *env, jobject jobj)
{
	cout << endl << "... multi03 ...";
	jclass clazz = env->GetObjectClass(jobj);
	jmethodID sort = env->GetMethodID(clazz, "multi04", "()V");
	env->CallVoidMethod(jobj, sort);
}