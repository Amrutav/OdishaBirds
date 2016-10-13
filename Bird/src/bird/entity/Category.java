package bird.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tbl_category")
public class Category
{
	@Id
	@GenericGenerator(name="bird",strategy="increment")
	@GeneratedValue(generator="bird")
	@Column(name="CategoryId")
    private int categoryId;
	@Column(name="CategoryName")
    private String categoryName;

    public int getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(int categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }
}
