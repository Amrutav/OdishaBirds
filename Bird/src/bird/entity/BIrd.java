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
public class BIrd {
		@Id
		@GenericGenerator(name="bird",strategy="increment")
		@GeneratedValue(generator="bird")
		@Column(name="BirdId")
	    private int birdId;
		@Column(name="BirdName")
	    private String birdName;
		@Column(name="BirdImage")
		private String birdImage;
		@ManyToOne
		@JoinColumn(name="CatId")
	    private Category category;
		public int getBirdId() {
			return birdId;
		}
		public void setBirdId(int birdId) {
			this.birdId = birdId;
		}
		public String getBirdName() {
			return birdName;
		}
		public void setBirdName(String birdName) {
			this.birdName = birdName;
		}
		public String getBirdImage() {
			return birdImage;
		}
		public void setBirdImage(String birdImage) {
			this.birdImage = birdImage;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		
		
}
