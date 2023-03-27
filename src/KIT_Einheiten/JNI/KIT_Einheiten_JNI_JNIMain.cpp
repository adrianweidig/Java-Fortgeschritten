#include "KIT_Einheiten_JNI_JNIMain.h"
#include <iostream>
using namespace std;

/*
 * Class:     KIT_Einheiten_JNI_JNIMain
 * Method:    sagHallo
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_KIT_1Einheiten_JNI_JNIMain_sagHallo(JNIEnv *, jclass) {
	cout << "Hallo Welt!" << endl;
}

/*
 * Class:     KIT_Einheiten_JNI_JNIMain
 * Method:    printInt
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_KIT_1Einheiten_JNI_JNIMain_printInt (JNIEnv *, jclass, jint wert) {
    cout << "Wert = " << wert << endl;
}

/*
 * Class:     KIT_Einheiten_JNI_JNIMain
 * Method:    getInt
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_KIT_1Einheiten_JNI_JNIMain_getInt (JNIEnv *, jclass) {
    jint zahl;

	cin >> zahl;

	return zahl;
}
