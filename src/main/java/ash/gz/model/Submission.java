package ash.gz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Submission
{
  @Id
  @GeneratedValue
  private long id;

  @Email
  private String email;

  private boolean supportsTransport;

  private boolean supportsHousing;

  private boolean supportsEnvironment;

  @OneToMany(mappedBy = "submission")
  private List<Fund> funds = new ArrayList<>();

  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public boolean isSupportsTransport()
  {
    return supportsTransport;
  }

  public void setSupportsTransport(boolean supportsTransport)
  {
    this.supportsTransport = supportsTransport;
  }

  public boolean isSupportsHousing()
  {
    return supportsHousing;
  }

  public void setSupportsHousing(boolean supportsHousing)
  {
    this.supportsHousing = supportsHousing;
  }

  public boolean isSupportsEnvironment()
  {
    return supportsEnvironment;
  }

  public void setSupportsEnvironment(boolean supportsEnvironment)
  {
    this.supportsEnvironment = supportsEnvironment;
  }

  public List<Fund> getFunds()
  {
    return funds;
  }

  public void setFunds(List<Fund> funds)
  {
    this.funds = funds;
  }

  public void addFund(Fund fund)
  {
    funds.add(fund);
    fund.setSubmission(this);
  }

  public void removeFund(Fund fund)
  {
    funds.remove(fund);
    fund.setSubmission(null);
  }
}
