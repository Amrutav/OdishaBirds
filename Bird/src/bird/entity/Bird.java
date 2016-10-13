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
@Table(name="tbl_bird")
public class Bird
{
	@Id
	@GenericGenerator(name="bird",strategy="increment")
	@GeneratedValue(generator="bird")
	@Column(name="BirdId")
    private int birdId;
	@Column(name="BirdName")
    private String birdName;
	@Column(name="BirdSound")
    private String birdSound;
	@Column(name="BirdColor")
    private String birdColor;
	@Column(name="BirdDetails")
    private String birdDetails;
	@Column(name="BirdFood")
    private String birdFood;
	@Column(name="BirdPopulation")
    private String birdPopulation;
	@Column(name="BirdAltName")
    private String birdAltName;
	@Column(name="BirdSciName")
    private String birdSciName;
	@Column(name="BirdResident")
    private String birdRsident;
	@Column(name="BirdVisibility")
    private String birdVisibility;
	@Column(name="BirdMigrtStatus")
    private String birdMigrtStatus;
	@Column(name="BirdNestPeriod")
    private String birdNestPeriod;
	@ManyToOne
	@JoinColumn(name="CategoryId")
    private Category category;
	
    public int getBirdId()
    {
        return birdId;
    }

    public void setBirdId(int birdId)
    {
        this.birdId = birdId;
    }

    public String getBirdColor()
    {
        return birdColor;
    }

    public void setBirdColor(String birdColor)
    {
        this.birdColor = birdColor;
    }

    public String getBirdDetails()
    {
        return birdDetails;
    }

    public void setBirdDetails(String birdDetails)
    {
        this.birdDetails = birdDetails;
    }

    public String getBirdFood()
    {
        return birdFood;
    }

    public void setBirdFood(String birdFood)
    {
        this.birdFood = birdFood;
    }

    public String getBirdPopulation()
    {
        return birdPopulation;
    }

    public void setBirdPopulation(String birdPopulation)
    {
        this.birdPopulation = birdPopulation;
    }

    public String getBirdAltName()
    {
        return birdAltName;
    }

    public void setBirdAltName(String birdAltName)
    {
        this.birdAltName = birdAltName;
    }

    public String getBirdSciName()
    {
        return birdSciName;
    }

    public void setBirdSciName(String birdSciName)
    {
        this.birdSciName = birdSciName;
    }

    public String getBirdRsident()
    {
        return birdRsident;
    }

    public void setBirdRsident(String birdRsident)
    {
        this.birdRsident = birdRsident;
    }

    public String getBirdVisibility()
    {
        return birdVisibility;
    }

    public void setBirdVisibility(String birdVisibility)
    {
        this.birdVisibility = birdVisibility;
    }

    public String getBirdMigrtStatus()
    {
        return birdMigrtStatus;
    }

    public void setBirdMigrtStatus(String birdMigrtStatus)
    {
        this.birdMigrtStatus = birdMigrtStatus;
    }

    public String getBirdNestPeriod()
    {
        return birdNestPeriod;
    }

    public void setBirdNestPeriod(String birdNestPeriod)
    {
        this.birdNestPeriod = birdNestPeriod;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public String getBirdName()
    {
        return birdName;
    }

    public void setBirdName(String birdName)
    {
        this.birdName = birdName;
    }

    public String getBirdSound()
    {
        return birdSound;
    }

    public void setBirdSound(String birdSound)
    {
        this.birdSound = birdSound;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Object setCategoryId)
    {
        category = (Category)setCategoryId;
    }
}
