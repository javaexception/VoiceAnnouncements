# VoiceAnnouncements
Android实现收款成功金额的语音播报功能(Nice tone)


![a1.jpg](http://upload-images.jianshu.io/upload_images/2787891-04b2d3631fd5abe0.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)



**Gradle依赖 -**

1.最app外层的build.gradle 添加代码:

```
allprojects {
    repositories {
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
```

2.在app 的build.gradle中添加：

```
	dependencies {
     compile 'com.github.javaexception:VoiceAnnouncements:v1.2'
	}
  ```
  
  
  **使用方法 -**<br>
  
  **1.普通调用**<br>
  
    ```
    VoiceUtils.with(this).Play("1111",true);
    ```
    
    **2.防止用户同时接收多条语音造成的语音重叠，采用下面的调用方法：**<br>
    
      ```
       private synchronized  void Play(final String str) {

                    if (VoiceUtils.with(this).GetIsPlay()){
                        System.out.println("正在播放语音 ");
                        new Thread() {
                            @Override
                            public  void run() {
                                super.run();
                                try {
                                    Thread.sleep(100);//休眠0.1秒
                                    Play(str);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();
                    }else {
                        VoiceUtils.with(this).Play(str,true);
                    }
                }
      ```
    
    如果是true播报语音为"收款成功+收款金额",如果是false只播报收款金额.<br>

播报语速的调控问题，现在因为只能支持Android6.0以上的，所以代码我没添加，等解决后一起更新.<br>


[简书地址](http://www.jianshu.com/p/1b9bd55f8960)<br>

我的公众号如下:<br>



![安卓干货铺](http://upload-images.jianshu.io/upload_images/2787891-b84423a2473039b8.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![a2.jpg](http://upload-images.jianshu.io/upload_images/2787891-b84864a81562fd5a.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
