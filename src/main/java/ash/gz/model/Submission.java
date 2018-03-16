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

  private String firstName;

  private String lastName;

  private String localBoard;

  private boolean receiveGZEmail;

  private boolean fossilFuelTax;

  private boolean waterInfrastructureTax;

  private boolean environmentTargetedRate;

  private boolean transportCheck;

  private boolean housingCheck;

  private boolean environmentCheck;

  @OneToMany(
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  @JoinColumn(name = "submission_id")
  private List<Checkbox> checkboxes = new ArrayList<>();

  private String extraTransportProjectsSupport;

  private String extraTransportProjectsDoNotSupport;

  private String extraEnvironmentalProjects;

  private String extraHousingProjects;

  private String otherComments;

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

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getLocalBoard()
  {
    return localBoard;
  }

  public void setLocalBoard(String localBoard)
  {
    this.localBoard = localBoard;
  }

  public boolean isReceiveGZEmail()
  {
    return receiveGZEmail;
  }

  public void setReceiveGZEmail(boolean receiveGZEmail)
  {
    this.receiveGZEmail = receiveGZEmail;
  }

  public boolean isFossilFuelTax()
  {
    return fossilFuelTax;
  }

  public void setFossilFuelTax(boolean fossilFuelTax)
  {
    this.fossilFuelTax = fossilFuelTax;
  }

  public boolean isWaterInfrastructureTax()
  {
    return waterInfrastructureTax;
  }

  public void setWaterInfrastructureTax(boolean waterInfrastructureTax)
  {
    this.waterInfrastructureTax = waterInfrastructureTax;
  }

  public boolean isEnvironmentTargetedRate()
  {
    return environmentTargetedRate;
  }

  public void setEnvironmentTargetedRate(boolean environmentTargetedRate)
  {
    this.environmentTargetedRate = environmentTargetedRate;
  }

  public boolean isTransportCheck()
  {
    return transportCheck;
  }

  public void setTransportCheck(boolean transportCheck)
  {
    this.transportCheck = transportCheck;
  }

  public boolean isHousingCheck()
  {
    return housingCheck;
  }

  public void setHousingCheck(boolean housingCheck)
  {
    this.housingCheck = housingCheck;
  }

  public boolean isEnvironmentCheck()
  {
    return environmentCheck;
  }

  public void setEnvironmentCheck(boolean environmentCheck)
  {
    this.environmentCheck = environmentCheck;
  }

  public List<Checkbox> getCheckboxes()
  {
    return checkboxes;
  }

  public void setCheckboxes(List<Checkbox> checkboxes)
  {
    this.checkboxes = checkboxes;
  }

  public void addCheckbox(Checkbox checkbox)
  {
    checkboxes.add(checkbox);
    checkbox.setSubmission(this);
  }

  public void removeCheckbox(Checkbox checkbox)
  {
    checkboxes.remove(checkbox);
    checkbox.setSubmission(null);
  }

  public String getExtraTransportProjectsSupport()
  {
    return extraTransportProjectsSupport;
  }

  public void setExtraTransportProjectsSupport(String extraTransportProjectsSupport)
  {
    this.extraTransportProjectsSupport = extraTransportProjectsSupport;
  }

  public String getExtraTransportProjectsDoNotSupport()
  {
    return extraTransportProjectsDoNotSupport;
  }

  public void setExtraTransportProjectsDoNotSupport(String extraTransportProjectsDoNotSupport)
  {
    this.extraTransportProjectsDoNotSupport = extraTransportProjectsDoNotSupport;
  }

  public String getExtraEnvironmentalProjects()
  {
    return extraEnvironmentalProjects;
  }

  public void setExtraEnvironmentalProjects(String extraEnvironmentalProjects)
  {
    this.extraEnvironmentalProjects = extraEnvironmentalProjects;
  }

  public String getExtraHousingProjects()
  {
    return extraHousingProjects;
  }

  public void setExtraHousingProjects(String extraHousingProjects)
  {
    this.extraHousingProjects = extraHousingProjects;
  }

  public String getOtherComments()
  {
    return otherComments;
  }

  public void setOtherComments(String otherComments)
  {
    this.otherComments = otherComments;
  }
}
