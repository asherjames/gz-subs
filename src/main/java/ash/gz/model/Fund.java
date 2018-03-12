package ash.gz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Fund
{
  @Id
  @GeneratedValue
  private UUID id;

  private String name;

  private boolean support;

  @ManyToOne
  private Submission submission;

  public Fund()
  {

  }

  public Fund(String name, boolean support, Submission submission)
  {
    this.name = name;
    this.support = support;
    this.submission = submission;
  }

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

  public boolean isSupport()
  {
    return support;
  }

  public void setSupport(boolean support)
  {
    this.support = support;
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
    Fund fund = (Fund) o;
    return id == fund.id &&
        support == fund.support &&
        Objects.equals(name, fund.name) &&
        Objects.equals(submission, fund.submission);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(id, name, support, submission);
  }
}
