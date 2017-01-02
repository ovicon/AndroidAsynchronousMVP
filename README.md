# AndroidAsynchronousCallbackMVP
An attempt to build a simple asynchronous MVP design for Android, without using any 3rd party libraries. The example uses two "features" to demonstrate asynchronicity.

The main difference from other implementaions, is that this implementation handles user interface "tasks", in separate threads started from the view, meaning that any long running operations on this threads, will not degrade the user experience provided by the view.

About the branches:
- master - this contains the latest development of the implementaion
- archive-vNO (Where NO is a number like 1, 2, 3...)
