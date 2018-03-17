package ash.gz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Checkbox
{
  @Id
  @GeneratedValue
  private UUID id;

  private String name;

  private boolean checked;

  private String type;

  public Checkbox()
  {
  }

  public Checkbox(String name, boolean checked, String type, Submission submission)
  {
    this.name = name;
    this.checked = checked;
    this.type = type;
    this.submission = submission;
  }

  @ManyToOne
  private Submission submission;

  public UUID getId()

  {
    return id;
  }

  public void setId(UUID id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public boolean isChecked()
  {
    return checked;
  }

  public void setChecked(boolean checked)
  {
    this.checked = checked;
  }

  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public Submission getSubmission()
  {
    return submission;
  }

  public void setSubmission(Submission submission)
  {
    this.submission = submission;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Checkbox checkbox = (Checkbox) o;
    return checked == checkbox.checked &&
        Objects.equals(id, checkbox.id) &&
        Objects.equals(name, checkbox.name) &&
        Objects.equals(type, checkbox.type) &&
        Objects.equals(submission, checkbox.submission);
  }

  @Override
  public int hashCode()
  {

    return Objects.hash(id, name, checked, type, submission);
  }
}
