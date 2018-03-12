package ash.gz.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Submission
{
  @Id
  @GeneratedValue
  private UUID id;

  @Email
  private String email;

  private boolean supportsTransport;

  private boolean supportsHousing;

  private boolean supportsEnvironment;

  @OneToMany(
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  @JoinColumn(name = "submission_id")
  private List<Fund> funds = new ArrayList<>();

  public Submission()
  {

  }

  public Submission(@Email String email, boolean supportsTransport, boolean supportsHousing, boolean supportsEnvironment, List<Fund> funds)
  {
    this.email = email;
    this.supportsTransport = supportsTransport;
    this.supportsHousing = supportsHousing;
    this.supportsEnvironment = supportsEnvironment;
    this.funds = funds;
  }

  public UUID getId()
  {
    return id;
  }

  public void setId(UUID id)
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
