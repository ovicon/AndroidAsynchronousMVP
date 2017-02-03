# AndroidAsynchronousMVP

Description
-------
Asynchronous MVP design for Android, without 3rd party libraries.

Problem
-------
How to implement a simple, decoupled, testable, asynchronous MVP desing, without using any 3rd party libraries, that can also handle screen orientation.

Solution
-------
The proposed solution for handling screen orientation, is a simple cache mechanism for the presenters. 

How does it work?

During orientation change, the Android OS calls two callback methods, where the developer can save and restore the view state. 

The callbacks are: __onSaveInstanceState__ and __onRestoreInstanceState__. 

When __onSaveInstanceState__ is called, the presenter is cached: 

```java
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Save presenter instance
        outState.putString(PRESENTER, presenter.getUuid().toString());
        Cache.getInstance().getCache().put(presenter.getUuid(), presenter);
    }
```

When __onRestoreInstanceState__ is called, the presenter

```java
```

that are saved and restored in the view callbacks


Known issues
-------


License
-------

    Copyright 2016 Ovidiu CONEAC

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
