# News App with MVVM Architecture

This is a simple News app built using the MVVM (Model-View-ViewModel) architecture pattern. The app consists of two screens: one displaying a list of news articles and the other showing a list of blog posts. The app fetches data from mock APIs and does not connect to any actual database.

## Folder Structure

The app follows a well-organized folder structure to separate different components and layers. Here's an overview of the folder structure:

```
app
├── data
│   ├── api
│   │   ├── NewsApiService.kt
│   │   └── BlogApiService.kt
│   ├── model
│   │   ├── News.kt
│   │   └── Blog.kt
│   ├── repository
│       ├── NewsRepository.kt
│       └── BlogRepository.kt
│
├── ui
│   ├── news
│   │   ├── NewsViewModel.kt
│   │   └── NewsFragment.kt
|   |   └── NewsAdapter.kt
|
│   ├── blog
│   │   ├── BlogViewModel.kt
│   │   └── BlogFragment.kt
|   |   └── BlogsAdapter.kt
|
│   └── utils
│       ├── GenericResponse.kt
│       └── DebounceClickListener.kt
|       └── RestAPIClass.kt
```

The `data` package contains the API services (`NewsApiService` and `BlogApiService`), data models (`News` and `Blog`), repositories (`NewsRepository` and `BlogRepository`), and a bookmark database (`BookmarkDatabase`) for managing bookmarked items.

The `ui` package contains two sub-packages, `news` and `blog`, which contain the corresponding ViewModel classes (`NewsViewModel` and `BlogViewModel`) and Fragment classes (`NewsFragment` and `BlogFragment`).

The `common` package contains a base ViewModel class (`BaseViewModel`) that provides common functionality to the ViewModels and a utility class for debouncing click events (`DebounceClickListener`).

The `utils` package contains a utility class for network-related operations (`NetworkUtils`).

## Functionality

### News Screen

- The News screen displays a list of news articles fetched from the mock News API.
- Each news article item includes an image, title, and description.
- Clicking on a news article item opens a detailed view of the news article.
- The bookmark icon beside each news article indicates the bookmark status.
- Clicking on the bookmark icon triggers a debounced API call to toggle the bookmark status of the news article.
- Pulling down on the list refreshes the news articles from the API.

### Blog Screen

- The Blog screen displays a list of blog posts fetched from the mock Blog API.
- Each blog post item includes an image, title, and description.
- Clicking on a blog post item opens a detailed view of the blog post.
- The bookmark icon beside each blog post indicates the bookmark status.
- Clicking on the bookmark icon triggers a debounced API call to toggle the bookmark status of the blog post.
- Pulling down on the list refreshes the blog posts from the API.

### Bookmarking

- The bookmark API call accepts two query parameters: `id` and `type`.
- The `id` value is obtained from the corresponding API response for news and blog.
- The `type` value is set as either "news" or "blog".
- Calling the bookmark API does not actually bookmark the item but updates the bookmark status in the API response.
- If the API to fetch news or blog items is called again, all bookmark statuses will be reset to false.

## Dependencies

The app uses the following dependencies:

- Retrofit: For making HTTP requests to the mock APIs.
- Gson: For parsing JSON responses from the APIs.
- Coroutines: For handling asynchronous operations.
- ViewModel and LiveData: For implementing the MVVM architecture.
- Glide: For loading and displaying images.
- SwipeRefreshLayout: For enabling pull-to-refresh functionality.

## Conclusion

This News app demonstrates the MVVM architecture pattern, providing separate layers for data retrieval, data models, repositories, and view models. The app fetches data from mock APIs, displays a list of news articles and blog posts, and allows users to bookmark items by making API calls. The app also implements debouncing on the bookmark click to prevent excessive API calls.
