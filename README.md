# IdleHandlerDemo
IdleHandler,简而言之，就是在looper里面的message暂时处理完了，这个时候会回调这个接口，返回false，那么就会移除它，返回true就会在下次message处理完了的时候继续回调。
