# MaishaMedsTechnicalInterview

An app hitting the https://jsonplaceholder.typicode.com/ to display a list of posts in a RecyclerView.

<img width="407" alt="Screenshot 2021-07-27 at 02 37 40" src="https://user-images.githubusercontent.com/40742916/127132779-0412c266-34e8-4985-9495-febb431c4558.png">


## Architecture

This is split and grouped into different packages. This helps create a better abstraction between the android framework and the business logic. This is following the clean architecture principles which create a clear separation of concerns.

### Presentation
This is code in the **ui package** - This contains the activity and the view model. The activity binds the data presented to it from the view model to the recycler view. 

### Domain
The domain layer contains data classes that are used across the presentation and the data layers.

### Data
The data layer contains:
- The  **network package** contains code that is responsible for fetching data from a remote server whenever the user is connected to the internet.
- The  **cache package** contains code that caches the data locally using Room database for loading the post whenever the user isn't connected to the internet.

## Libraries used

- **Jetpack**
  -  **Viewmodel** - Manage UI related data in a lifecycle conscious way and act as a channel between use cases and the ui
  -  **Data Binding** - support library that allows binding of UI components in layouts to data sources, binds character details and search results to UI
  -  **Room** - Provides abstraction layer over SQLite to cache data locally
-  **Retrofit** - type safe http client that allows interacting with APIs and sending network requests with OkHttp
-  **Gson** - JSON Parser, used to parse requests on the data layer for Entities
-  **okhttp logging interceptor** - logs HTTP request and response data.
-  **Koin** - A pragmatic lightweight dependency injection framework for Kotlin
-  **Mockito** - A Java-based mocking framework used for unit testing.
