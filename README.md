tic-tac-toe-sample
==================

This takes a sample app from the Android SDK 14 distribution, and extends it.

The sample app was originally made as a demonstration of how app code could be
organized into two projects:

* a *library project* for common code
* an *Android project* for app code

This "fork" of the sample app shows how a second *Android project* can be added
as a way of defining a new build target for the app.

Both build configruations of the app can co-exist on the same device and they
reference the common code contained by the *library project*.
