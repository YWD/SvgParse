package xyz.hasaki.svgparse.svg;

public class ConstrainedSvgPathParser extends SvgPathParser {

  private float originalWidth, originalHeight;
  private float viewWidth, viewHeight;

  private ConstrainedSvgPathParser(int originalWidth, int originalHeight, int viewWidth,
      int viewHeight) {
    this.originalWidth = originalWidth <= 0 ? 1 : originalWidth;
    this.originalHeight = originalHeight <=0 ? 1: originalHeight;
    this.viewWidth = viewWidth <= 0 ? 1: viewWidth;
    this.viewHeight = viewHeight <= 0 ? 1 : viewHeight;
  }

  public void resetSize() {
    this.originalHeight = 1 ;
    this.originalWidth = 1 ;
    this.viewWidth = 1 ;
    this.viewHeight = 1 ;
  }

  @Override
  protected float transformX(float x) {
    return x * viewWidth / originalWidth;
  }

  @Override
  protected float transformY(float y) {
    return y * viewHeight / originalHeight;
  }

  public void setSize(float[] size) {
    this.originalWidth = size[0] ;
    this.originalHeight = size[1];
    this.viewWidth = size[2] ;
    this.viewHeight = size[3] ;
  }

  public static class Builder {

    private int originalWidth, originalHeight;
    private int viewWidth, viewHeight;

    public Builder originalWidth(int originalWidth) {
      this.originalWidth = originalWidth;
      return this;
    }

    public Builder originalHeight(int originalHeight) {
      this.originalHeight = originalHeight;
      return this;
    }

    public Builder viewWidth(int width) {
      this.viewWidth = width;
      return this;
    }

    public Builder viewHeight(int height) {
      this.viewHeight = height;
      return this;
    }

    public ConstrainedSvgPathParser build() {
      return new ConstrainedSvgPathParser(originalWidth, originalHeight, viewWidth, viewHeight);
    }
  }
}