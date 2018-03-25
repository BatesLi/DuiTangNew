package com.example.test.myduitang.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.test.myduitang.R;

public class StartActivity extends AppCompatActivity {

  @BindView(R.id.img_start) ImageView mImgStart;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_start);
    ButterKnife.bind(this);
    initImage();
  }
  public void MyStartActivity() {
    Intent intent = new Intent(StartActivity.this, MainActivity.class);
    startActivity(intent);
    //用于呈现淡入淡出的效果，该方法需要在startActivity(intent);或者finish();之后调用
    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    finish();
  }
  private void initImage() {
    mImgStart.setImageResource(R.drawable.start);
    //进行缩放动画
    ScaleAnimation scaleAnimation = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f,
        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
    scaleAnimation.setDuration(4000);
    //动画播放完成后保持形状
    scaleAnimation.setFillAfter(true);
    scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
      @Override
      public void onAnimationStart(Animation animation) {

      }

      @Override
      public void onAnimationEnd(Animation animation) {
        MyStartActivity();
      }

      @Override
      public void onAnimationRepeat(Animation animation) {

      }
    });
    mImgStart.startAnimation(scaleAnimation);
  }
}
