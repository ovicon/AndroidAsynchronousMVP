# AndroidAsynchronousMVP
Asynchronous MVP design for Android, without 3rd party libraries.

Install
-------
Download and install the application from [here](https://play.google.com/store/apps/details?id=ro.ovidiuconeac.androidcallbackmvp&hl=en). 

The problem
-------
How to implement a simple, decoupled, testable, asynchronous MVP design, without using any 3rd party libraries, that can also handle screen orientation.

The solution
-------
The proposed solution for handling screen orientation, is a simple cache mechanism for the presenters: 

```java
public class Cache implements Serializable {

    private static Cache ourInstance;
    private Map<UUID, Presenter> cache;

    public static Cache getInstance() {
        if (ourInstance == null) {
            ourInstance = new Cache();
        }
        return ourInstance;
    }

    private Cache() {
        cache = new HashMap<>();
    }

    public void cachePresenterFor(UUID uuid, Presenter presenter) {
        cache.put(uuid, presenter);
    }

    public Presenter restorePresenterFor(UUID uuid) {
        Presenter presenter = cache.get(uuid);
        cache.remove(presenter);
        return presenter;
    }
}
```
How does it work?

During orientation change, the Android OS calls two callback methods, where the developer can save and restore the view state. These callbacks are: __onSaveInstanceState__ and __onRestoreInstanceState__. 

When __onSaveInstanceState__ is called, the presenter is cached: 

```java
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Save presenter instance
        outState.putString(PRESENTER, presenter.getUuid().toString());
        cachePresenter(presenter);
    }
    
    @Override
    public void cachePresenter(Presenter presenter) {
        Cache.getInstance().cachePresenterFor(presenter.getUuid(), presenter);
    }
```
The reason each presenter instance has a UUID, is to handle the case of multiple instances of the same view. Each view has to have its own presenter, so cache will contain multiple instances of the same presenter class. When the view is restored, it has to find the appropriate presenter in the cache.

When __onRestoreInstanceState__ is called, the view restores its presenter from the cache, and the presenter restores its reference to the view:

```java
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore presenter instance
        restorePresenter(UUID.fromString(savedInstanceState.getString(PRESENTER)));
    }
    
    @Override
    public void restorePresenter(UUID uuid) {
        presenter = (FirstPresenter) Cache.getInstance().restorePresenterFor(uuid);
        presenter.setScreen(this);
    }
```
Asynchronous operations are handled in the presenters. Each presenter acts as a "bridge" between the view and the model (business logic). This "bridge" mechanism is implemented with __AsyncTasks__. Each __AsyncTask__ orchestrates the flow of date between the view and the model, performing background operations and publishing the results on the UI.

```java
    public void requestMessage(final FirstScreen screen) {
        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... params) {
                return model.requestMessage();
            }

            @Override
            protected void onPostExecute(String message) {
                super.onPostExecute(message);
                screen.postMessage(message);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
```
If you are looking for a basic foundation upon which to build your own applications, based on this proposed MVP solution, please take a look at the following repository: [Boilerpart code for asynchronous MVP design for Android, without 3rd party libraries.](https://github.com/ovicon/AndroidAsynchronousMVPBoilerpart)

Known issues
-------
How to test unit test the presenters?
 
License
-------

    Copyright 2017 Ovidiu CONEAC

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
