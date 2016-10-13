package bird.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tbl_image")
public class Image
{
	@Id
	@GenericGenerator(name="bird",strategy="increment")
	@GeneratedValue(generator="bird")
	@Column(name="ImageId")
    private int imageId;
	@Column(name="ImageName")
    private String imageName;
	@Column(name="ImagePath")
    private String imagePath;
	@ManyToOne
	@JoinColumn(name="BirdId")
    private Bird bird;

    public String getImageName()
    {
        return imageName;
    }

    public void setImageName(String imageName)
    {
        this.imageName = imageName;
    }

    public int getImageId()
    {
        return imageId;
    }

    public void setImageId(int imageId)
    {
        this.imageId = imageId;
    }

    public String getImagePath()
    {
        return imagePath;
    }

    public void setImagePath(String imagePath)
    {
        this.imagePath = imagePath;
    }

    public Bird getBird()
    {
        return bird;
    }

    public void setBird(Bird bird)
    {
        this.bird = bird;
    }
}
