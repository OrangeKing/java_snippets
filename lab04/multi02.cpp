#include <iostream>
#include "ArrayJNI.h"
#include "function.h"

using namespace std;

JNIEXPORT jobjectArray JNICALL Java_ArrayJNI_multi02
(JNIEnv *env, jobject jobj, jobjectArray tab)
{
	cout << endl << "... multi02 ...";
	jclass clazz = env->GetObjectClass(jobj);
	jfieldID fieldID = env->GetFieldID(clazz, "order", "Ljava/lang/Boolean;");
	jobject obj = env->GetObjectField(jobj, fieldID);

	jclass boolClass = env->FindClass("java/lang/Boolean");
	jmethodID getBool = env->GetMethodID(boolClass, "booleanValue", "()Z");
	bool ord = env->CallBooleanMethod(obj, getBool);
	//cout << ord;

	return proccess(env, tab, ord);
}