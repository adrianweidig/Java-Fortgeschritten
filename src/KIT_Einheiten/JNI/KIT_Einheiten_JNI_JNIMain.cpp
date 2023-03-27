#include "KIT_Einheiten_JNI_JNIMain.h"
#include <iostream>
using namespace std;

JNIEXPORT void JNICALL Java_KIT_1Einheiten_JNI_JNIMain_sagHallo(JNIEnv *, jclass)
{
	cout << "Hallo Welt!" << endl;
}
