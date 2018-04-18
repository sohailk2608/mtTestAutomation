# mtTestAutomation

Automation done by Sohail Khan (sohailk2608@gmail.com)
App name: myTaxi

I have added Test Cases Excel file along with this Code. I haven't done coding however, I have mentioned the cases in text as requested..

A) Steps to configure the Project on your workstation:
  1. Install the Android Studio
  2. Open Android SDK Manager and go to SDK Tools tab.
  3. Make sure that "Android Support Repository" is supported.
  4. Create a new Project (or Open a Project)
  5. Check If you are getting error: 
    Error:CreateProcess error=216, This version of %1 is not compatible with the version of Windows you're running. Check your computer's system information to see whether you need a x86 (32-bit) or x64 (64-bit) version of the program, and then contact the software publisher
  6. Then open Project Structure by pressing ctrl+alt+shift+s
  7. Uncheck the checkbox named "Use embedded JDK (recommended)"
  8. Browse and give path to your own jdk (e.g.: C:\Program Files\Java\jdk1.8.0_162)
  9. Press OK and the Studio will start building Gradle
  10. if you get an error:
    unable to start hte daemon process. This problem might...
  11. Go to Project> Gradle Scripts> Gradle properties (double click)
  12. change the line "org.gradle.jvmargs=-Xmx1024m" to "org.gradle.jvmargs=-Xmx768m"

B) How to Install Virtual Android Device (In case if your processor does not support Android Studio Virtual Android)
  1. Download and install the latest version of Nox App Player from bignox official website: https://www.bignox.com/
  2. Start Android studio and create a new activity
  3. Start Nox App Player, go to Nox system settings >> turn root mode on >> save changes and restart Nox
    (Note: Nox is defaulted to start in tablet mode, you could choose in System Settings >> Advanced >> Startup Setting >> Phone to better emulate the Android phone experience)
  4. Go to Android settings in Nox >> About Tablet >> Keep clicking Build number until it shows that you are now a developer >> go back to Android settings and you will find the developer options now.
  5. Go to developer options >> tick USB debugging
  6. Turn off the following : "Window animation scale", "Transition animation scale" and "Animation duration scale"
  7. Now in cmd go to the bin folder under the installation path of Nox App Player, input this command: nox_adb.exe connect 127.0.0.1:62001. You will see a successfully connected notice in cmd. If it shows null or offline, just re-start Nox and try again.
  8. Now Android studio will detect Nox.
  
C) To Check Android Emulator's OS Version and sdk API level:
  1. Install Terminal Emulator from Play Store on to the Android emulator.
  2. Open the Terminal Emulator and type: "getprop ro.build.version.release" (without the quotes "")
  3. You will get OS version in response like: 7.1.2 for Nougat
  4. Type getprop ro.build.version.sdk
  5. You will get API level like: 25 (for Nougat)

D) To Inspect objects inside the App, use the following:
  1. Connect the device to your Workstation.
  2. Go to the following path:
    C:\Users\<UserName>\AppData\Local\Android\Sdk\tools\bin
  3. Open the file named "uiautomatorviewer.bat"
  4. Take a Screenshot of the Device with the current page
  5. Hover the mouse over any of the element you want.
  6. On the Right hand pane, you will see all the Node Details, identifiers and the hierarchy of the element.
