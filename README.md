# VoiceAnnouncements
Android实现收款成功金额的语音播报功能(Nice tone)
推荐文章: <br>
 [Android实现购物车页面及购物车效果(点击动画)](http://www.jianshu.com/p/82e249713f1b)<br>
           [Android自定义收银键盘(原创)](http://www.jianshu.com/p/a57f32c21fb7)<br>

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
	        compile 'com.github.javaexception:VoiceAnnouncements:v1.0'
	}
  ```
  
  
  **使用方法 -**
  
    ```
    VoiceUtils.with(this).Play("1111",true);
    ```
    如果是true播报语音为"收款成功+收款金额",如果是false只播报收款金额.<br>

播报语速的调控问题，现在因为只能支持Android6.0以上的，所以代码我没添加，等解决后一起更新.<br>

附上一些代码:


    ```
    public  void PlaySoundList( final int soundindex, final String soundString, final int soundcount){
           boolean createState=false;
        if(mediaPlayer==null) {
            mediaPlayer = null;
        }
        System.out.println("加载音频["+soundindex+"]");
        mediaPlayer = createSound(soundindex,soundString);
        createState=true;

        if(createState==true)
            System.out.println("加载音频成功["+soundindex+"]");
        else
            System.out.println("加载音频失败["+soundindex+"]");

        //播放完成触发此事件
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();//释放音频资源
                int newsoundindex =soundindex;
                System.out.println("释放资源[" +soundindex+"]");
                if(soundindex<soundcount) {
                    newsoundindex=newsoundindex+1;
                    PlaySoundList(newsoundindex, soundString,soundcount);
                }

            }
        });
        try {
            //在播放音频资源之前，必须调用Prepare方法完成些准备工作
            if(createState)
                mediaPlayer.prepare();
            else
                mediaPlayer.prepare();
            //开始播放音频
            mediaPlayer.start();
            System.out.println("播放音频["+soundindex+"]");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```


```
    public  MediaPlayer createSound(int soundIndex, String soundString){
        MediaPlayer mp=null;
        String soundChar = soundString.substring(soundIndex-1,soundIndex);

        switch (soundChar)
        {
            case "零":
                mp=MediaPlayer.create(mContext,R.raw.sound0);
                break;
            case "壹":
                mp=MediaPlayer.create(mContext,R.raw.sound1);
                break;
            case "贰":
                mp=MediaPlayer.create(mContext,R.raw.sound2);
                break;
            case "叁":
                mp=MediaPlayer.create(mContext,R.raw.sound3);
                break;
            case "肆":
                mp=MediaPlayer.create(mContext,R.raw.sound4);
                break;
            case "伍":
                mp=MediaPlayer.create(mContext,R.raw.sound5);
                break;
            case "陆":
                mp=MediaPlayer.create(mContext,R.raw.sound6);
                break;
            case "柒":
                mp=MediaPlayer.create(mContext,R.raw.sound7);
                break;
            case "捌":
                mp=MediaPlayer.create(mContext,R.raw.sound8);
                break;
            case "玖":
                mp=MediaPlayer.create(mContext,R.raw.sound9);
                break;
            case "拾":
                mp=MediaPlayer.create(mContext,R.raw.soundshi);
                break;
            case "佰":
                mp=MediaPlayer.create(mContext,R.raw.soundbai);
                break;
            case "仟":
                mp=MediaPlayer.create(mContext,R.raw.soundqian);
                break;
            case "角":
                mp=MediaPlayer.create(mContext,R.raw.soundjiao);
                break;
            case "分":
                mp=MediaPlayer.create(mContext,R.raw.soundfen);
                break;
            case "元":
                mp=MediaPlayer.create(mContext,R.raw.soundyuan);
                break;
            case "整":
                mp=MediaPlayer.create(mContext,R.raw.soundzheng);
                break;
            case "万":
                mp=MediaPlayer.create(mContext,R.raw.soundwan);
                break;
            case "$":
                mp=MediaPlayer.create(mContext,R.raw.soundsuccess);
                break;
        }
        mp.stop();
        return mp;
    }  
```
```
[简书地址](http://www.jianshu.com/p/1b9bd55f8960)<br>

我的公众号如下:<br>


![333.jpg](http://upload-images.jianshu.io/upload_images/2787891-fea940bfb62b16b3.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![a2.jpg](http://upload-images.jianshu.io/upload_images/2787891-b84864a81562fd5a.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
