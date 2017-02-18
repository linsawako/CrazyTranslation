# CrazyTranslation
Rxjava+Retrofit 用有道翻译的API 实现一个简单的翻译功能

仅为一个练习用的demo，RxBus的使用还没有完成

## 使用有道翻译的api
http://fanyi.youdao.com/openapi?path=web-mode

返回json数据

## 使用rxjava的变换器实现错误预处理
```
public static Observable.Transformer<Word, Word> handleResult() {
        return new Observable.Transformer<Word, Word>() {
            @Override
            public Observable<Word> call(Observable<Word> wordObservable) {
                return wordObservable.map(new Func1<Word, Word>() {
                    @Override
                    public Word call(Word word) {
                        if (word.getErrorCode() == 0){
                            if (word.getQuery().equals(word.getTranslation().get(0))){
                                throw new RuntimeException("didn't find this word");
                            }
                        }else{
                            throw new RuntimeException("other error");
                        }
                        return word;
                    }
                });
            }
        };
```
## 使用oKHttp的拦截器进行缓存
```
Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                //无网络时，设置使用缓存
                if (!isNetworkConnected(BaseApplication.getAppContext())) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                Response.Builder newBuilder = response.newBuilder();
                if (isNetworkConnected(BaseApplication.getAppContext())) {
                    // 有网络时 设置缓存超时时间0个小时
                    int maxAge = 0;
                    newBuilder.header("Cache-Control", "public, max-age=" + maxAge);
                } else {
                    // 无网络时，设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    newBuilder.header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale);
                }
                return newBuilder.build();
            }
        };
```
 
