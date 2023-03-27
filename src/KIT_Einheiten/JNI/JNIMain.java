package KIT_Einheiten.JNI;

/**
 * Erste Schritte mit JNI
 * <p>
 * 1. Java Datei erstellen mit einer "native" Methode
 * 2. Header-Datei mit javah.exe erstellen
 * 2.1. Terminal: javac -h . JNI_Beispiel_1_Main.java (Verzeichnis der Datei)
 * ODER 2.2. Gem. Anleitung siehe unten vorgehen
 * 3. .cpp Datei Erstellen (Name wie .h Datei) und ausprogrammieren
 * 3. In Verzeichnis mit Compiler-Installation wechslen (z.B. bei Visual Studio Community Edition 2022 unter C:\Program Files\Microsoft Visual Studio\2022\Community\VC\Auxiliary\Build)
 * 4. Compiler für C++ installieren: cmd /c vcvarsall.bat x64 '&&' (Get-Process -Id $PID).Path     | (via Powershell oder CMD)
 * 5. Via cd in Projektordner wechseln:
 * 5.1. ERST cl /I "..\..\..\UsedJDK\jdk1.8.0_111\include" /I "..\..\..\UsedJDK\jdk1.8.0_111\include\win32" /LD "KIT_Einheiten_JNI_JNIMain.cpp" /EHsc
 */
public class JNIMain {
    /* Anleitung für das bauen eines JavaH Tools für IntelliJ:
     *
     * 1.	File->Settings->External Tools
     * 2.	Click the + button for the "Edit Tool" dialog
     * 3.	The following are the form name/value pairs I used:
     *      o	Name: javah
     *      o	Group: Java
     *      o	Description: Java Native Interface C Header and Stub File Generator
     *       o	Options: Check All
     *    o	Show in: Check All
     *    o	Tool Settings...
     *    o	Program: $JDKPath$\bin\javah.exe
     *    o	Parameters: -jni -v -d $FileDir$ $FileClass$
     *    o	Working directory: $SourcepathEntry$
     * 4.	Click OK, Click OK
     * 5.	Navigate to your java class with the native method
     * 6.	With the java class being shown in the editor, go to Tools->Java->javah
     * 7.	Notice the .h file that was generated in the same directory as your class.
     */

    static {
        System.loadLibrary("KIT_Einheiten_JNI_JNIMain.dll");
    }

    public static void main(String[] args) {
        sagHallo();
    }

    private static native void sagHallo();
}
