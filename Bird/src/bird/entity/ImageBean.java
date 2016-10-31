package bird.entity;

public class ImageBean {
	
	private int imageId;
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	private String imageName;
	private String imagePath;
	private int birdId;
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public int getBirdId() {
		return birdId;
	}
	public void setBirdId(int birdId) {
		this.birdId = birdId;
	}
	
}
