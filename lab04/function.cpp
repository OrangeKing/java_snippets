#include "jni.h"

void sort(bool order, int n, double *values)
{
	for (int i = 0; i < n - 1; i++)
	{
		for (int j = i + 1; j < n; j++)
		{
			if (order)
			{
				if (values[i] > values[j])
				{
					double temp = values[j];
					values[j] = values[i];
					values[i] = temp;
				}
			}
			else
			{
				if (values[i] < values[j])
				{
					double temp = values[j];
					values[j] = values[i];
					values[i] = temp;
				}
			}
		}
	}
}

jobjectArray proccess(JNIEnv *env, jobjectArray tab, bool ord)
{
	int n = env->GetArrayLength(tab);
	//cout << endl << n << endl;

	jclass doubleClass = env->FindClass("java/lang/Double");
	jmethodID getDouble = env->GetMethodID(doubleClass, "doubleValue", "()D");

	double *tempTab = new double[n];
	double val;

	for (int i = 0; i < n; i++)
	{
		jobject obj = env->GetObjectArrayElement(tab, i);
		val = env->CallDoubleMethod(obj, getDouble);
		tempTab[i] = val;
		//cout << val;
	}

	sort(ord, n, tempTab);

	/*for (int i = 0; i < n; i++)
	{
	cout << tempTab[i] << endl;
	}*/

	jobjectArray result = env->NewObjectArray(n, doubleClass, NULL);
	jmethodID createDouble = env->GetMethodID(doubleClass, "<init>", "(D)V");

	for (int i = 0; i < n; i++)
	{
		jobject nobject = env->NewObject(doubleClass, createDouble, tempTab[i]);
		env->SetObjectArrayElement(result, i, nobject);
	}

	return result;
}